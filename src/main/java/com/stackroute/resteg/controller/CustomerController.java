package com.stackroute.resteg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.resteg.model.Customer;
import com.stackroute.resteg.service.CustomerService;

//@RestController
public class CustomerController {
//	@Autowired
//	CustomerService custservice;
//	
//	@PostMapping("/savecust")
//	public ResponseEntity<?> saveCust(@RequestBody Customer customer)
//	{
//		
//		try
//		{
//			Customer cust=custservice.saveCustomer(customer);
//			return new ResponseEntity<Customer>(cust,HttpStatus.OK);
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
//		}
//	}
//	
//	@GetMapping("/show/{id}")
//	public ResponseEntity<?> showCust(@PathVariable("id") int id,HttpSession sess)
//	{
//		Customer cust=custservice.findCustomer(id);
//		sess.setAttribute("username", cust.getCustname());
//		return new ResponseEntity<Customer>(cust,HttpStatus.FOUND);
//	}

}
