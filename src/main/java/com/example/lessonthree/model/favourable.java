package com.example.lessonthree.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "favourable")
public class favourable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "class_num")
    private Long class_num;

    public Long getClassnum() {
        return class_num;
    }

    @Column(name = "class_name")
    private String class_name;

    public String getClassname() {
        return class_name;
    }

    @Column(name = "class_favourable")
    private Long class_favourable;
    public Long getCfavourable() {
        return class_favourable;
    }

}