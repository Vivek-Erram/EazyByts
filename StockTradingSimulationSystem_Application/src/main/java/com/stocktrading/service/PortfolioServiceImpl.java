package com.stocktrading.service;

import com.stocktrading.model.Portfolio;
import com.stocktrading.repository.PortfolioRepository;
import com.stocktrading.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public Portfolio savePortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public List<Portfolio> getPortfolioByUser(Long userId) {
        return portfolioRepository.findByUserId(userId);
    }
}
