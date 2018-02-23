package com.jjdev.eagle.api.dtos;

import java.util.Date;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author JGilson
 */
public class JOrderDto {

    private Long id;

    @NotEmpty(message = "Initial date cannot be empty.")
    private Date initialDate;

    @NotEmpty(message = "Final date cannot be empty.")
    private Date finalDate;

    private Double value;

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

    @Override
    public String toString() {
        return "JOrderDto{" + "id=" + id + ", initialDate=" + initialDate
                + ", finalDate=" + finalDate + ", value=" + value + '}';
    }

}
