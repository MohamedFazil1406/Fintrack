package com.example.finance.service;

import com.example.finance.dto.AuthResponse;
import com.example.finance.dto.LoginRequest;
import com.example.finance.entity.User;
import java.util.List;


public interface userService {

    User register(User user);

    List<User> getAllUsers();

    AuthResponse login(LoginRequest request);
}
