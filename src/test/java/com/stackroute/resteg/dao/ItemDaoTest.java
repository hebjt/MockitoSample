package com.stackroute.resteg.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.stackroute.resteg.config.HiberConfiguration;
import com.stackroute.resteg.exception.ItemAlreadyExistException;
import com.stackroute.resteg.model.Item;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(classes= {HiberConfiguration.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
		TransactionalTestExecutionListener.class})
public class ItemDaoTest 
{
	@Autowired
	SessionFactory sessfact;
	
	ItemDAO itemdao;
	
	private Item item;
	
	@Before
	public void init() throws Exception
	{
		itemdao=new ItemDAOImpl(sessfact);
		item=new Item();
		item.setItemid(999);
		item.setItemname("Medicines");
		item.setPrice(2400);
	}
	
	@Test 
	
	public void additems() throws Exception
	{
		Item itmobj=itemdao.saveItem(item);
		Item result=itemdao.findItemById(999);

		Assert.assertEquals(itmobj, result);
	}
	
	@After
	public void tearoff()
	{
		Query query = sessfact.getCurrentSession().createQuery("DELETE from Item where itemid=999");
		query.executeUpdate();

	}

}
