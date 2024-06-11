package com.mechurao;
import lombok.Getter;
import lombok.ToString;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Account {
    private double balance;
    private List<Transaction> transactions;
    private String accountId;

    public Account(@NonNull String accountId, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountId = accountId;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        this.transactions.add(new Transaction(TransactionType.DEPOSIT, initialBalance, "initial", accountId));
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        transactions.add(new Transaction(TransactionType.DEPOSIT, amount, null, accountId));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
        transactions.add(new Transaction(TransactionType.WITHDRAW, amount, accountId, null));
    }
}
