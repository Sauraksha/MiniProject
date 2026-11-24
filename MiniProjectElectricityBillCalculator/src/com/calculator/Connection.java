package com.calculator;


import java.util.Scanner;

// Parent Class
class Connection {

    private int consumerNo;
    private int units;

    // Constructor
    Connection(int consumerNo, int units) {
        this.consumerNo = consumerNo;
        this.units = units;
    }

    // Getter methods
    public int getConsumerNo() {
        return consumerNo;
    }

    public int getUnits() {
        return units;
    }

    // Domestic Energy Charge
    public double getEnergyCharge() {

        double charge;

        if (units <= 100) {
            charge = units * 3;
        }
        else if (units <= 300) {
            charge = (100 * 3) + (units - 100) * 5;
        }
        else {
            charge = (100 * 3) + (200 * 5)
                     + (units - 300) * 8;
        }

        return charge;
    }

    // Fixed Charge
    public double getFixedCharge() {
        return 50;
    }

    // Duty Rate
    public double getDutyRate() {
        return 0.05;
    }

    // Duty Calculation
    public double getDuty() {
        return (getEnergyCharge() + getFixedCharge())
                * getDutyRate();
    }

    // Calculate Final Bill
    public double calculateBill(boolean paidLate) {

        double energy = getEnergyCharge();
        double fixed = getFixedCharge();
        double duty = getDuty();

        double amount = energy + fixed + duty;

        double fine = 0;

        if (paidLate) {
            fine = amount * 0.02;
        }

        return amount + fine;
    }

    // Connection Type
    public void printType() {
        System.out.println("Domestic");
    }

    // Display Bill
    public void showBill(boolean paidLate) {

        double energy = getEnergyCharge();
        double fixed = getFixedCharge();
        double duty = getDuty();

        double amount = energy + fixed + duty;

        double fine = 0;

        if (paidLate) {
            fine = amount * 0.02;
        }

        double total = calculateBill(paidLate);

        System.out.println("\n========== ELECTRICITY BILL ==========");
        System.out.println("Consumer No    : " + getConsumerNo());

        System.out.print("Connection     : ");
        printType();

        System.out.println("Units Used     : " + getUnits());

        System.out.println("--------------------------------------");
        System.out.printf("Energy Charge  : %.2f%n", energy);
        System.out.printf("Fixed Charge   : %.2f%n", fixed);
        System.out.printf("Duty            : %.2f%n", duty);
        System.out.printf("Late Fine       : %.2f%n", fine);
        System.out.println("--------------------------------------");
        System.out.printf("Total Bill     : %.2f%n", total);
        System.out.println("======================================");
    }
}

