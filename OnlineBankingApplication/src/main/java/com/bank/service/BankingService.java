package com.bank.service;

import java.util.List;

import com.bank.model.BankUserDetails;

public interface BankingService {
	
	public void addNewUser(BankUserDetails employee);

	public List<BankUserDetails> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public BankUserDetails getEmployee(int employeeid);

	public BankUserDetails updateEmployee(BankUserDetails employee);
	
	public BankUserDetails validateUser(String emailId);

	public BankUserDetails validateBankUser(String customerID);
}
