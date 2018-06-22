package com.bank.dao;

import java.util.List;

import com.bank.model.BankUserDetails;

public interface BankingServiceDAO {

	public void addUser(BankUserDetails employee);

	public List<BankUserDetails> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public BankUserDetails updateEmployee(BankUserDetails employee);

	public BankUserDetails getEmployee(int employeeid);

	public BankUserDetails getEmployeeByEmail(String email);

	public BankUserDetails getEmployeeByCustomerID(String customerID);

}
