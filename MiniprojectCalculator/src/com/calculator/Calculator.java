package com.calculator;


import java.util.Scanner;

class Calculator {

    // Private data members
    private double lastResult;
    private int operationCount;

    // Constructor
    Calculator() {
        this.lastResult = 0;
        this.operationCount = 0;
    }

    // Add two integers
    public double add(int a, int b) {
        lastResult = a + b;
        operationCount++;
        return lastResult;
    }

    // Add two double values
    public double add(double a, double b) {
        lastResult = a + b;
        operationCount++;
        return lastResult;
    }

    // Add three integers
    public double add(int a, int b, int c) {
        lastResult = a + b + c;
        operationCount++;
        return lastResult;
    }

    // Subtraction
    public double subtract(double a, double b) {
        lastResult = a - b;
        operationCount++;
        return lastResult;
    }

    // Multiplication
    public double multiply(double a, double b) {
        lastResult = a * b;
        operationCount++;
        return lastResult;
    }

    // Division
    public double divide(double a, double b) {

        if (b == 0) {
            System.out.println("Cannot divide by zero");
            return lastResult;
        }

        lastResult = a / b;
        operationCount++;
        return lastResult;
    }

    // Remainder
    public double remainder(int a, int b) {

        if (b == 0) {
            System.out.println("Cannot divide by zero");
            return lastResult;
        }

        lastResult = a % b;
        operationCount++;
        return lastResult;
    }

    // Power using for loop
    public double power(int base, int exponent) {

        if (exponent < 0) {
            System.out.println("Exponent must be zero or positive");
            return lastResult;
        }

        double result = 1;

        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }

        lastResult = result;
        operationCount++;

        return lastResult;
    }

    // Square of a number
    public double square(double number) {
        lastResult = number * number;
        operationCount++;
        return lastResult;
    }

    // Getter for last result
    public double getLastResult() {
        return lastResult;
    }

    // Getter for operation count
    public int getOperationCount() {
        return operationCount;
    }
}

