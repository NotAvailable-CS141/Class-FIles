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
 * <description-of-assignment>
 *
 * Team Not Available
 *  Ryan Guidry, Ethan Balderas, Fadhar Cartillo, Zhihang Yao, Daniel Gruhn
 */

public class Spy {
	//fields 
	/**
	 * The lives of the spy.
	 * Initial value of 3.
	 * 
	 */
	private int lives=3;
	
	/**
	 * Spy starts with a single bullet.
	 * 
	 */
	private boolean hasBullet=true;
	
	/**
	 * The turns of invincibility left.
	 */
	private int invincibility=0;

	/**
	 * Creates a location object in Spy
	 */
	Location loc = new Location(8,0);
	
	
	/**
	 * Allows the spy to shoot an enemy
	 */
	public boolean shoot(Ninja enemy) {
		if(hasBullet) {
			hasBullet = false;
			
			return true;
		}
		return false;
	}
	
	/**
	 * Lets the spy see 2 squares in every direction
	 */
	public void look() {
		
	}
	
	/**
	 * The spy moves in the desired direction
	 */
	public void move(int dir) {
		if(invincibility>0) {
			invincibility--;
		}
		
		
	}
	
	

}
