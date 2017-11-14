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
 * up all your ammo, gain invincibility, and one that will show you where the briefcase is.
 *
 * Team Not Available
 *  Ryan Guidry, Ethan Balderas, Fadhar Castillo, Zhihang Yao, Daniel Gruhn
 */

public class Location {

	private int row;
	private int column; 
	
	public Location(int x, int y) {
		row = x;
		column = y;
	}
	
	public void setLocation(int x, int y) {
		row = x;
		column = y;
	}
	
	public int[] getLocation() {
		int[] array = new int[2];
		array[0] = row;
		array[1] = column;
		return array;
	}
	
	public int getRow() {return row;}
	public int getCol() {return column;}
	
	
	/**
	 * Checks whether one location(this) is adjacent to the other(l).
	 * 
	 * @param l the location this is being compared to.
	 * @return whether l is adjacent to this
	 */
	public boolean adjacentTo(Location l) {
		return Math.abs(getCol() - l.getCol()) == 1 && Math.abs(getRow() - l.getRow()) == 1;
	}
}
