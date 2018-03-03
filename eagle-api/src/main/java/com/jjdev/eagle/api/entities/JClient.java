package com.jjdev.eagle.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JGilson
 */
@Entity
@Table(name = "client")
public class JClient implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "_name", nullable = false, length = 255)
    private String name;

    @Column(name = "gender", nullable = false, length = 32)
    private String gender;

    @Column(name = "chat_id", unique = true, nullable = false, length = 255)
    private String chatId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_visit", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastVisit;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JOrder> orders;

    public JClient() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public List<JOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<JOrder> orders) {
        this.orders = orders;
    }

    @PrePersist
    public void prePersist() {
        created = new Date();
        lastVisit = created;
    }

    @PreUpdate
    public void preUpdate() {
        lastVisit = new Date();
    }

    @Override
    public String toString() {
        return "JClient{" + "id=" + id + ", name=" + name + ", gender="
                + gender + ", chatId=" + chatId + ", created=" + created
                + ", lastVisit=" + lastVisit + ", orders=" + orders + '}';
    }

}
