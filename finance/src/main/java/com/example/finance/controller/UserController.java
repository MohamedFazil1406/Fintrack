package com.example.finance.controller;

import com.example.finance.dto.AuthResponse;
import com.example.finance.dto.LoginRequest;
import com.example.finance.entity.User;
import com.example.finance.service.userService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final userService userService;

    public UserController(userService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return userService.login(request);
    }



    @GetMapping("/user")
    public String userAccess() {
        return "User access granted";
    }
}