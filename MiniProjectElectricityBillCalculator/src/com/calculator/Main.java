package com.calculator;


import java.util.Scanner;


// Main Class
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        int billCount = 0;
        double totalRevenue = 0;
        double highestBill = 0;
        int highestConsumerNo = 0;

        do {

            System.out.println("\n===== ELECTRICITY BILL CALCULATOR =====");
            System.out.println("1. Domestic Bill");
            System.out.println("2. Commercial Bill");
            System.out.println("3. Agricultural Bill");
            System.out.println("4. Show Summary");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) {

                int consumerNo;

                do {
                    System.out.print("Enter Consumer Number: ");
                    consumerNo = sc.nextInt();

                    if (consumerNo <= 0) {
                        System.out.println(
                            "Consumer number must be greater than zero."
                        );
                    }

                } while (consumerNo <= 0);

                int units;

                do {
                    System.out.print("Enter Units Used: ");
                    units = sc.nextInt();

                    if (units < 0) {
                        System.out.println(
                            "Units cannot be negative. Enter again."
                        );
                    }

                } while (units < 0);

                // Runtime Polymorphism
                Connection c;

                if (choice == 1) {
                    c = new Connection(consumerNo, units);
                }
                else if (choice == 2) {
                    c = new CommercialConnection(consumerNo, units);
                }
                else {
                    c = new AgriConnection(consumerNo, units);
                }

                int lateChoice;

                do {
                    System.out.println(
                        "Is payment late? (1 = Yes, 2 = No)"
                    );
                    lateChoice = sc.nextInt();

                    if (lateChoice != 1 && lateChoice != 2) {
                        System.out.println("Invalid choice. Try again.");
                    }

                } while (lateChoice != 1 && lateChoice != 2);

                boolean paidLate = (lateChoice == 1);

                // Display Bill
                c.showBill(paidLate);

                // Calculate bill for summary
                double bill = c.calculateBill(paidLate);

                billCount++;
                totalRevenue += bill;

                if (bill > highestBill) {
                    highestBill = bill;
                    highestConsumerNo = consumerNo;
                }

            }
            else if (choice == 4) {

                System.out.println("\n========== BILL SUMMARY ==========");
                System.out.println("Number of Bills : " + billCount);
                System.out.printf(
                    "Total Revenue  : %.2f%n", totalRevenue
                );

                if (billCount > 0) {
                    System.out.printf(
                        "Highest Bill   : %.2f%n", highestBill
                    );
                    System.out.println(
                        "Consumer No    : " + highestConsumerNo
                    );
                }
                else {
                    System.out.println("No bills generated yet.");
                }

                System.out.println("==================================");
            }
            else if (choice == 0) {
                System.out.println("Thank you for using the system!");
            }
            else {
                System.out.println("Invalid menu choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}

