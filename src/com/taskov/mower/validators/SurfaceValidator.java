package com.taskov.mower.validators;

import com.taskov.mower.entities.implementaions.Mower;
import com.taskov.mower.entities.implementaions.Surface;
import com.taskov.mower.exceptions.ValidationException;

public class SurfaceValidator {
	
	public static void validateSurfaceCoordinates(int x, int y) throws ValidationException{
		if(x!=y || x < 0){
			throw new ValidationException("The surface must have a square shape! The x and y coordinates must be equal and greater than 0.");
		}
	}

	/*
	 * This method checks if the mower's initial coordinates fit within the surface's.
	 */

	public static void validateMowerCoordinatesWithRegardsToTheSurface(
			Surface surface, Mower mower) throws ValidationException {
		if (mower.getMowerPosition().getHorizontalPositionX() > surface
				.getSurfaceMaxCoordinates().getHorizontalPositionX()
				|| mower.getMowerPosition().getVerticalPositionY() > surface
						.getSurfaceMaxCoordinates().getVerticalPositionY()) {
			throw new ValidationException(
					"This mower can't be placed on that surface because of it's initial possition coordinates");
		}
	}
}
