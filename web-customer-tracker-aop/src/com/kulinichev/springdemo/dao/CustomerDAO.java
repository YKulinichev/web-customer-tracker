package com.kulinichev.springdemo.dao;

import java.util.List;

import com.kulinichev.springdemo.entity.Customer;

public interface CustomerDAO {
	
	//public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public List<Customer> getCustomers(int theSortField);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);

	public Customer getCustomer(int theId);
	


}
