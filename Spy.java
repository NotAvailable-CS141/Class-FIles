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
 * {@link Spy} is the player's character. The spy is tasked with retrieving a briefcase located in a room.
 */
public class Spy implements Serializable{

	/**
	 * An ID given to Spy to convert from bytes back into an object for saving and loading.
	 */
	private static final long serialVersionUID = 4523575704147940785L;


	/**
	 * The lives of the spy.
	 * Initial value of lives is 3.
	 * 
	 * To return the lives use {@link getLives() }
	 * 
	 */
	private int lives=3;

	/**
	 * Spy starts with a single bullet.
	 * Value is set to true as default.
	 * 
	 * To decrease by one use {@link takeDamage()}
	 * To return the lives use {@link getLives()}
	 * 
	 */
	private boolean hasBullet=true;

	/**
	 * The turns of invincibility left.
	 * To modify invincibility use {@link setInvincible(int i)}
	 * To return the turns of invincibility use {@link getTurnsInvincible()}
	 * To return the status of invincibility use {@link isInvincible()}
	 */
	private int invincibility=0;

	/**
	 * The location of the Spy; stored as a location item. 
	 * To modify the location use {@link setLocation(Location l)} 
	 * To return the location use {@link getLocation() }
	 */
	Location loc = new Location(8,0);

	/**
	 * Returns the location of the the Spy.
	 * 
	 * @return loc
	 */
	public Location getLocation(){
		return loc;}

	/**
	 * Sets the location of the spy to the inputed location.
	 * 
	 * @param l; the new location to be set.
	 */
	public void setLocation(Location l) {
		loc = l;}

	/**
	 * Returns the lives left of a Spy.
	 * 
	 * @return lives
	 */
	public int getLives() {
		return lives;}

	/**
	 * Decreases the Spy's lives by one.
	 */
	public void takeDamage() {
		lives--;}

	/**
	 * Returns the status of invincibility of the Spy
	 * 
	 * @return invincibility boolean
	 */
	public boolean isInvincible() {
		return invincibility > 0;}

	/**
	 * Returns the turns of invincibility
	 * 
	 * @return invincibility
	 */
	public int getTurnsInvincible() {
		return invincibility;}

	/**
	 * Sets the invinibility int.
	 * 
	 * @param i; the value to set invincibility
	 */
	public void setInvincible(int i) {
		invincibility = i;}

	/**
	 * Sets the hasBullet boolean to true. 
	 */
	public void reload() {
		hasBullet = true;}

	/**
	 * Allows the Spy to shoot an enemy.
	 * Checks to see if Spy has a bullet to shoot with.
	 * 
	 * @return the status of hasBullet after shooting
	 */
	public boolean shoot() {
		if(hasBullet) {
			hasBullet = false;
			return true;
		}
		return false;
	}


	/**
	 * The spy moves in the desired direction based on the user input
	 * @param dir; the direction the Spy will move
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
	 * Reduces the spy's number of lives by 1
	 */
	public void die() {
		if (lives > 0) {
			lives--;
		}
	}


	/**
	 * Returns 1 if the Spy has a bullet
	 * Returns 0 if the Spy has no bullet
	 * 
	 * @return 1 or 0
	 * 
	 */
	public int hasBullet() {
		if (hasBullet) {
			return 1;
		}
		else {
			return 0;
		}
	}

	/**
	 * Returns the boolean value of the Spy's bullet.
	 * 
	 * @return hasBullet; the status of the Spy's ammo
	 */
	public boolean hasAmmo() {
		return hasBullet;
	}
}
