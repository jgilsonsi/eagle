package com.jjdev.eagle.api.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author JGilson
 */
@Entity
@Table(name = "equipment_type")
public class JEquipmentType implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "_name", nullable = false, unique = true, length = 255)
    private String name;

    @OneToMany(mappedBy = "equipmentType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JEquipmentModel> equipmentModels;

    public JEquipmentType() {
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

    public List<JEquipmentModel> getEquipmentModels() {
        return equipmentModels;
    }

    public void setEquipmentModels(List<JEquipmentModel> equipmentModels) {
        this.equipmentModels = equipmentModels;
    }

    @Override
    public String toString() {
        return "JEquipmentType{" + "id=" + id + ", name=" + name
                + ", equipmentModels=" + equipmentModels + '}';
    }

}
