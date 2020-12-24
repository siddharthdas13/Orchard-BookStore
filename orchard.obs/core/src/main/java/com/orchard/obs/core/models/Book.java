package com.orchard.obs.core.models;

import java.util.List;

public class Book {
	private String name;
	private float price;
	private List<String> authors;
	private String language;
	
	
	public Book() {
		super();
	}

	public Book(String name, float price, List<String> authors, String language) {
		super();
		this.name = name;
		this.price = price;
		this.authors = authors;
		this.language = language;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the author
	 */
	public List<String> getAuthors() {
		return authors;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(List<String> authors) {
		this.authors = authors;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
