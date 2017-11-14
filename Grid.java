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

import edu.cpp.cs.cs141.FinalProject.PickUp.PickUpType;

public class Grid {

private Space[][] grid;
	
//private boolean fogOfWar;

	/**
	 * creates a grid of strings that represent different units
	 * @param String
	 */
	
	public Grid()
	{
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
		for(int i =0; i<9; i++){
			
			for(int j =0; j<9; j++)
			{
				grid[i][j].setVisible(true);
			}	
		}
		visual();
	}
	
	public String visual()
	{
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
		if (end.getRow() > 8 || end.getCol() > 8 || end.getRow() < 0 || end.getCol() < 0) {
			return false;
		}
		
		if(grid[end.getRow()][end.getCol()].isRoom()) {
			if(start.getRow()+1 != end.getRow() || start.getCol() != end.getCol()) {
				return true;
			}	
		}
		
		if(grid[end.getRow()][end.getCol()].hasNinja()) {
			return false;
		}	
		
		return true;
	}
}
