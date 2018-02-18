package com.jjdev.eagle.api.controllers;

import com.jjdev.eagle.api.dtos.JEquipmentTypeDto;
import com.jjdev.eagle.api.entities.JEquipmentType;
import com.jjdev.eagle.api.response.JResponse;
import com.jjdev.eagle.api.services.IEquipmentTypeService;
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
@RequestMapping("/api/v1/equipment-type")
@CrossOrigin(origins = "*")
public class JEquipmentTypeController {

    private static final Logger log = LoggerFactory.getLogger(JEquipmentTypeController.class);

    @Autowired
    private IEquipmentTypeService equipmentTypeService;

    public JEquipmentTypeController() {
    }

    /**
     * Return a list of equipment types.
     *
     * @return ResponseEntity<Response<List<JEquipmentTypeDto>>>
     */
    @GetMapping(value = "")
    public ResponseEntity<JResponse<List<JEquipmentTypeDto>>> readAll() {

        log.info("Searching all equipment types.");

        JResponse<List<JEquipmentTypeDto>> response = new JResponse<>();

        List<JEquipmentType> equipmentTypes = this.equipmentTypeService.findAll();
        List<JEquipmentTypeDto> equipmentTypesDto = equipmentTypes.stream()
                .map(equipmentType -> this.equipmentTypeToDto(equipmentType))
                .collect(Collectors.toList());

        response.setData(equipmentTypesDto);
        return ResponseEntity.ok(response);
    }

    /**
     * Create a equipment type.
     *
     * @param equipmentType
     * @param result
     * @return ResponseEntity<JResponse<JEquipmentTypeDto>>
     */
    @PostMapping
    public ResponseEntity<JResponse<JEquipmentTypeDto>> create(
            @Valid @RequestBody JEquipmentTypeDto equipmentTypeDto, BindingResult result) {

        log.info("Creating equipment type: {}", equipmentTypeDto.getName());

        JResponse<JEquipmentTypeDto> response = new JResponse<>();
        if (result.hasErrors()) {
            log.info("Validation erros: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors()
                    .add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        JEquipmentType equipmentType = this.dtoToEquipmentType(equipmentTypeDto);
        equipmentType = this.equipmentTypeService.create(equipmentType);

        response.setData(this.equipmentTypeToDto(equipmentType));
        return ResponseEntity.ok(response);
    }

    /**
     * Update equipment type.
     *
     * @param id
     * @param equipmentTypeDto
     * @return ResponseEntity<JResponse<JEquipmentTypeDto>>
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<JResponse<JEquipmentTypeDto>> update(@PathVariable("id") Long id,
            @Valid @RequestBody JEquipmentTypeDto equipmentTypeDto, BindingResult result) {

        log.info("Updating equipment type: {}", equipmentTypeDto.getName());

        JResponse<JEquipmentTypeDto> response = new JResponse<>();

        if (result.hasErrors()) {
            log.info("Validation errors: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        equipmentTypeDto.setId(id);
        JEquipmentType equipmentType = this.dtoToEquipmentType(equipmentTypeDto);
        equipmentType = this.equipmentTypeService.update(equipmentType);

        response.setData(this.equipmentTypeToDto(equipmentType));
        return ResponseEntity.ok(response);
    }

    /**
     * Delete equipment type by id.
     *
     * @param id
     * @return ResponseEntity<JResponse<JEquipmentType>>
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<JResponse<String>> delete(@PathVariable("id") Long id) {

        log.info("Removing equipment type by id: {}", id);

        JResponse<String> response = new JResponse<>();
        Optional<JEquipmentType> equipmentType = this.equipmentTypeService.findById(id);

        if (!equipmentType.isPresent()) {
            log.info("Invalid equipment type id: {}", id);
            response.getErrors().add("Invalid equipment type id: " + id);
            return ResponseEntity.badRequest().body(response);
        }

        this.equipmentTypeService.remove(id);

        return ResponseEntity.ok(new JResponse<>());
    }

    /**
     * Convert DTO to JEquipmentType.
     *
     * @param equipmentTypeDto
     * @return JEquipmentType
     */
    private JEquipmentType dtoToEquipmentType(JEquipmentTypeDto equipmentTypeDto) {
        JEquipmentType equipmentType = new JEquipmentType();
        equipmentType.setId(equipmentTypeDto.getId());
        equipmentType.setName(equipmentTypeDto.getName());

        return equipmentType;
    }

    /**
     * Convert JEquipmentType to DTO.
     *
     * @param equipmentType
     * @return JEquipmentTypeDto
     */
    private JEquipmentTypeDto equipmentTypeToDto(JEquipmentType equipmentType) {
        JEquipmentTypeDto equipmentTypeDto = new JEquipmentTypeDto();
        equipmentTypeDto.setId(equipmentType.getId());
        equipmentTypeDto.setName(equipmentType.getName());

        return equipmentTypeDto;
    }

}
