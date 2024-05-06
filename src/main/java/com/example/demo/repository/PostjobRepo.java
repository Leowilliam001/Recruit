package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Empl;
// import com.example.demo.domain.Postjob;

@Repository
public interface PostjobRepo extends JpaRepository<Empl, Integer> {

}
