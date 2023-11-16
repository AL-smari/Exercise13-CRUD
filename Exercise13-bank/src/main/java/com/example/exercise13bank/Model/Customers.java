package com.example.exercise13bank.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customers {
    private String ID;
    private String username;
    private double balance;
}
