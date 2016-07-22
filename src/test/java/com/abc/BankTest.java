package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
	private static final double DOUBLE_DELTA = 1e-15;

	@Test //Test bank manager get report showing list of customers and their number of accounts
	public void getCustomerReport() {
		Bank bank = new Bank();
		Customer john = new Customer("John");
		bank.addNewCustomer(john);
		john.openBankAccount(new Account(Account.CHECKING));
		john.openBankAccount(new Account(Account.SAVINGS));
		assertEquals("Customer Report\n - John (2 accounts)", bank.getCustomerReport());
	}

	@Test //Test bank manager get report showing the total interest paid on account
	public void getTotalInterestPaidOnCheckingAccount() {
		Bank bank = new Bank();
		Account checkingAccount = new Account(Account.CHECKING);
		Customer bill = new Customer("Bill").openBankAccount(checkingAccount);
		bank.addNewCustomer(bill);
		checkingAccount.deposit(100.0);
		assertEquals(0.1, bank.getTotalInterestPaidReport(), DOUBLE_DELTA);
	}

	@Test
	public void getTotalInterestPaidOnSavingsAccount() {
		Bank bank = new Bank();
		Account savingsAccount = new Account(Account.SAVINGS);
		bank.addNewCustomer(new Customer("Jack").openBankAccount(savingsAccount));
		savingsAccount.deposit(1500.0);
		assertEquals(2.0, bank.getTotalInterestPaidReport(), DOUBLE_DELTA);
	}

	@Test
	public void getTotalInterestPaidOnMaxiSavingsAccount() {
		Bank bank = new Bank();
		Account maxiSavingsAccount = new Account(Account.MAXI_SAVINGS);
		bank.addNewCustomer(new Customer("George").openBankAccount(maxiSavingsAccount));
		maxiSavingsAccount.deposit(3000.0);
		assertEquals(170.0, bank.getTotalInterestPaidReport(), DOUBLE_DELTA);
	}

}
