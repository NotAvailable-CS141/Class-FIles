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

import java.util.Scanner;

public class UserInterface {
	
	private GameEngine engine = new GameEngine();
	private Scanner scan = new Scanner(System.in);
	
	
	public void displayMainMenu() {
		//Displays game menu at the start of the game
	}
	public void displayHelp() {
		//Displays game rules
	}
	public void displayGrid() {
		//Displays game grid with all assets
		
		System.out.println(engine.getGrid().visual());		
		
	}
	public void displayStats() {
		//Displays the statistics of the game such as lives left
	}
	public void displayWin() {
		//Displays winning message if player retrieves briefcase
	}
	public void displayGameOver() {
		//Displays game over message if player dies 3 times
	}
	public void saveGame() {
		//saves the game to file
	}
	public void loadGameSave() {
		//loads game save from file
	}
	public void start() {
		// TODO Auto-generated method stub
		displayGrid();
		
		
	}

}
