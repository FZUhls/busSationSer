package com.example.lessonthree.jpa;

import com.example.lessonthree.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface TicketJPA extends JpaRepository<Ticket,Long>,
        JpaSpecificationExecutor<Ticket>,
        Serializable {
}
