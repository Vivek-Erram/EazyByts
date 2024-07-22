
package com.stocktrading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stocktrading.model.Portfolio;


public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

	@Query("SELECT p FROM Portfolio p WHERE p.user.id = :userId")
	public  List<Portfolio> findByUserId(@Param("userId") Long userId);

}
