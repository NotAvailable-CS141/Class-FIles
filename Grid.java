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
package edu.cpp.cs.cs141.FinalProject;

import java.io.Serializable;

import edu.cpp.cs.cs141.FinalProject.PickUp.PickUpType;

public class Grid implements Serializable{

	
/**
	 * 
	 */
	private static final long serialVersionUID = 5904995247957030234L;
private Space[][] grid;
private boolean debug;
	
//private boolean fogOfWar;

	/**
	 * creates a grid of strings that represent different units
	 * @param String
	 */
	
	public Grid()
	{
		debug = false;
		grid = new Space[9][9];
		for(int i =0; i<9; i++)
		{
			for(int j =0; j<9; j++)
			{
				if(((i+2)%3==0) && ((j+2)%3==0)) 
				{
					grid[i][j] = new Space(i,j,true);
					grid[i][j].setVisible(true);
				}
				else {
					grid[i][j] = new Space(i,j, false);
				}
			}	
		}
		placeEverything();
	}
		
	public void placeEverything()
	{
		grid[8][0].setPlayer(true);
		placePickUps();
		placeNinjas();	
		placeBriefcase();
	}
	
	public void look(Location loc, int direction) {
		if (!debug) {
			switch(direction) {
			case 1://right
				if(loc.getCol()+1 < 9) {
					grid[loc.getRow()][loc.getCol()+1].setVisible(true);
				}
				if(loc.getCol()+2 < 9 && !grid[loc.getRow()][loc.getCol()+1].isRoom()) {
					grid[loc.getRow()][loc.getCol()+2].setVisible(true);
				}
				break;
			case 2://left
				if(loc.getCol()-1 > -1) {
					grid[loc.getRow()][loc.getCol()-1].setVisible(true);
				}
				if(loc.getCol()-2 > -1 && !grid[loc.getRow()][loc.getCol()-1].isRoom()) {
					grid[loc.getRow()][loc.getCol()-2].setVisible(true);
				}
				break;
			case 3://up 
				if(loc.getRow()-1 > -1) {
					grid[loc.getRow()-1][loc.getCol()].setVisible(true);
				}
				if(loc.getRow()-2 > -1 && !grid[loc.getRow()-1][loc.getCol()].isRoom()) {
					grid[loc.getRow()-2][loc.getCol()].setVisible(true);
				}
				break;
			case 4://down
				if(loc.getRow()+1 < 9) {
					grid[loc.getRow()+1][loc.getCol()].setVisible(true);
				}
				if(loc.getRow()+2 < 9 && !grid[loc.getRow()+1][loc.getCol()].isRoom()) {
					grid[loc.getRow()+2][loc.getCol()].setVisible(true);
				}
				break;
			}
		}
	}
	
	public void movePlayer(Location oldLoc, Location newLoc) {
		//Set the old location of the player to false, meaning that he is no longer in that space
		grid[oldLoc.getRow()][oldLoc.getCol()].setPlayer(false);
		//Set new location of the player to true
		grid[newLoc.getRow()][newLoc.getCol()].setPlayer(true);
	}
	
	public void placeBriefcase() {
		boolean hasPlacedBriefCase = false;
		do {
			int xPos = (int)(Math.random() * 9);
			int yPos = (int)(Math.random() * 9);
			if(grid[xPos][yPos].isRoom()) {
				grid[xPos][yPos].setBriefcase(true);
				hasPlacedBriefCase = true;
			}
		}while(!hasPlacedBriefCase);
		
	}
	
	public void placePickUps() {
		int numberOfPowerUps = 3;
		do{
			int xPos = (int)(Math.random() * 9);
			int yPos = (int)(Math.random() * 9);		
			if(grid[xPos][yPos].isRoom() || grid[xPos][yPos].hasPlayer() || grid[xPos][yPos].hasPickUp()){	
			}else
				{
					if(numberOfPowerUps == 3)
						grid[xPos][yPos].makePickUp(xPos,yPos, PickUpType.RADAR);
					if(numberOfPowerUps == 2)
						grid[xPos][yPos].makePickUp(xPos,yPos, PickUpType.AMMO);
					if(numberOfPowerUps == 1)
						grid[xPos][yPos].makePickUp(xPos,yPos, PickUpType.INVINCIBILITY);
					numberOfPowerUps--;
				}
		  }
		  while(numberOfPowerUps > 0);
	}
	
	public void placeNinjas() {
		int numberOfNinjas = 6;
		do{
			int xPos = (int)(Math.random() * 9);
			int yPos = (int)(Math.random() * 9);
			
			if(grid[xPos][yPos].isRoom() || grid[xPos][yPos].hasPlayer() || grid[xPos][yPos].hasNinja() || (xPos > 5 && yPos < 3)){
			}
				else
				{
					grid[xPos][yPos].setNinja(true);
					numberOfNinjas--;
				}
		  }
		  while(numberOfNinjas > 0);
	}
	
	/**
	 * show some nice ascii art for a map
	 */
	public String boardStateToString()
	{
		return "";
	}
	
	/** 
	 * sets the visibility of all spaces on the grid to true
	 */
	public void debug()
	{
		debug = true;
		for(int i =0; i<9; i++){
			
			for(int j =0; j<9; j++)
			{
				grid[i][j].setVisible(true);
				grid[i][j].setDebug(true);
			}	
		}
		visual();
	}
	
	public String visual() {
		String board = "";
		for(int i =0; i<9; i++){
		
			for(int j =0; j<9; j++)
			{
				board += grid[i][j].toString();
			}	
			board+= "\n";
		}
		return board;
	}
	
	public Space[][] getGrid() {
		return grid;
	}
	
	public boolean isValidMove(Location start, Location end) {
		if(grid[start.getRow()][start.getCol()].isRoom()) {
			if(end.getCol() != start.getCol() || end.getRow()+1 != start.getRow()) {
				return false;
			}
		}
		
		if (end.getRow() > 8 || end.getCol() > 8 || end.getRow() < 0 || end.getCol() < 0) {
			return false;
		}
		
		if(grid[end.getRow()][end.getCol()].isRoom()) {
			if(start.getRow()+1 != end.getRow() || start.getCol() != end.getCol()) {
				return false;
			}	
		}
		
		if(grid[end.getRow()][end.getCol()].hasNinja()) {
			return false;
		}
		
		if(grid[end.getRow()][end.getCol()].hasPlayer()) {
            return false;
        }
		return true;
	}
	
	public boolean hasValidMove(Location start) {
		int nRow = start.getRow();
		int nCol = start.getCol();
		//up
		if(isValidMove(start, new Location(nRow-1, nCol))) {
			return true;
		}
		//right
		if(isValidMove(start, new Location(nRow, nCol+1))) {
			return true;
		}
		//down
		if(isValidMove(start, new Location(nRow+1, nCol))) {
			return true;
		}
		//left
		if(isValidMove(start, new Location(nRow, nCol-1))) {
			return true;
		}
		return false;
	}
	/**
	 * This shoot method is responsible for killing/disabling ninjas within the grid 
	 * @param location indicates the location of the spy and is used to determine row or column to begin ninja checking
	 * @param playerDirection indicates the direction that the spy wants to shoot, 1 = right, 2 = left, 3 = up, 4 = down
	 */
	public Location shoot(Location location, int playerDirection) {
		//Check that location is not out of bounds
		Location ninjaLoc;
		if (location.getCol() >= 0 && location.getCol() < 9 && location.getRow() >= 0 && location.getRow() < 9) {
			//Determine what direction to shoot
			switch(playerDirection) {
			case 1:
				//Cycle spaces to the right
				for(int i = location.getCol(); i < 9; i++) {
					//If the bullet hits a room, return control
					if (grid[location.getRow()][i].isRoom()) {
						return (ninjaLoc = new Location(-1,-1));
					}
					//Otherwise if it is a ninja, kill it and return control to avoid collateral
					else if(grid[location.getRow()][i].hasNinja()) {
						grid[location.getRow()][i].setNinja(false);
						ninjaLoc = new Location(location.getRow(),i);
						return (ninjaLoc);
					}
				}
				break;
			case 2: 
				//Cycle spaces to the left
				for(int i = location.getCol(); i >= 0; i--) {
					//If the bullet hits a room, return control
					if (grid[location.getRow()][i].isRoom()) {
						return (ninjaLoc = new Location(-1,-1));
					}
					//Otherwise if it is a ninja, kill it and return control to avoid collateral
					else if(grid[location.getRow()][i].hasNinja()) {
						grid[location.getRow()][i].setNinja(false);
						ninjaLoc = new Location(location.getRow(),i);
						return (ninjaLoc);
					}
				}
				break;
			case 3:
				//Cycle spaces above
				for(int i = location.getRow();  i >= 0; i--) {
					//If the bullet hits a room, return control
					if (grid[i][location.getCol()].isRoom()) {
						return (ninjaLoc = new Location(-1,-1));
					}
					//Otherwise if it is a ninja, kill it and return control to avoid collateral
					else if(grid[i][location.getCol()].hasNinja()) {
						grid[i][location.getCol()].setNinja(false);
						ninjaLoc = new Location(i,location.getCol());
						return (ninjaLoc);
					}
				}
				break;
			case 4: 
				//Cycle spaces below
				for(int i = location.getRow();  i < 9; i++) {
					//If the bullet hits a room, return control
					if (grid[i][location.getCol()].isRoom()) {
						return (ninjaLoc = new Location(-1,-1));
					}
					//Otherwise if it is a ninja, kill it and return control to avoid collateral
					else if(grid[i][location.getCol()].hasNinja()) {
						grid[i][location.getCol()].setNinja(false);
						ninjaLoc = new Location(i,location.getCol());
						return (ninjaLoc);
					}
				}
				break;
			}
		}
		return (ninjaLoc = new Location(-1,-1));
	}
}