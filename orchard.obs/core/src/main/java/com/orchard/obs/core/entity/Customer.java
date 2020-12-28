package com.orchard.obs.core.entity;

public class Customer {
	private String name;
	private String phone;
	private String address;
	private String pin;
	private String city;
	private String country;
	private String state;
	private String orderNo;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String phone, String address, String pin, String city, String country, String state) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.pin = pin;
		this.city = city;
		this.country = country;
		this.state = state;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
