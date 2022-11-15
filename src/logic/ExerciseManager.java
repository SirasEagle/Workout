package logic;

import Design.Colors;
import Design.eColor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class ExerciseManager {

	private static String path = "C:\\Adrian\\3_Selfmade\\5_Programme\\_1 Java\\alul\\src\\database\\";

	/**
	 * Chooses a user specific image for the exercise, identifiable by the index
	 * 
	 * @param exeIndex The index of the exercise, use this.index
	 * @return the selected
	 */
	protected static String getPicPath(int exeIndex) {
		String ret = "";

		if (Main.getUserFlag() == 0) {
			switch (exeIndex) {
				case 0:
					ret = path + "1.jpg";
					break;
				case 1:
					ret = path + "2.jpg";
					break;
				case 2:
					ret = path + "3.jpg";
					break;
				case 3:
					ret = path + "4.jpg";
					break;
				case 4:
					ret = path + "5.jpg";
					break;
				case 5:
					ret = path + "6.jpg";
					break;
				case 6:
					ret = path + "7.jpg";
					break;
				case 7:
					ret = path + "8.jpg";
					break;
				case 8:
					ret = path + "9.jpg";
					break;
				case 9:
					ret = path + "10.jpg";
					break;
				case 10:
					ret = path + "11.jpg";
					break;
				case 11:
					ret = path + "12.jpg";
					break;
				case 12:
					ret = path + "13.jpg";
					break;
				case 13:
					ret = path + "14.jpg";
					break;
				case 14:
					ret = path + "15.jpg";
					break;
				case 15:
					ret = path + "16.jpg";
					break;
				case 16:
					ret = path + "17.jpg";
					break;
				case 17:
					ret = path + "18.jpg";
					break;
				default:
					break;
			}
		} else if (Main.getUserFlag() == 1) {
			switch (exeIndex) {
				case 0:
					ret = path + "user1exer\\1.jpg";
					break;
				case 1:
					ret = path + "user1exer\\2.jpg";
					break;
				case 2:
					ret = path + "user1exer\\3.jpg";
					break;
				case 3:
					ret = path + "user1exer\\4.jpg";
					break;
				case 4:
					ret = path + "user1exer\\5.jpg";
					break;
				case 5:
					ret = path + "user1exer\\6.jpg";
					break;
				case 6:
					ret = path + "user1exer\\7.jpg";
					break;
				case 7:
					ret = path + "user1exer\\8.jpg";
					break;
				case 8:
					ret = path + "user1exer\\9.jpg";
					break;
				case 9:
					ret = path + "user1exer\\10.jpg";
					break;
				case 10:
					ret = path + "user1exer\\11.jpg";
					break;
				case 11:
					ret = path + "user1exer\\12.jpg";
					break;
				case 12:
					ret = path + "user1exer\\13.jpg";
					break;
				case 13:
					ret = path + "user1exer\\14.jpg";
					break;
				case 14:
					ret = path + "user1exer\\15.jpg";
					break;
				case 15:
					ret = path + "user1exer\\16.jpg";
					break;
				case 16:
					ret = path + "user1exer\\17.jpg";
					break;
				case 17:
					ret = path + "user1exer\\18.jpg";
					break;
				default:
					break;
			}
		}

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

		if (Main.getUserFlag() == 0) {
			switch (exeIndex) {
				case 0:
					ret = 20;
					break;
				case 1:
					ret = 3;
					break;
				case 2:
					ret = 11;
					break;
				case 3:
					ret = 11;
					break;
				case 4:
					ret = 20;
					break;
				case 5:
					ret = 15;
					break;
				case 6:
					ret = 10;
					break;
				case 7:
					ret = 4;
					break;
				case 8:
					ret = 15;
					break;
				case 9:
					ret = 15;
					break;
				case 10:
					ret = 20;
					break;
				case 11:
					ret = 16;
					break;
				case 12:
					ret = 12;
					break;
				case 13:
					ret = 20;
					break;
				case 14:
					ret = 20;
					break;
				case 15:
					ret = 15;
					break;
				case 16:
					ret = 15;
					break;
				case 17:
					ret = 14;
					break;
				default:
					break;
			}
		} else if (Main.getUserFlag() == 1) {

			if (Main.exercises == null) {
				ExerciseManager.fillExercises();
			}
			if (Main.exercises.size() <= exeIndex) {
				ExerciseManager.fillExercises();
			}
			ret = Main.exercises.get(exeIndex).getMediumReps();
		}
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

		if (Main.getUserFlag() == 0) {
			switch (index) {
				case 0:
					fColor = Colors.exRed();
					break;
				case 1:
					fColor = Colors.exOrange();
					break;
				case 2:
					fColor = Colors.exOrange();
					break;
				case 3:
					fColor = Colors.exOrange();
					break;
				case 4:
					fColor = Colors.exOrange();
					break;
				case 5:
					fColor = Colors.exOrange();
					break;
				case 6:
					fColor = Colors.exOrange();
					break;
				case 7:
					fColor = Colors.exOrange();
					break;
				case 8:
					fColor = Colors.exGreen();
					break;
				case 9:
					fColor = Colors.exGreen();
					break;
				case 10:
					fColor = Colors.exGreen();
					break;
				case 11:
					fColor = Colors.exPink();
					break;
				case 12:
					fColor = Colors.exCyan();
					break;
				case 13:
					fColor = Colors.exYellow();
					break;
				case 14:
					fColor = Colors.exBlue();
					break;
				case 15:
					fColor = Colors.exBlue();
					break;
				case 16:
					fColor = Colors.exPink();
					break;
				case 17:
					fColor = Colors.exPink();
					break;
				default:
					break;
			}
		} else if (Main.getUserFlag() == 1) {

			if (Main.exercises == null) {
				ExerciseManager.fillExercises();
			}
			if (Main.exercises.size() <= index) {
				ExerciseManager.fillExercises();
			}
			eColor e = Main.exercises.get(index).getEColor();
			fColor = ExerciseManager.getColorAsFloat(e);
		}
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

		if (Main.getUserFlag() == 0) {
			switch (exeIndex) {
				case 0:
					ret = "Kniebeuge";
					break;
				case 1:
					ret = "Chin-ups";
					break;
				case 2:
					ret = "Pull-up half";
					break;
				case 3:
					ret = "Pull-close";
					break;
				case 4:
					ret = "Bow down";
					break;
				case 5:
					ret = "Pull-close L";
					break;
				case 6:
					ret = "Chin-ups L";
					break;
				case 7:
					ret = "Pull-ups";
					break;
				case 8:
					ret = "Triceps";
					break;
				case 9:
					ret = "Push-ups";
					break;
				case 10:
					ret = "Butterfly";
					break;
				case 11:
					ret = "Hammer-Curls";
					break;
				case 12:
					ret = "Shoulder";
					break;
				case 13:
					ret = "Low back";
					break;
				case 14:
					ret = "Bike";
					break;
				case 15:
					ret = "Sit-ups";
					break;
				case 16:
					ret = "B-Curls";
					break;
				case 17:
					ret = "Rev-Curls";
					break;
				default:
					break;
			}
		} else if (Main.getUserFlag() == 1) {

			if (Main.exercises == null) {
				ExerciseManager.fillExercises();
			}
			if (Main.exercises.size() <= exeIndex) {
				ExerciseManager.fillExercises();
			}
			ret = Main.exercises.get(exeIndex).getName();
		}
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

	private static void fillExercises() throws FileNotFoundException {

		BufferedReader reader = new BufferedReader(new FileReader(
				path + "user1exer\\definition.txt"));
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
		for (int i = 0; i < emp.length; i++) {
			Main.exercises.add(emp[i]);
		}
	}
}
