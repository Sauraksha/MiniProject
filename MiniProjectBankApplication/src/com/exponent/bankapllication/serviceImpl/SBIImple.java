package com.exponent.bankapllication.serviceImpl;

import java.util.Scanner;

import com.exponent.bankapllication.model.Account;
import com.exponent.bankapllication.service.RBI;
import com.exponent.bankapplication.validation.Validation;

public class SBIImple implements RBI {
	
	boolean isAccountCreated=false;
	
	Scanner sc=new Scanner(System.in);
	Account ac=new Account();
	

	@Override
	public void createAccount() {
	
//		System.out.println("Enter your account number:");
//		int accNo=sc.nextInt();
//		ac.setAccountNumber(accNo);
		
		System.out.println("Enter your name:");
		String name=sc.next();
		ac.setName(name);
		
		System.out.println("Enter your adharcard number:");
		ac.setAdharNumber(sc.next());
		
		System.out.println("Enter your pancard number:");
		ac.setPanNumber(sc.next());
		
		System.out.println("Enter your email:");
		ac.setEmail(sc.next());
		
//		System.out.println("Enter your contact number:");
		long cNumber = Validation.getContactNumber();
		ac.setContact(cNumber);
		
		System.out.println("Enter account opening amount:");
		ac.setAccountBalance(sc.nextDouble());
		
		Validation.getAccountNumber();
		
		System.out.println("Account created successfully......");
		
		isAccountCreated=true;
		
		
	
		
	}

	@Override
	public void showAccountDetails() {
		if(isAccountCreated)
		{
			
		
		System.out.println("Enter your account number:");
		long accountNumber=sc.nextInt();
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
		else
		{
			System.out.println("You need to create account:");
		}
		
	}

	@Override
	public void showAccountBalance() {
		if(isAccountCreated)
		{
			
		
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
		else
		{
			System.out.println("You need to create account:");
		}
		
		
		
	}

	@Override
	public void depositMoney() {
		if(isAccountCreated)
		{
			
	
		System.out.println("Enter the amount to deposit:");
		double deposit =sc.nextDouble();
		double updateBalance=ac.getAccountBalance()+deposit;
		ac.setAccountBalance(updateBalance);
		System.out.println("New Balance is"+updateBalance);
		}
		else
		{
			System.out.println("You need to create account:");
		}
		
	}

	@Override
	public void withdrawMoney() {
		if(isAccountCreated)
		{
			
		
		System.out.println("Enter the amount to withdraw:");
		double withdrawmoney=sc.nextDouble();
		double updateBalance=ac.getAccountBalance()-withdrawmoney;
		ac.setAccountBalance(updateBalance);
		System.out.println("New Balance is"+updateBalance);
		}
		else
		{
			System.out.println("You need to create account:");
		}
			
		
	}

	@Override
	public void updateAccountDetails() {
		if(isAccountCreated)
		{
			
		
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
		else
		{
			System.out.println("You need to create account:");
		}
	}

}
