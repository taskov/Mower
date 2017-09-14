package com.taskov.mower.command.implementaions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.taskov.mower.entities.implementaions.Mower;
import com.taskov.mower.entities.implementaions.MowerInstructions;
import com.taskov.mower.entities.implementaions.Surface;
import com.taskov.mower.exceptions.ValidationException;
import com.taskov.mower.exceptions.WrongFileFormatException;
import com.taskov.mower.validators.FileValidator;

public class MowerCommand {
	
	public static void main(String[] args) throws IOException {
		String filePath = "C://Users//Taskov//Desktop//javaex//mower.txt";
		Stream<String> stream = Files.lines(Paths.get(filePath));
		List<String> lines = new ArrayList<String>();
		lines = stream.collect(Collectors.toList());
		try {
			MowerCommand mowerCommand = new MowerCommand();
			mowerCommand.parseFileAndProceed(lines);
		} catch (WrongFileFormatException | ValidationException e) {
			e.printStackTrace();
		} finally {
			stream.close();
		}
	}
	
	public void parseFileAndProceed(List<String> lines) throws WrongFileFormatException, ValidationException{
		FileValidator.validateFile(lines);	
		MowerInstructions mowFile = new MowerInstructions(lines);
		Surface surface = mowFile.getSurface();
		List<Mower> mowers = mowFile.getMowers();
		for(int i = 0; i < mowers.size(); i++){
			Mower mower = mowers.get(i);
			System.out.println("Start moving mower number: " + (i+1) + "\n");
			mower.move(surface);
			System.out.println(mower.toString());
		}
		System.out.println(surface.getMowersPositions().toString());
	}
}
