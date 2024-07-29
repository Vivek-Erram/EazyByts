package com.example.newsaggregator.controller;

import com.example.newsaggregator.model.User;
import com.example.newsaggregator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/login")
    public User loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.findByUsername(username);
        if (user != null && userService.passwordEncoder().matches(password, user.getPassword())) {
            return user;
        }
        return null; // Return an error or null if credentials are invalid
    }
}
