package com.stackroute.resteg.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.resteg.exception.ItemAlreadyExistException;
import com.stackroute.resteg.model.Item;
@Transactional
@Repository
public class ItemDAOImpl  implements ItemDAO{

   @Autowired
   SessionFactory sessfact;
   
   
  public  ItemDAOImpl()
    {
    	
    }
    
   public  ItemDAOImpl(SessionFactory sess)
    {
    	this.sessfact=sess;
    }
   
    
	
	public Item saveItem(Item item) {
	sessfact.getCurrentSession().save(item);
		return item;
	}

	public Item findItemById(int id) {
	
Item itemobj=(Item)sessfact.getCurrentSession().createQuery("from Item where itemid="+id).uniqueResult();
		return itemobj;
	}

	public boolean deleteItem(int id) {
		
		Item itemobj=findItemById(id);
		
		if(itemobj!=null)
		{
		sessfact.getCurrentSession().delete(itemobj);
		return true;
		}
		else
			return false;
	}

	public List<Item> findAllItems() {
		List<Item> items=sessfact.getCurrentSession().createQuery("from Item").list();
		return items;
	}

}
