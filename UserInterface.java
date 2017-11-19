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
		int playerChoice;
		while(true) {
			try {
				playerChoice = sc.nextInt();
				return playerChoice;
			}
			catch(java.util.InputMismatchException e) {
				sc.nextLine();
			}
			//exception Handle
		}
	}
	
	/**
	 * The displayMainMenu() method Displays the starting options for the player. These options are 
	 * 1. Start New Game, 2. Load Game Save, 3. Help, 4. Exit Game Then prompts the user to choose an option, then proceeds
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
			System.out.println("Welcome to Find The Briefcase:");
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
				exitGame();
				break;
			default:
				System.out.println("Invalid option. Please try again...");
				break;
			}
		}
		return 0;
	}
	public void displayHelp() {
		//Displays game rules
		System.out.println("   In this turn-based game, you play as a Spy who is on a mission to retrieve important documents");
		System.out.println("from a building that is pitch black. There are also ninjas patrolling the building. Each turn, you");
		System.out.println("are able to move left, right, up or down one space as long as there are no obstacles in that direction.");
		System.out.println("The next turn, the ninjas move one space in a random direction.");
		System.out.println("The building has 9 rooms, but only one has the precious briefcase containing the documents.");
		System.out.println("   While navigating the building, you can only enter the rooms from the North side of the room.");
		System.out.println("Because you are a highly trained Spy, you are equipped with night vision gogles that allow you to see");
		System.out.println("only two spaces ahead. You also have a pistol with a single round at your disposal in case you encounter");
		System.out.println("a Ninja. Be careful as you only have 3 lives, and each time you die you respawn back at the start.");
		System.out.println("If you run out of lives, you automatically lose the game.");
		System.out.println("");
		System.out.println("There are three power-ups scattered around the building which have the following properties:");
		System.out.println("   Additional Bullet: Grants you an additional bullet if you have not used the initial bullet.");
		System.out.println("   Invincibility: Grants you invulnerability from Ninja stabs for five turns.");
		System.out.println("   Radar: Allows you to see where the briefcase is located .");
		System.out.println("");
		System.out.println("Each object has its own Icon in the map.");
		System.out.println("S - Spy");
		System.out.println("N - Ninja");
		System.out.println("B - Briefcase");
		System.out.println("A - Ammo (only 1 round)");
		System.out.println("I - Invincibility");
		System.out.println("R - Radar");
		System.out.println("* - Unseen space" + "\n");
	}
	public void displayGrid(String grid) {
		//Displays game grid with all assets
		System.out.println(grid);
	}
	public void displayStats(int lives, int ammo) {
		//Displays the statistics of the game such as lives left
		System.out.println("Lives left: " + lives + "     Rounds left: " + ammo);
	}
	public void displayWin() {
		//Displays winning message if player retrieves briefcase
		System.out.println("MISSION ACCOMPLISHED! Good job 007.");
		exitGame();
	}
	public void displayGameOver() {
		//Displays game over message if player dies 3 times
		System.out.println("You ran out of lives.");
		System.out.println("");
		System.out.println("Game Over.");
		exitGame();
	}
	
	public void displayUnexpectedError() {
		System.out.println("Unexpected Error Ocurred! Exiting Game.");
		System.exit(0);
	}
	
	public void displayInvalidMoveError() {
		System.out.println("That move is not permitted. Please try again.");
	}
	
	public void saveGame() {
		//saves the game to file
	}
	public void loadGameSave() {
		//loads game save from file
	}

	public int getMove() {
		//First ask which direction w' getDirection()
		//Then ask what action.
		//Use getPlayerChoice() for user input and use displayMainMenu() as reference for design
		
		
		boolean playerInput = false;
		int playerChoice;
		while(!playerInput) {
			System.out.println("What would you like to do next?" + "\n" +
							"1. Move"  + "\n" + 
							"2. Shoot" + "\n" +
							"3. Pause Game");
			
			playerChoice = getPlayerChoice();
			
			if (playerChoice > 0 && playerChoice < 4) {
				return playerChoice;
			}
			else {
				System.out.println("Invalid option. Please try again...");
			}
		}
		return 0;
	}

	public int getDirection() {
		// asks for direction
		
		boolean playerInput = false;
		int playerChoice;
		while(!playerInput) {
			System.out.println("What direction?" + "\n" +
				"1. Right"+ "\n" +
				"2. Left"+ "\n" +
				"3. Up"+ "\n" +
				"4. Down");
			
			playerChoice = getPlayerChoice();
			
			if ( playerChoice > 0 && playerChoice < 5) {
				return playerChoice;
			}
			else {
				System.out.println("Invalid option. Please try again...");
			}
		}
		return 0;
	}
	
	public int pauseGameMenu() {
		
		boolean playerInput = false;
		int playerChoice;
		while(!playerInput) {
			System.out.println("Pause Menu" + "\n" +
				"1. Save Game" + "\n" +
				"2. Exit Game"+ "\n" +
				"3. Resume Game");
			
			playerChoice = getPlayerChoice();
			
			if (playerChoice < 4 && playerChoice > 0) {
				return playerChoice;
			}
			else {
				System.out.println("Invalid option. Please try again...");
			}
		}
		return 0;
	}
	
	public void exitGame() {
		System.exit(0);
	}

}
