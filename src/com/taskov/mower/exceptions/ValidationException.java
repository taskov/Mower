package com.taskov.mower.exceptions;

public class ValidationException extends Exception{

	
	private static final long serialVersionUID = 621220430719117079L;

	public ValidationException(){
		
	}
	
	public ValidationException(String message){
		super(message);
	}
}
