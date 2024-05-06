package com.example.demo.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Empl;
import com.example.demo.service.PostjobService;

@Controller
public class DashController {

    private static final ArrayList<Empl> employees = new ArrayList<>();

    @Autowired
    private PostjobService service;

    @GetMapping("/dynamic")
    public String dynamic(Model model) {
        model.addAttribute("employees", employees);
        model.addAttribute("newEmployee", new Empl());
        return "dynamic";
    }

    @PostMapping("/remove-employee")
    public String removeEmployee(@RequestParam("role") String role) {
        service.remJob(role);
        employees.removeIf(employee -> employee.getRole().equals(role));
        return "redirect:/dynamic";
    }

    @GetMapping("/dash")
    public String dash() {
        return "dash";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@ModelAttribute("emp") Empl emp) {
        service.saveJob(emp.role, emp.salary, emp.phno);
        employees.add(emp);
        return "redirect:/dynamic";
    }

    @GetMapping("/comp")
    public String comp(Model model) throws SQLException {
        ResultSet rs = service.retJob();
        List<Map<String, String>> jobs = new ArrayList<>();

        while (rs.next()) {
            Map<String, String> job = new HashMap<>();
            job.put("Role", rs.getString(1));
            job.put("Salary", rs.getString(2));
            job.put("Phno", rs.getString(3));
            jobs.add(job);
        }

        model.addAttribute("jobs", jobs);
        return "comp";
    }

}
