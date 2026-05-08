package com.example.finance.controller;

import com.example.finance.entity.Transaction;
import com.example.finance.entity.User;
import com.example.finance.repository.UserRepository;
import com.example.finance.service.TransactionService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private TransactionService transactionService;
    private UserRepository userRepository;

    public TransactionController(TransactionService transactionService, UserRepository userRepository) {
        this.transactionService = transactionService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {

        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        System.out.println("EMAIL FROM TOKEN: " + email);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ ALWAYS assign user from JWT
        transaction.setUser(user);

        return transactionService.addTransaction(transaction);
    }

    @GetMapping("/{userId}")
    public List<Transaction> getTransactions(@PathVariable Long userId) {
        return transactionService.getUserTransactions(userId);
    }
}
