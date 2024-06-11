package com.mechurao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private List<Account> accounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Bank Account Simulation");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Display Balance");
            System.out.println("5. Display Transactions");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    displayBalance();
                    break;
                case 5:
                    displayTransactions();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter account ID: ");
        String accountId = scanner.next();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        try {
            Account account = new Account(accountId, initialBalance);
            accounts.add(account);
            System.out.println("Account created successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void depositMoney() {
        System.out.print("Enter account ID: ");
        String accountId = scanner.next();
        Account account = findAccount(accountId);
        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.print("Enter deposit amount: ");
            double depositAmount = scanner.nextDouble();
            try {
                account.deposit(depositAmount);
                System.out.println("Deposit successful.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter account ID: ");
        String accountId = scanner.next();
        Account account = findAccount(accountId);
        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.print("Enter withdrawal amount: ");
            double withdrawAmount = scanner.nextDouble();
            try {
                account.withdraw(withdrawAmount);
                System.out.println("Withdrawal successful.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void displayBalance() {
        System.out.print("Enter account ID: ");
        String accountId = scanner.next();
        Account account = findAccount(accountId);
        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.println("Current balance: " + account.getBalance());
        }
    }

    private void displayTransactions() {
        System.out.print("Enter account ID: ");
        String accountId = scanner.next();
        Account account = findAccount(accountId);
        if (account == null) {
            System.out.println("Account not found.");
        } else {
            List<Transaction> transactions = account.getTransactions();
            System.out.println("Transactions:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private Account findAccount(String accountId) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }
}
