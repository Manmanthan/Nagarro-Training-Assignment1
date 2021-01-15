package com.nagarro.training;

/**
 * This is the main project class which creates a InputManager object and then
 * calls it's method startManager to perform the command line operations.
 * 
 * @author manbhardwaj
 *
 */

public class Application {

	public static void main(String args[]) {
		InputManager manager = new InputManager();
		manager.startManager(args);
	}
}
