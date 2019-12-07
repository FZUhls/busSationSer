package com.example.lessonthree.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "administrator")
public class Administrator implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "passwd")
    private Long passwd;

    public Long getId() {
        return id;
    }

    public void setId(Long ID) {
        this.id = ID;
    }

    public Long getPasswd() {
        return passwd;
    }

    public void setPasswd(Long passwd) {
        this.passwd = passwd;
    }
}