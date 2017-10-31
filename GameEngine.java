/**
 * 
 */
package edu.cpp.cs.cs141.sg;

/**
 * @author thedr_000
 *
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
