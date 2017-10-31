/**
 * 
 */
package edu.cpp.cs.cs141.sg;

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
 * up all your ammo, gain invisibility, and one that will show you where the briefcase is.
 *
 * Team Not Available
 *  Ryan Guidry, Ethan Balderas, Fadhar Castillo, Zhihang Yao, Daniel Gruhn
 */
public class GameEngine {
	
	/**
	 * Fields
	 */
	Spy spy;
	Ninja[] ninjas;
	PickUp[] pickups;
	Grid grid;
	
	int spyLives = 3;
	
	GameEngine(){
	}
	
	/**
	 * Methods
	 */
	boolean isGameOver(){
		//Returns true if player has no more lives left, false otherwise
	}
	
	boolean isPlayerDead() {
		//Returns true if player's health is zero, false otherwise
	}
	
	int[] getBriefcaseLocation() {
		//Retrieves briefcase location from Grid

	}
	
	int[] getNinjaLocation() {
		//Retrieves ninja location from Grid
		
	}
	
	int[] getSpyLocation() {
		//Retrieves spy location from Grid

	}
	
	int[] setNinjaLocation() {
		//Sets ninja location explicitly to Grid
	}
	
	int[] setSpyLocation() {
		//Sets spy location explicitly to Grid
	}
	
	int[] setBriefcaseLocation() {
		//Sets briefcase location explicitly to Grid

	}
	
	void resetSpyLocation() {
		//Return the spy to the starting position on the Grid

	}
	
	void pickUpPowerUp(){
		//Evaluates which PowerUp type, then respective action taken

	}
	
	void debugMode() {
		//Enables debug mode, lights are turned on in the building
		
	}
	
	

}
