package com.atm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating account object
        Account acc = new Account(12345678, 1234, 20000);

        System.out.println("===== ATM MACHINE =====");
        System.out.println("Account Number: " + acc.getAccountNo());

        // Login process
        boolean login = false;

        for (int i = 1; i <= 3; i++) {

            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (acc.verifyPin(enteredPin)) {

                System.out.println("Login successful!");
                login = true;
                break;
            } else {

                System.out.println("Incorrect PIN");

                if (i < 3) {
                    System.out.println("Attempts remaining: " + (3 - i));
                }
            }
        }

        // Stop program if login fails
        if (!login) {

            System.out.println("Card blocked. Too many incorrect attempts.");
            sc.close();
            return;
        }

        // ATM menu
        while (true) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change PIN");
            System.out.println("5. Last Transaction");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    System.out.println("Available Balance: "
                            + acc.getBalance());
                    break;
                }

                case 2: {
                    System.out.print("Enter deposit amount: ");
                    double amount = sc.nextDouble();

                    if (acc.deposit(amount)) {
                        System.out.println("Deposit successful!");
                        System.out.println("Updated Balance: "
                                + acc.getBalance());
                    }

                    break;
                }

                case 3: {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = sc.nextDouble();

                    if (acc.withdraw(amount)) {
                        System.out.println("Please collect your cash.");
                        System.out.println("Withdrawal successful!");
                        System.out.println("Remaining Balance: "
                                + acc.getBalance());
                    }

                    break;
                }

                case 4: {
                    System.out.print("Enter old PIN: ");
                    int oldPin = sc.nextInt();

                    System.out.print("Enter new PIN: ");
                    int newPin = sc.nextInt();

                    acc.changePin(oldPin, newPin);

                    break;
                }

                case 5: {
                    acc.showLastTransaction();
                    break;
                }

                case 0: {
                    System.out.println("Thank you for using ATM!");
                    sc.close();
                    return;
                }

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}


