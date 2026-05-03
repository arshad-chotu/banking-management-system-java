package com.bank.app;

public class SavingsAccount extends Account{
	public SavingsAccount(String accountNo, Customer cust, double bal){
		super(accountNo, cust, bal);
	}
	@Override
	public boolean withdraw(double amount) {
	    if (balance - amount < 1000) {
	        System.out.println("Minimum balance must be maintained");
	        return false;
	    } else {
	        return super.withdraw(amount);
	    }
	}
}
