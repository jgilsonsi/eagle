package com.jjdev.eagle.api.dtos;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author JGilson
 */
public class JUserDto {

    @ApiModelProperty(hidden = true)
    private Long id;

    @NotEmpty(message = "Name cannot be empty.")
    @Length(max = 255, message = "Name must be contain a maximum of {max} characters.")
    private String name;

    @NotEmpty(message = "Email cannot be empty.")
    @Length(min = 5, max = 255, message = "User must be contain between {min} and {max} characters.")
    @Email(message = "Invalid email.")
    private String email;

    @NotEmpty(message = "Password cannot be empty.")
    @Length(min = 6, max = 255, message = "Password must be contain between {min} and {max} characters.")
    private String password;

    @ApiModelProperty(hidden = true)
    private String role;

    public JUserDto() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDto{" + "id=" + id + ", name=" + name + ", email=" + email
                + ", password=" + password + ", role=" + role + '}';
    }

}
