package com.example.crm.controller;

import com.example.crm.model.Support;
import com.example.crm.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/support")
public class SupportController {
    @Autowired
    private SupportService supportService;

    @GetMapping
    public List<Support> getAllSupportTickets() {
        return supportService.getAllSupportTickets();
    }

    @PostMapping
    public Support addSupportTicket(@RequestBody Support support) {
        return supportService.addSupportTicket(support);
    }
}
