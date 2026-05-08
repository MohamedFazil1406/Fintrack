package com.example.finance.service;

import com.example.finance.dto.CategorySummary;
import com.example.finance.dto.DashboardResponse;
import com.example.finance.dto.MonthlySummary;
import com.example.finance.entity.Transaction;

import java.util.List;

public interface DashboardService {
    DashboardResponse getDashboardData(String username);

    List<MonthlySummary> getMonthlySummary(String username);

    List<CategorySummary> getCategorySummary(String email);

    List<Transaction> getRecentTransactions(String email);
}