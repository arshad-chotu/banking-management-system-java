package com.bank.app;

public class Account {
	protected String accountNumber;
	protected Customer customer;
	protected double balance;
	
	public Account(String accountNo,Customer cust, double bal) {
		this.accountNumber=accountNo;
		this.customer=cust;
		this.balance=bal;
	}
	
	public void deposit(double amount) {
		if (amount > 0) {
		    balance += amount;
		    System.out.println("Deposited: " + amount);
		    System.out.println("New Balance: " + balance);
		}
		else {
		    System.out.println("Invalid deposit amount");
		}
	}
	public boolean withdraw(double amount) {
		if (amount <= 0) {
		    // invalid
			System.out.println("Invalid amount entry");
			return false;
		}
		else if (amount > balance) {
		    // insufficient funds
			System.out.println("Insufficient balance");
			return false;
		}
		else {
		    balance -= amount;
		    System.out.println("Withdrew " + amount);
		    System.out.println("New Balance: " + balance);
		    return true;
		}
	}
	public void displayAccount() {
		System.out.println("Account number : "+accountNumber);
		System.out.println("Balance : "+balance);
		System.out.println("Customer Details -> ");
		customer.displayCustomer();
	}
}
