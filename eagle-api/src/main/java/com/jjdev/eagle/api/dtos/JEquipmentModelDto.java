package com.jjdev.eagle.api.dtos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author JGilson
 */
public class JEquipmentModelDto {

    private Long id;

    @NotEmpty(message = "Name cannot be empty.")
    @Length(max = 255, message = "Name must be contain a maximum of {max} characters.")
    private String name;

    private String description;

    private JEquipmentTypeDto equipmentTypeDto;

    public JEquipmentModelDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JEquipmentTypeDto getEquipmentTypeDto() {
        return equipmentTypeDto;
    }

    public void setEquipmentTypeDto(JEquipmentTypeDto equipmentTypeDto) {
        this.equipmentTypeDto = equipmentTypeDto;
    }

    @Override
    public String toString() {
        return "JEquipmentModelDto{" + "id=" + id + ", name=" + name
                + ", description=" + description + ", equipmentTypeDto="
                + equipmentTypeDto + '}';
    }

}
