package com.example.finance.service.impl;


import com.example.finance.dto.AuthResponse;
import com.example.finance.dto.LoginRequest;
import com.example.finance.entity.User;
import com.example.finance.repository.UserRepository;
import com.example.finance.service.userService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.finance.security.JwtUtil;


import java.util.List;

@Service
public class UserImplementation implements userService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserImplementation(UserRepository userRepository,
                              PasswordEncoder passwordEncoder,
                              JwtUtil jwtUtil,AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public User register(User user) {

        // 🔐 Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        try {
            System.out.println("LOGIN STARTED");

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            System.out.println("AUTH SUCCESS");

            String email = authentication.getName();

            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            String token = jwtUtil.generateToken(email, user.getRole().name());

            return new AuthResponse(token, user.getRole().name());

        } catch (Exception e) {
            System.out.println("AUTH FAILED: " + e.getMessage());
            e.printStackTrace(); // 🔥 VERY IMPORTANT
            throw new RuntimeException("Login failed"); // ✅ MUST return or throw
        }
    }

}