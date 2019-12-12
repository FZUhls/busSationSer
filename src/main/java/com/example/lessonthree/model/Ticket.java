package com.example.lessonthree.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ticket_price")
    private Long ticket_price;

    public Long getPrice() {
        return ticket_price;
    }

    @Column(name = "start_time")
    private String start_time;

    public String getStarttime() {
        return start_time;
    }

    @Column(name = "arrive_time")
    private String arrive_time;

    @Column(name = "start_place")
    private String start_place;

    public String getStartplace() {
        return start_place;
    }

    @Column(name = "arrive_place")
    private String arrive_place;


    @Column(name = "platform")
    private String platform;
    public String getPlatform() {
        return platform;
    }

    @Column(name = "passenger_num")
    private Long passenger_num;
    public Long getPassengernum() {
        return passenger_num;
    }

    @Column(name = "name")
    private String name;
    public String getName() {
        return name;
    }

    @Column(name = "class")
    private String passclass;
    public String getPassclass() {
        return passclass;
    }
}