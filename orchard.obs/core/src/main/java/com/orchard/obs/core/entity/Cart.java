/**
 * 
 */
package com.orchard.obs.core.entity;

/**
 * @author Rushabh
 *
 */
public class Cart {
	private String customerId;
	private Book book;
	private int cartQuantity;
	
	public Cart() {
		super();
	}

	public Cart(String customerId, Book book, int cartQuantity) {
		super();
		this.customerId = customerId;
		this.book = book;
		this.cartQuantity = cartQuantity;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	
}
