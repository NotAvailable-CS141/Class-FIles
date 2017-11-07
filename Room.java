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

 
public class Room extends Space{

	private boolean hasBriefcase;
	
	private boolean fogOfWar;
	
	/**
	 * creates 9 rooms that the player cannot see the contents of
	 * one of them has a briefcase in it
	 * @param hasBriefcase
	 * @param fogOfWar
	 */
	public Room(int x, int y, boolean hasBriefcase)
	{
		super(x,y, true);
		this.hasBriefcase=hasBriefcase;
	}
	
	/**
	 * if the player enters the room with the briefcase returns true so the 
	 * ui can tell the player they won
	 * @return
	 */
	public boolean checkBriefcase()
	{
		return false;
	}
	
	/**
	 * sets the contents of a room to visible for if a player checks a room or the radar is located
	 */
	public void setVisible()
	{
	
	}
	
	
}
