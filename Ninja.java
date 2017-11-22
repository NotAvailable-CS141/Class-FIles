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
	
	private Location location = new Location(0, 0);
	private boolean alive;
	
	public Ninja(int row, int column) {
		location.setLocation(row,column);
		alive = true;
	}
	
	public Location getLocation() {return location;}
	
	/**
	 *  The ninja will move in a random direction after checking to see if 
	 *  the spy is adjacent to it.
	 */
	public void moveTo(Location l) {
		location = l;
	}
	
	public void die() {
		alive = false;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
}
