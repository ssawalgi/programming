package com.abc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	@Test //Test customer statement generation
	public void getStatement(){

		Account checkingAccount = new Account(Account.CHECKING);
		Account savingsAccount = new Account(Account.SAVINGS);

		Customer henry = new Customer("Henry").openBankAccount(checkingAccount).openBankAccount(savingsAccount);

		checkingAccount.deposit(100.0);
		savingsAccount.deposit(4000.0);
		savingsAccount.withdraw(200.0);

		assertEquals("Statement for Henry\n" +
				"\n" +
				"Checking Account\n" +
				"  deposit $100.00\n" +
				"Total $100.00\n" +
				"\n" +
				"Savings Account\n" +
				"  deposit $4,000.00\n" +
				"  withdrawal $200.00\n" +
				"Total $3,800.00\n" +
				"\n" +
				"Total In All Accounts $3,900.00", henry.getStatement());
	}

	@Test //Test customer with single account
	public void singleCustomerWithSingleAccount(){
		Customer oscar = new Customer("Oscar").openBankAccount(new Account(Account.SAVINGS));
		assertEquals(1, oscar.getNumberOfBankAccounts());
	}

	@Test //Test customer with multiple accounts
	public void singleCustomerWithMultipleAccounts(){
		Customer oscar = new Customer("Oscar")
				.openBankAccount(new Account(Account.SAVINGS));
		oscar.openBankAccount(new Account(Account.CHECKING));
		assertEquals(2, oscar.getNumberOfBankAccounts());
	}

}
