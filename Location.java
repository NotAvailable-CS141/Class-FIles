package edu.cpp.cs.cs141.FinalProject;

import java.io.Serializable;

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
 * The {@link Location} is the underlying storage of a row and column that
 *  is used by the {@link Space}, {@link Spy}, {@link Ninja}, {@link PickUp} 
 *  and {@link Grid} to represent an object's location in the Grid. 
 */
public class Location implements Serializable{
	
	/**
	 * An ID given to Location to convert from bytes back into an object for saving and
	 * loading.
	 */
	private static final long serialVersionUID = 6500434308332521738L;
	
	/**
	 * The {@link row} variable stores the row component of an object's location.
	 */
	private int row;
	
	/**
	 * The {@link column} variable stores the column component of an object's location.
	 */
	private int column; 
	
	/**
	 * The Location object's constructor with provided row and column with
	 * @param r and @param c
	 */
	public Location(int r, int c) {
		row = r;
		column = c;
	}
	
	/**
	 * This method copies the location component @param r to {@link row} and 
	 * @param c to {@link column} to this active Location object 
	 */
	public void setLocation(int r, int c) {
		row = r;
		column = c;
	}
	
	/**
	 * This method returns a 2D array of type int, with the {@link row} as the first value,
	 * and the {@link column} as the second value. 
	 * @return
	 */
	public int[] getLocation() {
		int[] array = new int[2];
		array[0] = row;
		array[1] = column;
		return array;
	}
	
	/**
	 * getRow() method returns the integer {@link row} value.
	 * @return row
	 */
	public int getRow() {return row;}
	
	/**
	 * getCol() method returns the integer {@link col} value.
	 * @return col
	 */
	public int getCol() {return column;}
	
	
	/**
	 * Checks whether one location(this) is adjacent to the other(l).
	 * 
	 * @param l the location this is being compared to.
	 * @return whether l is adjacent to this
	 */
	public boolean adjacentTo(Location l) {
		
		// checks if adjacent up down left or right 
		return (Math.abs(getCol() - l.getCol()) == 1 && getRow() == l.getRow()) || 
				(Math.abs(getRow() - l.getRow()) == 1 && getCol() == l.getCol());
	}
}
