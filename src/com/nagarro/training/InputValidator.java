package com.nagarro.training;

/**
 * InputValidator class validates the command line input from user.
 * @author manbhardwaj
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.nagarro.training.models.ImportedItem;
import com.nagarro.training.models.Item;
import com.nagarro.training.models.ItemDetail;
import com.nagarro.training.models.ManufacturedItem;
import com.nagarro.training.models.RawItem;

public class InputValidator {
	static Scanner scan = new Scanner(System.in);

	static String userWantToContinueInput() {
		String choice = "";
		while (true) {
			System.out.print("---> Do you want to enter details of any other item (y/n): ");
			try {
				choice = scan.nextLine();
				if (!choice.matches("y|Y|Yes|yes|n|N|No|no") || choice == null || choice.isEmpty()) {
					throw new Exception("Please input a valid option.");
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return choice;
	}

	static String quantityInput() {
		String quantity;
		while (true) {
			System.out.println("Enter quantity of item : ");
			try {
				quantity = scan.nextLine();
				if (!quantity.matches("[0-9]+") || Integer.parseInt(quantity) <= 0) {
					throw new Exception("Quantity should be positive whole number value.");
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return quantity;
	}

	static String priceInput() {
		String price;
		while (true) {
			System.out.println("Enter price of item : ");
			try {
				price = scan.nextLine();
				if (!price.matches("[0-9]+") || Double.parseDouble(price) <= 0)
					throw new Exception("Price should be positive integer value.");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return price;
	}

	static String typeInput() {
		String type = "";
		while (true) {
			System.out.println("Enter type of item [ raw , manufactured , imported ] : ");
			try {
				type = scan.nextLine().toLowerCase();
				switch (type) {
				case Strings.raw:
				case Strings.manufactured:
				case Strings.imported:
					break;
				default:
					throw new Exception("Invalid 'Item Type' specified !");
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return type;
	}

	static String nameInput() {
		String name = "";
		while (true) {
			System.out.println("Enter name of item : ");
			name = scan.nextLine();
			try {
				if (name == null || name.isEmpty()) {
					throw new Exception("Name field cannot be empty");
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return name;
	}

	ItemDetail getItemDetail(String[] args) {
		ArrayList<String> argsList = new ArrayList<>(Arrays.asList(args));

		String type = argsList.get(argsList.indexOf("-" + Strings.type) + 1);
		String name = argsList.get(argsList.indexOf("-" + Strings.name) + 1);
		Double price = null;
		Integer quantity = null;

		if (argsList.indexOf("-" + Strings.price) >= 0) {
			price = Double.parseDouble(argsList.get(argsList.indexOf("-" + Strings.price) + 1));
		}
		if (argsList.indexOf("-" + Strings.quantity) >= 0) {
			quantity = Integer.parseInt(argsList.get(argsList.indexOf("-" + Strings.quantity) + 1));
		}
		if (quantity == null)
			quantity = 1; // default quantity

		switch (type) {
		case Strings.raw:
			return new ItemDetail(new RawItem(name, price), quantity);
		case Strings.manufactured:
			return new ItemDetail(new ManufacturedItem(name, price), quantity);
		case Strings.imported:
			return new ItemDetail(new ImportedItem(name, price), quantity);
		default:
			return new ItemDetail(new Item("InvalidItem", (double) 0), 0);
		}
	}
}
