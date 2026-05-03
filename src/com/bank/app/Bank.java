package com.bank.app;

public class Bank {
	private Account[] accounts = new Account[100];
	private int accountCount = 0;
	public void addAccount(Account acc) {
		if(accountCount < accounts.length) {
			accounts[accountCount] = acc;
			accountCount++;
		}else {
			System.out.println("Bank Storage full");
		}
	}
	public void displayAllAccounts() {
		for(int i=0;i<accountCount;i++) {
			accounts[i].displayAccount();
		}
	}
	public Account searchAccount(String accountNo) {
		for(int i=0;i<accountCount;i++) {
			if (accounts[i].accountNumber.equals(accountNo)) {
				return accounts[i];
			}
		}
		return null;
	}
}
