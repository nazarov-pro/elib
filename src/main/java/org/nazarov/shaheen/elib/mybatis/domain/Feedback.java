package org.nazarov.shaheen.elib.mybatis.domain;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Shahin on 5/17/2017.
 */
public class Feedback {

    private int id;
    @Size(min = 5,max = 100)
    private String name;
    @Size(min = 5,max = 100)
    private String email;
    @Size(min = 10,max = 5000)
    private String message;
    private Date date = new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
