package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Clog;
import com.example.demo.domain.Login;
import com.example.demo.repository.ClogRepo;
import com.example.demo.repository.LogRepo;

@Service
public class LogService {
    @Autowired
    private LogRepo rep;

    public Login log(String username, String password) {
        Login user = rep.findByUsernameAndPassword(username, password);
        return user;
    }

    @Autowired
    private ClogRepo crep;

    public Clog canlog(String canuser, String canpass) {
        Clog user = crep.findByUsernameAndPassword(canuser, canpass);
        return user;
    }
}
