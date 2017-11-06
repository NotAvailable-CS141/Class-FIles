/**
 * 
 */
package edu.cpp.cs.cs141.FinalProject;

/**
 * This class depicts the Main methods which is used to run the entire program;
 * Incorporated in the class is one main method used to run.
 *
 */
public class Main {

	/**
	 * 
	 * The main method instantiates a {@link UserInterface} and 
	 * runs UserInterface's method {@see edu.cpp.cs.cs141.Assignment2.UserInterface#start()}.
	 * 
	 * @param args is a string args needed to initiate the main method
	 */
	public static void main(String[] args) {
		
		UserInterface ui = new UserInterface();
		ui.start();
	}

}
