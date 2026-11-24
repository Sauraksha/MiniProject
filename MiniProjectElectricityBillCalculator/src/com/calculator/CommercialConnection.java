package com.calculator;


import java.util.Scanner;



// Child Class 1
class CommercialConnection extends Connection {

    CommercialConnection(int consumerNo, int units) {
        super(consumerNo, units);
    }

    @Override
    public double getEnergyCharge() {

        int units = getUnits();
        double charge;

        if (units <= 200) {
            charge = units * 7;
        }
        else {
            charge = (200 * 7) + (units - 200) * 10;
        }

        return charge;
    }

    @Override
    public double getFixedCharge() {
        return 150;
    }

    @Override
    public void printType() {
        System.out.println("Commercial");
    }
}

