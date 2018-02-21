package com.jjdev.eagle.api.dtos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author JGilson
 */
public class JEquipmentTypeDto {

    private Long id;

    @NotEmpty(message = "Name cannot be empty.")
    @Length(max = 255, message = "Name must be contain a maximum of 255 characters.")
    private String name;

    public JEquipmentTypeDto() {
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

    @Override
    public String toString() {
        return "JEquipmentTypeDto{" + "id=" + id + ", name=" + name + '}';
    }

}
