package com.exponent.bankapllication.serviceImpl;

import java.util.Scanner;

import com.exponent.bankapllication.model.Account;
import com.exponent.bankapllication.service.RBI;

public class SBIImple implements RBI {
	
	Scanner sc=new Scanner(System.in);
	Account ac=new Account();
	

	@Override
	public void createAccount() {
		System.out.println("Enter your account number:");
		int accNo=sc.nextInt();
		ac.setAccountNumber(accNo);
		
		System.out.println("Enter your name:");
		String name=sc.next();
		ac.setName(name);
		
		System.out.println("Enter your adharcard number:");
		ac.setAdharNumber(sc.next());
		
		System.out.println("Enter your pancard number:");
		ac.setPanNumber(sc.next());
		
		System.out.println("Enter your email:");
		ac.setEmail(sc.next());
		
		System.out.println("Enter your contact number:");
		ac.setContact(sc.nextLong());
		
		System.out.println("Enter account opening amount:");
		ac.setAccountBalance(sc.nextDouble());
		
		System.out.println("Account created successfully......");
		
		
		
		
	
		
	}

	@Override
	public void showAccountDetails() {
		System.out.println("Enter your account number:");
		int accountNumber=sc.nextInt();
		if(accountNumber==ac.getAccountNumber())
		{
//			System.out.println(ac);
			
			
				System.out.println(" _____________________________________________________________________________________________________");
				System.out.println("|Account Number  |Name       |AdharNumber   |PanNumber   |Contact    |Email       |Account Balannce   |");
				System.out.println("|________________|___________|______________|____________|___________|____________|___________________|");
				System.out.println("|"+ac.getAccountNumber()+"            |"+ac.getName()+"  |" +ac.getAdharNumber()+"      |"+ac.getPanNumber()+"    |"+ac.getContact()+" |"+ac.getEmail()+"|"+ac.getAccountBalance()+"           |" );
				System.out.println("|________________|___________|______________|____________|___________|____________|___________________|");
			
		}
		else 
		{
			System.out.println("Account doesnt exist:");
		}
		
	}

	@Override
	public void showAccountBalance() {
		System.out.println("Enter your account number:");
		int accountNumber=sc.nextInt();
		if(accountNumber==ac.getAccountNumber())
		{
			System.out.println("Current account balance:"+ac.getAccountBalance());
		}
		else 
		{
			System.out.println("Account doesn' 2 t exist:");
		}
		
		
		
	}

	@Override
	public void depositMoney() {
		System.out.println("Enter the amount to deposit:");
		double deposit =sc.nextDouble();
		double updateBalance=ac.getAccountBalance()+deposit;
		ac.setAccountBalance(updateBalance);
		System.out.println("New Balance is"+updateBalance);
		
	}

	@Override
	public void withdrawMoney() {
		System.out.println("Enter the amount to withdraw:");
		double withdrawmoney=sc.nextDouble();
		double updateBalance=ac.getAccountBalance()-withdrawmoney;
		ac.setAccountBalance(updateBalance);
		System.out.println("New Balance is"+updateBalance);
			
		
	}

	@Override
	public void updateAccountDetails() {
		System.out.println("Enter your choice:");
		int ch=sc.nextInt();
		switch(ch)
		{
			case 1:
				System.out.println("Enter the new name:");
				ac.setName(sc.next());
				break;
			case 2:
				System.out.println("Enter the new mobile number:");
				ac.setContact(sc.nextLong());
				break;
			case 3:
				System.out.println("Enter the new email id:");
				ac.setEmail(sc.next());
				break;
		}
		
	}

}
