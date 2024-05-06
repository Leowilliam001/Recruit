package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Clog;
import com.example.demo.service.LogService;
import com.example.demo.service.RegService;

@Controller
public class ClogController {
    @Autowired
    private LogService service;

    @Autowired
    private RegService service2;

    @PostMapping("/canlog")
    public String login(@ModelAttribute("user") Clog user) {

        Clog oauthUser = service.canlog(user.getUsername(), user.getPassword());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            // model.addAttribute("loggedInUser", user.getUsername());
            return "candhome";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/cregister")
    public String api2() {

        return "cregister";
    }

    @PostMapping("/cregister")
    public String register(@ModelAttribute("user") Clog user) {

        Clog oauthUser = service2.saveCan(user.getUsername(), user.getPassword());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/clog";
        } else {
            return "redirect:/disp2";
        }
    }

    @GetMapping("/clog")
    public String clog() {
        return "clog";
    }

    @GetMapping("/rlog")
    public String rlog() {
        return "log";
    }
}
