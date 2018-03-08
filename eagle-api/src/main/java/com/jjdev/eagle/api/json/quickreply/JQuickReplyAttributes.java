package com.jjdev.eagle.api.json.quickreply;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author JGilson
 */
public class JQuickReplyAttributes {

    @JsonProperty("equipment_type_id")
    private Long equipmentTypeId;
    @JsonProperty("equipment_type_name")
    private String equipmentTypeName;

    public JQuickReplyAttributes() {
    }

    public Long getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(Long equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public String getEquipmentTypeName() {
        return equipmentTypeName;
    }

    public void setEquipmentTypeName(String equipmentTypeName) {
        this.equipmentTypeName = equipmentTypeName;
    }

}
