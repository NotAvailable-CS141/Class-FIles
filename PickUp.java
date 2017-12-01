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



/**
 *{@link PickUp} class represents the three available items a {@link Spy} can use.
 * It contains radar, invincibility, and ammo. 
 */
public class PickUp implements Serializable{

	/**
	 * An ID given to PickUp to convert from bytes back into an object for saving and
	 * loading.
	 */
	private static final long serialVersionUID = -7138136614495246769L;

	/**
	 * The location of the PowerUp; stored as a location item. 
	 * PickUp locations do not change. 
	 * 
	 */
	Location location;


	/**
	 * An enum that differentiates between what type of PickUp the pick up is.
	 *
	 */
	public static enum PickUpType{AMMO, RADAR, INVINCIBILITY}

	/**
	 * The type the PickUp is. 
	 * To return the type of PickUp use {@link getType()}
	 */
	private PickUpType type;

	/**
	 * Represents whether the pickup has not been touched by the player.
	 * Remains true until the player touches it, to which it then becomes false, and the object despawns.
	 * To return the status use {@link isActive()}
	 * To set to false use {@link disable()}
	 * 
	 */
	private boolean isActiveOnGrid;

	/**
	 * @param p 
	 * 		The type of the pickup
	 * @param x
	 * 		The first coordinate of the location
	 * @param y
	 * 		The second coordinate of the location
	 * @param isActive 
	 * 		The state of the PowerUp on the grid.
	 */
	public PickUp(PickUpType p, int x, int y, boolean isActive) {
		type = p;

		location = new Location(x,y);

		isActiveOnGrid = isActive;
	}

	/**
	 * Returns the type of the PickUp
	 * 
	 * @return type; the type of PickUp
	 */
	public PickUpType getType() {
		return type;}

	/**
	 * Returns the current status of the PickUp on the grid.
	 * 
	 * @return isActiveOnGrid; the status of the PickUp on the grid.
	 */
	public boolean isActive() {
		return isActiveOnGrid;}

	/**
	 * Sets isActiveOnGrid to false; the item is no longer active.
	 */
	public void disable() {
		isActiveOnGrid = false;}
}
