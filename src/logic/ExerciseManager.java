package logic;

import Design.Colors;
import Design.eColor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class ExerciseManager {

	// private static String pathAbsolute = "C:\\Adrian\\3_Selfmade\\5_Programme\\_1
	// Java\\alul\\src\\database\\";
	private static String pathRelative = "src\\database\\";

	/**
	 * Chooses a user specific image for the exercise, identifiable by the index
	 * 
	 * @param exeIndex The index of the exercise, use this.index
	 * @return the selected
	 */
	protected static String getPicPath(String exeName) {
		String ret = "";

		ret = pathRelative + "user" + Main.getUserFlag() + "exer\\" + exeName + ".jpg";

		return ret;
	}

	/**
	 * Chooses a user specific medium repeating number for the exercise,
	 * identifiable by the index
	 * 
	 * @param exeIndex The index of the exercise, use this.index
	 * @return the selected
	 * @throws FileNotFoundException
	 */
	protected static int getMedRep(int exeIndex) throws FileNotFoundException {
		int ret = 0;

		if (Main.exercises == null) {
			ExerciseManager.updateExercises(Main.getUserFlag());
		}
		if (Main.exercises.size() <= exeIndex) {
			ExerciseManager.updateExercises(Main.getUserFlag());
		}
		ret = Main.exercises.get(exeIndex).getMediumReps();

		return ret;
	}

	public static float getExeBrightnes(Exercise exe) {
		Integer exeCount = (exe.set1 + exe.set2 + exe.set3);
		float isMedian = exeCount / 3f;
		Integer shouldMedian = exe.getMediumReps();
		float fBrightnes = isMedian / (shouldMedian * 2.2f);

		if (fBrightnes > 1f) {
			fBrightnes = 1f;
		}

		return (fBrightnes + 0.1f);
	}

	public static float getExeColor(int index) throws FileNotFoundException {
		float fColor = 0f;

		if (Main.exercises == null) {
			ExerciseManager.updateExercises(Main.getUserFlag());
		}
		if (Main.exercises.size() <= index) {
			ExerciseManager.updateExercises(Main.getUserFlag());
		}
		eColor e = Main.exercises.get(index).getEColor();
		fColor = ExerciseManager.getColorAsFloat(e);
		return fColor;
	}

	/**
	 * Chooses a user specific name for the exercise, identifiable by the index
	 * 
	 * @param exeIndex The index of the exercise, use this.index
	 * @return the selected
	 */
	public static String getName(int exeIndex) throws FileNotFoundException {
		String ret = "";

		if (Main.exercises == null) {
			ExerciseManager.updateExercises(Main.getUserFlag());
		}
		if (Main.exercises.size() <= exeIndex) {
			ExerciseManager.updateExercises(Main.getUserFlag());
		}
		ret = Main.exercises.get(exeIndex).getName();

		return ret;
	}

	private static float getColorAsFloat(eColor e) {
		float ret = 0f;
		switch (e) {
			case ORANGE:
				ret = Colors.exOrange();
				break;
			case PINK:
				ret = Colors.exPink();
				break;
			case RED:
				ret = Colors.exRed();
				break;
			case BLUE:
				ret = Colors.exBlue();
				break;
			case YELLOW:
				ret = Colors.exYellow();
				break;
			case CYAN:
				ret = Colors.exCyan();
				break;
			case GREEN:
				ret = Colors.exGreen();
				break;
			default:
				ret = Colors.exOrange();
				break;
		}
		return ret;
	}

	protected static void updateExercises(int user) throws FileNotFoundException {

		if (Main.exercises != null) {
			Main.exercises.clear();
		}
		// BufferedReader reader = new BufferedReader(new FileReader(
		// pathAbsolute + "user" + user + "exer\\definition.txt"));
		BufferedReader reader = new BufferedReader(new FileReader(
				pathRelative + "user" + user + "exer\\definition.txt"));
		String jsonString = "";
		String line = "";
		try {
			StringBuilder sb = new StringBuilder();
			try {
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				try {
					line = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			jsonString = sb.toString();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// System.out.println(jsonString);

		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		// JsonObject object = (JsonObject) parser.parse(jsonString);// response will be
		// the json String
		JsonArray object = (JsonArray) parser.parse(jsonString);// response will be the json String
		Exercise[] emp = gson.fromJson(object, Exercise[].class);

		// sort the array from smallest to largest
		Arrays.sort(emp, new Comparator<Exercise>() {
			public int compare(Exercise b1, Exercise b2) {
				if (b1.getIndex() > b2.getIndex()) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		for (int i = 0; i < emp.length; i++) {
			Main.exercises.add(emp[i]);
		}
	}
}
