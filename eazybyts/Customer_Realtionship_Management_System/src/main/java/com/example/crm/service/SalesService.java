package com.example.crm.service;

import com.example.crm.model.Sales;
import com.example.crm.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Sales addSales(Sales sales) {
        return salesRepository.save(sales);
    }
}

