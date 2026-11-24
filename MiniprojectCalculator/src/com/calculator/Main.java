package com.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Calculator cal = new Calculator();

        int choice;

        while (true) {

            System.out.println("\n===== SIMPLE CALCULATOR =====");
            System.out.println("1. Add two numbers");
            System.out.println("2. Add three numbers");
            System.out.println("3. Subtract");
            System.out.println("4. Multiply");
            System.out.println("5. Divide");
            System.out.println("6. Remainder");
            System.out.println("7. Power");
            System.out.println("8. Square");
            System.out.println("9. Show last result and operation count");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter first number: ");
                    int a = sc.nextInt();

                    System.out.print("Enter second number: ");
                    int b = sc.nextInt();

                    System.out.println("Result = " + cal.add(a, b));
                    break;

                case 2:
                    System.out.print("Enter first number: ");
                    int x = sc.nextInt();

                    System.out.print("Enter second number: ");
                    int y = sc.nextInt();

                    System.out.print("Enter third number: ");
                    int z = sc.nextInt();

                    System.out.println("Result = " + cal.add(x, y, z));
                    break;

                case 3:
                    System.out.print("Enter first number: ");
                    double num1 = sc.nextDouble();

                    System.out.print("Enter second number: ");
                    double num2 = sc.nextDouble();

                    System.out.println("Result = " + cal.subtract(num1, num2));
                    break;

                case 4:
                    System.out.print("Enter first number: ");
                    double m1 = sc.nextDouble();

                    System.out.print("Enter second number: ");
                    double m2 = sc.nextDouble();

                    System.out.println("Result = " + cal.multiply(m1, m2));
                    break;

                case 5:
                    System.out.print("Enter first number: ");
                    double d1 = sc.nextDouble();

                    System.out.print("Enter second number: ");
                    double d2 = sc.nextDouble();

                    System.out.println("Result = " + cal.divide(d1, d2));
                    break;

                case 6:
                    System.out.print("Enter first whole number: ");
                    int r1 = sc.nextInt();

                    System.out.print("Enter second whole number: ");
                    int r2 = sc.nextInt();

                    System.out.println("Result = " + cal.remainder(r1, r2));
                    break;

                case 7:
                    System.out.print("Enter base: ");
                    int base = sc.nextInt();

                    System.out.print("Enter exponent: ");
                    int exponent = sc.nextInt();

                    System.out.println("Result = " + cal.power(base, exponent));
                    break;

                case 8:
                    System.out.print("Enter a number: ");
                    double squareNum = sc.nextDouble();

                    System.out.println("Result = " + cal.square(squareNum));
                    break;

                case 9:
                    System.out.println("Last Result = " + cal.getLastResult());

                    System.out.println("Total Operations = "
                            + cal.getOperationCount());
                    break;

                case 0:
                    System.out.println("Thank you for using Calculator!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}


