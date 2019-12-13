package com.example.lessonthree.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "bus")
public class Bus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "licence_plate")
    private String licencePlate;

    @Column(name = "brand")
    private String brand;

    @Column(name = "max_passen")
    private Long maxPassen;

    public Long getMaxPassen() {
        return maxPassen;
    }

    public void setMaxPassen(Long maxPassen) {
        this.maxPassen = maxPassen;
    }

    @Column(name = "driver_num")
    private String  driverNum;

    public String getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }

    @Column(name = "driver_name")
    private String driverName;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
