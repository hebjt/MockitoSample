package com.stackroute.resteg.service;

import java.util.List;

import com.stackroute.resteg.exception.ItemAlreadyExistException;
import com.stackroute.resteg.exception.ItemNotFoundException;
import com.stackroute.resteg.model.Item;

public interface ItemService {
   
	public Item addItem(Item obj) throws ItemAlreadyExistException;
	public boolean deleteItem(int id) throws ItemNotFoundException;
	public List<Item> getallItems();
	public Item findItem(int id);
 
}
