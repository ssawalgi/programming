package com.abc;

import java.util.ArrayList;
import java.util.List;
import com.abc.util.Utility;

public class Bank {
	private List<Customer> customers;

	public Bank() {
		this.customers = new ArrayList<Customer>();
	}

	public void addNewCustomer(Customer newCustomer) {
		customers.add(newCustomer);
	}

	public List<Customer> getAllCustomers() {
		return customers;
	}

	public String getCustomerReport() {
		String customerReport = "Customer Report";
		for (Customer eachCustomer : customers)
			customerReport += "\n - " + eachCustomer.getCustomerName() +
			" (" + Utility.format(eachCustomer.getNumberOfBankAccounts(), "account") + ")";
		return customerReport;
	}

	public double getTotalInterestPaidReport() {
		double totalInterestPaidByBank = 0;
		for(Customer eachCustomer: customers)
			totalInterestPaidByBank += eachCustomer.totalInterestEarnedOnAccounts();
		return totalInterestPaidByBank;
	}
}
