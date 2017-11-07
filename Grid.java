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

import java.lang.reflect.Array;

public class Grid {

private Space[][] grid;
	
private boolean fogOfWar;

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
					grid[i][j] = new Room(i,j,false);
					//fill one of the rooms with a brief case
				}
				else {
					grid[i][j] = new Space(i,j, false);
					grid[i][j].setPickUp();
					//Fill empty spaces randomly with drops
					//Fill empty spaces with ninjas
					//Fill the bottom left [8][0] with spy 
				}
				
		}	
		}
	}
	
	/**
	 * checks to see if there are and other units in the room to trigger an event
	 */
	
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
}
