package com.stackroute.resteg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.resteg.dao.ItemDAO;
import com.stackroute.resteg.exception.ItemAlreadyExistException;
import com.stackroute.resteg.exception.ItemNotFoundException;
import com.stackroute.resteg.model.Item;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemDAO repo;

	public Item addItem(Item item) throws ItemAlreadyExistException {
		Item resultobj;
    Item itemobj=repo.findItemById(item.getItemid());
    
	  if(itemobj!=null)
	  {
		  throw new ItemAlreadyExistException("Item id is already exist");
	  }
	  else
	  {
		resultobj=repo.saveItem(item);
		return resultobj;
	  }
	  
		 
    
	}

	public boolean deleteItem(int id) throws ItemNotFoundException {
		boolean result=false;
	 Item item=repo.findItemById(id);
	 if(item==null)
		 throw new ItemNotFoundException("Item id coudnt be found");
	 else
		 result=repo.deleteItem(id);
	 
		return result;
	}

	public List<Item> getallItems() {
	List<Item> items=repo.findAllItems();
		return items;
	}

	public Item findItem(int id) {
		Item item=repo.findItemById(id);
		return item;
	}

}
