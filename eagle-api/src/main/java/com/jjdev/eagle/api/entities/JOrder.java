package com.jjdev.eagle.api.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JGilson
 */
@Entity
@Table(name = "_order")
public class JOrder implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "initial_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date initialDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "final_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date finalDate;

    @Column(name = "_value", nullable = false)
    private Double value;

    @ManyToOne(fetch = FetchType.EAGER)
    private JClient client;

    @ManyToOne(fetch = FetchType.EAGER)
    private JEquipmentModel equipmentModel;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created;

    public JOrder() {
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

    public JClient getClient() {
        return client;
    }

    public void setClient(JClient client) {
        this.client = client;
    }

    public JEquipmentModel getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(JEquipmentModel equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @PrePersist
    public void prePersist() {
        created = new Date();
    }

    @Override
    public String toString() {
        return "JOrder{" + "id=" + id + ", initialDate=" + initialDate + ", finalDate="
                + finalDate + ", value=" + value + ", client=" + client + ", equipmentModel="
                + equipmentModel + ", created=" + created + '}';
    }

}
