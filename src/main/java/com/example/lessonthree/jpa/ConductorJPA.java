package com.example.lessonthree.jpa;

import com.example.lessonthree.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface ConductorJPA extends
        JpaRepository<Conductor,Long>,
        JpaSpecificationExecutor<Conductor>,
        Serializable {
    Conductor findConductorByConNum(Long comNum);
}
