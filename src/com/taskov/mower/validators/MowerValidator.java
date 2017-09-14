package com.taskov.mower.validators;

import com.taskov.mower.exceptions.ValidationException;

public class MowerValidator {
	
	public static void validateOrientation(char orientation)throws ValidationException {
		String allOrientations = "EWNS";
		if(allOrientations.indexOf(orientation) == -1){
			throw new ValidationException("Not a valid orientation: " + orientation);
		}
	}
	
	public static void validateDirections(char[] directions) throws ValidationException{
		String allDirections = "GDA";
		for(int i = 0; i < directions.length; i++){
			if(allDirections.indexOf(directions[i]) == -1){
				throw new ValidationException("Not a valid direction: " + directions[i]);
			}
		}
	}

}
