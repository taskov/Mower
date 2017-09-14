package com.taskov.mower.config;

/*This class contains all of the configurations for file validation*/
public class FileValidatorConfiguration {

	//minimum number of lines in the file
	public static final int MINIMUM_FILE_LENGTH = 3;

	//the precise length of the first line (the one defining the surface)
	public static final int FIRST_LINE_LENGHT = 3;
	//the precise length of the mower initial position line 
	public static final int INITIAL_MOWER_POSITION_LINE_LENGTH = 5;

	//Regex validating the first line (the one defining the surface)
	public static final String VALIDATE_FIRST_LINE_REGEX = "\\d\\s\\d";
	//Regex validating the mower initial position line 
	public static final String VALIDATE_INITIAL_MOWER_POSITION_LINE_REGEX = "\\d\\s\\d\\s[EWNS]{1}";
	//Regex validating the line indicating mower's directions:
	public static final String VALIDATE_MOWER_DIRECTIONS_LINE_REGEX = "^[ADG]+$";

	//Error messages
	public static final String WRONG_NUMBER_OF_LINES_MESSAGE = "The number of lines in the file shoudl be odd and greater than 1! In the file that you are trying to parse the number of lines is: ";
	public static final String WRONG_FIRST_LINE_FORMAT = "The first line of the file should only contain 2 equal digits and a blanc space between them.";
	public static final String WRONG_INITIAL_MOWER_LINE_MESSAGE = "The line declaring mower's initial coordinates should only contain 5 symbols. 2 digits (x and y) and a letter (orientation: E W N or S) separated by blanc spaces. Validation error detected on line number: ";
	public static final String WRONG_MOWER_DIRECTIONS_LINE = "The line containg move directions for a mower should only contain capital letters indicating directions (A G or D)! Validation error detected on line number: ";

}
