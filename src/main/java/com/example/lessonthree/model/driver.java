package com.example.lessonthree.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "driver")
public class driver implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "driver_num")
    private Long driver_num;

    public Long getDrivernum() {
        return driver_num;
    }

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    @Column(name = "salary")
    private Long salary;
    public Long getsalary() {
        return salary;
    }

}