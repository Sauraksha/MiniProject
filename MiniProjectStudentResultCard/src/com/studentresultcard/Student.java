package com.studentresultcard;


import java.util.Scanner;

// Parent class
class Student {

    // Private data members
    private int rollNo;
    private int marks1;
    private int marks2;
    private int marks3;

    // Constructor
    Student(int rollNo, int marks1, int marks2, int marks3) {

        this.rollNo = rollNo;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    // Getter for roll number
    public int getRollNo() {
        return rollNo;
    }

    // Getter methods for marks
    public int getMarks1() {
        return marks1;
    }

    public int getMarks2() {
        return marks2;
    }

    public int getMarks3() {
        return marks3;
    }

    // Calculate total marks
    public int getTotal() {
        return marks1 + marks2 + marks3;
    }

    // Maximum total marks
    public int getMaxTotal() {
        return 300;
    }

    // Calculate percentage
    public double getPercentage() {

        return (double) getTotal() * 100 / getMaxTotal();
    }

    // Check pass or fail
    public boolean isPass() {

        if (marks1 >= 40 && marks2 >= 40 && marks3 >= 40) {
            return true;
        }

        return false;
    }

    // Calculate grade
    public char getGrade() {

        if (!isPass()) {
            return 'F';
        }

        double percentage = getPercentage();

        if (percentage >= 90) {
            return 'A';
        }
        else if (percentage >= 75) {
            return 'B';
        }
        else if (percentage >= 60) {
            return 'C';
        }
        else {
            return 'D';
        }
    }

    // Display common result details
    protected void showResultDetails() {

        System.out.println("Roll No     : " + getRollNo());
        System.out.println("Subject 1   : " + getMarks1());
        System.out.println("Subject 2   : " + getMarks2());
        System.out.println("Subject 3   : " + getMarks3());

        System.out.println("Total       : " + getTotal()
                + " / " + getMaxTotal());

        System.out.printf("Percentage  : %.2f%%%n", getPercentage());

        System.out.println("Grade       : " + getGrade());

        if (isPass()) {
            System.out.println("Result      : PASS");
        }
        else {
            System.out.println("Result      : FAIL");
        }
    }

    // Display result card
    public void showResultCard() {

        System.out.println("\n======= RESULT CARD =======");

        showResultDetails();

        System.out.println("===========================");
    }
}


