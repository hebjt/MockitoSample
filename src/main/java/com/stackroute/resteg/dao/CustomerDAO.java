package com.stackroute.resteg.dao;

import com.stackroute.resteg.model.Customer;

public interface CustomerDAO {
 
	 Customer saveRec(Customer cust);
	Customer findcust(int custid);
}
