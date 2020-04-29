package com.stackroute.resteg.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.resteg.dao.ItemDAO;
import com.stackroute.resteg.exception.ItemAlreadyExistException;
import com.stackroute.resteg.model.Item;

import junit.framework.Assert;

public class ItemServiceTest {

	@Mock
	ItemDAO itemrepo;
	
	private Item item;
	
	@InjectMocks
	ItemServiceImpl itemservice;
	
	@Before
	public void init() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		item=new Item();
		item.setItemid(100);
		item.setItemname("Tablest");
		item.setPrice(100);
		
		
	}
	
  @Test
  public void testAdditem() throws ItemAlreadyExistException
  {
   Mockito.when(itemservice.addItem(item)).thenReturn(item);
   
   Item itemobj=itemservice.addItem(item); //
	 
  Assert.assertEquals(item, itemobj); 
  }
  
  
  
  
  @Test
  
  public void testFindItem() throws Exception
  {
	  Mockito.when(itemservice.findItem(100)).thenReturn(item);
	  
	  Item iobj=itemservice.findItem(100);
	  
	  Assert.assertEquals(item, iobj);
	  
  }
  
  
  @Test
  
  public void testFindItemall() throws Exception
  {
	  Mockito.when(itemservice.findItem(200)).thenReturn(null);
	  
	  Item iobj=itemservice.findItem(200);
	  
	  Assert.assertEquals(null, iobj);
	  
  }


}


