package com.stocktrading.service;

import com.stocktrading.model.Trading;

import java.util.List;

public interface TradingService {
    Trading saveTrade(Trading trade);
    List<Trading> getTradesByUser(Long userId);
}
