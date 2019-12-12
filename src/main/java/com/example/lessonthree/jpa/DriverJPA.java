package com.example.lessonthree.jpa;

import com.example.lessonthree.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface DriverJPA extends
        JpaRepository<Driver,Long>,
        JpaSpecificationExecutor<Driver>,
        Serializable {
    Driver findDriverByDriverNum(Long driverNum);
}
