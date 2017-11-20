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
		//Temporary grid display for testing
		
		
		
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
			ui.loadGameSave();
			break;
		default:
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
			ui.displayStats(spy.getLives(), spy.hasBullet());
			int playerMove = ui.getMove();
	
			//MOVING
			switch (playerMove) {
			case 1: 
				if(spyMove()) {
					moveNinjas();
				}
				break;
			case 2:
				spyShoot();
				break;
			case 3:
				spyLook();
				break;
			case 4:
				pauseGame();
				break;
			}
		}
			
	}

	private void pauseGame() {
		//Pause menu allows game to save, exit, enable debug mode, and resume game
				int pauseMenuOption;
				pauseMenuOption = ui.displayPauseMenu();
				switch(pauseMenuOption) {
				case 1:
					//Choosing 1 starts a new game. Calls newGame method which initializes new game objects.
					ui.saveGame();
					break;
				case 2:
					ui.exitGame();
					break;
				case 3:
					grid.debug();
					break;
				case 4:
					return;
				default:
					ui.displayUnexpectedError();
					break; //Hands over control to Main which automatically exits program.
				}
	}

	/**
	 * @return true if spy moves, false if the move in invalid
	 */
	public boolean spyMove() {
		int playerDirection = ui.getDirection();
		//Check the position to the right of the spy in the grid 
		if (playerDirection == 1) {//right
			Location currentLoc = new Location(spy.getLocation().getRow(), spy.getLocation().getCol());
			Location futureLoc = new Location(spy.getLocation().getRow(), spy.getLocation().getCol()+1);
			
			if(!grid.isValidMove(currentLoc, futureLoc)) {
				ui.displayInvalidMoveError();
				return false;
			}
			if(grid.isValidMove(currentLoc, futureLoc)) {
				spy.move(1);
				grid.movePlayer(currentLoc, futureLoc);
				return true;
			}
		}
		//Check the position to the left of the spy in the grid 
		else if(playerDirection == 2) {//left
			Location currentLoc = new Location(spy.getLocation().getRow(), spy.getLocation().getCol());
			Location futureLoc = new Location(spy.getLocation().getRow(), spy.getLocation().getCol()-1);
			if(!grid.isValidMove(currentLoc, futureLoc)) {
				ui.displayInvalidMoveError();
				return false;
			}
			if(grid.isValidMove(currentLoc, futureLoc)) {
				spy.move(2);
				grid.movePlayer(currentLoc, futureLoc);
				return true;
			}
		}
		else if(playerDirection == 3) {//up
			Location currentLoc = new Location(spy.getLocation().getRow(), spy.getLocation().getCol());
			Location futureLoc = new Location(spy.getLocation().getRow()-1, spy.getLocation().getCol());
			if(!grid.isValidMove(currentLoc, futureLoc)) {
				ui.displayInvalidMoveError();
				return false;
			}
			if(grid.isValidMove(currentLoc, futureLoc)) {
				spy.move(3);
				grid.movePlayer(currentLoc, futureLoc);
				return true;
			}
		}
		else if(playerDirection == 4) {//down
			Location currentLoc = new Location(spy.getLocation().getRow(), spy.getLocation().getCol());
			Location futureLoc = new Location(spy.getLocation().getRow()+1, spy.getLocation().getCol());
			if(!grid.isValidMove(currentLoc, futureLoc)) {
				ui.displayInvalidMoveError();
				return false;
			}
			if(grid.isValidMove(currentLoc, futureLoc)) {
				spy.move(4);
				grid.movePlayer(currentLoc, futureLoc);
				return true;
			}
		}
		return false;
	}
	public void spyShoot() {
		int playerDirection = ui.getDirection();
		//Check the position to the right of the spy in the grid 
		if (playerDirection == 1) {
			spy.shoot();
		}
		//Check the position to the left of the spy in the grid 
		else if(playerDirection == 2) {
			spy.shoot();
		}
		else if(playerDirection == 3) {
			spy.shoot();
		}
		else if(playerDirection == 4) {
			spy.shoot();
		}
	}
	public void spyLook() {
		//Makes correct spaces in whatever direction spy looks to visible
		int playerDirection = ui.getDirection();
		grid.look(spy.getLocation(), playerDirection);
		
		//Shows Grid and Stats
		ui.displayGrid(grid.visual());
		ui.displayStats(spy.getLives(), spy.hasBullet());
		
		//New Menu after player looks
			int lookMenuOption = ui.displayLookMenu();
			switch(lookMenuOption) {
			case 1:
				if(spyMove()) {
					moveNinjas();
				}
				break;
			case 2:
				spyShoot();
				break;		
			case 3:
				pauseGame();
				break;
			}
		
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
		grid.getGrid()[spy.getLocation().getRow()][spy.getLocation().getCol()].setPlayer(false);
		spy.setLocation(new Location(8,0));
		grid.getGrid()[spy.getLocation().getRow()][spy.getLocation().getCol()].setPlayer(true);
	}
	
	public void pickUpPowerUp(PickUp p){
		//Evaluates which PowerUp type, then respective action taken
		switch(p.getType()) {
			case AMMO:
				spy.reload();
				break;
			case RADAR: 
				for(Space[] array : grid.getGrid()) {
					for(Space s : array) {
						if(s.isRoom()) {
							s.setVisible(true);
						}
					}
				}
				break;
			case INVINCIBILITY:
				spy.setInvincible(5);
				break;
			default: break;
		}
	}
	
	public void debugMode() {
		//Enables debug mode, lights are turned on in the building
		for(Space[] array : grid.getGrid()) {
			for(Space s : array) {
				s.setVisible(true);
			}
		}
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
		int pickUpCounter=0;
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
					pickups[pickUpCounter] = grid.getGrid()[x][y].getPickUp();
					pickUpCounter++;
				}
	
			}
		}
	}
	
	/**
	 * Loops through the ninja array, making each ninja take its turn.
	 * If ninja is adjacent to spy, the ninja stabs the spy and returns the spy to its starting position.
	 * Regardless, the ninja will pick a random direction to move one space in.
	 */
	public void moveNinjas() {
		for(Ninja n : ninjas) {
			if(n.getLocation().adjacentTo(spy.getLocation())) {
				//stabs the spy
				if(!spy.isInvincible()) {
					System.out.println("A ninja has stabbed you.");
					spy.takeDamage();
					if(spy.getLives() <= 0) {
						gameOver = true;
						ui.displayGameOver();
					}
					//moves the spy back to spawn point
					resetSpyLocation();
				}	
			}
			
			int direction;
			int nRow = n.getLocation().getRow();
			int nCol = n.getLocation().getCol();
			Location endLoc = new Location(-1, -1);
			
			do {
				direction = (int)(Math.random()*4) + 1;
				switch(direction) {
					case 1://up
						endLoc = new Location(nRow-1, nCol);
						break;
					case 2://right
						endLoc = new Location(nRow, nCol+1);
						break;
					case 3://down
						endLoc = new Location(nRow+1, nCol);
						break;
					case 4://left
						endLoc = new Location(nRow, nCol-1);
						break;
					default: break;
				}
			}while(!grid.isValidMove(n.getLocation(), endLoc));
				
			n.moveTo(endLoc);
			grid.getGrid()[nRow][nCol].setNinja(false);
			grid.getGrid()[endLoc.getRow()][endLoc.getCol()].setNinja(true);
			
			if(n.getLocation().adjacentTo(spy.getLocation())) {
				//stabs the spy
				if(!spy.isInvincible()) {
					System.out.println("A ninja has stabbed you.");
					spy.takeDamage();
					if(spy.getLives() <= 0) {
						gameOver = true;
						ui.displayGameOver();
					}
					//moves the spy back to spawn point
					resetSpyLocation();
				}	
			}
		}
	}
}