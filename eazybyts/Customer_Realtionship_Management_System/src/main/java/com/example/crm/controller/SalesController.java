package com.example.crm.controller;

import com.example.crm.model.Sales;
import com.example.crm.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    @PostMapping
    public Sales addSales(@RequestBody Sales sales) {
        return salesService.addSales(sales);
    }
}
