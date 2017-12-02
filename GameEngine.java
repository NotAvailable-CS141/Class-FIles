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

/**
 * {@link GameEngine} Class is the brain of the Find The Briefcase game. It holds all the game objects and is responsible
 * for the logic and game execution. The GameEngine Class evaluates all player input that has been retrieved by the
 * {@link UserInterface} Class and runs the game conditions based on the player input. When the GameEngine needs to communicate
 * with the player, GameEngine instructs the UserInterface to retrieve input as well as display messages to the player.
 */
public class GameEngine {
	//Fields
	/**
	 * The {@link Spy} object is the entity that the Player controls during game execution.
	 */
	private Spy spy;
	
	/*
	 * The {@link Ninja} array holds the total number of Ninja enemies for the game.
	 */
	private Ninja[] ninjas;
	/*
	 * The {@link PickUp} array holds the total number of PickUp objects that the player/spy
	 * can acquire during game execution.
	 */
	private PickUp[] pickups;
	
	/**
	 * The {@link Grid} object is the board that holds all entity location data. 
	 */
	private Grid grid;
	
	/**
	 * The {@link UserInterface} object enables user input and {@link GameEngine} output
	 */
	private UserInterface ui;
	
	/**
	 * boolean that keeps track whether the Player has been killed.
	 */
	private boolean playerDead = false;
	
	/**
	 * boolean that keeps track whether the Game is over.
	 */
	private boolean gameOver = false;

	/**
	 * {@link GameEngine GameEngine()} constructor initializes all game assets for proper
	 * game execution.
	 */
	GameEngine(){
		ui = new UserInterface();
		grid = new Grid();
		spy = new Spy();
		pickups = new PickUp[3];
		ninjas = new Ninja[6];
		createEntities();
	}
	
	/**
	 * {@link GameEngine GameEngine(Grid g, Spy s, Ninja[] ni, PickUp[] p)} overloaded
	 * constructor that creates an instance of GameEngine from loaded game data from file.
	 * @param g loaded Grid object from file.
	 * @param s loaded Spy object from file.
	 * @param ni loaded Ninja objects from file.
	 * @param p loaded PickUp objects from file.
	 */
	GameEngine(Grid g, Spy s, Ninja[] ni, PickUp[] p){
		grid = g;
		spy = s;
		pickups = p;
		ninjas = ni;
	}
	
	//Methods
	/**
	 * {@link GameEngine getSpy()} method returns the spy object. This method is meant to be used for loading functionality.
	 * @return spy
	 */
	public Spy getSpy() {return spy;}
	
	/**
	 * {@link GameEngine setSpy(Spy spy)} method sets the active spy object to the temporary spy object. 
	 * This method is meant to be used for loading functionality.
	 */
	public void setSpy(Spy spy) {this.spy = spy;}
	
	/**
	 * {@link GameEngine getNinjas()} method returns the array of ninjas. This method is meant to be used for loading functionality.
	 * @return ninjas
	 */
	public Ninja[] getNinjas() {return ninjas;}
	
	/**
	 * {@link GameEngine setNinjas(Ninja[] ninjas)} method sets the active Ninja array object to the temporary Ninja array object. 
	 * This method is meant to be used for loading functionality.
	 */
	public void setNinjas(Ninja[] ninjas) {this.ninjas = ninjas;}
	
	/**
	 * {@link GameEngine getPickups()} method returns the array of pickups. This method is meant to be used for loading functionality.
	 * @return pickups
	 */
	public PickUp[] getPickups() {return pickups;}
	
	/**
	 * {@link GameEngine (PickUp[] pickups)} method sets the active PickUp array object to the temporary PickUp array object. 
	 * This method is meant to be used for loading functionality.
	 */
	public void setPickups(PickUp[] pickups) {this.pickups = pickups;}
	
	/**
	 * {@link GameEngine isGameOver()} method returns the boolean value of gameOver
	 * @return gameOver
	 */
	public boolean isGameOver(){return gameOver;}
	
	/**
	 * {@link GameEngine setGameOver(boolean go)} sets the active gameOver boolean value to the temporary boolean go value.
	 * @param go
	 */
	public void setGameOver(boolean go) {gameOver = go;}
	
	/**
	 * {@link GameEngine isPlayerDead()} method returns the boolean value of playerDead
	 * @return playerDead
	 */
	public boolean isPlayerDead() {return playerDead;}
	
	/**
	 * {@link GameEngine setPlayerDead(boolean playerDead)} method sets the active playerDead boolean value to the temporary 
	 * playerDead boolean value
	 * @param playerDead
	 */
	public void setPlayerDead(boolean playerDead) {this.playerDead = playerDead;}
	
	/**
	 * {@link GameEngine getGrid()} method returns the grid object
	 * @return the grid
	 */
	public Grid getGrid() {return grid;}

	/**
	 * {@link GameEngine setGrid(Grid grid)} sets the temporary grid to the active grid object.
	 * @param grid 
	 */
	public void setGrid(Grid grid) {this.grid = grid;}
	
	/**
	 * {@link GameEngine startGame()} method evaluates the user's choice that is displayed by the UserInterface method 
	 * displayMainMenu(). If the user chose 1, a new game is started. If the user chose 2, loadGame() 
	 * method is called. 
	 */
	public void startGame() {
	
		int mainMenuOption;
		mainMenuOption = ui.displayMainMenu();
		switch(mainMenuOption) {
		case 1:
			newGame();
			break;
		case 2:
			loadedGame();
			break;
		default:
			ui.displayUnexpectedError();
			break; 
		}
		
		
	}
	
	/**
	 * {@link GameEngine loadFromEngineObject(GameEngine e)} is called by the loadedGame() method to set the active GameEngine
	 * object's attributes which are the Spy, Ninja[], PickUp[], and Grid from a temporary GameEngine e that
	 * contains the initialized attributes which were read from a save file.
	 * @param e
	 */
	private void loadFromEngineObject(GameEngine e) {
		setSpy(e.getSpy());
		setNinjas(e.getNinjas());
		setPickups(e.getPickups());
		setGrid(e.getGrid());
	
	}

	/**
	 * {@link GameEngine newGame()} method is the main game loop when the user chooses to start a brand new game and executes until the gameOver
	 * condition is not satisfied. The method displays the grid,
	 * the statistics (Spy's lives, Spy's bullet count, Spy's turns left invincible). It retrieves the desired move
	 * prompted and returned by ui.getMove(), evaluates and executes the desired option. Once the option is executed,
	 * the gameOver condition is checked, if gameOver == true, playerDead condition is checked which evaluates if the spy is dead
	 * If indeed the spy is dead, displayGameOver() is called and terminates program execution, otherwise displayWin() is called.
	 */
	public void newGame() {
		
		while(!gameOver) {
			ui.displayGrid(grid.visual());
			ui.displayStats(spy.getLives(), spy.hasBullet(), spy.getTurnsInvincible());
			int playerMove = ui.getMove();
	
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
			
			if(gameOver) {
				if(playerDead) 
					ui.displayGameOver();
				else 
					ui.displayWin();
				
				ui.exitGame();
			}
		}
			
	}
	
	/**
	 * {@link GameEngine loadedGame()} is similar to newGame(), except that loadedGame() calls ui.loadGame() which returns the
	 * temporarily constructed GameEngine object from a specified game save file, and copies the data to the
	 * active GameEngine/this.
	 */
	public void loadedGame() {
		loadFromEngineObject(ui.loadGame());
		while(!gameOver) {
			ui.displayGrid(grid.visual());
			ui.displayStats(spy.getLives(), spy.hasBullet(), spy.getTurnsInvincible());
			int playerMove = ui.getMove();
	
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
			
			if(gameOver) {
				if(playerDead) 
					ui.displayGameOver();
				else 
					ui.displayWin();
				
				ui.exitGame();
			}
		}
	}
	/**
	 * {@link GameEngine pauseGame()} method pauses game execution so that the user can save, exit, enable debug mode. The method calls
	 * ui.displayPauseMenu() which displays the pause menu options and return the player choice for evaluation in this method.
	 */
	public void pauseGame() {
		//Pause menu allows game to save, exit, enable debug mode, and resume game
		int pauseMenuOption;
		pauseMenuOption = ui.displayPauseMenu();
		switch(pauseMenuOption) {
		case 1:
			//Choosing 1 starts a new game. Calls newGame method which initializes new game objects.
			ui.saveGame(grid, spy, ninjas, pickups);
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
	 * {@link GameEngine spyMove()} method is responsible for moving the spy's location by evaluating the desired direction while playing.
	 * It also evaluates if the player picks up a power up when moving, or if he finds the briefcase.
	 * @return true if spy moves, false if the move is invalid
	 */
	public boolean spyMove() {
        int playerDirection = ui.getDirection();
        Location currentLoc = new Location(spy.getLocation().getRow(), spy.getLocation().getCol());
        Location futureLoc = new Location(0,0);
        //Check the position to the right of the spy in the grid 
        switch(playerDirection) {
            case 1: futureLoc = new Location(spy.getLocation().getRow(), spy.getLocation().getCol()+1);
                break;
            case 2: futureLoc = new Location(spy.getLocation().getRow(), spy.getLocation().getCol()-1);
                break;
            case 3: futureLoc = new Location(spy.getLocation().getRow()-1, spy.getLocation().getCol());
                break;
            case 4: futureLoc = new Location(spy.getLocation().getRow()+1, spy.getLocation().getCol());
                break;
            default: break;    
        }
        if(grid.isValidMove(currentLoc, futureLoc)) {
        	//if player tries to enter a room
        	if(grid.getGrid()[futureLoc.getRow()][futureLoc.getCol()].isRoom()) {
        		Space room = grid.getGrid()[futureLoc.getRow()][futureLoc.getCol()];
        		if(room.hasBriefcase()) {
        			ui.displayHasBriefcase();
        			gameOver = true;
        		} else {
        			ui.displayHasNoBriefcase();
        		}
        	} else {
           		//Moves the spy, visually and spatially, to the new location.
        		spy.move(playerDirection);
        		grid.movePlayer(currentLoc, futureLoc);
        		//Handles powerup
        		if(grid.getGrid()[futureLoc.getRow()][futureLoc.getCol()].hasPickUp()) {
        			PickUp p = grid.getGrid()[futureLoc.getRow()][futureLoc.getCol()].getPickUp();
        			pickUpPowerUp(p);
        			p.disable();
        		}
        	}
            return true;
        } else {//if player tries to make an invalid move
            ui.displayInvalidMoveError();
            return false;
        }
    }
	
	/**
	 * {@link GameEngine spyShoot()} method is responsible for the spy's shooting mechanic by evaluating the desired direction. If the direction
	 * is valid, spy.hasAmmo() is called and returns a boolean value if the spy has not used his only bullet. spy.shoot is then
	 * called which reduces the ammo counter, then grid.shoot(spy.getLocation(), playerDirection) is executed which determines if
	 * a ninja is present in any of the spaces in the desired location. If a ninja is found, the respective ninja is killed/deactivated
	 * and no longer displayed. Otherwise, Missed Shot message is displayed by the UserInterface.
	 */
	public void spyShoot() {
		int playerDirection = ui.getDirection();
		//Check the position to the right of the spy in the grid 
		if (playerDirection >= 0 && playerDirection <5) {
			
			if(spy.hasAmmo()) {
				spy.shoot();
				Location ninjaLoc;
				ninjaLoc = grid.shoot(spy.getLocation(), playerDirection);
			
				if(ninjaLoc.getCol() != -1 && ninjaLoc.getRow() != -1) {
					for(Ninja n : ninjas) {
						if(n.getLocation().getCol() == ninjaLoc.getCol() && n.getLocation().getRow() == ninjaLoc.getRow()) {
							n.die();
							ui.displayNinjaKilled();
						}
					}
				}
				else {
					ui.displayMissedShot();
				}
			}
			else {
				ui.displayNoAmmo();
			}
		}
	}
	
	/**
	 * {@link GameEngine spyLook()} is a special menu that is responsible for looking two spaces in the desired direction. It displays the
	 * modified grid with the space's visibility enabled, displays the player's statistics. Then ui.displayLookMenu is called
	 * and evaluated. The options left after looking is to move or shoot.
	 */
	public void spyLook() {
		//Makes correct spaces in whatever direction spy looks to visible
		int playerDirection = ui.getDirection();
		grid.look(spy.getLocation(), playerDirection);
		
		//Shows Grid and Stats
		ui.displayGrid(grid.visual());
		ui.displayStats(spy.getLives(), spy.hasBullet(), spy.getTurnsInvincible());
		
		//New Menu after player looks
		boolean doneWithMenu = false;
		while(!doneWithMenu) {
			int lookMenuOption = ui.displayLookMenu();
			switch(lookMenuOption) {
			case 1://Move
				if(spyMove()) {
					resetVisibility();
					moveNinjas();
					doneWithMenu = true;
				}
				break;
			case 2:
				spyShoot();
				doneWithMenu = true;
				break;		
			default:
				System.out.println("Invalid Input. Try Again.");
				break;
			}
		}
			
		
	}
	
	/**
	 * {@link GameEngine resetSpyLocation()} method is called when the Player/Spy is stabbed by a Ninja and still has enough lives to keep
	 * playing. This method returns the spy to the starting point and changes grid visibility according to the spy's new
	 * location. 
	 */
	public void resetSpyLocation() {
		//Return the spy to the starting position on the Grid
		grid.getGrid()[spy.getLocation().getRow()][spy.getLocation().getCol()].setPlayer(false);
		spy.setLocation(new Location(8,0));
		grid.getGrid()[spy.getLocation().getRow()][spy.getLocation().getCol()].setPlayer(true);
	}
	
	
	/**
	 * {@link GameEngine pickUpPowerUp()} evaluates which PowerUp type has been found, then respective functionaity/action is taken.
	 * @param p
	 */
	public void pickUpPowerUp(PickUp p){
		PickUp.PickUpType type = p.getType();
		switch(type) {
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
		ui.displayPickUp(type);
	}
	
	/**
	 * {@link GameEngine resetVisibility()} method is changes the grid's visibility so that no objects are visible other than the spy
	 * and the undiscovered rooms. Functionality is designed to be used during look() function execution.
	 */
	public void resetVisibility() {
		for(Space[] array : grid.getGrid()) {
			for(Space s : array) {
				if(!s.isRoom()) {
					s.setVisible(false);
				}
			}
		}
	}
	
	
	
	/**
	 * {@link GameEngine createEntities()} method is responsible for initializing Ninja[] and PickUp[] objects locations relative to the grid.
	 */
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
	 * {@link GameEngine moveNinjas()} method oops through the ninja array, making each ninja take its turn.
	 * If ninja is adjacent to spy, the ninja stabs the spy and returns the spy to its starting position.
	 * Regardless, the ninja will pick a random direction to move one space in.
	 */
	public void moveNinjas() {
		for(Ninja n : ninjas) {
			if(n.isAlive() && n.getLocation().adjacentTo(spy.getLocation())) {
				//stabs the spy
				if(!spy.isInvincible()) {
					ui.displayStabbed();
					spy.takeDamage();
					if(spy.getLives() <= 0) {
						gameOver = true;
						ui.displayGameOver();
					}
					//moves the spy back to spawn point
					resetSpyLocation();
				}	
			}
			if(n.isAlive()) {
				int direction;
				int nRow = n.getLocation().getRow();
				int nCol = n.getLocation().getCol();
				Location startLoc = n.getLocation();
				Location endLoc = new Location(-1, -1);
			
				do {
					if(!grid.hasValidMove(startLoc)) {
						break;
					}
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
					}
					while(!grid.isValidMove(startLoc, endLoc) || grid.getGrid()[endLoc.getRow()][endLoc.getCol()].isRoom());
				
			
				n.moveTo(endLoc);
				grid.getGrid()[nRow][nCol].setNinja(false);
				grid.getGrid()[endLoc.getRow()][endLoc.getCol()].setNinja(true);	
			}
			
		}
	}
}
