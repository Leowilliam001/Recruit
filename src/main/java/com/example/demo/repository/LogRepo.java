package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Login;

@Repository
public interface LogRepo extends JpaRepository<Login, String> {
    Login findByUsernameAndPassword(String username, String password);
}
