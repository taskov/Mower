package com.taskov.mower.entities.implementaions;

import org.junit.Test;

import com.taskov.mower.config.TestConfigsConstants;
import com.taskov.mower.exceptions.ValidationException;

public class SurfaceTest {
	
	@Test
	public void testSurfaceConstructor() throws ValidationException{
		new Surface(TestConfigsConstants.SURFACE_X, TestConfigsConstants.SURFACE_Y);
	}
	
	@Test (expected = ValidationException.class)
	public void testSurfaceConstructorDifferentArgs() throws ValidationException{
		new Surface(TestConfigsConstants.SURFACE_X, TestConfigsConstants.SURFACE_Y_DIFF);
	}
	
	@Test (expected = ValidationException.class)
	public void testSurfaceConstructorNegativeArgs() throws ValidationException{
		new Surface(TestConfigsConstants.SURFACE_NEGATIVE_X, TestConfigsConstants.SURFACE_NEGATIVE_Y);
	}
	

}
