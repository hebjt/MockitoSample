package com.stackroute.resteg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.resteg.dao.CustomerDAO;
import com.stackroute.resteg.dao.ItemDAO;
import com.stackroute.resteg.exception.ItemNotFoundException;
import com.stackroute.resteg.model.Customer;
import com.stackroute.resteg.model.Item;

//@Service
public class CustomerServiceImpl // implements CustomerService{
{
//	@Autowired
//	CustomerDAO customerrepo;
//	
//	@Autowired
//	ItemDAO repoitem;
//
//	public Customer saveCustomer(Customer obj)  throws ItemNotFoundException{
//		
// Item item=obj.getItem();
//  
// System.out.println("inside save" + item.getItemid() + item.getItemname());
// Item itemresult=repoitem.findItemById(item.getItemid());
// 
// System.out.println("in repo" + itemresult.getItemname());
// 
//  if(itemresult==null)
//	  throw new ItemNotFoundException("item not found");
//  else
//	  customerrepo.saveRec(obj);
//  
//  
//return obj;
//	}
//
//	public Customer findCustomer(int id) {
//		Customer custobj=customerrepo.findcust(id);
//		return custobj;
//	}
//	

}
