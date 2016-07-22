package com.abc;

import java.util.ArrayList;
import java.util.List;
import com.abc.util.Utility;

public class Customer {

	private String customerName;
	private List<Account> bankAccount;

	public Customer(String custName) {
		this.customerName = custName;
		this.bankAccount = new ArrayList<Account>();
	}

	public String getCustomerName() {
		return customerName;
	}

	public List<Account> getBankAccount() {
		return bankAccount;
	}

	public Customer openBankAccount(Account accountType) {
		bankAccount.add(accountType);
		return this;
	}

	public int getNumberOfBankAccounts() {
		return bankAccount.size();
	}

	public String getStatement() {
		String statement = null;
		statement = "Statement for " + customerName + "\n";
		double total = 0.0;
		for (Account eachAccountType : bankAccount) {
			statement += "\n" + getAccountAndTransactionDetails(eachAccountType) + "\n";
			total += eachAccountType.sumTransactions();
		}
		statement += "\nTotal In All Accounts " + Utility.toDollars(total);
		return statement;
	}

	private String getAccountAndTransactionDetails(Account account) {
		String accountType = "";

		//Translate to pretty account type
		switch(account.getAccountType()){
		case Account.CHECKING:
			accountType += "Checking Account\n";
			break;
		case Account.SAVINGS:
			accountType += "Savings Account\n";
			break;
		case Account.MAXI_SAVINGS:
			accountType += "Maxi Savings Account\n";
			break;
		}
		//Now total up all the transactions
		double totalTransaction = 0.0;
		for (Transaction eachTransaction : account.transactions) {
			accountType += "  " + (eachTransaction.amount < 0 ? "withdrawal" : "deposit") + " " + Utility.toDollars(eachTransaction.amount) + "\n";
			totalTransaction += eachTransaction.amount;
		}
		accountType += "Total " + Utility.toDollars(totalTransaction);
		return accountType;
	}

	public double totalInterestEarnedOnAccounts() {
		double totalInterestEarnedOnAccount = 0;
		for (Account eachAccount : bankAccount)
			totalInterestEarnedOnAccount += eachAccount.getInterestEarned();
		return totalInterestEarnedOnAccount;
	}
}
