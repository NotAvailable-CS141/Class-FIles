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

    public Space(int x, int y, boolean hasNinja, PickUp pickUp, boolean visible, boolean isPick, boolean room) {
        this.x = x;
        this.y = y;
        this.hasNinja = hasNinja;
        this.pickUp=pickUp;
        this.visible = visible;
        isPickUp = isPick;
        isRoom =room;
    }
    
     public Space(int x, int y, boolean isRoom) {
        this.x = x;
        this.y = y;
        this.hasNinja = false;
       // this.pickUp= null;
        this.visible = false;
        this.isPickUp = false;
        this.isRoom=isRoom;
        hasPlayer = false;
    }
    
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean getNinja() {
       return false;
    }

    public void setNinja() {
        
    }

    public PickUp getPickUp() {
        return null;
    }
    
     public void setPickUp() {
    	
    }

    public boolean getVisible() {
        return false;
    }
    
     public void setVisible() {
        
    }
    
    /**
     * @return
     */
    /**
     * @return
     */
    public String toString(){
        String spaceRepresentation;
        if(!visible)
        	//add debug mode boolean
        {
            spaceRepresentation = "*";
        }
        else  {
        	if(isPickUp) {
        		
        		switch(pickUp.getType()) {
        		case RADAR:
        			spaceRepresentation = "R";
        			break;
        		case AMMO:
        			spaceRepresentation = "B";
        			break;
        		case INVINCIBILITY:
        			spaceRepresentation = "I";
        			break;
        		default: 
        			break;
       	
        	    }		
        	}
        	 if(hasNinja)
             {
                 spaceRepresentation = "N";
             }
          else if(hasPlayer)
             {
                 spaceRepresentation = "P";      
             }
          else
             {
                 spaceRepresentation = " ";
             }
          
        }
        
        if(isRoom) {
            
          	spaceRepresentation = "#";
              //Briefcase room for debug   
          }   	
        
     return "[" + spaceRepresentation + "]";
    }
}
