package com.nagarro.training.models;

public class RawItem extends Item {
	private Double itemTax;
	
	public RawItem(String name, Double price) {
		super(name, price);
	}
	
	@Override
	public Double getTax() {
		itemTax = 12.5 / 100 * getPrice();
		return itemTax;
	}
}
