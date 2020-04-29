package com.stackroute.resteg.controller;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.resteg.config.HiberConfiguration;
import com.stackroute.resteg.model.Item;
import com.stackroute.resteg.service.ItemService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {HiberConfiguration.class})
@WebAppConfiguration
public class ControllerTest
{
 

	MockMvc mymvc;

	 @Mock
	 ItemService itemserve;
	
	 @InjectMocks
	 private ItemController itemcontrol;
	 
	 Item item;
	 
	 @Before
	 public void init() throws Exception
	 {
		 MockitoAnnotations.initMocks(this);
		
mymvc=MockMvcBuilders.standaloneSetup(itemcontrol).build();	 
   
  item=new Item();
  item.setItemid(600);
  item.setItemname("Mask");
  item.setPrice(340);
		 
	 }
	
	 @Test
	 public void addTest() throws Exception
	 {

	//Mockito.when(itemserve.addItem(item)).thenReturn(item);
		 
mymvc.perform(MockMvcRequestBuilders.post("/additem")
	 .contentType(MediaType.APPLICATION_JSON).content(convertobject(item)))
     .andExpect(MockMvcResultMatchers.status().isOk())
     .andDo(MockMvcResultHandlers.print());
	 
			 
	 }
	 
	 
	 private static String convertobject(final Object obj) throws JsonProcessingException
	 {
		 String result;
		 
		 final ObjectMapper map=new ObjectMapper();
		 
		 final String output=map.writeValueAsString(obj);
		 
		 result=output;
		 System.out.println(result);
		 return result;
	 }
	 
	
}
