package com.taskov.mower.exceptions;

public class WrongFileFormatException extends Exception {

	private static final long serialVersionUID = 5882835216374779043L;

	public WrongFileFormatException() {

	}

	public WrongFileFormatException(String message) {
		super(message);
	}
}
