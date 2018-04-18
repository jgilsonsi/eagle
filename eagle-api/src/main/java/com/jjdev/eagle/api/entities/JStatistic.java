package com.jjdev.eagle.api.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author JGilson
 */
@Entity
public class JStatistic implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "value", nullable = false)
    private Long value;

    public JStatistic() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "JStatistic{" + "name=" + name + ", value=" + value + '}';
    }

}
