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

import edu.cpp.cs.cs141.FinalProject.PickUp.PickUpType;

public class Space {

    private int x;
    private int y;
    private boolean hasPlayer;
    private boolean hasNinja;
    private boolean visible;
    private PickUp pickUp;
    private boolean isPickUp;
    private boolean isRoom;
    private boolean debug;
    private boolean hasRadar;

    private boolean hasBriefcase;
    
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
     
     public void setRadar(boolean a) {
    	 hasRadar = a;
     }
     
     public void setBriefcase(boolean a) {
    	 hasBriefcase = a;
     }
     
     public boolean hasBriefcase() {
    	 return hasBriefcase;
     }
     
     public void makePickUp(int x, int y, PickUpType a) {
    	 isPickUp = true;
         pickUp = new PickUp(a,x,y,true);
     }
     
     public void setPlayer(boolean a) {
    	 hasPlayer = a;
     }
     
    public boolean hasPlayer() {
    	if(hasPlayer) {
    		return true;
    	}
    	return false;
    }
    
    public boolean isRoom() {
    	if(isRoom) {
    		return true;
    	}
    	return false;
    }
    
    public boolean hasPickUp() {
    	if(isPickUp) {
    		return true;
    	}
    	return false;
    }
    
    public PickUp getPickUp() {
    	return pickUp;
    }

    public boolean hasNinja() {
    	if(hasNinja) {
    		return true;
    	}
    	return false;
    }

    public void setNinja(boolean a) {
    	hasNinja = a;
    }
    
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

	public void setVisible(boolean b) {
		visible = b;
		
	}

	public void setDebug(boolean b) {
		debug = b;
		
	}
}