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

    @NotEmpty(message = "Gender cannot be empty.")
    @Length(max = 32, message = "Gender must be contain a maximum of {max} characters.")
    private String gender;

    @NotEmpty(message = "ChatId cannot be empty.")
    @Length(max = 255, message = "ChatId must be contain a maximum of {max} characters.")
    private String chatId;

    @ApiModelProperty(hidden = true)
    private Date created;

    @ApiModelProperty(hidden = true)
    private Date lastVisit;

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

    @Override
    public String toString() {
        return "JClientDto{" + "id=" + id + ", name=" + name + ", gender="
                + gender + ", chatId=" + chatId + ", created=" + created
                + ", lastVisit=" + lastVisit + '}';
    }

}
