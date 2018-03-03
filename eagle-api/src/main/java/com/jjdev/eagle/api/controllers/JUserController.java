package com.jjdev.eagle.api.controllers;

import com.jjdev.eagle.api.dtos.JUserDto;
import com.jjdev.eagle.api.entities.JUser;
import com.jjdev.eagle.api.enums.EUserType;
import com.jjdev.eagle.api.response.JResponse;
import com.jjdev.eagle.api.utils.JPasswordUtils;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jjdev.eagle.api.services.IUserService;

/**
 *
 * @author JGilson
 */
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class JUserController {

    private static final Logger log = LoggerFactory.getLogger(JUserController.class);

    @Autowired
    private IUserService userService;

    public JUserController() {
    }

    /**
     * Create user.
     *
     * @param user
     * @param result
     * @return ResponseEntity<JResponse<JUserDto>>
     */
    @PostMapping
    public ResponseEntity<JResponse<JUserDto>> create(@Valid @RequestBody JUserDto userDto,
            BindingResult result) {

        log.info("Creating user: {}", userDto.getEmail());

        JResponse<JUserDto> response = new JResponse<>();
        if (result.hasErrors()) {
            log.info("Validation erros: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors()
                    .add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        JUser user = this.dtoToUser(userDto);
        user = this.userService.create(user);

        response.setData(this.userToDto(user));
        return ResponseEntity.ok(response);
    }

    /**
     * Return user by email.
     *
     * @param email
     * @return ResponseEntity<JResponse<JUserDto>>
     */
    @GetMapping(value = "/{email:.+}")
    public ResponseEntity<JResponse<JUserDto>> readByEmail(@PathVariable("email") String email) {

        log.info("Searching user by email: {}", email);

        JResponse<JUserDto> response = new JResponse<>();

        Optional<JUser> user = this.userService.readByEmail(email);
        if (!user.isPresent()) {
            log.info("User not found for email: {}", email);
            response.getErrors().add("User not found for email: " + email);
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(this.userToDto(user.get()));
        return ResponseEntity.ok(response);
    }

    /**
     * Update user.
     *
     * @param id
     * @param userDto
     * @return ResponseEntity<JResponse<JUserDto>>
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<JResponse<JUserDto>> update(@PathVariable("id") Long id,
            @Valid @RequestBody JUserDto userDto, BindingResult result) {

        log.info("Updating user: {}", userDto.getEmail());

        JResponse<JUserDto> response = new JResponse<>();

        if (result.hasErrors()) {
            log.info("Validation errors: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        userDto.setId(id);
        JUser user = this.dtoToUser(userDto);
        if (!this.userService.update(user)) {
            log.info("Invalid user id: {}", id);
            response.getErrors().add("Invalid user id: " + id);
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(this.userToDto(user));
        return ResponseEntity.ok(response);
    }

    /**
     * Delete user by id.
     *
     * @param id
     * @return ResponseEntity<JResponse<String>>
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<JResponse<String>> delete(@PathVariable("id") Long id) {

        log.info("Removing user by id: {}", id);

        JResponse<String> response = new JResponse<>();
        Optional<JUser> user = this.userService.readById(id);

        if (!user.isPresent()) {
            log.info("Invalid user id: {}", id);
            response.getErrors().add("Invalid user id: " + id);
            return ResponseEntity.badRequest().body(response);
        }

        this.userService.delete(id);

        return ResponseEntity.ok(new JResponse<>());
    }

    //--------------------------------------------------------------------------
    /**
     * Convert DTO to JUser.
     *
     * @param userDto
     * @return JUser
     */
    private JUser dtoToUser(JUserDto userDto) {
        
        JUser user = new JUser();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(JPasswordUtils.generateBCrypt(userDto.getPassword()));
        user.setRole(EUserType.ROLE_USER.name());

        return user;
    }

    /**
     * Convert JUser to DTO.
     *
     * @param user
     * @return JUserDto
     */
    private JUserDto userToDto(JUser user) {
        
        JUserDto userDto = new JUserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword("");
        userDto.setRole(user.getRole());

        return userDto;
    }

}
