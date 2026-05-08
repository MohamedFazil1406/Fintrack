package com.example.finance.controller;

import com.example.finance.dto.CategorySummary;
import com.example.finance.dto.DashboardResponse;
import com.example.finance.dto.MonthlySummary;
import com.example.finance.entity.Transaction;
import com.example.finance.service.DashboardService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public DashboardResponse getDashboard() {

        String Email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return dashboardService.getDashboardData(Email);
    }

    @GetMapping("/monthly")
    public List<MonthlySummary> getMonthlyDashboard() {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return dashboardService.getMonthlySummary(username);
    }

    @GetMapping("/category")
    public List<CategorySummary> getCategorySummary() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return dashboardService.getCategorySummary(email);
    }

    @GetMapping("/recent")
    public List<Transaction> getRecentTransactions() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return dashboardService.getRecentTransactions(email);
    }
}