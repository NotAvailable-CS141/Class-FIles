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

public class Ninja {
	
	
	/**
	 * This will represent the horizontal coordinate of the ninja
	 */
	private int row;
	
	/**
	 * This will represent the vertical coordinate of the ninja
	 */
	private int column;
	
	/**
	 *  The ninja will move in a random direction after checking to see if 
	 *  the spy is adjacent to it.
	 */
	public void move() {
		
	}

	/**
	 * @return the row the ninja is located
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set for the ninja
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the column the ninja is located
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column the column to set for the ninja
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	
}
