package com.taskov.mower.command.implementaions;

import java.util.ArrayList;

import org.junit.Test;

import com.taskov.mower.exceptions.ValidationException;
import com.taskov.mower.exceptions.WrongFileFormatException;
import com.taskov.mower.mockups.TestMockups;

public class MowerCommadTest {
	
	@Test
	public void testParseFileAndProceedCorrectContent() throws WrongFileFormatException, ValidationException{
		TestMockups testConfigs = new TestMockups();
		ArrayList<String> fileContent = new ArrayList<String>();
		fileContent = testConfigs.mockCorrectFileContent();
		MowerCommand mow = new MowerCommand();
		mow.parseFileAndProceed(fileContent);
	}
	
	@Test (expected = WrongFileFormatException.class)
	public void testParseFileAndProceedIncorrectContentWrongNumberOfLines() throws WrongFileFormatException, ValidationException {
		TestMockups testConfigs = new TestMockups();
		ArrayList<String> fileContent = new ArrayList<String>();
		fileContent = testConfigs.mockIncorrectFileContentWrongNumberOfLines();
		MowerCommand mow = new MowerCommand();
		mow.parseFileAndProceed(fileContent);
	}
	
	@Test (expected = WrongFileFormatException.class)
	public void testParseFileAndProceedIncorrectContentWrongOrderOfLines() throws WrongFileFormatException, ValidationException {
		TestMockups testConfigs = new TestMockups();
		ArrayList<String> fileContent = new ArrayList<String>();
		fileContent = testConfigs.mockIncorrectFileContentWrongOrderOfLines();
		MowerCommand mow = new MowerCommand();
		mow.parseFileAndProceed(fileContent);
	}
	
	@Test (expected = WrongFileFormatException.class)
	public void testParseFileAndProceedIncorrectContentWrongSurfaceDefinitionLine() throws WrongFileFormatException, ValidationException {
		TestMockups testConfigs = new TestMockups();
		ArrayList<String> fileContent = new ArrayList<String>();
		fileContent = testConfigs.mockIncorrectFileContentWrongSurfaceDefinitionLine();
		MowerCommand mow = new MowerCommand();
		mow.parseFileAndProceed(fileContent);
	}
	
	@Test (expected = WrongFileFormatException.class)
	public void testParseFileAndProceedIncorrectContentWrongInitialMowerPositionLine() throws WrongFileFormatException, ValidationException {
		TestMockups testConfigs = new TestMockups();
		ArrayList<String> fileContent = new ArrayList<String>();
		fileContent = testConfigs.mockIncorrectFileContentWrongInitialMowerPositionLine();
		MowerCommand mow = new MowerCommand();
		mow.parseFileAndProceed(fileContent);
	}
	
	@Test (expected = WrongFileFormatException.class)
	public void testParseFileAndProceedIncorrectContentWrongMowerDirectionsLine() throws WrongFileFormatException, ValidationException {
		TestMockups testConfigs = new TestMockups();
		ArrayList<String> fileContent = new ArrayList<String>();
		fileContent = testConfigs.mockIncorrectFileContentWrongMowerDirectionsLine();
		MowerCommand mow = new MowerCommand();
		mow.parseFileAndProceed(fileContent);
	}
	
}
