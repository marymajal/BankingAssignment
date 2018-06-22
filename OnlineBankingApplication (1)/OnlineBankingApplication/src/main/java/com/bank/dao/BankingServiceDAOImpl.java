package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.model.BankUserDetails;

@Repository
public class BankingServiceDAOImpl implements BankingServiceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(BankUserDetails bankUserDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(bankUserDetails);

	}

	@SuppressWarnings("unchecked")
	public List<BankUserDetails> getAllEmployees() {

		return sessionFactory.getCurrentSession().createQuery("from BankUserDetails")
				.list();
	}
	
	@Override
	public BankUserDetails getEmployeeByEmail(String email) {
		BankUserDetails bankUserDetail = new BankUserDetails();
		List<BankUserDetails> list = new ArrayList<BankUserDetails>();
		String sqlQuery = "select * from BANKAPP_DETAIL where email=:email";
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sqlQuery);
		query.setString("email", email);
		List<Object[]> user1 = (List<Object[]>) query.list();
		for (Object[] ob : user1) {
			bankUserDetail.setEmail(ob[4].toString());
			bankUserDetail.setPassword(ob[4].toString());

		}
		return bankUserDetail;

	}
	
	@Override
	public void deleteEmployee(Integer employeeId) {
		BankUserDetails employee = (BankUserDetails) sessionFactory.getCurrentSession().load(
				BankUserDetails.class, employeeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}

	}

	public BankUserDetails getEmployee(int empid) {
		return (BankUserDetails) sessionFactory.getCurrentSession().get(
				BankUserDetails.class, empid);
	}

	@Override
	public BankUserDetails updateEmployee(BankUserDetails employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

	@Override
	public BankUserDetails getEmployeeByCustomerID(String customerID) {
		BankUserDetails bankUserDetail = new BankUserDetails();
		List<BankUserDetails> list = new ArrayList<BankUserDetails>();
		String sqlQuery = "select * from BANKAPP_DETAIL where sso_id=:customerID";
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sqlQuery);
		query.setString("customerID", customerID);
		List<Object[]> user1 = (List<Object[]>) query.list();
		for (Object[] ob : user1) {
			bankUserDetail.setBankName(ob[1].toString());
		}
		return bankUserDetail;
	}

}