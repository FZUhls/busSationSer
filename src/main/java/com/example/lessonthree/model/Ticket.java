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

    @Column(name = "start_time")
    private String start_time;

    @Column(name = "arrive_time")
    private String arrive_time;

    @Column(name = "start_place")
    private String start_place;

    @Column(name = "arrive_place")
    private String arrive_place;

    @Column(name = "platform")
    private String platform;

    @Column(name = "passenger_num")
    private Long passenger_num;

    @Column(name = "name")
    private String name;

    @Column(name = "class")
    private String passclass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(Long ticket_price) {
        this.ticket_price = ticket_price;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(String arrive_time) {
        this.arrive_time = arrive_time;
    }

    public String getStart_place() {
        return start_place;
    }

    public void setStart_place(String start_place) {
        this.start_place = start_place;
    }

    public String getArrive_place() {
        return arrive_place;
    }

    public void setArrive_place(String arrive_place) {
        this.arrive_place = arrive_place;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Long getPassenger_num() {
        return passenger_num;
    }

    public void setPassenger_num(Long passenger_num) {
        this.passenger_num = passenger_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassclass() {
        return passclass;
    }

    public void setPassclass(String passclass) {
        this.passclass = passclass;
    }
}