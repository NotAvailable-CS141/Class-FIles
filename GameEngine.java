/**
 * 
 */
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
 * up all your ammo, gain invisibility, and one that will show you where the briefcase is.
 *
 * Team Not Available
 *  Ryan Guidry, Ethan Balderas, Fadhar Castillo, Zhihang Yao, Daniel Gruhn
 */
public class GameEngine {
	
	/**
	 * Fields
	 */
	private Spy spy;
	private Ninja[] ninjas;
	private PickUp[] pickups;
	private Grid grid;
	private UserInterface ui;
	boolean playerDead = false;
	boolean gameOver = false;

	

	GameEngine(){
		ui = new UserInterface();
		grid = new Grid();
		spy = new Spy();
		pickups = new PickUp[3];
		ninjas = new Ninja[6];
		createEntities();
	}
	
	/**
	 * Methods
	 */
	
	/**
	 * The startGame method evaluates the user's choice that is displayed by the UserInterface method 
	 * displayMainMenu(). If the user chose 1, a new game is started. If the user chose 2, UserInterface 
	 * loadGameSave() method is called which returns the read information to the GameEngine. 
	 * @param ui
	 */
	public void startGame() {
		
		//Actual game code
		int mainMenuOption;
		mainMenuOption = ui.displayMainMenu();
		switch(mainMenuOption) {
		case 1:
			//Choosing 1 starts a new game. Calls newGame method which initializes new game objects.
			newGame();
			break;
		case 2:
			//Choosing 2 loads game save. ui.loadGameSave() should return the information
			//read from file. Since it is not yet implemented, the return type is void.
			
			System.out.println(mainMenuOption);
			//ui.loadGameSave();
			break;
		default:
			System.out.println(mainMenuOption);
			ui.displayUnexpectedError();
			break; //Hands over control to Main which automatically exits program.
		}
	}
	
	/**
	 * newGame() method is the main game loop when the user chooses to start a brand new game.
	 */
	public void newGame() {
		while(!gameOver) {
			ui.displayGrid(grid.visual());
			nextMove(ui.getDirection(), ui.nextMove());
		}	
	}
	private void nextMove(int x, int y) {
		//Direction int x
		//Action int y
		
		
	}

	/**
	 * loadedGame(String gameData) is the main game loop when the user chooses to load a game from file.
	 * @param gameData
	 */
	public void loadedGame(String gameData) {
		
	}
	public boolean isGameOver(){
		//Returns true if player has no more lives left, false otherwise
		return gameOver;
	}
	
	public boolean isPlayerDead() {
		//Returns true if player's health is zero, false otherwise
		return playerDead;
	}
	
	public void resetSpyLocation() {
		//Return the spy to the starting position on the Grid
		
	}
	
	public void pickUpPowerUp(){
		//Evaluates which PowerUp type, then respective action taken

	}
	
	public void debugMode() {
		//Enables debug mode, lights are turned on in the building
		
	}
	
	/**
	 * @return the grid
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public void createEntities() {
		int ninjaCounter=0;
		int pickCounter=0;
		//loops thru grid
		for(int x=0; x<9; x++) {
			for(int y=0; y<9; y++) {
				if(grid.getGrid()[x][y].hasNinja()) {
					//makes ninja at each grid location
					ninjas[ninjaCounter] = new Ninja(x,y);
					ninjaCounter++;
				}
				//makes pickups at grid location
				if(grid.getGrid()[x][y].hasPickUp()) {
					pickups[pickCounter] = grid.getGrid()[x][y].getPickUp();
					pickCounter++;
				}
	
			}
		}
	}

}