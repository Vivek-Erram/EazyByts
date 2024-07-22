package com.stocktrading.service;
import com.stocktrading.model.User;
public interface UserService {
    // Define user-related methods here
	 public  User saveUser(User user);
	 public   User getUserByUsername(String username);
}
