package com.nagarro.training.models;

public class ImportedItem extends Item {
	private Double itemTax;
	
	public ImportedItem(String name, Double price) {
		super(name, price);
	}
	
	@Override
	public Double getTax() {
		itemTax = 10.0 / 100 * getPrice();
		if(itemTax <= 100) 
			itemTax += 5;
		else if(itemTax >= 100 && itemTax <= 200)
			itemTax += 10;
		else
			itemTax += 5.0 / 100 * (itemTax + getPrice());
		return itemTax;
	}
}
