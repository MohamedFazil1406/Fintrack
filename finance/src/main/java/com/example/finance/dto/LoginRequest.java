package com.example.finance.dto;

import jakarta.validation.constraints.*;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;


}