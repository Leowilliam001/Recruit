package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "job")
@Data
public class Empl {
    @Id
    public String role;
    public String salary;
    public String phno;
}
