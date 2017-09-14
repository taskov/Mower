package com.taskov.mower.entities.implementaions;

import static org.junit.Assert.*;

import org.junit.Test;

import com.taskov.mower.exceptions.ValidationException;
import com.taskov.mower.mockups.TestMockups;

public class MowerTest {
	
	@Test
	public void testMoveOkCoordinates() throws ValidationException{
		TestMockups testMockups = new TestMockups();
		Mower mower = testMockups.mockMower();
		Surface surface =  testMockups.mockSurface();
		mower.move(surface);
		assertEquals(mower.getMowerPosition().getHorizontalPositionX(), 1);
		assertEquals(mower.getMowerPosition().getVerticalPositionY(), 3);
	}
	
	@Test  (expected = ValidationException.class)
	public void testMoveSmallerSurface () throws ValidationException{
		TestMockups testMockups = new TestMockups();
		Mower mower = testMockups.mockMowerWithCoordinatesThatDoNotMatchTheSurface();
		Surface surface =  testMockups.mockSurface();
		mower.move(surface);
	}
	
}
