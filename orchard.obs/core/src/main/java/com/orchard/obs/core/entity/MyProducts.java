package com.orchard.obs.core.entity;

public class MyProducts {
	private String isbn;
	private String name;
	private double price;
	private double discount;
	private int quantity;
	public MyProducts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyProducts(String isbn, String name, double price, double discount, int quantity) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.quantity=quantity;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
