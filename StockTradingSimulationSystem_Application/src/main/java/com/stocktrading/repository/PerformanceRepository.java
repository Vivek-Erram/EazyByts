package com.stocktrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stocktrading.model.Performance;

import java.util.List;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
	 @Query("SELECT p FROM Performance p WHERE p.user.id = :userId")
	public List<Performance> findByUserId(Long userId);
}
