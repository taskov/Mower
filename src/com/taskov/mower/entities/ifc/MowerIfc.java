package com.taskov.mower.entities.ifc;

import com.taskov.mower.entities.implementaions.Surface;
import com.taskov.mower.exceptions.ValidationException;


public interface MowerIfc {
	
	/*This method moves or rotates a mower*/
	public void move(Surface surface) throws ValidationException;	

}
