package com.calculator;


import java.util.Scanner;

// Child Class 2
class AgriConnection extends Connection {

    AgriConnection(int consumerNo, int units) {
        super(consumerNo, units);
    }

    @Override
    public double getEnergyCharge() {
        return getUnits() * 2;
    }

    @Override
    public double getFixedCharge() {
        return 0;
    }

    @Override
    public double getDutyRate() {
        return 0;
    }

    @Override
    public void printType() {
        System.out.println("Agricultural");
    }
}

