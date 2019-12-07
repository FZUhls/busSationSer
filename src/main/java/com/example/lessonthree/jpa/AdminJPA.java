package com.example.lessonthree.jpa;
import com.example.lessonthree.model.Administrator;
import com.example.lessonthree.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface AdminJPA extends
        JpaRepository<Administrator,Long>,
        JpaSpecificationExecutor<Administrator>,
        Serializable {
    Administrator findByUsername(String username);
}
