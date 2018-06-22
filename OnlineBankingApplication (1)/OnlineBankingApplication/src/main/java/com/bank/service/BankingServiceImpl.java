package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.BankingServiceDAO;
import com.bank.model.BankUserDetails;

@Service
@Transactional
public class BankingServiceImpl implements BankingService {

	@Autowired
	private BankingServiceDAO bankingServiceDAO;

	@Override
	@Transactional
	public void addNewUser(BankUserDetails employee) {
		bankingServiceDAO.addUser(employee);
	}

	@Override
	@Transactional
	public List<BankUserDetails> getAllEmployees() {
		return bankingServiceDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		bankingServiceDAO.deleteEmployee(employeeId);
	}

	public BankUserDetails getEmployee(int empid) {
		return bankingServiceDAO.getEmployee(empid);
	}

	public BankUserDetails updateEmployee(BankUserDetails employee) {
		// TODO Auto-generated method stub
		return bankingServiceDAO.updateEmployee(employee);
	}

	public void setEmployeeDAO(BankingServiceDAO employeeDAO) {
		this.bankingServiceDAO = employeeDAO;
	}

	@Override
	public BankUserDetails validateUser(String emailId) {
		return bankingServiceDAO.getEmployeeByEmail(emailId);
	}

	@Override
	public BankUserDetails validateBankUser(String customerID) {
		return bankingServiceDAO.getEmployeeByCustomerID(customerID);
	}

}
