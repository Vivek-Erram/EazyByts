package com.example.crm.service;

import com.example.crm.model.Support;
import com.example.crm.repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportService {
    @Autowired
    private SupportRepository supportRepository;

    public List<Support> getAllSupportTickets() {
        return supportRepository.findAll();
    }

    public Support addSupportTicket(Support support) {
        return supportRepository.save(support);
    }
}

