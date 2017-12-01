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
 * {@link Ninja} Class represents the enemies in the game. They patrol the grid and try to kill the Spy.
 */
public class Ninja implements Serializable {

	/**
	 * An ID given to Ninja to convert from bytes back into an object for saving and
	 * loading.
	 */
	private static final long serialVersionUID = 8549242193453135971L;

	/**
	 * The location of the Ninja; stored as a location item. To modify the location
	 * use {@link moveTo(Location l)} To return the location use
	 * {@link getLocation()}
	 */
	private Location location = new Location(0, 0);

	/**
	 * The current state of a Ninja 
	 * To modify the Ninja to not alive use {@link die()};
	 * {@link die()} To return the status of the Ninja use {@link isAlive()}
	 */
	private boolean alive;

	/**
	 * The default constructor for Ninja The Ninja is set to alive when constructed
	 * 
	 * @param row;
	 *            the row location in the array.
	 * @param column;
	 *            the column location in the array.
	 */
	public Ninja(int row, int column) {
		location.setLocation(row, column);
		alive = true;
	}

	/**
	 * Returns the location of the Ninja
	 * 
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * The Ninja will move in a random direction after checking to see if the spy is
	 * adjacent to it. The ninja's location is set to the Location inputed
	 * 
	 * @param l; the loaction to move to
	 */
	public void moveTo(Location l) {
		location = l;
	}

	/**
	 * Sets the ninja's alive status to false
	 */
	public void die() {
		alive = false;
	}

	/**
	 * Returns the current status of the Ninja
	 * 
	 * @return isAlive();
	 */
	public boolean isAlive() {
		return alive;
	}

}
