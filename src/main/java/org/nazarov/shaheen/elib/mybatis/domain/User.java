package org.nazarov.shaheen.elib.mybatis.domain;

import org.nazarov.shaheen.elib.mybatis.tool.Role;
import org.nazarov.shaheen.elib.mybatis.tool.Status;
import pro.nazarov.tool.Validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Shahin on 5/17/2017.
 */
public class User {

    private int id;
    @Size(min = 5 , message = Validation.NOT_NULL_MESSAGE)
    private String fullName;
    @Pattern(regexp = Validation.EMAIL_REGEX , message = Validation.EMAIL_MESSAGE)
    private String email;
    @Pattern(regexp = Validation.PASSWORD_LIGHT_REGEX , message = Validation.PASSWORD_LIGHT_MESSAGE)
    private String password;
    private Role role;
    private String image;
    @Pattern(regexp = Validation.PHONENUMBER_REGEX , message = Validation.PHONENUMBER_MESSAGE)
    private String phone;
    private Status status;

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
