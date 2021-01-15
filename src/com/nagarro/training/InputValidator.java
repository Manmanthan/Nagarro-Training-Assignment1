package com.nagarro.training;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the InputValidator class used for validating the arguments passed 
 * by the user and throw the exceptions respective to the invalid argument
 * @author manbhardwaj
 */

import com.nagarro.training.exceptions.InvalidInput;
import com.nagarro.training.models.ImportedItem;
import com.nagarro.training.models.Item;
import com.nagarro.training.models.ItemDetail;
import com.nagarro.training.models.ManufacturedItem;
import com.nagarro.training.models.RawItem;

public class InputValidator {

	private void validateTypeOption(ArrayList<String> args) {
		String type = args.get(args.indexOf("-" + Strings.type) + 1);
		switch (type) {
		case "raw":
		case "manufactured":
		case "imported":
			break;
		default:
			throw new InvalidInput("Invalid 'Item Type' specified !");
		}
	}

	private void validateOptionHasCorrectDataType(ArrayList<String> args) {
		try {
			if (args.indexOf("-" + Strings.quantity) >= 0)
				Integer.parseInt(args.get(args.indexOf("-" + Strings.quantity) + 1));
			if (args.indexOf("-" + Strings.price) >= 0)
				Double.parseDouble(args.get(args.indexOf("-" + Strings.price) + 1));
		} catch (NumberFormatException e) {
			throw new InvalidInput("Invalid input ! Make sure that item quantity and price are positive integer.");
		}
	}

	private void validate(ArrayList<String> args) throws InvalidInput {
		validateTypeOption(args);
		validateOptionHasCorrectDataType(args);
	}

	ItemDetail getItemDetail(String[] args) throws InvalidInput {
		ArrayList<String> argsList = new ArrayList<>(Arrays.asList(args));

		validate(argsList);

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
