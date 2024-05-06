package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "login")
@Data
public class Login {
    @Id
    private String username;
    private String password;
}
