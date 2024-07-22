package com.stocktrading.service;

import com.stocktrading.model.Performance;
import com.stocktrading.repository.PerformanceRepository;
import com.stocktrading.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Override
    public Performance savePerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    @Override
    public List<Performance> getPerformanceByUser(Long userId) {
        return performanceRepository.findByUserId(userId);
    }
}
