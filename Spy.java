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
	 * Allows the spy to shoot an enemy
	 */
	public void shoot() {
		
	}
	
	/**
	 * Lets the spy see 2 squares in every direction
	 */
	public void look() {
		
	}
	
	/**
	 * The spy moves in the desired dirrection.
	 */
	public void move() {
		if(invincibility>0) {
			invincibility--;
		}
		
		
	}
	
	

}
