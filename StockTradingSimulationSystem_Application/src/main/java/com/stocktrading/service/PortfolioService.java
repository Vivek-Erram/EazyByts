package com.stocktrading.service;

import com.stocktrading.model.Portfolio;

import java.util.List;

public interface PortfolioService {
    Portfolio savePortfolio(Portfolio portfolio);
    List<Portfolio> getPortfolioByUser(Long userId);
}
