package com.nagarro.training;

import java.util.Scanner;

/**
 * This InputManager program manages the command line arguments from the user
 * @author manbhardwaj
 */

import com.nagarro.training.models.ItemDetail;

public class InputManager {
	void startManager(String[] args) {
		Scanner scan = new Scanner(System.in);
		String choice = "y";

		do {
			try {
				System.out.println("Enter name of item : ");
				String name = scan.nextLine();
				System.out.println("Enter type of item [ raw , manufactured , imported ] : ");
				String type = scan.nextLine();
				System.out.println("Enter price of item : ");
//			while (!scan.hasNextInt()) {
//				System.out.println("That's not a number!");
//				scan.nextLine();
//			}
				String price = scan.nextLine();
				System.out.println("Enter quantity of item : ");
				String quantity = scan.nextLine();

				String[] arguments = new String[] { "-name", name, "-type", type, "-price", price, "-quantity",
						quantity };
				ItemDetail itemDetail = new InputValidator().getItemDetail(arguments);
				itemDetail.display();

				System.out.println("Do you want to enter details of any other item (y/n): ");
				choice = scan.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
		} while ("y".equals(choice));

		System.out.println("Program Finished.");
		System.exit(0);
	}
}
