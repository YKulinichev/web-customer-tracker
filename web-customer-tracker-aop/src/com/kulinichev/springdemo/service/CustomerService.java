package com.kulinichev.springdemo.service;

import java.util.List;

import com.kulinichev.springdemo.entity.Customer;

public interface CustomerService {

	//public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
	public List<Customer> getCustomers(int theSortField);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);
		
	
}
