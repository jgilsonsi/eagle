package com.jjdev.eagle.api.dtos;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 *
 * @author JGilson
 */
public class JOrderDto {

    @ApiModelProperty(hidden = true)
    private Long id;

    private Date initialDate;

    private Date finalDate;

    private Double value;

    private Long clientId;

    @ApiModelProperty(hidden = true)
    private String clientName;

    private Long equipmentModelId;

    @ApiModelProperty(hidden = true)
    private String equipmentModelName;

    @ApiModelProperty(hidden = true)
    private String equipmentTypeName;

    public JOrderDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public String getEquipmentTypeName() {
        return equipmentTypeName;
    }

    public void setEquipmentTypeName(String equipmentTypeName) {
        this.equipmentTypeName = equipmentTypeName;
    }

    @Override
    public String toString() {
        return "JOrderDto{" + "id=" + id + ", initialDate=" + initialDate
                + ", finalDate=" + finalDate + ", value=" + value + ", clientId="
                + clientId + ", clientName=" + clientName + ", equipmentModelId="
                + equipmentModelId + ", equipmentModelName=" + equipmentModelName
                + ", equipmentTypeName=" + equipmentTypeName + '}';
    }

}
