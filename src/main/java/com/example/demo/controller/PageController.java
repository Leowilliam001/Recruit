package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/reccont")
    public String reccont() {
        return "reccont"; // This will render reccont.html
    }

    @GetMapping("/recabout")
    public String recabout() {
        return "recabout"; // This will render recabout.html
    }

    @GetMapping("/new_disp")
    public String disp2() {
        return "disp2";
    }

}
