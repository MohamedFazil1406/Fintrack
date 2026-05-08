package com.example.finance.dto;

import lombok.*;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardResponse {

    private double totalIncome;
    private double totalExpense;
    private double balance;
    private Map<String, Double> categoryBreakdown;
}
