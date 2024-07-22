package com.stocktrading.service;

import com.stocktrading.model.Performance;

import java.util.List;

public interface PerformanceService {
    Performance savePerformance(Performance performance);
    List<Performance> getPerformanceByUser(Long userId);
}
