package com.nagarro.training.models;

public class Item {
	private String itemName;
	private Double itemPrice;
	
	public Item(String name, Double price) {
		this.itemName = name;
		this.itemPrice = price;
	}
	
	public String getName() {
		return itemName;
	}
	
	public Double getTax() {
		return null;
	}
	
	public Double getPrice() {
		return itemPrice;
	}
}
