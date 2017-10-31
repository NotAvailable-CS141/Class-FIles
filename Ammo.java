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
 * This class represents the ammo powerup. 
 * When picked up, it reloads the spy's gun.
 * Picking this up while at full ammo will not give any additional ammo.
 * 
 * @author Zhihang Yao(Evan)
 */
public class Ammo extends PickUp {
	
	public Ammo(int[] loc, boolean isActive) {
		super(loc, isActive);
	}
	
	/**
	 * Replenishes the ammo of the spy.
	 * If the spy already has full ammo, does nothing.
	 * 
	 * @see edu.cpp.cs.cs141.finalAssignment.PickUp#useAbility()
	 */
	@Override
	public void useAbility() {
		
	}

}
