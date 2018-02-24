package com.jjdev.eagle.api.dtos;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author JGilson
 */
public class JClientDto {

    @ApiModelProperty(hidden = true)
    private Long id;

    @NotEmpty(message = "Name cannot be empty.")
    @Length(max = 255, message = "Name must be contain a maximum of {max} characters.")
    private String name;

    @Length(max = 255, message = "Name must be contain a maximum of {max} characters.")
    private String chatId;

    @ApiModelProperty(hidden = true)
    private Date dateCreate;

    public JClientDto() {
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

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return "JClientDto{" + "id=" + id + ", name=" + name + ", chatId="
                + chatId + ", dateCreate=" + dateCreate + '}';
    }

}
