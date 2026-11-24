package com.parking;


import java.util.Scanner;

// ================= PARENT CLASS =================

class Vehicle {

    private int ticketNo;
    private int minutesParked;
    private boolean passHolder;

    // Constructor
    Vehicle(int ticketNo, int minutesParked, boolean passHolder) {
        this.ticketNo = ticketNo;
        this.minutesParked = minutesParked;
        this.passHolder = passHolder;
    }

    // Getter methods
    public int getTicketNo() {
        return ticketNo;
    }

    public int getMinutesParked() {
        return minutesParked;
    }

    public boolean isPassHolder() {
        return passHolder;
    }

    // Overridden by child classes
    public double getRatePerHour() {
        return 0;
    }

    public double getDailyCap() {
        return 0;
    }

    // Calculate billable hours
    public int getBillableHours() {

        if (minutesParked <= 15) {
            return 0;
        }

        int hours = minutesParked / 60;

        if (minutesParked % 60 != 0) {
            hours++;
        }

        return hours;
    }

    // Calculate normal parking fee
    public double calculateFee() {

        // Free parking up to 15 minutes
        if (minutesParked <= 15) {
            return 0;
        }

        int fullDays = minutesParked / 1440;
        int remainingMinutes = minutesParked % 1440;

        // Charge for complete days
        double fee = fullDays * getDailyCap();

        // Calculate remaining hours
        int remainingHours = remainingMinutes / 60;

        if (remainingMinutes % 60 != 0) {
            remainingHours++;
        }

        double remainingFee = remainingHours * getRatePerHour();

        // Remaining fee cannot exceed daily cap
        if (remainingFee > getDailyCap()) {
            remainingFee = getDailyCap();
        }

        fee = fee + remainingFee;

        return fee;
    }

    // Method Overloading
    public double calculateFee(boolean lostTicket) {

        double fee = calculateFee();

        double discount = 0;

        // Pass holder gets 50% discount
        if (passHolder) {
            discount = fee * 0.50;
        }

        fee = fee - discount;

        // Lost ticket fine
        if (lostTicket) {
            fee = fee + 200;
        }

        return fee;
    }

    public void printType() {
        System.out.println("Vehicle");
    }

    // Display receipt
    public void showReceipt(boolean lostTicket) {

        double parkingFee = calculateFee();

        double discount = 0;

        if (passHolder) {
            discount = parkingFee * 0.50;
        }

        double fine = 0;

        if (lostTicket) {
            fine = 200;
        }

        double total = calculateFee(lostTicket);

        System.out.println("\n========== PARKING RECEIPT ==========");

        System.out.println("Ticket No      : " + ticketNo);

        System.out.print("Vehicle        : ");
        printType();

        System.out.println("Time Parked    : " + minutesParked + " minutes");
        System.out.println("Billable Hours : " + getBillableHours());

        System.out.printf("Rate Per Hour  : %.2f%n", getRatePerHour());

        System.out.println("-------------------------------------");

        System.out.printf("Parking Fee    : %.2f%n", parkingFee);
        System.out.printf("Pass Discount  : %.2f%n", discount);
        System.out.printf("Lost Ticket    : %.2f%n", fine);

        System.out.println("-------------------------------------");

        System.out.printf("Total to Pay   : %.2f%n", total);

        System.out.println("=====================================");
    }
}


