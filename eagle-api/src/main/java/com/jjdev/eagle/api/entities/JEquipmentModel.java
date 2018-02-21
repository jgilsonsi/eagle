package com.jjdev.eagle.api.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author JGilson
 */
@Entity
@Table(name = "equipment_model")
public class JEquipmentModel implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private JEquipmentType equipmentType;

    public JEquipmentModel() {
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

    public JEquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(JEquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    @Override
    public String toString() {
        return "JEquipmentModel{" + "id=" + id + ", name=" + name
                + ", description=" + description + ", equipmentType="
                + equipmentType + '}';
    }

}
