package com.exponent.bankapllication.controller;

import java.util.Scanner;

import com.exponent.bankapllication.service.RBI;
import com.exponent.bankapllication.serviceImpl.SBIImple;

public class AdminController {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		RBI rbi=new SBIImple();
		
		//menu
		while(flag)
		{
			System.out.println(" ____________________________________");
			System.out.println("|       WELCOME TO SBI BANK          |");
			System.out.println("|        Banking Service             |");
			System.out.println("|____________________________________|");
			System.out.println("|       Select your option           |");
			System.out.println("|____________________________________|");
			System.out.println("|option        Banking Service       |");
			System.out.println("|____________________________________|");
			System.out.println("|1.            Create Account        |");
			System.out.println("|2.            Show Account Details  |");
			System.out.println("|3.            Show Account Balance  |");
			System.out.println("|4.            Deposit Money         |");
			System.out.println("|5.            Withdraw Money        |");
			System.out.println("|6.            Update Account Details|");
			System.out.println("|7.            Exit                  |");
			System.out.println("|____________________________________|");
			
			System.out.println("Enter your choice between 1 to 7:");
			int ch =sc.nextInt();
			switch(ch)
			{
			case 1:
				rbi.createAccount();
				break;
			case 2:
				rbi.showAccountDetails();
				break;
			case 3:
				rbi.showAccountBalance();
				break;
			case 4:
				rbi.depositMoney();
				break;
			case 5:
				rbi.withdrawMoney();
				break;
			case 6:
				rbi.updateAccountDetails();
				break;
			case 7:
				flag=false;
				break;
			default:
					System.out.println("Entered wrong choice select between 1 to 7");
				
			}
		}
		System.out.println();
		
	
	}

}
