package com.studentresultcard;

import java.util.Scanner;

//Main class
public class Main {

 // Method to read valid marks
 public static int readValidMarks(Scanner sc, String subject) {

     int marks;

     do {

         System.out.print("Enter " + subject + " marks (0-100): ");
         marks = sc.nextInt();

         if (marks < 0 || marks > 100) {
             System.out.println("Invalid marks! Enter marks between 0 and 100.");
         }

     } while (marks < 0 || marks > 100);

     return marks;
 }

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     int totalStudents;

     // Read number of students
     do {

         System.out.print("Enter number of students: ");
         totalStudents = sc.nextInt();

         if (totalStudents <= 0) {
             System.out.println("Number of students must be greater than zero.");
         }

     } while (totalStudents <= 0);

     // Class summary variables
     int passCount = 0;
     int failCount = 0;

     double sumOfPercentages = 0;
     double highestPercentage = -1;

     int topperRoll = -1;

     // Loop for multiple students
     for (int i = 1; i <= totalStudents; i++) {

         System.out.println("\nEnter details of Student " + i);

         int type;

         // Select student type
         do {

             System.out.println("1. General Student");
             System.out.println("2. Science Student");

             System.out.print("Enter student type: ");
             type = sc.nextInt();

             if (type != 1 && type != 2) {
                 System.out.println("Invalid student type! Try again.");
             }

         } while (type != 1 && type != 2);

         // Read roll number
         int rollNo;

         do {

             System.out.print("Enter Roll Number: ");
             rollNo = sc.nextInt();

             if (rollNo <= 0) {
                 System.out.println("Roll number must be greater than zero.");
             }

         } while (rollNo <= 0);

         // Read subject marks
         int m1 = readValidMarks(sc, "Subject 1");
         int m2 = readValidMarks(sc, "Subject 2");
         int m3 = readValidMarks(sc, "Subject 3");

         // Parent class reference
         Student student;

         // Create appropriate object
         if (type == 1) {

             student = new Student(rollNo, m1, m2, m3);

         }
         else {

             int practical = readValidMarks(sc, "Practical");

             student = new ScienceStudent(
                     rollNo, m1, m2, m3, practical);
         }

         // Display result card
         student.showResultCard();

         // Calculate percentage
         double percentage = student.getPercentage();

         // Update total percentage
         sumOfPercentages = sumOfPercentages + percentage;

         // Count pass and fail students
         if (student.isPass()) {

             passCount++;

             // Find topper only among passed students
             if (percentage > highestPercentage) {

                 highestPercentage = percentage;
                 topperRoll = student.getRollNo();
             }

         }
         else {

             failCount++;
         }
     }

     // Class summary
     double averagePercentage = sumOfPercentages / totalStudents;

     System.out.println("\n======= CLASS SUMMARY =======");

     System.out.println("Total Students    : " + totalStudents);
     System.out.println("Passed            : " + passCount);
     System.out.println("Failed            : " + failCount);

     System.out.printf("Average Percent   : %.2f%%%n",
             averagePercentage);

     // Check if topper exists
     if (topperRoll != -1) {

         System.out.println("Topper Roll No    : " + topperRoll);

         System.out.printf("Topper Percentage : %.2f%%%n",
                 highestPercentage);

     }
     else {

         System.out.println("Topper            : No topper");
     }

     System.out.println("=============================");

     sc.close();
 }
}


