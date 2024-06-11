package com.mechurao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Transaction {
    private TransactionType type;
    private double amount;
    private String sender;
    private String recipient;
}
