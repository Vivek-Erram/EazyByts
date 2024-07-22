package com.stocktrading.repository;
import com.stocktrading.model.User;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stocktrading.model.*;
public interface UserRepository extends JpaRepository<User, Long> 
{

	com.stocktrading.model.User save(com.stocktrading.model.User user);

//	com.stocktrading.model.User save(com.stocktrading.model.User user);
	@Query("SELECT u FROM User u WHERE u.username = :username")
   public User findByUsername(@Param("username") String username);
	

	//com.stocktrading.model.User save(com.stocktrading.model.User user);
}

