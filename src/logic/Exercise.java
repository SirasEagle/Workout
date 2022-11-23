package logic;

import java.io.FileNotFoundException;
import java.util.Comparator;

import Design.eColor;

/**
 * This class creates object of the type "Exercise". <br>
 * 
 * @author Adrian Leutert
 *
 */
public class Exercise implements Comparable<Exercise> {

	private int index;
	private String name;
	private String picPath;
	private int mediumReps;
	private float fColor;
	private eColor eCol;
	public int set1;
	public int set2;
	public int set3;

	public Exercise(int index) throws FileNotFoundException {
		this.index = index;
		this.picPath = ExerciseManager.getPicPath(ExerciseManager.getName(index));
		this.name = ExerciseManager.getName(index);
		this.mediumReps = ExerciseManager.getMedRep(index);
		this.fColor = ExerciseManager.getExeColor(index);
		this.set1 = 0;
		this.set2 = 0;
		this.set3 = 0;
	}

	public String getName() {
		return name;
	}
	
	public float getColor() {
		return fColor;
	}

	public eColor getEColor() {
		return eCol;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicPath() {
		return picPath;
	}

	public int getMediumReps() {
		return mediumReps;
	}

	public void setMediumReps(int mediumReps) {
		this.mediumReps = mediumReps;
	}
	
	public int getIndex() {
		return index;
	}

	@Override
	public int compareTo(Exercise o) {
		return Comparator.comparing(Exercise::getIndex).thenComparing(Exercise::getIndex).compare(this, o);
	}
}
