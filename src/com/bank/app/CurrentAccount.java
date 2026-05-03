package com.bank.app;

public class CurrentAccount extends Account{
	private double overdraftLimit = 5000;
	public CurrentAccount(String accountNo, Customer cust, double bal) {
		super(accountNo, cust, bal);
	}
	@Override
	public boolean withdraw(double amount) {
		if(amount <=0) {
			System.out.println("Invalid amount entry");
			return false;
		}
		else if(amount > balance + overdraftLimit) {
			System.out.println("Overdraft limit exceeded");
			return false;
		}
		else {
			balance -= amount;
			System.out.println("withdraw : "+amount);
			System.out.println("new balance : "+balance);
			return true;
		}
	}
}
