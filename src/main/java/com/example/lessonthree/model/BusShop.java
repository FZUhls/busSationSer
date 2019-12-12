package com.example.lessonthree.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "bus_shop")
public class BusShop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bus_class")
    private String bus_class;

    public String getBusclass() {
        return bus_class;
    }

    public void setBusclass(String busclass) {
        this.bus_class = busclass;
    }

    @Column(name = "bus_price")
    private Long bus_price;

    public Long getprice() {
        return bus_price;
    }

}