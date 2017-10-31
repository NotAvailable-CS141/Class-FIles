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
package edu.cpp.cs.cs141.finalAssignment;

/**
 * Represents the parent class of the pickups in the game:
 * Radar, Ammo, and Invincibility
 * 
 * @author Zhihang Yao(Evan)
 */
public abstract class PickUp {
	/**
	 * The location of the item, represented by an array of length 2. 
	 * First number represents what array it is in the grid, second 
	 */
	private int[] location;
	
	/**
	 * Represents whether the pickup has not been touched by the player.
	 * Remains true until the player touches it, to which it then becomes false, and the object despawns.
	 */
	private boolean isActiveOnGrid;
	
	public PickUp() {
		location = new int[2];
		isActiveOnGrid = false;
	}
	
	/**
	 * @param loc 
	 * 		An array of length 2 representing the coordinates of the object @see location
	 * @param isActive 
	 * 		@see isActiveOnGrid
	 */
	public PickUp(int[] loc, boolean isActive) {
		location = new int[2];
		location[0] = loc[0];
		location[1] = loc[1];
		
		isActiveOnGrid = isActive;
	}
	
	public int[] getLocation() {return location;}
	public boolean isActive() {return isActiveOnGrid;}
	public void disable() {isActiveOnGrid = false;}
	
	/**
	 * Apply whatever the pickup's ability is to the player.
	 * 
	 * Ammo: refills the spy's single bullet but does not give him an extra bullet if he already has one.
	 * Radar: displays the location of the briefcase.
	 * Invincibility: protects the spy from being stabbed by ninjas for five turns.
	 */
	public abstract void useAbility(); 
}
