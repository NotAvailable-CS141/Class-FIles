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
 * up all your ammo, gain invisibility, and one that will show you where the briefcase is.
 *
 * Team Not Available
 *  Ryan Guidry, Ethan Balderas, Fadhar Castillo, Zhihang Yao, Daniel Gruhn
 */

package edu.cpp.cs.cs141.FinalProject;

import java.util.Scanner;

public class UserInterface {
	
	Scanner sc = new Scanner(System.in);
	
	public int getPlayerChoice() {
		
	    int playerChoice = sc.nextInt();
		return playerChoice;
		//exception Handle
	}
	
	/**
	 * The displayMainMenu() method Displays the starting options for the player. These options are 
	 * 1. Start New Game, 2. Load Game Save, 3. Help. Then prompts the user to choose an option, then proceeds
	 * to evaluate the user response. Depending on the response, it will return an integer in the range of 0 and 2.
	 * A return of 0 means that the user wants to exit the game; Return of 1 means that the user wants to Start New Game;
	 * Return of 2 means that the user wants to load a game save.
	 * This integer is used in the Main class where the game is started from.
	 * @param engine
	 * @return
	 */
	public int displayMainMenu() {
		
		boolean playerInput = false;
		int playerChoice;
		while(!playerInput) {
			System.out.println("1. Start New Game.");
			System.out.println("2. Load Game Save");
			System.out.println("3. Help.");
			System.out.println("4. Exit the game.");
			
			playerChoice = getPlayerChoice();
			
			switch (playerChoice) {
			case 1:				
				return playerChoice;
			case 2:
				return playerChoice;
			case 3:
				displayHelp();
				break;
			case 4:
				System.out.println("Exiting Game!");
				System.exit(0);
			default:
				System.out.println("Invalid option. Please try again...");
				break;
			}
		}
		return 0;
	}
	public void displayHelp() {
		//Displays game rules
		System.out.println("In this game, you play as a Spy who is on a mission to retrieve important documents");
		System.out.println("from a building that is pitch black. There are also ninjas patrolling the building.");
		System.out.println("The building has 9 rooms, which only one has the precious briefcase containing the documents.");
		System.out.println("");
	}
	public void displayGrid(String grid) {
		//Displays game grid with all assets
		System.out.println(grid);
	}
	public void displayStats() {
		//Displays the statistics of the game such as lives left
	}
	public void displayWin() {
		//Displays winning message if player retrieves briefcase
	}
	public void displayGameOver() {
		//Displays game over message if player dies 3 times
	}
	
	public void displayUnexpectedError() {
		System.out.println("Unexpected Error Ocurred! Exiting Game.");
	}
	public void saveGame() {
		//saves the game to file
	}
	public void loadGameSave() {
		//loads game save from file
	}

	public void nextMove() {
		System.out.println("What would you like to do next? Wack off?");
		
	}

}