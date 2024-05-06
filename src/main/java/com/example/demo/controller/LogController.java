package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Login;
import com.example.demo.service.LogService;
import com.example.demo.service.RegService;

@Controller

public class LogController {

    public String username;
    @Autowired
    private LogService service;

    @GetMapping("/")
    public String api() {

        return "log";
    }

    @PostMapping("/log")
    public String login(@ModelAttribute("user") Login user) {
        Login oauthUser = service.log(user.getUsername(), user.getPassword());
        // username = user.getUsername();
        // model1.addAttribute("loggedInUser", username);
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/rechome";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/rechome")
    public String display() {
        return "rechome";
    }

    @Autowired
    private RegService service2;

    @GetMapping("/register")
    public String api2() {

        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") Login user) {

        Login oauthUser = service2.saveUser(user.getUsername(), user.getPassword());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/";
        } else {
            return "redirect:/disp2";
        }
    }

    @GetMapping("/disp2")
    public String disp2() {
        return "disp2";
    }

}
