package com.example.finance.service;

import com.example.finance.entity.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction);

    List<Transaction> getUserTransactions(Long id);
}
