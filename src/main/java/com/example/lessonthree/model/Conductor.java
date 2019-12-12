package com.example.lessonthree.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "conductor")
public class Conductor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "con_num")
    private Long conNum;

    @Column(name = "name")
    private String name;

    @Column(name = "basic_salary")
    private Long basicSalary;

    @Column(name = "push_money")
    private Long pushMoney;

    @Column(name = "ticket_num")
    private Long ticketNum;

    public Long getId() {
        return id;
    }

    public Long getConNum() {
        return conNum;
    }

    public String getName() {
        return name;
    }

    public Long getBasicSalary() {
        return basicSalary;
    }

    public Long getPushMoney() {
        return pushMoney;
    }

    public Long getTicketNum() {
        return ticketNum;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setConNum(Long conNum) {
        this.conNum = conNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasicSalary(Long basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setPushMoney(Long pushMoney) {
        this.pushMoney = pushMoney;
    }

    public void setTicketNum(Long ticketNum) {
        this.ticketNum = ticketNum;
    }
}