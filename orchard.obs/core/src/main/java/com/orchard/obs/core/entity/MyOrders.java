package com.orchard.obs.core.entity;

import java.util.List;

public class MyOrders {
	private int myOrderNo;
	private List<MyProducts>books;
	public int getMyOrderNo() {
		return myOrderNo;
	}
	public void setMyOrderNo(int myOrderNo) {
		this.myOrderNo = myOrderNo;
	}
	public List<MyProducts> getBooks() {
		return books;
	}
	public void setBooks(List<MyProducts> books) {
		this.books = books;
	}
	
}
