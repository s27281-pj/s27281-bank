package com.example.s27281_bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class User {
    private Integer id;
    private String peselNumber;
    private Double initialBalance;
    private UserCurrency userCurrency;
    private String firstName;
    private String surName;
}
