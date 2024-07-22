package com.stocktrading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stocktrading.model.Trading;

public interface TradingRepository extends JpaRepository<Trading, Long> {
    @Query("SELECT t FROM Trading t WHERE t.user.id = :userId")
List<Trading> findByUserId(@Param("userId") Long userId);
}

