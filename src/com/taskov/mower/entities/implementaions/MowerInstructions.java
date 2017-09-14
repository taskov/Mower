package com.taskov.mower.entities.implementaions;

import java.util.ArrayList;
import java.util.List;

import com.taskov.mower.exceptions.ValidationException;

/*This input file is parsed in an object like this for convenience.
 * It contains the surface object and a list of all of the mowers that
 * will be moving on that surface
 * */
public class MowerInstructions {

	private Surface surface;
	private List<Mower> mowers;
	
	public MowerInstructions (List<String> lines) throws ValidationException {
		Surface surface = getSurfaceFromFileContent(lines.get(0));
		this.surface = surface;
		List<Mower> mowers = getMowersFromFileContent(lines);
		this.mowers = mowers;
	}

	public Surface getSurface() {
		return surface;
	}

	public void setSurface(Surface surface) {
		this.surface = surface;
	}

	public List<Mower> getMowers() {
		return mowers;
	}

	public void setMowers(List<Mower> mowers) {
		this.mowers =  mowers;
	}
	
	private Surface getSurfaceFromFileContent(String line) throws ValidationException{
		String []surfaceParams = line.split("\\s");
		int surfaceMaxHorizontalPositionX = Integer.parseInt(surfaceParams[0]);
		int surfaceMaxVerticalPositionY = Integer.parseInt(surfaceParams[1]);
		Surface surface = new Surface(surfaceMaxHorizontalPositionX, surfaceMaxVerticalPositionY);
		return surface;
	}
	
	private List<Mower> getMowersFromFileContent(List<String> lines) throws ValidationException{
		List<Mower> mowers = new ArrayList<Mower>();
		//TODO: configs for i and 2?
		for(int i = 1; i < lines.size(); i+=2) {
			String[] line = lines.get(i).split("\\s");
			int mowerHorizontalPositionX = Integer.parseInt(line[0]);
			int mowerVerticalPositionY = Integer.parseInt(line[1]);
			char direction = line[2].charAt(0);
			Position mowerPosition = new Position(mowerHorizontalPositionX, mowerVerticalPositionY);
			Mower mower = new Mower(mowerPosition, direction, lines.get(i+1).toCharArray());
			mowers.add(mower);
		}
		return mowers;
	}

}
