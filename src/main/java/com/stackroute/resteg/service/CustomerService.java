package com.stackroute.resteg.service;

import com.stackroute.resteg.exception.ItemNotFoundException;
import com.stackroute.resteg.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer obj) throws ItemNotFoundException;
	Customer findCustomer(int id);
}
