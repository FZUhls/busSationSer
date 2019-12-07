package com.example.lessonthree.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "bus_number")
public class BusNumber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bus_num")
    private Long busNum;

    @Column(name = "departure")
    private String departure;

    @Column(name = "destination")
    private String destination;

    @Column(name = "licence_plate")
    private String licencePlate;

    @Column(name = "ticket_cost")
    private Long ticketCost;

    @Column(name = "dep_time")
    private String depTime;

    @Column(name = "arr_time")
    private String arrTime;

    @Column(name = "platform")
    private String platform;

    @Column(name = "date")
    private String  date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusNum() {
        return busNum;
    }

    public void setBusNum(Long busNum) {
        this.busNum = busNum;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Long getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(Long ticketCost) {
        this.ticketCost = ticketCost;
    }
}
