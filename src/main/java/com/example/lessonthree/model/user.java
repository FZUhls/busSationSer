package com.example.lessonthree.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class user implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UId")
    private Long id;

    @Column(name = "UName")
    private String name;

    @Column(name = "UOccup")
    private String occup;

    @Column(name = "UGender")
    private String sex;

    public String getOccup() {
        return occup;
    }

    public void setOccup(String occup) {
        this.occup = occup;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
}
