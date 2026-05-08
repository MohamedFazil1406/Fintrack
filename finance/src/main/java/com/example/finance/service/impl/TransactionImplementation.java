package com.example.finance.service.impl;

import com.example.finance.entity.Transaction;
import com.example.finance.repository.TransactionRepository;
import com.example.finance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionImplementation implements TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;

    public TransactionImplementation(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getUserTransactions(Long userId) {
        return transactionRepository.findByUserId(userId);
    }
}
