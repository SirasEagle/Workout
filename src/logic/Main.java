package logic;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import database.TextToObject;

public class Main {

	public static Object[][] oContent = { { "Exercise", 1, 2, 3, 4, 5, 6, 7 }, { " ", 1, 2, 3, 4, 5, 6, 7 },
			{ " ", 1, 2, 3, 4, 5, 6, 7 }, { " ", 1, 2, 3, 4, 5, 6, 7 }, { " ", 1, 2, 3, 4, 5, 6, 7 },
			{ " ", 1, 2, 3, 4, 5, 6, 7 }, { " ", 1, 2, 3, 4, 5, 6, 7 }, { " ", 1, 2, 3, 4, 5, 6, 7 },
			{ " ", 1, 2, 3, 4, 5, 6, 7 }, { " ", 1, 2, 3, 4, 5, 6, 7 },
			{ " ", 1, 2, 3, 4, 5, 6, 7 }, { " ", 1, 2, 3, 4, 5, 6, 7 },
			{ " ", 1, 2, 3, 4, 5, 6, 7 }, { " ", 1, 2, 3, 4, 5, 6, 7 },
			{ " ", 1, 2, 3, 4, 5, 6, 7 }, { " ", 1, 2, 3, 4, 5, 6, 7 },
			{ " ", 1, 2, 3, 4, 5, 6, 7 }, { " ", 1, 2, 3, 4, 5, 6, 7 }, { " ", 1, 2, 3, 4, 5, 6, 7 } };
	public static List<String> lines;
	public static int pastJumps = 0;
	/**
	 * This list contains all workouts a user has noted. <br>
	 * 
	 * @author Adrian Leutert
	 */
	private static List<Day> workouts;
	/**
	 * This list contains every exercise a user has noted. <br>
	 * Not the workouts themselves.
	 * 
	 * @author Adrian Leutert
	 */
	public static List<Exercise> exercises;
	private static short userFlag = 0;
	private static short smartFlag = 0;
	public final static int tableColSize = 18;
	public final static int tableWidthSize = 6;
	/**
	 * 0=Windows<br>1=iOS
	 */
	public static int osFlag = 1;

	public static void main(String[] args) throws IOException {

		// Initialize objects=======================================================|
		exercises = new ArrayList<Exercise>();
		lines = TextToObject.getLinesFromFile();
		workouts = TextToObject.getDaysFromLines(lines);
		refreshContent();

		// Start GUI================================================================|
		MainFrame frame = new MainFrame();
		frame.setUndecorated(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Rotates the Elements in the oContent Array to one older Date
	 */
	public static boolean getOlder() {
		if ((workouts.size() < 7) || (workouts.size() - pastJumps < 7)) {
			return false;
		}
		pastJumps++;
		refreshContent();
		return true;
	}

	/**
	 * Rotates the Elements in the oContent Array to one newer Date
	 */
	public static boolean getNewer() {
		if ((workouts.size() < 7) || (pastJumps <= 0)) {
			return false;
		}
		pastJumps--;
		refreshContent();
		return true;
	}

	public static void refreshContent() {
		Main.lines = TextToObject.getLinesFromFile();
		try {
			ExerciseManager.updateExercises(userFlag);
			Main.setWorkouts(TextToObject.getDaysFromLines(Main.lines));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		int tableWidth = tableWidthSize;
		if (workouts.size() < 6) {
			tableWidth = workouts.size();
		}
		for (int i = 0; i < tableWidth; i++) {
			int index = i + (workouts.size() - tableWidth) - pastJumps;
			if (workouts.get(index) != null) {
				oContent[0][1 + i] = workouts.get(index).getDate().toString();
				Exercise[] exercises = workouts.get(index).getExercises();
				for (int j = 0; j < tableColSize; j++) {
					if ((exercises[j].set1 + exercises[j].set2 + exercises[j].set3) == 0) {
						oContent[1 + j][1 + i] = " ";
					} else {
						if (exercises[j].set3 <= 0) {
							if (exercises[j].set2 <= 0) {
								oContent[1 + j][1 + i] = exercises[j].set1;
							} else {
								oContent[1 + j][1 + i] = (exercises[j].set1 + "-" + exercises[j].set2);
							}
						} else {
							oContent[1 + j][1 + i] = (exercises[j].set1 + "-" + exercises[j].set2 + "-"
									+ exercises[j].set3);
						}
					}
				}
			}
		}
		return;
	}

	public static short getUserFlag() {
		return Main.userFlag;
	}

	public static short getSmartFlag() {
		return Main.smartFlag;
	}

	public static List<logic.Day> getWorkouts() {
		return Main.workouts;
	}

	public static void setWorkouts(List<logic.Day> newList) {
		if (newList != null) {
			Main.workouts = newList;
		}
	}

	public static void setUserFlag(int flag) {
		if ((flag != 0) && (flag != 1)) {
			return;
		}
		userFlag = (short) flag;
		pastJumps = 0; // reset calender jumps
	}

	public static void setSmartFlag(int flag) {
		if ((flag != 0) && (flag != 1)) {
			return;
		}
		smartFlag = (short) flag;
	}
}
