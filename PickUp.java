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

public class PickUp implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7138136614495246769L;

	Location location;
	
	public static enum PickUpType{AMMO, RADAR, INVINCIBILITY}
	
	private PickUpType type;
	
	/**
	 * Represents whether the pickup has not been touched by the player.
	 * Remains true until the player touches it, to which it then becomes false, and the object despawns.
	 */
	private boolean isActiveOnGrid;
	
	/**
	 * @param p 
	 * 		The type of the pickup
	 * @param loc 
	 * 		An array of length 2 representing the coordinates of the object @see location
	 * @param isActive 
	 * 		@see isActiveOnGrid
	 */
	public PickUp(PickUpType p, int x, int y, boolean isActive) {
		type = p;
		
		location = new Location(x,y);
		
		isActiveOnGrid = isActive;
	}
	
	public PickUpType getType() {return type;}
	public boolean isActive() {return isActiveOnGrid;}
	public void disable() {isActiveOnGrid = false;}
}
