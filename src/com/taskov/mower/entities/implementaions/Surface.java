package com.taskov.mower.entities.implementaions;

import java.util.HashSet;
import java.util.Set;

import com.taskov.mower.exceptions.ValidationException;
import com.taskov.mower.validators.SurfaceValidator;

/*This class represents the surface on which the mowers will operate. 
 * A coordinate system that is limited horizontally (surfaceMaxHorizontalPositionX)
 * and vertically (surfaceMaxVerticalPositionY). It also contains a set of positions 
 * of all of the mowers on the field.
 * */

public class Surface {

	private Position surfaceMaxCoordinates;
	private Set<Position> mowersPositions;

	public Surface(int surfaceMaxHorizontalPositionX, int surfaceMaxVerticalPositionY) throws ValidationException{
		SurfaceValidator.validateSurfaceCoordinates(surfaceMaxHorizontalPositionX, surfaceMaxVerticalPositionY);
		Position surfaceMaxCoordinates = new Position(surfaceMaxHorizontalPositionX, surfaceMaxVerticalPositionY);
		this.setSurfaceMaxCoordinates(surfaceMaxCoordinates);
		Set<Position> mps = new HashSet<Position>();
		this.setMowersPositions(mps);
	}

	public Set<Position> getMowersPositions() {
		return mowersPositions;
	}

	public void setMowersPositions(Set<Position> mowersPositions) {
		this.mowersPositions = mowersPositions;
	}
	

	public Position getSurfaceMaxCoordinates() {
		return surfaceMaxCoordinates;
	}

	public void setSurfaceMaxCoordinates(Position surfaceMaxCoordinates) {
		this.surfaceMaxCoordinates = surfaceMaxCoordinates;
	}

}
