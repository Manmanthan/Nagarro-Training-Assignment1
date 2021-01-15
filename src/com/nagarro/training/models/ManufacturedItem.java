package com.nagarro.training.models;

public class ManufacturedItem extends Item {
	private Double itemTax;
	
	public ManufacturedItem(String name, Double price) {
		super(name, price);
	}

	@Override
	public Double getTax() {
		itemTax = 12.5 / 100 * getPrice();
		itemTax = 2.0 / 100 *(getPrice() + itemTax);
		return itemTax;
	}
}
