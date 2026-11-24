package com.parking;


import java.util.Scanner;

// ================= PARKING LOT CLASS =================

class ParkingLot {

    private int freeBikeSlots = 5;
    private int freeCarSlots = 3;
    private int freeTruckSlots = 2;

    private int nextTicketNo = 1;

    private double totalCollection = 0;

    private int vehiclesServed = 0;

    // Park vehicle and generate ticket
    public int parkVehicle(int type) {

        switch (type) {

            case 1:
                if (freeBikeSlots > 0) {
                    freeBikeSlots--;
                    return nextTicketNo++;
                }
                break;

            case 2:
                if (freeCarSlots > 0) {
                    freeCarSlots--;
                    return nextTicketNo++;
                }
                break;

            case 3:
                if (freeTruckSlots > 0) {
                    freeTruckSlots--;
                    return nextTicketNo++;
                }
                break;

            default:
                System.out.println("Invalid vehicle type.");
                return 0;
        }

        return 0;
    }

    // Release parking slot
    public boolean releaseSlot(int type) {

        switch (type) {

            case 1:
                if (freeBikeSlots < 5) {
                    freeBikeSlots++;
                    return true;
                }
                break;

            case 2:
                if (freeCarSlots < 3) {
                    freeCarSlots++;
                    return true;
                }
                break;

            case 3:
                if (freeTruckSlots < 2) {
                    freeTruckSlots++;
                    return true;
                }
                break;
        }

        return false;
    }

    // Add collection
    public void addCollection(double amount) {
        totalCollection = totalCollection + amount;
        vehiclesServed++;
    }

    // Check whether a vehicle of this type is parked
    public boolean hasParkedVehicle(int type) {

        switch (type) {

            case 1:
                return freeBikeSlots < 5;

            case 2:
                return freeCarSlots < 3;

            case 3:
                return freeTruckSlots < 2;

            default:
                return false;
        }
    }

    // Display free slots
    public void showAvailability() {

        System.out.println("\n======= PARKING AVAILABILITY =======");

        System.out.println("Free Bike Slots  : " + freeBikeSlots);
        System.out.println("Free Car Slots   : " + freeCarSlots);
        System.out.println("Free Truck Slots : " + freeTruckSlots);

        System.out.println("===================================");
    }

    // Display daily report
    public void showReport() {

        System.out.println("\n========= COLLECTION REPORT =========");

        System.out.println("Vehicles Served : " + vehiclesServed);

        System.out.printf("Total Collection: %.2f%n", totalCollection);

        System.out.println("=====================================");
    }
}


