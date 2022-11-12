package logic;

import Design.Colors;

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
	 * Chooses a user specific name for the exercise, identifiable by the index
	 * 
	 * @param exeIndex The index of the exercise, use this.index
	 * @return the selected
	 */
	protected static String getName(int exeIndex) {
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
				ret =  "Butterfly";
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
			switch (exeIndex) {
			case 0:
				ret = "Crunches"; // "Scissors pro Seite" - 1 - Schere
				break;
			case 1:
				ret = "Peeing Dog"; // "Peeing Dog pro Seite" - 6
				break;
			case 2:
				ret = "Scissors"; 
				break;
			case 3:
				ret = "Crocodile"; // "Crunches" - 4
				break;
			case 4:
				ret = "SitUps"; // "SitUps" - 5
				break;
			case 5:
				ret = "Ankle touch"; // "Ankle Touches pro Seite" - 3 
				break;
			case 6:
				ret = "Poopin Dog"; // "Leg Raise pro Seite" - 7
				break;
			case 7:
				ret = "Bridges"; // "Hip Raise" - 2 - Also mein Low back
				break;
			case 8:
				ret = "Biceps Curls";
				break;
			case 9:
				ret = "Pull-close L"; // "Pull-close L" - 10 - siehe meine Übungen
				break;
			case 10:
				ret = "Leg Raise";
				break;
			case 11:
				ret = "Shoulder"; // "Schulter" - 8
				break;
			case 12:
				ret = "Side bend"; // Dumbbell side bend pro seite
				break;
			case 13:
				ret = "Core stabil"; // Standing Core stabilization pro seite
				break;
			case 14:
				ret = "Bow extend."; // Bow extension pro seite
				break;
			case 15:
				ret = "Bike";
				break;
			case 16:
				ret = "Squads";
				break;
			case 17:
				ret = "Butterfly";
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
	 */
	protected static int getMedRep(int exeIndex) {
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
			switch (exeIndex) {
			case 0:
				ret = 15;
				break;
			case 1:
				ret = 9;
				break;
			case 2:
				ret = 25;
				break;
			case 3:
				ret = 20;
				break;
			case 4:
				ret = 9;
				break;
			case 5:
				ret = 10;
				break;
			case 6:
				ret = 8;
				break;
			case 7:
				ret = 12;
				break;
			case 8:
				ret = 12;
				break;
			case 9:
				ret = 9;
				break;
			case 10:
				ret = 7;
				break;
			case 11:
				ret = 5;
				break;
			case 12:
				ret = 15;
				break;
			case 13:
				ret = 10;
				break;
			case 14:
				ret = 10;
				break;
			case 15:
				ret = 15;
				break;
			case 16:
				ret = 15;
				break;
			case 17:
				ret = 12;
				break;
			default:
				break;
			}
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

	public static float getExeColor(int index) {
		float fColor = 0f;

		if (Main.getUserFlag() == 0) {
			switch (index) {
			case 0:
				fColor =Colors.exRed();
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
			switch (index) {
			case 0:
				fColor = Colors.exBlue();
				break;
			case 1:
				fColor = Colors.exRed();
				break;
			case 2:
				fColor = Colors.exRed();
				break;
			case 3:
				fColor = Colors.exRed();
				break;
			case 4:
				fColor = Colors.exBlue();
				break;
			case 5:
				fColor = Colors.exBlue();
				break;
			case 6:
				fColor = Colors.exOrange();
				break;
			case 7:
				fColor = Colors.exOrange();
				break;
			case 8:
				fColor = Colors.exPink();
				break;
			case 9:
				fColor = Colors.exPink();
				break;
			case 10:
				fColor = Colors.exBlue();
				break;
			case 11:
				fColor = Colors.exYellow();
				break;
			case 12:
				fColor = Colors.exBlue();
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
				fColor = Colors.exRed();
				break;
			case 17:
				fColor = Colors.exCyan();
				break;
			default:
				break;
			}
		}

		return fColor;
	}
}
