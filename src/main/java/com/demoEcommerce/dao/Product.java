package com.demoEcommerce.dao;

public class Product {

	
	private long id;
	private String name;
	private double price;
	private double totprice;
	private int itemcount;
	
	
	
	public Product(long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	
	public Product() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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


	public double getTotprice() {
		return totprice;
	}


	public void setTotprice(double totprice) {
		this.totprice = totprice;
	}


	public int getItemcount() {
		return itemcount;
	}


	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}
	
	
	
}
