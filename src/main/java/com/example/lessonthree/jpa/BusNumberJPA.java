package com.example.lessonthree.jpa;

import com.example.lessonthree.model.BusNumber;
import com.example.lessonthree.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

public interface BusNumberJPA extends
        JpaRepository<BusNumber,Long>,
        JpaSpecificationExecutor<user>,
        Serializable {
    BusNumber findBusNumberByBusNum(Long busNum);
}
