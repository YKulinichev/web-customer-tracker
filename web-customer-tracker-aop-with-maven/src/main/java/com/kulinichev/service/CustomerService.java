package com.kulinichev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kulinichev.entity.Customer;

@Service
public interface CustomerService {
	
	//public List<Customer> getCustomers();

		public void saveCustomer(Customer theCustomer);
		
		public List<Customer> getCustomers(int theSortField);

		public Customer getCustomer(int theId);

		public void deleteCustomer(int theId);

		public List<Customer> searchCustomers(String theSearchName);

}
