package logic;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Day {

	private LocalDate date;
	private static int maxExercises = Main.tableColSize;
	private Exercise[] exercises;
	private int value;

	/**
	 * Creates a new Day with 20.05.2022 as the date
	 * 
	 * @throws FileNotFoundException
	 */
	public Day() throws FileNotFoundException {
		this.date = LocalDate.now();
		if (Main.exercises.size() > Main.tableColSize) {
			maxExercises = Main.exercises.size();
		}
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

	public void addExercise(int exIndex, int set1, int set2, int set3) {
		if (exercises.length < exIndex) {
			System.out.println("[DAY] Exercise has a too high index");
			System.out.println("[DAY] index=" + exIndex + ", but can fit only " + exercises.length + " exercises.");
			return;
		}
		this.exercises[exIndex].set1 = set1;
		this.exercises[exIndex].set2 = set2;
		this.exercises[exIndex].set3 = set3;
		return;
	}

}
