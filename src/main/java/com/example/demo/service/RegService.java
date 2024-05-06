package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Clog;
import com.example.demo.domain.Login;
import com.example.demo.repository.ClogRepo;
import com.example.demo.repository.LogRepo;

@Service
public class RegService {
    @Autowired
    private LogRepo userRepository;

    public Login saveUser(String username, String password) {
        Login user = new Login();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Autowired
    private ClogRepo canRepository;

    public Clog saveCan(String canuser, String canpass) {
        Clog user = new Clog();
        user.setUsername(canuser);
        user.setPassword(canpass);
        return canRepository.save(user);
    }

}
