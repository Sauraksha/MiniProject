package com.studentresultcard;

//Child class
class ScienceStudent extends Student {

 private int practicalMarks;

 // Constructor chaining
 ScienceStudent(int rollNo, int marks1, int marks2,
                int marks3, int practicalMarks) {

     super(rollNo, marks1, marks2, marks3);

     this.practicalMarks = practicalMarks;
 }

 // Getter for practical marks
 public int getPracticalMarks() {
     return practicalMarks;
 }

 // Overriding getTotal()
 @Override
 public int getTotal() {

     return super.getTotal() + practicalMarks;
 }

 // Overriding getMaxTotal()
 @Override
 public int getMaxTotal() {

     return 400;
 }

 // Overriding isPass()
 @Override
 public boolean isPass() {

     if (super.isPass() && practicalMarks >= 40) {
         return true;
     }

     return false;
 }

 // Display science result card
 @Override
 public void showResultCard() {

     System.out.println("\n======= RESULT CARD =======");

     showResultDetails();

     System.out.println("Practical   : " + practicalMarks);

     System.out.println("===========================");
 }
}
