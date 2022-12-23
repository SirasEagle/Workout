package database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import logic.Day;
import logic.ExerciseManager;
import logic.Main;
import logic.Statistics;

public class TextToObject {

	private static List<Day> allDays;

	/**
	 * Returns a list of all existing lines of the "exercises"-.txt file
	 * 
	 * @return String list of the lines
	 */
	public static List<String> getLinesFromFile() {
		List<String> allLines = null;
		try {
			allLines = Files.readAllLines(
					Paths.get("src" + ExerciseManager.getPathChar() + "database" + ExerciseManager.getPathChar()
							+ "user" + Main.getUserFlag() + "exer").toAbsolutePath()
							.resolve("exercises.txt"),
					StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allLines;
	}

	/**
	 * Returns a list of Day objects, extracted from the strings
	 * 
	 * @param lines - The String list to extract from. Has to have the format:
	 * 
	 *              <pre>
	 * yyyy-mm-dd
	 * 5-15-15-15
	 * 8-7-7 
	 * --
	 * yyyy-mm-dd
	 * ...
	 *              </pre>
	 * 
	 * @return List of recognized day objects
	 * @throws FileNotFoundException
	 */
	public static List<Day> getDaysFromLines(List<String> lines) throws FileNotFoundException {
		allDays = new ArrayList<Day>();
		for (int i = 0; i < lines.size(); i++) {
			if (((lines.get(i).substring(0, 2).equals("20")) || (lines.get(i).substring(0, 2).equals("21")))
					&& (lines.get(i).charAt(2) != ' ')) {
				Day newDay = new Day();
				newDay.setDateString(lines.get(i).substring(0, 10));
				// reading out the exercises
				int cracra = 1;
				while (true) {
					if ((lines.get(i + cracra) != null) && (lines.get(i + cracra).charAt(0) != '-')) {
						String[] exercises = lines.get(i + cracra).split("-");
						String exName = exercises[0];
						int round1 = Integer.parseInt(exercises[1]);
						int round2 = Integer.parseInt(exercises[2]);
						int round3 = Integer.parseInt(exercises[3]);
						int exIndex = 0;
						for (int j = 0; j < Main.exercises.size(); j++) {
							if (Main.exercises.get(j).getName().equals(exName)) {
								exIndex = j;
								break;
							}
						}
						newDay.addExercise(exIndex, round1, round2, round3);
					} else {
						break;
					}
					cracra++;
				}
				newDay.setValue(Statistics.getValueFromDay(newDay));
				allDays.add(newDay);
			}
		}
		return allDays;
	}

}
