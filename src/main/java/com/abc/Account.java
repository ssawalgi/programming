package com.abc;

import java.util.ArrayList;
import java.util.List;

public class Account {

	public static final int CHECKING = 0;
	public static final int SAVINGS = 1;
	public static final int MAXI_SAVINGS = 2;
	public static final double ONE_THOUSAND_DOLLARS = 1000;
	public static final double TWO_THOUSAND_DOLLARS = 2000;
	public static final double POINT_ONE_PERCENT = 0.001;
	public static final double POINT_TWO_PERCENT = 0.002;
	public static final double TWO_PERCENT = 0.02;
	public static final double FIVE_PERCENT = 0.05;
	public static final double TEN_PERCENT = 0.1;

	private final int accountType;
	public List<Transaction> transactions;

	public Account(int accountType) {
		this.accountType = accountType;
		this.transactions = new ArrayList<Transaction>();
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be greater than zero");
		} else {
			transactions.add(new Transaction(amount));
		}
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be greater than zero");
		} else {
			transactions.add(new Transaction(-amount));
		}
	}

	public double getInterestEarned() {
		double amount = sumTransactions();
		switch(accountType){
		case SAVINGS:
			if (amount <= ONE_THOUSAND_DOLLARS)
				return calculateInterest(amount, POINT_ONE_PERCENT);
			else
				return 1 + calculateInterest(amount-ONE_THOUSAND_DOLLARS, POINT_TWO_PERCENT);

		case MAXI_SAVINGS:
			if (amount <= ONE_THOUSAND_DOLLARS)
				return calculateInterest(amount, TWO_PERCENT);

			if (amount <= TWO_THOUSAND_DOLLARS)
				return 20 + calculateInterest(amount-ONE_THOUSAND_DOLLARS, FIVE_PERCENT);

			return 70 + calculateInterest(amount-TWO_THOUSAND_DOLLARS, TEN_PERCENT); 

		default:
			return calculateInterest(amount, POINT_ONE_PERCENT);
		}
	}

	public double sumTransactions() {
		return checkIfTransactionsExist(true);
	}

	private double checkIfTransactionsExist(boolean checkAll) {
		double amount = 0.0;
		for (Transaction eachTransaction: transactions)
			amount += eachTransaction.amount;
		return amount;
	}

	public int getAccountType() {
		return accountType;
	}
	private double calculateInterest(double amount, double interestRate ){
		return amount*interestRate;

	}
}
