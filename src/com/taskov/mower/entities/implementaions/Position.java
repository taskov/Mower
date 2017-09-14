package com.taskov.mower.entities.implementaions;

/*A wrapper class for X and Y coordinates for each mower and surface*/

public class Position {
	
	private int horizontalPositionX;
	private int verticalPositionY;
	
	public Position(int mowerHorizontalPositionX, int mowerVerticalPositionY){
		this.horizontalPositionX = mowerHorizontalPositionX;
		this.verticalPositionY = mowerVerticalPositionY;
	}
	
	public int getHorizontalPositionX() {
		return horizontalPositionX;
	}
	public void setHorizontalPositionX(int horizontalPositionX) {
		this.horizontalPositionX = horizontalPositionX;
	}
	public int getVerticalPositionY() {
		return verticalPositionY;
	}
	public void setMowerVerticalPositionY(int verticalPositionY) {
		this.verticalPositionY = verticalPositionY;
	}

	@Override
    public boolean equals(Object o) {
		if (o == this){
			return true;
		}
		
		if(!(o instanceof Position)){
			return false;
		}
		
		Position mp = (Position) o;
		return getHorizontalPositionX() == mp.getHorizontalPositionX() && getVerticalPositionY() == mp.getVerticalPositionY();
	}
	
	@Override
	public int hashCode() {
	      return getHorizontalPositionX() + getVerticalPositionY();
	}
	
	@Override
	public String toString(){
		return this.horizontalPositionX + " " + this.verticalPositionY;
	}
	
}
