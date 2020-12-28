package com.orchard.obs.core.models;

import java.util.List;

public class Book {
	private String name;
	private float price;
	private List<String> authors;
	private String language;
	private float discount;
	private boolean isNew;
	private boolean isBestSeller;
	
	public Book() {
		super();
	}

	public Book(String name, float price, List<String> authors, String language,float discount,boolean isNew,boolean isBestSeller) {
		super();
		this.name = name;
		this.price = price;
		this.authors = authors;
		this.language = language;
		this.discount=discount;
		this.isNew=isNew;
		this.isBestSeller=isBestSeller;
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
	 * @return the authors
	 */
	public List<String> getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<String> authors) {
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

	/**
	 * @return the discount
	 */
	public float getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	/**
	 * @return the isNew
	 */
	public boolean isNew() {
		return isNew;
	}

	/**
	 * @param isNew the isNew to set
	 */
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	/**
	 * @return the isBestSeller
	 */
	public boolean isBestSeller() {
		return isBestSeller;
	}

	/**
	 * @param isBestSeller the isBestSeller to set
	 */
	public void setBestSeller(boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
	}
	
	
}
