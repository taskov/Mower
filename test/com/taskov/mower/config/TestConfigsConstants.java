package com.taskov.mower.config;

public class TestConfigsConstants {

	// line 1 - defines the surface
	public static final String LINE_1_SURFACE_DEFINITION_CORRECT = "5 5";
	public static final String LINE_1_SURFACE_DEFINITION_INCORRECT = "5 3";
	public static final String LINE_1_SURFACE_DEFINITION_INCORRECT_2 = "a b";

	// line 2 - defines the mower's initial position
	public static final String LINE_2_INITIAL_MOWER_POSITION_CORRECT = "1 2 N";
	public static final String LINE_2_INITIAL_MOWER_POSITION_CORRECT_2 = "3 3 E";
	public static final String LINE_2_INITIAL_MOWER_POSITION_INCORRECT = "1 2 L";
	public static final String LINE_2_INITIAL_MOWER_POSITION_INCORRECT_2 = "1 2 2";
	public static final String LINE_2_INITIAL_MOWER_CORRECT_BIGGER_THAN_SURFACE = "9 9 E";

	// line 3 - defines the mower's movement instructions
	public static final String LINE_3_MOWER_MOVEMENT_INSTRUCTIONS_CORRECT = "GAGAGAGAA";
	public static final String LINE_3_MOWER_MOVEMENT_INSTRUCTIONS_CORRECT_2 = "AADAADADDA";
	public static final String LINE_3_MOWER_MOVEMENT_INSTRUCTIONS_INCORRECT = "GAADAAG1";
	public static final String LINE_3_MOWER_MOVEMENT_INSTRUCTIONS_INCORRECT_2 = "GA G";

	//surface
	public static final int SURFACE_X = 5;
	public static final int SURFACE_Y = 5;
	public static final int SURFACE_Y_DIFF = 6;
	public static final int SURFACE_NEGATIVE_X = -5;
	public static final int SURFACE_NEGATIVE_Y = -5;
	
	//mower 
	public static final char MOWER_INITIAL_ORIENTATION = 'N';
	public static final char[] MOWER_DIRECTIONS = {'G','A','G','A','G','A','G','A','A'};
	
	//position
	public static final int MOWER_INITIAL_X_POSITION = 1;
	public static final int MOWER_INITIAL_Y_POSITION = 2;
	
	public static final int MOWER_INITIAL_X_POSITION_XL = 9;
	public static final int MOWER_INITIAL_Y_POSITION_XL = 9;
	
	
}
