package com.stocktrading.runner;

import com.stocktrading.model.User;
import com.stocktrading.service.UserService;
import com.stocktrading.model.Trading;
import com.stocktrading.service.TradingService;
import com.stocktrading.model.Portfolio;
import com.stocktrading.service.PortfolioService;
import com.stocktrading.model.Performance;
import com.stocktrading.service.PerformanceService;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;
    
    @Autowired
    private TradingService tradingService;
    
    @Autowired
    private PortfolioService portfolioService;
    
    @Autowired
    private PerformanceService performanceService;

    @Override
    public void run(String... args) throws Exception {
        // Create a new user
        User user = new User();
        user.setUsername("john_doe");
        user.setPassword("password123");
        userService.saveUser(user);

        // Create a new trade
        Trading trade = new Trading();
        trade.setStockSymbol("AAPL");
        trade.setQuantity(10);
        trade.setPrice(150.0);
        trade.setTimestamp(LocalDateTime.now());
        trade.setUser(user);
        tradingService.saveTrade(trade);

        // Create a new portfolio entry
        Portfolio portfolio = new Portfolio();
        portfolio.setStockSymbol("AAPL");
        portfolio.setQuantity(10);
        portfolio.setAveragePrice(150.0);
        portfolio.setUser(user);
        portfolioService.savePortfolio(portfolio);

        // Create a new performance entry
        Performance performance = new Performance();
        performance.setStockSymbol("AAPL");
        performance.setProfitLoss(0.0);
        performance.setUser(user);
        performanceService.savePerformance(performance);

        // Output to console
        System.out.println("Demo data created.");
    }
}
