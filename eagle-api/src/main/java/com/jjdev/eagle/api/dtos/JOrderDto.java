package com.jjdev.eagle.api.dtos;

import java.util.Date;

/**
 *
 * @author JGilson
 */
public class JOrderDto {

    private Long id;

    private Date initialDate;

    private Date finalDate;

    private Double value;

    private Long clientId;

    private Long equipmentModelId;

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

    public Long getEquipmentModelId() {
        return equipmentModelId;
    }

    public void setEquipmentModelId(Long equipmentModelId) {
        this.equipmentModelId = equipmentModelId;
    }

    @Override
    public String toString() {
        return "JOrderDto{" + "id=" + id + ", initialDate=" + initialDate
                + ", finalDate=" + finalDate + ", value=" + value + ", clientId="
                + clientId + ", equipmentModelId=" + equipmentModelId + '}';
    }

}
