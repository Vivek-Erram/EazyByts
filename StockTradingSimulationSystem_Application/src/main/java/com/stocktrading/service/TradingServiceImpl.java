package com.stocktrading.service;

import com.stocktrading.model.Trading;
import com.stocktrading.repository.TradingRepository;
//import com.stocktrading.service.TradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradingServiceImpl implements TradingService {

    @Autowired
    private TradingRepository tradingRepository;

    @Override
    public Trading saveTrade(Trading trade) {
        return tradingRepository.save(trade);
    }

    @Override
    public List<Trading> getTradesByUser(Long userId) {
        return tradingRepository.findByUserId(userId);
    }
}
