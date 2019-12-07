package com.example.lessonthree.model;

import javax.persistence.*;
import java.io.Serializable;

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
