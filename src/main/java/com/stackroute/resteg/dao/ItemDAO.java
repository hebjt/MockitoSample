package com.stackroute.resteg.dao;

import java.util.List;

import com.stackroute.resteg.exception.ItemAlreadyExistException;
import com.stackroute.resteg.model.Item;

public interface ItemDAO {

 Item saveItem(Item obj ) ;
 Item findItemById(int id);
 boolean deleteItem(int id);
 List<Item> findAllItems();
	
}
