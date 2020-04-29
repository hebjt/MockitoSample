package com.stackroute.resteg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.resteg.exception.ItemAlreadyExistException;
import com.stackroute.resteg.exception.ItemNotFoundException;
import com.stackroute.resteg.model.Item;
import com.stackroute.resteg.service.ItemService;

@RestController

public class ItemController {
	
	@Autowired
	ItemService iservice;
	

	
	
	@GetMapping("/showitem")
	public ResponseEntity<?> showItem()
	{
		List<Item> items=iservice.getallItems();
		
		return new ResponseEntity<List>(items,HttpStatus.OK);
		
	}
	
	@PostMapping("/additem")
	public ResponseEntity<?> addItems(@RequestBody Item item)
	{
		Item resultobj;
		
	//	String s=sess.getAttribute("username").toString();
		try
		{
			resultobj=iservice.addItem(item);
			return new ResponseEntity<Item>(resultobj,HttpStatus.OK);
			
		}
		catch(ItemAlreadyExistException except)
		{
			
			return new ResponseEntity<String>(except.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteitem(@PathVariable("id") int itemid)
	{
		try
		{
		boolean bool=iservice.deleteItem(itemid);
		return new ResponseEntity<String>("Item REmoved successfully",HttpStatus.OK);
		}
		catch(ItemNotFoundException exce)
		{
			return new ResponseEntity<String>(exce.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
}
