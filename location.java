/**
 * 
 */
package edu.cpp.cs.cs141.finalProject;


/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Final Project
 *
 * <description-of-assignment>
 *
 * Team Not Available
 *  Ryan Guidry, Ethan Balderas, Fadhar Cartillo, Zhihang Yao, Daniel Gruhn
 */

public class location {

	private int row;
	private int column; 
	
	public location(int x, int y) {
		row=x;
		column=y;
	}
	
	public void setLocation(int x, int y) {
		row =x;
		column=y;
	}
	
	public int[] getLocation() {
		int[]  array = new int[2];
		array[0]=row;
		array[1]=column;
		return array;
	}
	
}
