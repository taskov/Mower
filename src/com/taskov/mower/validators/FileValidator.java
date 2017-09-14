package com.taskov.mower.validators;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.taskov.mower.config.FileValidatorConfiguration;
import com.taskov.mower.exceptions.WrongFileFormatException;

/*
 * This class is responsible for the input file validation.
 */

public class FileValidator {
	
	/*The patterns responsible for validation*/
	static Pattern patternFilesFirstLine = Pattern.compile(FileValidatorConfiguration.VALIDATE_FIRST_LINE_REGEX);
	static Pattern patternInitialMowerPosition = Pattern.compile(FileValidatorConfiguration.VALIDATE_INITIAL_MOWER_POSITION_LINE_REGEX);
	static Pattern patterMowerDirectionsLine = Pattern.compile(FileValidatorConfiguration.VALIDATE_MOWER_DIRECTIONS_LINE_REGEX);
	
	/*This method validates the number of lines in the file. The file should have:
	 * 1) a minimum number of lines defined by the MINIMUM_FILE_LENGTH configuration variable
	 * 2) the number of lines in the file should be odd (a header line defining the surface + 2 lines per mower)
	 */
	private static void validateFileLength(List<String> lines) throws WrongFileFormatException {
		if (lines.size() % 2 == 0 && lines.size() < FileValidatorConfiguration.MINIMUM_FILE_LENGTH) {
			throw new WrongFileFormatException(FileValidatorConfiguration.WRONG_NUMBER_OF_LINES_MESSAGE + lines.size());
		}
	}
	
	/*This method validates the header line - the one defining the surface.
	 * It should contain exactly 2 equal digits and a space between them.
	 * The exact length of the line is defined by the FIRST_LINE_LENGHT configuration variable.
	 */
	private static void validateFirstLine(String firstLine) throws WrongFileFormatException {
		Matcher firstLineMatcher = patternFilesFirstLine.matcher(firstLine);
		if(firstLine.length() != FileValidatorConfiguration.FIRST_LINE_LENGHT || !firstLineMatcher.find()) {
			throw new WrongFileFormatException(FileValidatorConfiguration.WRONG_FIRST_LINE_FORMAT);
		}
		String[] firstLineValues = firstLine.split("\\s");
		if(Integer.parseInt(firstLineValues[0]) != Integer.parseInt(firstLineValues[1])) {
			throw new WrongFileFormatException(FileValidatorConfiguration.WRONG_FIRST_LINE_FORMAT);
		}
	}
	
	/*
	 * This method validates the lines indicating the initial position of each mower.
	 * Such a line should contain 2 digits separated by a space and a direction (E,W,N or S onlyS) 
	 * separated by a space from the second digit.
	 * The total number of symbols is defined by the INITIAL_MOWER_POSITION_LINE_LENGTH configuration variable.
	 */
	private static void validateMowersInitialMowerPosition(String line, int i) throws WrongFileFormatException{
		Matcher initialMowerPositionMatcher = patternInitialMowerPosition.matcher(line);
		if(!initialMowerPositionMatcher.find() || line.length() != FileValidatorConfiguration.INITIAL_MOWER_POSITION_LINE_LENGTH){
			throw new WrongFileFormatException(FileValidatorConfiguration.WRONG_INITIAL_MOWER_LINE_MESSAGE + i);
		}
	}
	
	/*
	 * This method validates the instructions for each mower. A line like this does not have a maximum length.
	 * A line of that type should only contain the letters 'A', 'D' and 'G' and no spaces at all. 
	 */
	private static void validateMowersInstructions(String line, int i) throws WrongFileFormatException {
		Matcher mowerInstructionsMatcher = patterMowerDirectionsLine.matcher(line);
		if(!mowerInstructionsMatcher.find()){
			throw new WrongFileFormatException(FileValidatorConfiguration.WRONG_MOWER_DIRECTIONS_LINE + i);
		}
	}
	
	
	/*
	 * This method validates the file content line by line. It loops through all of the lines and 
	 * depending on the line number it calls validateMowersInitialMowerPosition or the validateMowersInstructions
	 * method.
	 * 
	 */
	private static void validateFileContent(List<String> lines) throws WrongFileFormatException{
		String currentLine;
		for(int i = 1; i < lines.size(); i++){
			currentLine = lines.get(i).trim();
			if(i%2 == 1) {
				validateMowersInitialMowerPosition(currentLine, i+1);
			} else {
				validateMowersInstructions(currentLine, i+1);
			}
		}
	}
	
	public static void validateFile(List<String> lines)
			throws WrongFileFormatException {
		validateFileLength(lines);
		validateFirstLine(lines.get(0).trim());
		validateFileContent(lines);
	}

}
