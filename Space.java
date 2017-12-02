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
import edu.cpp.cs.cs141.FinalProject.PickUp.PickUpType;

/**
 * {@link Space} Class are all of the parts that a grid encompasses. It keeps track using its fields what is on its space. 
 * Other than keeping track of what is present, it also has a method that will allow the display of a symbol that represents
 * what is on the space.
 */
public class Space implements Serializable{

	private static final long serialVersionUID = 4750266959645292953L;
	
	
	/**
	 * Fields
	 */
	private int x; //Row of the Space
    private int y; //Column of the Space
    private boolean hasPlayer; //field used to indicate if a player is on the space
    private boolean hasNinja; //field used to indicate if a ninja is on the space
    private boolean visible; //field used to indicate if a space is visible
    private PickUp pickUp; //field used to represent a pick up on the space
    private boolean isPickUp; //field used to indicate if a pickup is on the space
    private boolean isRoom; //field used to indicate if a space is a room
    private boolean debug; //field used to indicate if a space is in debug mode
    private boolean hasRadar; //field used to indicate if a radar has been activated
    private boolean hasBriefcase; //field used to indicate if a space has the briefcase
    
     public Space(int x, int y, boolean isRoom) {
        this.x = x;
        this.y = y;
        this.hasNinja = false;
        this.visible = false;
        this.isPickUp = false;
        this.isRoom = isRoom;
        hasPlayer = false;
        hasBriefcase = false;
        debug=false;
        hasRadar = false;
    }
    
    /**
     * Method that sets if the space has a radar to whatever the input is  
     * 
     * @param a
     */
    public void setRadar(boolean a) {
    	 hasRadar = a;
     }
     
    /**
     * Sets the condition if a briefcase is on the space
     * @param a
     */
    public void setBriefcase(boolean a) {
    	 hasBriefcase = a;
    }
     
    /**
     * @return if the space has the briefcase
     */
    public boolean hasBriefcase() {
    	return hasBriefcase;
    }
     
    /**
     * Makes a pickup on the space
     * @param x //x coordinate
     * @param y //y coordinate
     * @param a //type of pick up
     */
    public void makePickUp(int x, int y, PickUpType a) {
    	 isPickUp = true;
         pickUp = new PickUp(a,x,y,true);
    }
     
    /**
     * Sets if space has player using the input
     * @param a
     */
    public void setPlayer(boolean a) {
    	 hasPlayer = a;
    }
     
    /**
     * @return if the space has a player
     */
    public boolean hasPlayer() {
    	if(hasPlayer) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * @return if the space is a room
     */
    public boolean isRoom() {
    	if(isRoom) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * @return if the space has a pickup
     */
    public boolean hasPickUp() {
    	if(isPickUp) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * @return the pick up on the space
     */
    public PickUp getPickUp() {
    	return pickUp;
    }

    /**
     * @return if the space has a ninja
     */
    public boolean hasNinja() {
    	if(hasNinja) {
    		return true;
    	}
    	return false;
    }

    /**
     * sets if there is a ninja on space based on input
     * @param a
     */
    public void setNinja(boolean a) {
    	hasNinja = a;
    }
    
    /**
     * @override
     * 
     * This method overrides the toString() method in {@link String} class. 
     * This method will return a certain symbol to the {@link Grid} class depending on the
     * values of the fields of the Space.
     */
    public String toString(){
         String spaceRepresentation="";
         if(!visible) //automatically in debug for checkpoint
         {
             spaceRepresentation = "*";
             if(hasPlayer){
                 spaceRepresentation = "S";
             }
         }
         else  {
        	 spaceRepresentation = "-";
              if(isPickUp) {
            	  if(pickUp.isActive()) {
            		  switch(pickUp.getType()) {
		                  case RADAR:
		                      spaceRepresentation = "R";
		                      break;
		                  case AMMO:
		                      spaceRepresentation = "A";
		                      break;
		                  case INVINCIBILITY:
		                      spaceRepresentation = "I";
		                      break;
	                  }
            	  }
              }
              if(hasNinja){
                  spaceRepresentation = "N";
              }
              if(isRoom) {
            	  spaceRepresentation = "#";
              }
              if(hasBriefcase && (debug || hasRadar)) {
            	  spaceRepresentation = "B"; 
              }
              if(hasPlayer){
                  spaceRepresentation = "S";
              }
           }        	 
         if(spaceRepresentation.equals("")) {
             spaceRepresentation = " ";
         }
         return "[" + spaceRepresentation + "]";
     }

	/**
	 * Sets the visibility of the space
	 * @param b
	 */
	public void setVisible(boolean b) {
		visible = b;
		
	}

	/**
	 * Sets the value of debug for the space
	 * @param b
	 */
	public void setDebug(boolean b) {
		debug = b;
		
	}
}