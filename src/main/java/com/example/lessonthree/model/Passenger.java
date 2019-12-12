package com.example.lessonthree.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "passenger")
public class Passenger implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_card")
    private Long id_card;

    public Long Idcard() {
        return id_card;
    }

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    @Column(name = "class")
    private String pass_class;
    public String getPass_class() {
        return pass_class;
    }

    @Column(name = "phone_num")
    private Long phone_num;

    public Long Phonenum() {
        return phone_num;
    }
}