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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * {@link UserInterface} Class is the object that is responsible for all communication between the Player/User
 * and the {@link GameEngine}. The UserInterface takes all input from the player and hands it over to the GameEngine
 * so that the information can be evaluated and executed. It also serves as the GameEngine's method of
 * communicating messages to the player.
 */
public class UserInterface {
	
	/**
	 * Scanner object provided by java.io that allows user input. 
	 */
	Scanner sc = new Scanner(System.in);
	
	/**
	 * getPlayerChoice() method is used to retrieve user integer selection. This method is not meant to be used
	 * by itself. Other methods call getPlayerChoice() and evaluate the value returned.
	 * @return playerChoice
	 */
	public int getPlayerChoice() {
		
		int playerChoice;
		while(true) {
			
			try {
				if(sc.hasNext()) {
					playerChoice = sc.nextInt();
					sc.nextLine();
					return playerChoice;
				}
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("Invalid Input. Try Again. YOU MONSTER.");
				sc.nextLine();
			}
			//exception Handle
		}
		
	}
	
	/**
	 * getFileName() method is used to retrieve user string that indicates the file name of the desired save file. 
	 * This method is not meant to be used by itself. This method is called by laodGame() which evaluates the returned string.
	 * @return fileName
	 */
	public String getFileName() {
		
		String fileName;
		while(true) {
			
			try {
				if(sc.hasNext()) {
					fileName = sc.nextLine();
					
					return fileName;
				}
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("Invalid Input. Try Again. YOU MONSTER.");
				sc.nextLine();
			}
		}
	}
	
	/**
	 * getMove() method displays the game options for the player. The player can shoose to Move, Shoot, Look, or Pause the game.
	 * This method return the integer value of the player's choice (retrieved by getPlayerChoice()) so it can be handled by the
	 *  GameEngine and continue game execution. 
	 * @return playerChoice
	 */
	public int getMove() {
		
		int playerChoice;
		while(true) {
			System.out.println("What would you like to do next?" + "\n" +
							"1. Move"  + "\n" + 
							"2. Shoot" + "\n" +
							"3. Look" + "\n" +
							"4. Pause Game");
			
			playerChoice = getPlayerChoice();
			
			if (playerChoice > 0 && playerChoice < 5) {
				return playerChoice;
			}
			else {
				System.out.println("Invalid option. Please try again...");
			}
		}	
	}
	
	/**
	 * getDirection() method displays the possible direction for the Move, Shoot or Look functionalities
	 * and retrieves the player's choice with getPlayerChoice().
	 * @return playerChoice
	 */
	public int getDirection() {
	
		int playerChoice;
		while(true) {
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
	}
	
	/**
	 * displayMainMenu() method Displays the starting options for the player. These options are 
	 * 1. Start New Game, 2. Load Game Save, 3. Help, 4. Exit Game. The method prompts the user to choose an option, then proceeds
	 * to evaluate the user response. Depending on the response, it will return an integer in the range of 0 and 2.
	 * A return of 0 means that the user wants to exit the game; Return of 1 means that the user wants to Start New Game;
	 * Return of 2 means that the user wants to load a game save.
	 * This integer is used in the Main class where the game is started from.
	 * @return playerChoice
	 */
	public int displayMainMenu() {
		
		boolean playerInput = false;
		int playerChoice;
		while(!playerInput) {
			System.out.println("Welcome to Find The Briefcase");
			System.out.println("1. Start New Game.");
			System.out.println("2. Load Game Save");
			System.out.println("3. Help.");
			System.out.println("4. Exit the game.");
			
			playerChoice = getPlayerChoice();
			
			switch (playerChoice) {
			case 1:	
				playerInput = true;
				return playerChoice;
			case 2:
				playerInput = true;
				return playerChoice;
			case 3:
				playerInput = false;
				displayHelp();
				break;
			case 4:
				playerInput = true;
				System.out.println("Exiting Game!");
				exitGame();
				break;
			default:
				playerInput = false;
				System.out.println("Invalid option. Please try again...");
				break;
			}
		}
		return 0;
	}

	/**
	 * displayPauseMenu() method displays the Pause Menu functionalities and retrieves the player's choice
	 *  with getPlayerChoice().
	 * @return playerChoice
	 */
	public int displayPauseMenu() {
		
		int playerChoice;
		while(true) {
			System.out.println("Pause Menu" + "\n" +
				"1. Save Game" + "\n" +
				"2. Exit Game"+ "\n" +
				"3. Enable Debug Mode"+ "\n" +
				"4. Resume Game");
			
			playerChoice = getPlayerChoice();
			
			if (playerChoice > 0 && playerChoice < 5) {
				return playerChoice;
			}
			else {
				System.out.println("Invalid option. Please try again...");
			}
		}
	}

	/**
	 * displayLookMenu() method displays the Look Menu functionalities and retrieves the player's choice
	 *  with getPlayerChoice().
	 * @return playerChoice
	 */
	public int displayLookMenu() {
		int playerChoice;
		while(true) {
			System.out.println("Look Menu" + "\n" +
				"1. Move" + "\n" +
				"2. Shoot"+ "\n");
			
			playerChoice = getPlayerChoice();
			
			if (playerChoice > 0 && playerChoice < 3) {
				return playerChoice;
			}
			else {
				System.out.println("Invalid option. Please try again...");
			}
		}
	}
	
	/**
	 * displayHelp() method displays the rules of the game for the user. This method does not return a value due to
	 * the display only nature of the method.
	 */
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
		System.out.println("* - Unseen space" +"\n");
	}
	
	/**
	 * displayGrid() displays the string game grid with all assets that was created by the Grid object.
	 * 
	 * @param grid
	 *  	the grid to be displayed.
	 */
	public void displayGrid(String grid) {
		System.out.println(grid);
	}
	
	/**
	 * displayStats() displays the statistics of the game such as lives left, ammo, and turns left invincible. Arguments are provided
	 *  by the GameEngine object.
	 * 
	 * @param lives
	 * @param ammo
	 * @param turnsInv
	 */
	public void displayStats(int lives, int ammo, int turnsInv) {
		System.out.println("Lives left: " + lives + "\tAmmo left: " + ammo + "\tTurns left Invincible: " + turnsInv + "\n");
	}
	
	/**
	 * displayWin() displays winning message if player retrieves briefcase and terminates program execution.
	 */
	public void displayWin() {
		System.out.println("MISSION ACCOMPLISHED! Good job 007.");
		exitGame();
	}
	
	/**
	 * displayGameOver() displays game over message if player dies 3 times and terminates program execution.
	 */
	public void displayGameOver() {
		System.out.println("You ran out of lives.");
		System.out.println("");
		System.out.println("Game Over.");
		exitGame();
	}
	
	/**
	 * displayUnexpectedError() displays an Unexpected game error message and terminates program execution to prevent unstable behavior.
	 */
	public void displayUnexpectedError() {
		System.out.println("Unexpected Error Ocurred! Exiting Game.");
		System.exit(0);
	}
	
	/**
	 * displayInvalidMoveError() displays an error message if the player tries to make an illegal move.
	 */
	public void displayInvalidMoveError() {
		System.out.println("That move is not permitted. Please try again.");
	}
	
	/**
	 * displayHasBriefcase() method displays a message when the briefcase is found in the room.
	 */
	public void displayHasBriefcase() {
		System.out.println("You enter the room...");
		System.out.println("...you found the briefcase!");
	}
	
	/**
	 * displayHasNoBriefcase() method displays a message when the briefcase is not found in the room.
	 */
	public void displayHasNoBriefcase() {
		System.out.println("You enter the room...");
		System.out.println("...but the briefcase isn't there!");
	}


	/**
	 * displayPickUp() method displays a the PickUp type that has been activated.
	 */
	public void displayPickUp(PickUp.PickUpType type) {
		System.out.println("You picked up: " + type);
	}
	
	/**
	 * displayStabbed() method displays a message when the Spy has been stabbed by a ninja.
	 */
	public void displayStabbed() {
		System.out.println("A ninja has stabbed you.");
	}
	
	/**
	 * displayNinjaKilled() method displays a message when the Spy has shot and killed a ninja.
	 */
	public void displayNinjaKilled() {
		System.out.println("Ninja was killed.");
	}

	/**
	 * displayNoAmmo() method displays a message when the Spy cannot shoot because he has ran out of ammo.
	 */
	public void displayNoAmmo() {
		System.out.println("You are unable to shoot, you have no remaining ammo.");
	}

	/**
	 * displayMissedShot() method displays a message when the Spy has shot but did not hit any ninjas.
	 */
	public void displayMissedShot() {
		System.out.println("Missed Shot. No confirmed kill.");
	}
	
	/**
	 * saveGame(Grid g, Spy s, Ninja[] n, PickUp[] p) method writes the game objects to file. It creates a new
	 * file with 'SaveFile*.file' file name and extension where * represents a number.
	 * @param g
	 * @param s
	 * @param n
	 * @param p
	 * @param is
	 * @param go
	 */
	public void saveGame(Grid g, Spy s, Ninja[] n, PickUp[] p){
		int counter = 1;
		File save = new File("SaveFile" + counter + ".file");
		
		while(save.exists()) {
			counter++;
			save = new File("SaveFile" + counter + ".file");
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(save);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(g);
			oos.writeObject(s);
			oos.writeObject(n);
			oos.writeObject(p);
			System.out.println("Game saved as: SaveFile"+counter+".file");
			
			fos.close();
			oos.close();
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Error saving game state. You're not supposed to be able to see this!");
		}		
	}
	
	/**
	 * loadGame() method loads game save by reading the written objects from a specified file. This method
	 * returns a temporarily constructed GameEngine object that is used to copy the read objects to the 
	 * active GameEngine object.
	 * @return ge
	 */
	public GameEngine loadGame() {
		boolean validFile;
		Grid g = new Grid();
		Spy s = new Spy();
		Ninja[] n = new Ninja[6];
		PickUp[] p = new PickUp[3];
		
		
		do{
			System.out.println("");
			System.out.println("Enter the file name in the format 'SaveFile*' where * represents the number.");
			String fileName = getFileName();
			
			try {
				File save = new File(fileName+".file");
				FileInputStream fis = new FileInputStream(save);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				g = (Grid)ois.readObject();
				s = (Spy)ois.readObject();
				n = (Ninja[])ois.readObject();
				p = (PickUp[])ois.readObject();
				
				fis.close();
				ois.close();
				
				validFile = true;
			}catch(IOException e) {
				validFile = false;
				System.out.println("File Not Found!");
			} catch(ClassNotFoundException e) {
				validFile = false;
				System.out.println("File Not Found!");
			}		
		}
		
		while(!validFile);
		GameEngine ge = new GameEngine(g, s, n, p);
		
		return ge;
	}
	
	/**
	 * exitGame() method display a thank you message and terminates program execution.
	 */
	public void exitGame() {
		System.out.println("Thank you for playing!");
		System.exit(0);
	}

}
