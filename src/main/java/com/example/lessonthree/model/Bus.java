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

    @Column(name ="size")
    private String size;

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
    private Long driverNum;

    public Long getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(Long driverNum) {
        this.driverNum = driverNum;
    }

    @Column(name = "driver_name")
    private String driver_name;

    public String getDrivername() {
        return driver_name;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
