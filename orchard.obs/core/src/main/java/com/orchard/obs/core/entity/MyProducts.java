package com.orchard.obs.core.entity;

public class MyProducts {
	private String book_id;
	private String name;
	private double price;
	private double discount;
	private int quantity;
	private String author;
	private String language;
	private String publisher;
	public MyProducts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyProducts(String isbn, String name, double price, double discount, int quantity) {
		super();
		this.book_id = isbn;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.quantity=quantity;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String isbn) {
		this.book_id = isbn;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
