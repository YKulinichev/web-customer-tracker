package com.kulinichev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kulinichev.dao.CustomerDAO;
import com.kulinichev.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

	
	//inject customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	/*@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}*/

	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
		
	}
	

	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}

	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
				return customerDAO.searchCustomers(theSearchName);
	}

	@Transactional
	public List<Customer> getCustomers(int theSortField) {
		
				return customerDAO.getCustomers(theSortField);
	}


	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}


}
