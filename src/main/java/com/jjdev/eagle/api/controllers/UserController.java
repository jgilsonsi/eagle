package com.jjdev.eagle.api.controllers;

import com.jjdev.eagle.api.dtos.UserDto;
import com.jjdev.eagle.api.entities.User;
import com.jjdev.eagle.api.enums.UserType;
import com.jjdev.eagle.api.response.Response;
import com.jjdev.eagle.api.services.UserService;
import com.jjdev.eagle.api.utils.PasswordUtils;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
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

/**
 *
 * @author JGilson
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    public UserController() {
    }

    /**
     * Return user by email.
     *
     * @param email
     * @return ResponseEntity<Response<UserDto>>
     */
    @GetMapping(value = "/{email:.+}")
    public ResponseEntity<Response<UserDto>> readByEmail(@PathVariable("email") String email) {

        log.info("Searching user by email: {}", email);

        Response<UserDto> response = new Response<>();
        Optional<User> user = this.userService.findByEmail(email);

        if (!user.isPresent()) {
            log.info("User not found for email: {}", email);
            response.getErrors().add("User not found for email: " + email);
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(this.userToDto(user.get()));
        return ResponseEntity.ok(response);
    }

    /**
     * Create a user.
     *
     * @param user
     * @param result
     * @return ResponseEntity<Response<UserDto>> @throws ParseException
     */
    @PostMapping
    public ResponseEntity<Response<UserDto>> create(@Valid @RequestBody UserDto userDto,
            BindingResult result) throws ParseException, NoSuchAlgorithmException {

        log.info("Creating user: {}", userDto.getEmail());

        Response<UserDto> response = new Response<>();
        if (result.hasErrors()) {
            log.error("Validation erros: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        User user = this.dtoToUser(userDto, result);
        user = this.userService.create(user);
        response.setData(this.userToDto(user));
        return ResponseEntity.ok(response);
    }

    /**
     * Update user.
     *
     * @param id
     * @param userDto
     * @return ResponseEntity<Response<UserDto>> @throws ParseException
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Response<UserDto>> update(@PathVariable("id") Long id,
            @Valid @RequestBody UserDto userDto, BindingResult result) throws ParseException, NoSuchAlgorithmException {

        log.info("Updating user: {}", userDto.getEmail());

        Response<UserDto> response = new Response<>();
        userDto.setId(id);
        User user = this.dtoToUser(userDto, result);

        if (result.hasErrors()) {
            log.error("Validation errors: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        user = this.userService.create(user);
        response.setData(this.userToDto(user));
        return ResponseEntity.ok(response);
    }

    /**
     * Remove user by id.
     *
     * @param id
     * @return ResponseEntity<Response<User>>
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response<String>> remove(@PathVariable("id") Long id) {

        log.info("Removing user by id: {}", id);

        Response<String> response = new Response<>();
        Optional<User> user = this.userService.findById(id);

        if (!user.isPresent()) {
            log.info("Invalid user id: {}", id);
            response.getErrors().add("Invalid user id: " + id);
            return ResponseEntity.badRequest().body(response);
        }

        this.userService.remove(id);
        return ResponseEntity.ok(new Response<>());
    }

    /**
     * Convert DTO to User.
     *
     * @param userDto
     * @param result
     * @return User
     * @throws NoSuchAlgorithmException
     */
    private User dtoToUser(UserDto userDto, BindingResult result) throws NoSuchAlgorithmException {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(PasswordUtils.generateBCrypt(userDto.getPassword()));
        user.setRole(UserType.ROLE_USER.name());

        return user;
    }

    /**
     * Convert User to DTO.
     *
     * @param user
     * @return UserDto
     */
    private UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword("");
        userDto.setRole(user.getRole());

        return userDto;
    }
}
