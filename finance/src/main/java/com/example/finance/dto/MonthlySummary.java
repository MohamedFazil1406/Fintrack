package com.example.finance.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonthlySummary {

    private String month;
    private double income;
    private double expense;




}