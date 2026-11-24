package com.atm;


import java.util.Scanner;

class Account {

    // Private data members
    private int accountNo;
    private int pin;
    private double balance;
    private double withdrawnToday;
    private int lastTxnType;
    private double lastTxnAmount;

    // Constructor
    Account(int accountNo, int pin, double balance) {

        this.accountNo = accountNo;
        this.pin = pin;
        this.balance = balance;
        this.withdrawnToday = 0;
        this.lastTxnType = 0;
        this.lastTxnAmount = 0;
    }

    // Verify PIN
    public boolean verifyPin(int enteredPin) {

        if (this.pin == enteredPin) {
            return true;
        }

        return false;
    }

    // Deposit money
    public boolean deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero");
            return false;
        }

        balance = balance + amount;

        lastTxnType = 1;
        lastTxnAmount = amount;

        return true;
    }

    // Withdraw money
    public boolean withdraw(double amount) {

        // Check amount
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero");
            return false;
        }

        // Check multiple of 100
        if (amount % 100 != 0) {
            System.out.println("Amount must be a multiple of 100");
            return false;
        }

        // Check per withdrawal limit
        if (amount > 10000) {
            System.out.println("Maximum withdrawal limit is 10000");
            return false;
        }

        // Check daily withdrawal limit
        if (withdrawnToday + amount > 20000) {
            System.out.println("Daily withdrawal limit is 20000");
            return false;
        }

        // Check minimum balance
        if (balance - amount < 500) {
            System.out.println("Minimum balance of 500 must be maintained");
            return false;
        }

        // Successful withdrawal
        balance = balance - amount;

        withdrawnToday = withdrawnToday + amount;

        lastTxnType = 2;
        lastTxnAmount = amount;

        return true;
    }

    // Change PIN
    public boolean changePin(int oldPin, int newPin) {

        if (this.pin != oldPin) {
            System.out.println("Incorrect old PIN");
            return false;
        }

        if (newPin < 1000 || newPin > 9999) {
            System.out.println("New PIN must be a 4 digit number");
            return false;
        }

        if (oldPin == newPin) {
            System.out.println("New PIN must be different from old PIN");
            return false;
        }

        this.pin = newPin;

        System.out.println("PIN changed successfully");

        return true;
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Get account number
    public int getAccountNo() {
        return accountNo;
    }

    // Show last transaction
    public void showLastTransaction() {

        switch (lastTxnType) {

            case 0:
                System.out.println("No transaction available");
                break;

            case 1:
                System.out.println("Last Transaction: Deposit of "
                        + lastTxnAmount);
                break;

            case 2:
                System.out.println("Last Transaction: Withdraw of "
                        + lastTxnAmount);
                break;

            default:
                System.out.println("Invalid transaction type");
        }
    }
}

