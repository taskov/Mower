package com.taskov.mower.mockups;

import java.util.ArrayList;

import com.taskov.mower.config.TestConfigsConstants;
import com.taskov.mower.entities.implementaions.Mower;
import com.taskov.mower.entities.implementaions.Position;
import com.taskov.mower.entities.implementaions.Surface;
import com.taskov.mower.exceptions.ValidationException;

public class TestMockups {
	
	public ArrayList<String> mockCorrectFileContent(){
		ArrayList<String> mockedContent = new ArrayList<String>();
		mockedContent.add(TestConfigsConstants.LINE_1_SURFACE_DEFINITION_CORRECT);
		mockedContent.add(TestConfigsConstants.LINE_2_INITIAL_MOWER_POSITION_CORRECT);
		mockedContent.add(TestConfigsConstants.LINE_3_MOWER_MOVEMENT_INSTRUCTIONS_CORRECT);
		mockedContent.add(TestConfigsConstants.LINE_2_INITIAL_MOWER_POSITION_CORRECT_2);
		mockedContent.add(TestConfigsConstants.LINE_3_MOWER_MOVEMENT_INSTRUCTIONS_CORRECT_2);
		return mockedContent;
	}
	
	public ArrayList<String> mockIncorrectFileContentWrongNumberOfLines(){
		ArrayList<String> mockedContent = new ArrayList<String>();
		mockedContent.add(TestConfigsConstants.LINE_1_SURFACE_DEFINITION_CORRECT);
		mockedContent.add(TestConfigsConstants.LINE_2_INITIAL_MOWER_POSITION_CORRECT);
		return mockedContent;
	}
	
	public ArrayList<String> mockIncorrectFileContentWrongOrderOfLines(){
		ArrayList<String> mockedContent = new ArrayList<String>();
		mockedContent.add(TestConfigsConstants.LINE_1_SURFACE_DEFINITION_CORRECT);
		mockedContent.add(TestConfigsConstants.LINE_2_INITIAL_MOWER_POSITION_CORRECT);
		mockedContent.add(TestConfigsConstants.LINE_2_INITIAL_MOWER_POSITION_CORRECT);
		mockedContent.add(TestConfigsConstants.LINE_3_MOWER_MOVEMENT_INSTRUCTIONS_CORRECT);
		mockedContent.add(TestConfigsConstants.LINE_3_MOWER_MOVEMENT_INSTRUCTIONS_CORRECT);
		return mockedContent;
	}
	
	public ArrayList<String> mockIncorrectFileContentWrongSurfaceDefinitionLine(){
		ArrayList<String> mockedContent = new ArrayList<String>();
		mockedContent.add(TestConfigsConstants.LINE_1_SURFACE_DEFINITION_INCORRECT);
		mockedContent.add(TestConfigsConstants.LINE_2_INITIAL_MOWER_POSITION_CORRECT);
		mockedContent.add(TestConfigsConstants.LINE_2_INITIAL_MOWER_POSITION_CORRECT);
		return mockedContent;
	}
	
	public ArrayList<String> mockIncorrectFileContentWrongInitialMowerPositionLine(){
		ArrayList<String> mockedContent = new ArrayList<String>();
		mockedContent.add(TestConfigsConstants.LINE_1_SURFACE_DEFINITION_CORRECT);
		mockedContent.add(TestConfigsConstants.LINE_2_INITIAL_MOWER_POSITION_INCORRECT);
		mockedContent.add(TestConfigsConstants.LINE_2_INITIAL_MOWER_POSITION_CORRECT);
		return mockedContent;
	}
	
	public ArrayList<String> mockIncorrectFileContentWrongMowerDirectionsLine(){
		ArrayList<String> mockedContent = new ArrayList<String>();
		mockedContent.add(TestConfigsConstants.LINE_1_SURFACE_DEFINITION_CORRECT);
		mockedContent.add(TestConfigsConstants.LINE_2_INITIAL_MOWER_POSITION_CORRECT);
		mockedContent.add(TestConfigsConstants.LINE_2_INITIAL_MOWER_POSITION_INCORRECT);
		return mockedContent;
	}
	
	public Surface mockSurface() throws ValidationException{
		Surface surface = new Surface(TestConfigsConstants.SURFACE_X, TestConfigsConstants.SURFACE_X);
		return surface;
	}
	
	public Mower mockMower() throws ValidationException{
		Position position = new Position(TestConfigsConstants.MOWER_INITIAL_X_POSITION, TestConfigsConstants.MOWER_INITIAL_Y_POSITION);
		Mower mower = new Mower(position, TestConfigsConstants.MOWER_INITIAL_ORIENTATION, TestConfigsConstants.MOWER_DIRECTIONS);
		return mower;
	}
	
	public Mower mockMowerWithCoordinatesThatDoNotMatchTheSurface() throws ValidationException{
		Position position = new Position(TestConfigsConstants.MOWER_INITIAL_X_POSITION_XL, TestConfigsConstants.MOWER_INITIAL_Y_POSITION_XL);
		Mower mower = new Mower(position, TestConfigsConstants.MOWER_INITIAL_ORIENTATION, TestConfigsConstants.MOWER_DIRECTIONS);
		return mower;
	}
	

}
