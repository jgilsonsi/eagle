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
    @Column(name = "item", nullable = false, length = 255)
    private String item;

    @Column(name = "value", nullable = false)
    private Long value;

    public JStatistic() {
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "JStatistic{" + "item=" + item + ", value=" + value + '}';
    }

}
