package com.example.lessonthree.jpa;

import com.example.lessonthree.model.BusNumber;
import com.example.lessonthree.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public interface BusNumberJPA extends
        JpaRepository<BusNumber,Long>,
        JpaSpecificationExecutor<user>,
        Serializable {
    BusNumber findBusNumberByBusNum(Long busNum);//使用车次号查询
    List<BusNumber> findBusNumberByDeparture(String departure);//定义使用出发地查询的方法
    List<BusNumber> findBusNumberByDateAndDepTime(String date,String depTime);//定义出发时间查询
}
