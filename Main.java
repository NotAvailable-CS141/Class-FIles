package edu.cpp.cs.cs141.FinalProject;

/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Final Project
 *
 * This project is a text-based game where you play as a spy
 * who must find the briefcase that is hidden in one of nine rooms
 * inside of a building. There 6 ninjas that are roaming the building
 * and will kill you if they are close enough to you. There are multiple power
 * ups in the building such as one that will give you additional ammo if you used
 * up all your ammo, gain invincibility, and one that will show you where the briefcase is.
 *
 * Team Not Available
 *  Ryan Guidry, Ethan Balderas, Fadhar Castillo, Zhihang Yao, Daniel Gruhn
 */

/**
 * This class depicts the Main methods which is used to run the entire program;
 * Incorporated in the class is one main method used to run.
 *
 */
public class Main {

	/**
	 * 
	 * The main method instantiates a {@link UserInterface} and 
	 * runs UserInterface's method {@see edu.cpp.cs.cs141.FinalProject.UserInterface#start()}.
	 * 
	 * @param args is a string args needed to initiate the main method
	 */
	public static void main(String[] args) {
		
		GameEngine engine = new GameEngine();
	
		engine.startGame();
		
	}
}
