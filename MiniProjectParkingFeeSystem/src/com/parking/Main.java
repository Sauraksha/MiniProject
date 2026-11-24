package com.parking;


import java.util.Scanner;



// ================= MAIN CLASS =================

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ParkingLot lot = new ParkingLot();

        int choice;

        do {

            System.out.println("\n======= PARKING FEE SYSTEM =======");

            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle and Pay");
            System.out.println("3. Show Free Slots");
            System.out.println("4. Collection Report");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // ========== PARK VEHICLE ==========

                case 1:

                    int parkType;

                    do {
                        System.out.println("\n--- Vehicle Type ---");
                        System.out.println("1. Bike");
                        System.out.println("2. Car");
                        System.out.println("3. Truck");

                        System.out.print("Select vehicle type: ");
                        parkType = sc.nextInt();

                        if (parkType < 1 || parkType > 3) {
                            System.out.println("Invalid vehicle type. Try again.");
                        }

                    } while (parkType < 1 || parkType > 3);

                    int ticket = lot.parkVehicle(parkType);

                    if (ticket == 0) {
                        System.out.println("Parking full! No ticket issued.");
                    }
                    else {
                        System.out.println("\nVehicle parked successfully!");
                        System.out.println("Your Ticket Number: " + ticket);
                    }

                    break;


                // ========== EXIT VEHICLE ==========

                case 2:

                    int exitType;

                    do {
                        System.out.println("\n--- Vehicle Type ---");
                        System.out.println("1. Bike");
                        System.out.println("2. Car");
                        System.out.println("3. Truck");

                        System.out.print("Select vehicle type: ");
                        exitType = sc.nextInt();

                        if (exitType < 1 || exitType > 3) {
                            System.out.println("Invalid vehicle type. Try again.");
                        }

                    } while (exitType < 1 || exitType > 3);

                    // Check whether vehicle is parked
                    if (!lot.hasParkedVehicle(exitType)) {
                        System.out.println("Error: No vehicle of this type is parked.");
                        break;
                    }

                    int ticketNo;

                    do {
                        System.out.print("Enter Ticket Number: ");
                        ticketNo = sc.nextInt();

                        if (ticketNo <= 0) {
                            System.out.println("Ticket number must be positive.");
                        }

                    } while (ticketNo <= 0);

                    int minutes;

                    do {
                        System.out.print("Enter Minutes Parked: ");
                        minutes = sc.nextInt();

                        if (minutes <= 0) {
                            System.out.println("Minutes must be greater than zero.");
                        }

                    } while (minutes <= 0);

                    int passChoice;

                    do {
                        System.out.println("Pass Holder? (1 = Yes, 2 = No)");
                        passChoice = sc.nextInt();

                        if (passChoice != 1 && passChoice != 2) {
                            System.out.println("Invalid choice.");
                        }

                    } while (passChoice != 1 && passChoice != 2);

                    boolean passHolder = (passChoice == 1);

                    int lostChoice;

                    do {
                        System.out.println("Lost Ticket? (1 = Yes, 2 = No)");
                        lostChoice = sc.nextInt();

                        if (lostChoice != 1 && lostChoice != 2) {
                            System.out.println("Invalid choice.");
                        }

                    } while (lostChoice != 1 && lostChoice != 2);

                    boolean lostTicket = (lostChoice == 1);

                    // Runtime Polymorphism
                    Vehicle v;

                    switch (exitType) {

                        case 1:
                            v = new Bike(ticketNo, minutes, passHolder);
                            break;

                        case 2:
                            v = new Car(ticketNo, minutes, passHolder);
                            break;

                        default:
                            v = new Truck(ticketNo, minutes, passHolder);
                            break;
                    }

                    // Release slot only if a vehicle of this type is parked
                    if (lot.releaseSlot(exitType)) {

                        // Display receipt
                        v.showReceipt(lostTicket);

                        // Update collection
                        double amount = v.calculateFee(lostTicket);

                        lot.addCollection(amount);

                        System.out.println("\nVehicle exited successfully.");
                    }
                    else {
                        System.out.println("Unable to release parking slot.");
                    }

                    break;


                // ========== FREE SLOTS ==========

                case 3:

                    lot.showAvailability();

                    break;


                // ========== COLLECTION REPORT ==========

                case 4:

                    lot.showReport();

                    break;


                // ========== EXIT ==========

                case 0:

                    System.out.println("Thank you for using Parking Fee System!");

                    break;


                default:

                    System.out.println("Invalid menu choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}

