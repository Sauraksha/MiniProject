package com.parking;


import java.util.Scanner;



// ================= TRUCK CLASS =================

class Truck extends Vehicle {

    Truck(int ticketNo, int minutesParked, boolean passHolder) {
        super(ticketNo, minutesParked, passHolder);
    }

    @Override
    public double getRatePerHour() {
        return 40;
    }

    @Override
    public double getDailyCap() {
        return 300;
    }

    @Override
    public void printType() {
        System.out.println("Truck");
    }
}


