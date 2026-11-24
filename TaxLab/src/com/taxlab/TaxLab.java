package com.taxlab;
import java.util.Scanner;
public class TaxLab {

	public void calculate()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your salary");
		double salary=sc.nextDouble();
		
		if(salary>0 && salary<=400000)
		{
			System.out.println("No tax");
			
		}
		if(salary>400000 && salary<=800000)
		{
			double tax=(salary-400000)/100*5;
			System.out.println(tax);
		}
		else if(salary>800000 && salary<=1200000)
		{
			double tax=(salary-800000)/100*10+20000;
			System.out.println(tax);
		}
		else if(salary>1200000 && salary<=1800000)
		{
			double tax=(salary-1200000)/100*15+60000;
			System.out.println(tax);
		}
		else if(salary>1800000 && salary<=2500000)
		{
			double tax=(salary-1800000)/100*20+150000;
			System.out.println(tax);
		}
		else if(salary>2500000)
		{
			double tax=(salary-2500000)/100*30+290000;
			System.out.println(tax);
		}
		else
		{
			System.out.println("Invalid Amount");
		}
	}
	
	public static void main(String[] args) {
		TaxLab t=new TaxLab();
		t.calculate();
	}
}
