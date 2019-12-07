package com.example.lessonthree.jpa;

import com.example.lessonthree.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface BusJPA
    extends JpaRepository<Bus,Long>,
            JpaSpecificationExecutor<Bus>,
        Serializable {
    Bus findBusByLicencePlate(String licencePlate);
}
