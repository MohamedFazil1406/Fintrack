package com.example.finance.service.impl;

import com.example.finance.dto.CategorySummary;
import com.example.finance.dto.DashboardResponse;
import com.example.finance.dto.MonthlySummary;
import com.example.finance.entity.Transaction;
import com.example.finance.repository.TransactionRepository;
import com.example.finance.repository.UserRepository;
import com.example.finance.service.DashboardService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public DashboardServiceImpl(TransactionRepository transactionRepository,
                                UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DashboardResponse getDashboardData(String email) {

        List<Transaction> transactions =
                transactionRepository.findByUserEmail(email);

        double income = 0;
        double expense = 0;
        Map<String, Double> categoryMap = new HashMap<>();

        for (Transaction t : transactions) {

            if (t.getType().equals("INCOME")) {
                income += t.getAmount();
            } else {
                expense += t.getAmount();
            }

            categoryMap.put(
                    t.getCategory(),
                    categoryMap.getOrDefault(t.getCategory(), 0.0) + t.getAmount()
            );
        }

        DashboardResponse response = new DashboardResponse();
        response.setTotalIncome(income);
        response.setTotalExpense(expense);
        response.setBalance(income - expense);
        response.setCategoryBreakdown(categoryMap);

        return response;
    }

    @Override
    public List<MonthlySummary> getMonthlySummary(String email) {

        Long userId = userRepository
                .findByEmail(email)
                .orElseThrow()
                .getId();

        List<Transaction> transactions =
                transactionRepository.findByUserId(userId);

        Map<String, Double> incomeMap = new HashMap<>();
        Map<String, Double> expenseMap = new HashMap<>();

        for (Transaction t : transactions) {

            String month = t.getDate().getMonth().toString();

            if ("INCOME".equals(t.getType())) {
                incomeMap.put(month,
                        incomeMap.getOrDefault(month, 0.0) + t.getAmount());
            } else {
                expenseMap.put(month,
                        expenseMap.getOrDefault(month, 0.0) + t.getAmount());
            }
        }

        List<MonthlySummary> result = new ArrayList<>();

        Set<String> allMonths = new HashSet<>();
        allMonths.addAll(incomeMap.keySet());
        allMonths.addAll(expenseMap.keySet());

        for (String month : allMonths) {
            result.add(new MonthlySummary(
                    month,
                    incomeMap.getOrDefault(month, 0.0),
                    expenseMap.getOrDefault(month, 0.0)
            ));
        }

        return result;
    }

    @Override
    public List<CategorySummary> getCategorySummary(String email) {

        Long userId = userRepository
                .findByEmail(email)
                .orElseThrow()
                .getId();

        List<Transaction> transactions =
                transactionRepository.findByUserId(userId);

        Map<String, Double> categoryMap = new HashMap<>();

        for (Transaction t : transactions) {
            categoryMap.put(
                    t.getCategory(),
                    categoryMap.getOrDefault(t.getCategory(), 0.0) + t.getAmount()
            );
        }

        List<CategorySummary> result = new ArrayList<>();

        for (Map.Entry<String, Double> entry : categoryMap.entrySet()) {
            result.add(new CategorySummary(entry.getKey(), entry.getValue()));
        }

        return result;
    }

    @Override
    public List<Transaction> getRecentTransactions(String email) {

        Long userId = userRepository
                .findByEmail(email)
                .orElseThrow()
                .getId();

        return transactionRepository
                .findByUserId(userId);
    }
}