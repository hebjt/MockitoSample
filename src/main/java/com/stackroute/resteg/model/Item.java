package com.stackroute.resteg.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	@Id
	int itemid;
	
	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	String itemname;
	
	int price;
	
//	@OneToMany
//	@JsonIgnore
//	List<Customer> customer;
//
//	public List<Customer> getCustomer() {
//		return customer;
//	}
//
//	public void setCustomers(List<Customer> customers) {
//		this.customer = customers;
//	}
//	
}
