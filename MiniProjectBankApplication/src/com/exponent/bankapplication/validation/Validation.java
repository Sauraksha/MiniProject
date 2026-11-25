package com.exponent.bankapplication.validation;

import java.util.Scanner;

public class Validation {
	Scanner sc=new Scanner(System.in);
	public static long getAccountNumber()
	{
//		System.out.println("Enter your account number");
		long accNumber=(long)(Math.random()*Math.pow(10, 12));
		System.out.println("Account number is:"+accNumber);
		return accNumber;
	}
	
	public static  long getContactNumber()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Contact Number:");
		long contactNumber=sc.nextLong();
		if(contactNumber > 6000000000l && contactNumber < 9999999999l)
		{
			return contactNumber;
		}
		else
		{
			System.out.println("Invalid Number");
		
		}
		return getContactNumber();
		
	}

}
