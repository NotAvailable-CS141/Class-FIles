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
package edu.cpp.cs.cs141.FinalProject;

public class GameEngine {
	
	/**
	 * Fields
	 */
	private Spy spy;
	private Ninja[] ninjas;
	private PickUp[] pickups;
	private Grid grid= new Grid();
	
	int spyLives = 3;
	
	GameEngine(){
	}
	
	/**
	 * Methods
	 */
	public boolean isGameOver(){
		//Returns true if player has no more lives left, false otherwise
	}
	
	public boolean isPlayerDead() {
		//Returns true if player's health is zero, false otherwise
	}
	
	public void resetSpyLocation() {
		//Return the spy to the starting position on the Grid

	}
	
	public void pickUpPowerUp(){
		//Evaluates which PowerUp type, then respective action taken

	}
	
	public void debugMode() {
		//Enables debug mode, lights are turned on in the building
		
	}

	/**
	 * @return the grid
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	

}
