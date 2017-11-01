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

public class Space {

    private int x;
    private int y;
    private boolean hasNinja;
    private boolean visible;
    private pickUp pickUp;

    public Space(int x, int y, Piece piece, Ninja ninja, pickUp pickUp, boolean visible) {
        this.x = x;
        this.y = y;
        this.ninja = ninja;
        this.pickUp=pickUp;
        this.visible = visible;
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

    public pickUp; getPickUp() {
        return null;
    }
    
     public void setPickUp() {
        
    }

    public boolean getVisible() {
        return false;
    }
    
     public void setVisible() {
        
    }
}
