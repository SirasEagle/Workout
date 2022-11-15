package logic;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Day {

	private LocalDate date;
	private static int maxExercises = 18;
	private Exercise[] exercises;
	private int value;

	/**
	 * Creates a new Day with 20.05.2022 as the date
	 * @throws FileNotFoundException
	 */
	public Day() throws FileNotFoundException {
		this.date = LocalDate.now();
		this.exercises = new Exercise[maxExercises];
		for (int i = 0; i < maxExercises; i++) {
			this.exercises[i] = new Exercise(i);
		}
		for (int i = 0; i < maxExercises; i++) {
			this.exercises[i].set1 = 0;
			this.exercises[i].set2 = 0;
			this.exercises[i].set3 = 0;
		}
		this.value = 0;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setDateString(String sDate) {
		this.date = LocalDate.parse(sDate);
	}

	public Exercise[] getExercises() {
		return exercises;
	}

	public void setExercises(Exercise[] exercises) {
		this.exercises = exercises;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static int getMaxExercises() {
		return maxExercises;
	}

	public String toString() {
		String retString = (this.date.toString() + ": \n");
		for (int i = 0; i < maxExercises; i++) {
			retString += (this.exercises[i].set1 + "-");
			retString += (this.exercises[i].set2 + "-");
			retString += (this.exercises[i].set3 + "\n");
		}
		return retString;
	}

	public void addExercise(int exIndex, int i, int j, int k) {
		this.exercises[(exIndex - 1)].set1 = i;
		this.exercises[(exIndex - 1)].set2 = j;
		this.exercises[(exIndex - 1)].set3 = k;
		return;
	}

}
