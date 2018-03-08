package com.jjdev.eagle.api.json.list;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author JGilson
 */
public class JListSetAttributes {

    @JsonProperty("equipment_model_id")
    private Long equipmentModelId;
    @JsonProperty("equipment_model_name")
    private String equipmentModelName;
    @JsonProperty("equipment_model_rate")
    private Double equipmentModelRate;

    public JListSetAttributes() {
    }

    public Long getEquipmentModelId() {
        return equipmentModelId;
    }

    public void setEquipmentModelId(Long equipmentModelId) {
        this.equipmentModelId = equipmentModelId;
    }

    public String getEquipmentModelName() {
        return equipmentModelName;
    }

    public void setEquipmentModelName(String equipmentModelName) {
        this.equipmentModelName = equipmentModelName;
    }

    public Double getEquipmentModelRate() {
        return equipmentModelRate;
    }

    public void setEquipmentModelRate(Double equipmentModelRate) {
        this.equipmentModelRate = equipmentModelRate;
    }

}
