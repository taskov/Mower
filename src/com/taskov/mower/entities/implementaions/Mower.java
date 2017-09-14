package com.taskov.mower.entities.implementaions;

import java.util.Arrays;

import com.taskov.mower.entities.ifc.MowerIfc;
import com.taskov.mower.exceptions.ValidationException;
import com.taskov.mower.validators.MowerValidator;
import com.taskov.mower.validators.SurfaceValidator;

/*
 * This class represents a mower. It has:
 * 1) mower position (x,y)
 * 2) mower orientation (E, W, N or S)
 * 3) list of directions for that mower
 * 4) moveAhead,  rotate, move, canMove, needRotation, shouldMove methods documented below 
 */

public class Mower implements MowerIfc{

	public Mower(Position mowerPosition, char mowerOrientation, char[] directions) throws ValidationException{
		MowerValidator.validateOrientation(mowerOrientation);
		MowerValidator.validateDirections(directions);
		this.mowerPosition = mowerPosition;
		this.mowerOrientation = mowerOrientation;
		this.directions = directions;
	}
	
	private Position mowerPosition;
	private char mowerOrientation;
	private char[] directions;
	
	public Position getMowerPosition() {
		return mowerPosition;
	}
	public void setMowerPosition(Position mowerPosition) {
		this.mowerPosition = mowerPosition;
	}
	public char getMowerOrientation() {
		return mowerOrientation;
	}
	public void setMowerOrientation(char mowerOrientation) {
		this.mowerOrientation = mowerOrientation;
	}

	public char[] getDirections() {
		return directions;
	}

	public void setDirections(char[] directions) {
		this.directions = directions;
	}
	
	/*
	 * This method is responsible for moving the mower one square further in the designated direction. 
	 */
	
	private void moveAhead(Surface surface){
		char currentOrientation = this.mowerOrientation;
		boolean canMove = canMove(surface, currentOrientation);
		if(canMove){
			int horizontalPositionX = this.mowerPosition.getHorizontalPositionX();
			int verticalPositionY = this.mowerPosition.getVerticalPositionY();

			switch(currentOrientation){
			case 'N':
				verticalPositionY += 1;
				System.out.println("Moving north");
				break;
			case 'S':
				verticalPositionY -= 1;
				System.out.println("Moving south");
				break;
			case 'E':
				horizontalPositionX += 1;
				System.out.println("Moving east");
				break;
			case 'W':
				horizontalPositionX -= 1;
				System.out.println("Moving west");
				break;
			}
			
			Position mp = new Position(horizontalPositionX, verticalPositionY);
			this.setMowerPosition(mp);
		}
		if(!canMove){
			System.out.println("Can't move to direction: " + currentOrientation);
		}
	}
	
	/*
	 *This method is responsible for the mower's rotation. The logic is the following:
	 *All of the possible rotations are combined within a single String in a way that:
	 * - if you are turning left you should switch to the previous direction
	 * - if you are turning right you should switch to the next direction    
	 */
	
	private void rotate(char direction){
		if(needRotation(direction)){
			String orientations = "WNES";
			int indexOfCurrentOrientation = orientations.indexOf(this.mowerOrientation);
			int indexOfNewOrientation = direction == 'G' ? indexOfCurrentOrientation - 1 : indexOfCurrentOrientation + 1;
			this.mowerOrientation = orientations.charAt((indexOfNewOrientation + orientations.length()) % orientations.length());
			System.out.println("Just rotated to: " + this.mowerOrientation);
		}
	}

	/*
	 *This method checks if the mower needs to be rotated. 
	 *Basically the only instruction that does not require rotation is A so that is the only thing that the code is checking.
	 */
	private boolean needRotation(char direction){
		return direction != 'A';
	}
	
	/*
	 * This method verifies if the mower can move forward.
	 * It checks:
	 *  1) if the move is limited by the size of the surface.
	 *  2) if the move is limited by another mower that is currently parked there. 
	 */
	
	private boolean canMove(Surface surface, char mowerOrientation){
		boolean surfaceLimitations = false;
		boolean otherMowers = false;
		
		int verticalPositionY = this.mowerPosition.getVerticalPositionY();
		int horizontalPositionX = this.mowerPosition.getHorizontalPositionX();
		
		switch(mowerOrientation){
			case 'N':
				surfaceLimitations = verticalPositionY < surface.getSurfaceMaxCoordinates().getVerticalPositionY();
				verticalPositionY += 1;
				break;
			case 'S':
				surfaceLimitations = verticalPositionY > 0;
				verticalPositionY -= 1;
				break;
			case 'E':
				surfaceLimitations = horizontalPositionX < surface.getSurfaceMaxCoordinates().getHorizontalPositionX();
				horizontalPositionX += 1;
				break;
			case 'W':
				surfaceLimitations = horizontalPositionX > 0;
				horizontalPositionX -= 1;
				break;
		}
		
		Position mp = new Position(horizontalPositionX, verticalPositionY);
		otherMowers = surface.getMowersPositions().contains(mp);
		
		return surfaceLimitations && !otherMowers;
		
	}
	
	@Override
	public void move(Surface surface) throws ValidationException{
		SurfaceValidator.validateMowerCoordinatesWithRegardsToTheSurface(surface, this);
		char[] directions = this.getDirections();
		for(int i = 0; i < directions.length; i++){
			rotate(directions[i]);
			if(shouldMove(directions[i])){
				moveAhead(surface);
			}
		}
		surface.getMowersPositions().add(this.getMowerPosition());
	}
	
	/*
	 *This method checks if the mower needs to be moved. 
	 *Basically the only instruction that does require a move is A so that is the only thing that the code is checking.
	 */
	private boolean shouldMove(char direction){
		return direction == 'A';
	}
	
	@Override
	public String toString(){
		return "\nMower position X: " + getMowerPosition().getHorizontalPositionX() + "\nMower position Y: " + getMowerPosition().getVerticalPositionY() + "\nCurrent orientation: " + getMowerOrientation()  + "\nDirection: " + Arrays.toString(getDirections()) + "\n";
	}
	
	
}
