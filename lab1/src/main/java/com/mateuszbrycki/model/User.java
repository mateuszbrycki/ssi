package com.mateuszbrycki.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Mateusz Brycki on 27.08.2016.
 */
@Entity
@Table(name="user_account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String mail;

    @NotNull
    private String password;

    @NotNull
    @Column(name="is_active")
    private Boolean isActive;

    public User() {
    }

    public User(Long id, String username, String mail, String password, Boolean isActive) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
