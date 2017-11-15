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
	
	public Location getLocation(){ return loc;}
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
		switch(dir) {
		case 1:	
			loc.setLocation(loc.getRow(), loc.getCol() + 1);
			break;
		case 2:
			loc.setLocation(loc.getRow(), loc.getCol() - 1);
			break;
		case 3:
			loc.setLocation(loc.getRow() - 1 , loc.getCol());
			break;
		case 4:
			loc.setLocation(loc.getRow() + 1, loc.getCol());
			break;
		}
	}
	
	/**
	 * Reduces the spy's number of lives 
	 */
	public void die() {
		if (lives > 0) {
			lives--;
		}
	}
	
	/**
	 * 
	 * @return Spy's number of lives left
	 */
	public int getLives() {
		return lives;
	}
	
	public int hasBullet() {
		if (hasBullet) {
			return 1;
		}
		else {
			return 0;
		}
	}
	

}
