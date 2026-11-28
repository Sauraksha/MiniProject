
package com.serviceImple;

	import java.util.Scanner;

	import com.model.Batch;
	import com.model.Course;
	import com.model.Faculty;
	import com.model.Student;
	import com.service.CMSService;

	public class CMSServiceImple implements CMSService{

		Scanner sc=new Scanner(System.in);
		Course course= new Course();
		Faculty faculty=new Faculty();
		Batch batch=new Batch();
		Student student=new Student();
		
		
		
		@Override
		public void addCourse() {
			System.out.print("Enter Course id: ");
			course.setCid(sc.nextInt());
			
			System.out.print("Enter Course name: ");
			course.setCname(sc.next());
			
		}

		@Override
		public void displayCourse() {
			System.out.println("Course ID: "+course.getCid());
			System.out.println("Course Name: "+course.getCname());
			System.out.println();
			
		}

		@Override
		public void addFaculty() {
			System.out.print("Enter Faculty ID: ");
			faculty.setFid(sc.nextInt());
			System.out.print("Faculty Name: ");
			faculty.setFname(sc.next());
			faculty.setCourse(course);
			
		}

		@Override
		public void displayFaculty() {
			System.out.println("Faculty ID: "+faculty.getFid());
			System.out.println("Faculty Name: "+faculty.getFname());
			displayCourse();
			System.out.println();
			
			//System.out.println(faculty.getCourse());
			
		}

		@Override
		public void addBatch() {
			System.out.print("Enter Batch ID: ");
			batch.setBid(sc.nextInt());
			System.out.print("Enter Batch name: ");
			batch.setBname(sc.next());
			batch.setFaculty(faculty);
			
		}

		@Override
		public void displayBatch() {
			System.out.println("Batch ID: "+batch.getBid());
			System.out.println("Batch Name: "+batch.getBname());
			displayFaculty();
			System.out.println();
			
		}

		@Override
		public void addStudent() {
			System.out.print("Enter Student ID: ");
			student.setSid(sc.nextInt());
			System.out.print("Enter Student Name: ");
			student.setSname(sc.next());
			student.setBatch(batch);
			
		}

		@Override
		public void displayStudent() {
			System.out.println("Student ID: "+student.getSid());
			System.out.println("Student Name: "+student.getSname());
			displayBatch();
			System.out.println();
			
		}

		@Override
		public void updateDetails() {
			boolean flag=true;
			while(flag)
			{
				System.out.println("********* UPDATION TABLE *********");
				System.out.println();
				System.out.println("|--------------------------------|");
				System.out.println("|      1) COURSE.                |");
				System.out.println("|--------------------------------|");
				System.out.println("|      2) FACULTY.               |");
				System.out.println("|--------------------------------|");
				System.out.println("|      3) BATCH.                 |");
				System.out.println("|--------------------------------|");
				System.out.println("|      4) STUDENT.               |");
				System.out.println("|--------------------------------|");
				System.out.println("|      5) EXIT.                  |");
				System.out.println("|--------------------------------|");
				
				System.out.println();
				System.out.print("Enter Your Choice");
				int choice=sc.nextInt();
				System.out.println();
				switch(choice)
				{
				case 1:
					boolean flag1=true;
					while(flag1)
					{
						
					System.out.println("|--------------------------------|");
					System.out.println("|      1) UPDATE COURSE ID.      |");
					System.out.println("|--------------------------------|");
					System.out.println("|      2) UPDATE COURSE NAME.    |");
					System.out.println("|--------------------------------|");
					System.out.println("|      3) EXIT.                  |");
					System.out.println("|--------------------------------|");
					
					System.out.println();
					System.out.print("Enter Choice for Update:");
					int choice1=sc.nextInt();
					switch(choice1)
					{
					case 1:
						System.out.print("Please Enter New Course ID: ");
						course.setCid(sc.nextInt());
						break;
						
					case 2:
						System.out.println("Please Enter New Course Name: ");
						course.setCname(sc.next());	
						
					case 3:
						System.out.println("Updation Complete!!!!!!!!");
						flag1=false;
						break;
						
						default:
							System.out.println("Wrong Input..");
							break;
					}
					}
					break;
					
				case 2:
					boolean flag2=true;
					while(flag2)
					{
						
					System.out.println("|--------------------------------|");
					System.out.println("|      1) UPDATE FACULTY ID.     |");
					System.out.println("|--------------------------------|");
					System.out.println("|      2) UPDATE FACULTY NAME.   |");
					System.out.println("|--------------------------------|");
					System.out.println("|      3) EXIT.                  |");
					System.out.println("|--------------------------------|");
					
					System.out.println();
					System.out.print("Enter Choice for Update:");
					int choice1=sc.nextInt();
					switch(choice1)
					{
					case 1:
						System.out.print("Please Enter New Faculty ID: ");
						faculty.setFid(sc.nextInt());
						break;
						
					case 2:
						System.out.println("Please Enter New Faculty Name: ");
						faculty.setFname(sc.next());	
						
					case 3:
						System.out.println("Updation Complete!!!!!!!!");
						flag2=false;
						break;
						
						default:
							System.out.println("Wrong Input..");
							break;
					}
					}
					break;
					
				case 3:
					boolean flag3=true;
					while(flag3)
					{
						
					System.out.println("|--------------------------------|");
					System.out.println("|      1) UPDATE BATCH ID.       |");
					System.out.println("|--------------------------------|");
					System.out.println("|      2) UPDATE BATCH NAME.     |");
					System.out.println("|--------------------------------|");
					System.out.println("|      3) EXIT.                  |");
					System.out.println("|--------------------------------|");
					
					System.out.println();
					System.out.print("Enter Choice for Update:");
					int choice1=sc.nextInt();
					switch(choice1)
					{
					case 1:
						System.out.print("Please Enter New Batch ID: ");
						batch.setBid(sc.nextInt());
						break;
						
					case 2:
						System.out.println("Please Enter New Batch Name: ");
						batch.setBname(sc.next());	
						
					case 3:
						System.out.println("Updation Complete!!!!!!!!");
						flag3=false;
						break;
						
						default:
							System.out.println("Wrong Input..");
							break;
					}
					}
					break; 
					
				case 4:
					boolean flag4=true;
					while(flag4)
					{
						
					System.out.println("|--------------------------------|");
					System.out.println("|      1) UPDATE STUDENT ID.     |");
					System.out.println("|--------------------------------|");
					System.out.println("|      2) UPDATE STUDENT NAME.   |");
					System.out.println("|--------------------------------|");
					System.out.println("|      3) EXIT.                  |");
					System.out.println("|--------------------------------|");
					
					System.out.println();
					System.out.print("Enter Choice for Update:");
					int choice1=sc.nextInt();
					switch(choice1)
					{
					case 1:
						System.out.print("Please Enter New Student ID: ");
						student.setSid(sc.nextInt());
						break;
						
					case 2:
						System.out.println("Please Enter New Student Name: ");
						student.setSname(sc.next());
						
					case 3:
						System.out.println("Updation Complete!!!!!!!!");
						flag4=false;
						break;
						
						default:
							System.out.println("Wrong Input..");
							break;
					}
					}
					break;
					
				case 5:
					System.out.println("Thank you!!");
					flag=false;
					break;
					
				}
				
			}
			
			
		}

	
}
