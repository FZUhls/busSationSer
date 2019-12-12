package com.example.lessonthree.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "conductor")
public class Conductor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "con_num")
    private Long con_num;

    public Long getConnum() {
        return con_num;
    }

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    @Column(name = "basic_salary")
    private Long basic_salary;
    public Long getBasicsalary() {
        return basic_salary;
    }

    @Column(name = "push_money")
    private Long push_money;

    public Long getPushmoney() {
        return push_money;
    }

    @Column(name = "ticket_num")
    private Long ticket_num;
    public Long getTicketnum() {
        return ticket_num;
    }

}