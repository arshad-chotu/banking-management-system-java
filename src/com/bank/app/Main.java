package com.bank.app;

import java.util.Scanner;

public class Main {
	public static Customer createCustomer(Scanner sc) {
	    System.out.print("Enter Customer ID: ");
	    String customerId = sc.nextLine();

	    System.out.print("Enter Name: ");
	    String name = sc.nextLine();

	    System.out.print("Enter Phone: ");
	    String phone = sc.nextLine();

	    return new Customer(customerId, name, phone);
	}
	    public static void main(String[] args) {
	    	
	    	Scanner sc = new Scanner(System.in);
	    	Bank bank = new Bank();
	    	
	    	int choice;
	    	
	    	do {
	    		System.out.println("\n--- Banking System Menu ---");
	            System.out.println("1. Create Savings Account");
	            System.out.println("2. Create Current Account");
	            System.out.println("3. Display All Accounts");
	            System.out.println("4. Deposit");
	            System.out.println("5. Withdraw");
	            System.out.println("6. Search Account");
	            System.out.println("7. Transfer Funds");
	            System.out.println("8. Exit");
	            System.out.print("Enter Choice: ");

	            choice = sc.nextInt();
	            sc.nextLine(); // consume newline

	            switch (choice) {

	                case 1:
	                	Customer cust = createCustomer(sc);
	                	
	                    System.out.print("Enter Account Number: ");
	                    String accountNo = sc.nextLine();

	                    System.out.print("Enter Initial Balance: ");
	                    double balance = sc.nextDouble();
	                    sc.nextLine();

	   
	                    SavingsAccount acc = new SavingsAccount(accountNo, cust, balance);

	                    bank.addAccount(acc);

	                    System.out.println("Savings Account Created Successfully!");
	                    break;
	                    
	                case 2:
	                    Customer currCust = createCustomer(sc);

	                    System.out.print("Enter Account Number: ");
	                    String currAccountNo = sc.nextLine();

	                    System.out.print("Enter Initial Balance: ");
	                    double currBalance = sc.nextDouble();
	                    sc.nextLine();
	                   
	                    CurrentAccount currAcc = new CurrentAccount(currAccountNo, currCust, currBalance);

	                    bank.addAccount(currAcc);

	                    System.out.println("Current Account Created Successfully!");
	                    break;

	                case 3:
	                    bank.displayAllAccounts();
	                    break;
	                    
	                case 4:
	                    System.out.print("Enter Account Number: ");
	                    String depositAccNo = sc.nextLine();

	                    Account foundDepositAcc = bank.searchAccount(depositAccNo);

	                    if(foundDepositAcc != null) {
	                        System.out.print("Enter Deposit Amount: ");
	                        double depositAmount = sc.nextDouble();
	                        sc.nextLine();

	                        foundDepositAcc.deposit(depositAmount);
	                    } else {
	                        System.out.println("Account Not Found");
	                    }
	                    break;

	                case 5:
	                    System.out.print("Enter Account Number: ");
	                    String withdrawAccNo = sc.nextLine();

	                    Account foundWithdrawAcc = bank.searchAccount(withdrawAccNo);

	                    if(foundWithdrawAcc != null) {
	                        System.out.print("Enter Withdraw Amount: ");
	                        double withdrawAmount = sc.nextDouble();
	                        sc.nextLine();

	                        foundWithdrawAcc.withdraw(withdrawAmount);
	                    } else {
	                        System.out.println("Account Not Found");
	                    }
	                    break;
	                
	                case 6:
	                    System.out.print("Enter Account Number to Search: ");
	                    String searchAccNo = sc.nextLine();

	                    Account foundSearchAcc = bank.searchAccount(searchAccNo);

	                    if(foundSearchAcc != null) {
	                        System.out.println("Account Found:");
	                        foundSearchAcc.displayAccount();
	                    } else {
	                        System.out.println("Account Not Found");
	                    }
	                    break;
	                
	                case 7:
	                    System.out.print("Enter Sender Account Number: ");
	                    String senderAccNo = sc.nextLine();

	                    System.out.print("Enter Receiver Account Number: ");
	                    String receiverAccNo = sc.nextLine();

	                    System.out.print("Enter Transfer Amount: ");
	                    double transferAmount = sc.nextDouble();
	                    sc.nextLine();

	                    Account sender = bank.searchAccount(senderAccNo);
	                    Account receiver = bank.searchAccount(receiverAccNo);

	                    if(sender == null || receiver == null) {
	                        System.out.println("Invalid Sender or Receiver Account");
	                    }
	                    else {
	                        boolean success = sender.withdraw(transferAmount);

	                        if(success) {
	                            receiver.deposit(transferAmount);
	                            System.out.println("Transfer Successful");
	                        }
	                        else {
	                            System.out.println("Transfer Failed");
	                        }
	                    }
	                    break;
	                    
	                case 8:
	                    System.out.println("Exiting...");
	                    break;
	                    
	                default:
	                    System.out.println("Invalid Choice");
	    	}
	    }while (choice != 8);
	    	sc.close();
	    }
}

