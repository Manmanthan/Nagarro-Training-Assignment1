package com.nagarro.training;

/**
 * This InputManager program manages the command line arguments from the user
 * @author manbhardwaj
 */

import com.nagarro.training.models.ItemDetail;

public class InputManager {

	void startManager(String[] args) {
		String choice = "y";

		do {
			try {
				String name = InputValidator.nameInput();
				String type = InputValidator.typeInput();
				String price = InputValidator.priceInput();
				String quantity = InputValidator.quantityInput();

				String[] arguments = new String[] { "-name", name, "-type", type, "-price", price, "-quantity",
						quantity };
				ItemDetail itemDetail = new InputValidator().getItemDetail(arguments);
				itemDetail.display();

				choice = InputValidator.userWantToContinueInput();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
		} while ("y".equals(choice));

		System.out.println("*******Program Finished********");
		System.exit(0);
	}
}
