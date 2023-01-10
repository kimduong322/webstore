package com.packt.webstore.domain;

public class Customer {
	
	private String customerId;
	private String name;
	private int noOfOrdersMade;
	private String address;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfOrdersMade() {
		return noOfOrdersMade;
	}
	public void setNoOfOrdersMade(int noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer(String customerId, String name, int noOfOrdersMade, String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.noOfOrdersMade = noOfOrdersMade;
		this.address = address;
	}
	public Customer() {
		super();
	}
	
}
