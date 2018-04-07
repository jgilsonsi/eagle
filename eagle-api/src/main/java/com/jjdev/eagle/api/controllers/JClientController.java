package com.jjdev.eagle.api.controllers;

import com.jjdev.eagle.api.dtos.JClientDto;
import com.jjdev.eagle.api.entities.JClient;
import com.jjdev.eagle.api.response.JResponse;
import com.jjdev.eagle.api.services.IClientService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

/**
 *
 * @author JGilson
 */
@RestController
@RequestMapping("/api/v1/clients")
@CrossOrigin(origins = "*")
public class JClientController {

    @Autowired
    private IClientService clientService;

    private static final Logger log = LoggerFactory.getLogger(JClientController.class);

    public JClientController() {
    }

    /**
     * Create client.
     *
     * @param client
     * @param result
     * @return ResponseEntity<JResponse<JClientDto>>
     */
    @PostMapping
    public ResponseEntity<JResponse<JClientDto>> create(
            @Valid @RequestBody JClientDto clientDto, BindingResult result) {

        log.info("Creating client: {}", clientDto.getName());

        JResponse<JClientDto> response = new JResponse<>();

        if (result.hasErrors()) {
            log.info("Validation erros: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors()
                    .add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        JClient client = this.dtoToClient(clientDto);
        client = this.clientService.create(client);

        response.setData(this.clientToDto(client));
        return ResponseEntity.ok(response);
    }

    /**
     * Return a list of clients.
     *
     * @return ResponseEntity<Response<List<JClientDto>>>
     */
    @GetMapping()
    public ResponseEntity<JResponse<List<JClientDto>>> readAll() {

        log.info("Searching all clients.");

        JResponse<List<JClientDto>> response = new JResponse<>();
        List<JClient> clients = this.clientService.readAll();

        List<JClientDto> clientsDto = clients.stream()
                .map(client -> this.clientToDto(client))
                .collect(Collectors.toList());

        response.setData(clientsDto);
        return ResponseEntity.ok(response);
    }

    /**
     * Update client.
     *
     * @param id
     * @param clientDto
     * @return ResponseEntity<JResponse<JClientDto>>
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<JResponse<JClientDto>> update(@PathVariable("id") Long id,
            @Valid @RequestBody JClientDto clientDto, BindingResult result) {

        log.info("Updating client: {}", clientDto.getName());

        JResponse<JClientDto> response = new JResponse<>();

        if (result.hasErrors()) {
            log.info("Validation errors: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        clientDto.setId(id);
        JClient client = this.dtoToClient(clientDto);
        client = this.clientService.update(client);

        response.setData(this.clientToDto(client));
        return ResponseEntity.ok(response);
    }

    /**
     * Delete client by id.
     *
     * @param id
     * @return ResponseEntity<JResponse<String>>
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<JResponse<String>> delete(@PathVariable("id") Long id) {

        log.info("Removing client by id: {}", id);

        JResponse<String> response = new JResponse<>();
        Optional<JClient> client = this.clientService.readById(id);

        if (!client.isPresent()) {
            log.info("Invalid client id: {}", id);
            response.getErrors().add("Invalid client id: " + id);
            return ResponseEntity.badRequest().body(response);
        }

        this.clientService.delete(id);

        return ResponseEntity.ok(new JResponse<>());
    }

    //--------------------------------------------------------------------------
    /**
     * Convert DTO to JClient.
     *
     * @param clientDto
     * @return JClient
     */
    private JClient dtoToClient(JClientDto clientDto) {

        JClient client = new JClient();
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setGender(clientDto.getGender());
        client.setChatId(clientDto.getChatId());

        return client;
    }

    /**
     * Convert JClient to DTO.
     *
     * @param client
     * @return JClientDto
     */
    private JClientDto clientToDto(JClient client) {

        JClientDto clientDto = new JClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setGender(client.getGender());
        clientDto.setChatId(client.getChatId());
        clientDto.setCreated(client.getCreated());
        clientDto.setLastVisit(client.getLastVisit());

        return clientDto;
    }

}
