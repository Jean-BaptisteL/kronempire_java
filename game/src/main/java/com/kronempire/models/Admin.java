package com.kronempire.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_admin;

    @Column(name = "email_admin", nullable = false)
    private String email_admin;

    @Column(name = "password_admin", nullable = false)
    private String password_admin;

    @Column(name = "firstname_admin", nullable = false, length = 25)
    private String firstname_admin;

    @Column(name = "lastname_admin", nullable = false, length = 25)
    private String lastname_admin;

    @OneToMany(mappedBy = "admin")
    private Set<Message> messages;

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getEmail_admin() {
        return email_admin;
    }

    public void setEmail_admin(String email_admin) {
        this.email_admin = email_admin;
    }

    public String getPassword_admin() {
        return password_admin;
    }

    public void setPassword_admin(String password_admin) {
        this.password_admin = password_admin;
    }

    public String getFirstname_admin() {
        return firstname_admin;
    }

    public void setFirstname_admin(String firstname_admin) {
        this.firstname_admin = firstname_admin;
    }

    public String getLastname_admin() {
        return lastname_admin;
    }

    public void setLastname_admin(String lastname_admin) {
        this.lastname_admin = lastname_admin;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
