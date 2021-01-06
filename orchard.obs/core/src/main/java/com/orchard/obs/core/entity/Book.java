/**
 * 
 */
package com.orchard.obs.core.entity;

import java.util.Date;

/**
 * @author Rushabh
 *
 */
public class Book {
	private int price, quantity, discount, pageCount;
	private Long isbn[];
	private String id, name, author[], genre, language, publisher, edition, description;
	private Date publishDate;
	private boolean isPresentInCart;
	
	public Book() {
		super();
	}

	public Book(int price, int quantity, int discount, int pageCount, Long[] isbn, String id, String name,
			String[] author, String genre, String language, String publisher, String edition, String description,
			Date publishDate, boolean isPresentInCart) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
		this.pageCount = pageCount;
		this.isbn = isbn;
		this.id = id;
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.language = language;
		this.publisher = publisher;
		this.edition = edition;
		this.description = description;
		this.publishDate = publishDate;
		this.isPresentInCart = isPresentInCart;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public Long[] getIsbn() {
		return isbn;
	}

	public void setIsbn(Long[] isbn) {
		this.isbn = isbn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getAuthor() {
		return author;
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public boolean isPresentInCart() {
		return isPresentInCart;
	}

	public void setPresentInCart(boolean isPresentInCart) {
		this.isPresentInCart = isPresentInCart;
	}
	
}
