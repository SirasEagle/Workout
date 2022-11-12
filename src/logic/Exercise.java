package logic;

/**
 * This class creates object of the type "Exercise". <br>
 * 
 * @author Adrian Leutert
 *
 */
public class Exercise {

	private String name;
	private String picPath;
	private int mediumReps;
	private int index;
	private float fColor;
	public int set1;
	public int set2;
	public int set3;

	public Exercise(int index) {
		this.index = index;
		this.picPath = ExerciseManager.getPicPath(index);
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
}
