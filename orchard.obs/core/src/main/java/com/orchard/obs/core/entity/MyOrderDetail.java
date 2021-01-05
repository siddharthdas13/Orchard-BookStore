package com.orchard.obs.core.entity;

import java.util.List;

public class MyOrderDetail {
	private String customer_id; 
	private Customer customer;
	private String date;
	private String time;
	private List<MyProducts> myProducts;
	public List<MyProducts> getMyProducts() {
		return myProducts;
	}
	public void setMyProducts(List<MyProducts> myProducts) {
		this.myProducts = myProducts;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
