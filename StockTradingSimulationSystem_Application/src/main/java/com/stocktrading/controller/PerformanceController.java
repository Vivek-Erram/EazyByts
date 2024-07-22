package com.stocktrading.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/performance")
public class PerformanceController {

    @GetMapping
    public String performance() {
        return "performance";
    }
}
