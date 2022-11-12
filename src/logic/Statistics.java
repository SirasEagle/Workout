package logic;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JTextArea;

public class Statistics {

	private static final int MAX_DEPTH = 20;
	private static final int MAX_DEPTH_DAYS = 60;

	public static int getValueFromDay(Day day) {
		int value = 0;
		int sum = 0;
		for (int i = 0; i < Day.getMaxExercises(); i++) {
			sum += day.getExercises()[i].set1;
			sum += day.getExercises()[i].set2;
			sum += day.getExercises()[i].set3;

			value += (((sum * 100) / 3) / day.getExercises()[i].getMediumReps());

			sum = 0;
		}
		value = value / Day.getMaxExercises();
		return value;
	}

	protected static String getAllValuesAsString() {
		if (Main.workouts.size() < 1) {
			return "Not enough workouts";
		}
		String ret = ((Integer) Main.workouts.get(0).getValue()).toString();
		for (int i = 1; i < Main.workouts.size(); i++) {
			ret += "%, ";
			if ((i % 10) == 0) {
				ret += "<br/>";
			}
			ret += ((Integer) Main.workouts.get(i).getValue()).toString();
		}
		return ret + "%";
	}

	protected static String getValueAsDots(Day day) {
		String ret = "";
		int count = day.getValue();
		if (count <= 0) {
			return "";
		}
		for (int j = 0; j < count; j++) {
			ret += ".";
		}
		return ret;
	}

	private static int[] getExerciseAverage(int flag, Exercise exercise, int index) {
		int[] ret = { 0, 0 };
		if (flag == 0) {
			int iDepth = MAX_DEPTH;
			if (Main.workouts.size() < MAX_DEPTH) {
				iDepth = Main.workouts.size();
			}
			ret[0] = index;
			for (int i = (Main.workouts.size() - iDepth); i < Main.workouts.size(); i++) {
				ret[1] += Main.workouts.get(i).getExercises()[index].set1
						+ Main.workouts.get(i).getExercises()[index].set2
						+ Main.workouts.get(i).getExercises()[index].set3;
			}
			ret[1] = (ret[1] * 100) / iDepth;
			ret[1] = ret[1] / (Main.workouts.get(0).getExercises()[index].getMediumReps() * 3);
		} else if (flag == 1) {
			int iDepth = MAX_DEPTH_DAYS;
			int iIndexOfBeginning = 0;
			LocalDate dDepth = Main.workouts.get((Main.workouts.size() - 1)).getDate().minusDays(iDepth);
			if (Main.workouts.get(0).getDate().isAfter(dDepth)) {
				dDepth = Main.workouts.get(0).getDate();
			} else {
				while (true) {
					if (Main.workouts.get(iIndexOfBeginning).getDate().isAfter(dDepth)
							|| Main.workouts.get(iIndexOfBeginning).getDate().isEqual(dDepth)) {
						break;
					}
					iIndexOfBeginning++;
				}
			}
			ret[0] = index;
			for (int i = iIndexOfBeginning; i < Main.workouts.size(); i++) {
				ret[1] += Main.workouts.get(i).getExercises()[index].set1
						+ Main.workouts.get(i).getExercises()[index].set2
						+ Main.workouts.get(i).getExercises()[index].set3;
			}
			ret[1] = (ret[1] * 100) / (iDepth / 3);
			ret[1] = ret[1] / (Main.workouts.get(0).getExercises()[index].getMediumReps() * 3);
		}
		return ret;
	}

	/**
	 * Fetches the average value of each exercise and stores it in an 2d array.
	 * 
	 * @return int[a][b], with a having the exerciseCount and b having
	 *         0=exerciseIndex, 1=averageValue
	 */
	private static int[][] getAllExerciseAverages(int flag) {
		int num = Day.getMaxExercises();
		int[][] ret = new int[num][2];
		for (int i = 0; i < num; i++) {
			int[] ex = Statistics.getExerciseAverage(flag, Main.workouts.get(0).getExercises()[i], i);
			ret[i][0] = ex[0];
			ret[i][1] = ex[1];
		}
		return ret;
	}

	/**
	 * 
	 * @param area - the Area you want the data to append to
	 * @param type - 0=normal; 1=most; 2=least
	 */
	protected static void getExAverages(int flag, JTextArea area, int type) {
		int num = Day.getMaxExercises();
		int[][] ret = new int[num][2];
		if (type == 0) {
			for (int i = 0; i < Day.getMaxExercises(); i++) {
				int[] ex = Statistics.getExerciseAverage(flag, Main.workouts.get(0).getExercises()[i], i);
				area.append(Main.workouts.get(0).getExercises()[ex[0]].getName());
				area.append(":\t ");
				area.append(((Integer) (ex[1])).toString());
				area.append("%\n");
			}
		} else if (type >= 1) {
			ret = getAllExerciseAverages(flag);

			// Sort the array
			Arrays.sort(ret, new Comparator<int[]>() {
				public int compare(int[] frst, int[] scnd) {
					if (frst[2 - 1] > scnd[2 - 1]) {
						return 1;
					} else {
						return -1;
					}
				}
			});

			if (type == 1) {
				// Flip the array
				for (int i = 0; i < ret.length / 2; i++) {
					Object temp1 = ret[i][0];
					Object temp2 = ret[i][1];
					ret[i][0] = ret[ret.length - 1 - i][0];
					ret[i][1] = ret[ret.length - 1 - i][1];
					ret[ret.length - 1 - i][0] = (int) temp1;
					ret[ret.length - 1 - i][1] = (int) temp2;
				}
			}
			for (int i = 0; i < num; i++) {
				area.append(Main.workouts.get(0).getExercises()[ret[i][0]].getName());
				area.append(":\t ");
				area.append(((Integer) (ret[i][1])).toString());
				area.append("%\n");
			}
		}

		return;
	}

	protected static int getPerformance(int flag) {
		int ret = 0;
		int[][] all = getAllExerciseAverages(flag);
		for (int i = 0; i < Day.getMaxExercises(); i++) {
			ret += all[i][1];
		}
		ret = ret / Day.getMaxExercises();
		return ret;
	}

	protected static String getMeasureStart(int flag) {
		String ret = "";
		if (flag == 0) {
			if (Main.workouts.size() < MAX_DEPTH) {
				ret = Main.workouts.get(0).getDate().toString();
			} else {
				ret = Main.workouts.get(Main.workouts.size() - MAX_DEPTH).getDate().toString();
			}
		} else if (flag == 1) {
			int iDepth = MAX_DEPTH_DAYS;
			int iIndexOfBeginning = 0;
			LocalDate dDepth = Main.workouts.get((Main.workouts.size() - 1)).getDate().minusDays(iDepth);
			if (Main.workouts.get(0).getDate().isAfter(dDepth)) {
				ret = Main.workouts.get(0).getDate().toString();
			} else {
				while (true) {
					if (Main.workouts.get(iIndexOfBeginning).getDate().isAfter(dDepth)
							|| Main.workouts.get(iIndexOfBeginning).getDate().isEqual(dDepth)) {
						break;
					}
					iIndexOfBeginning++;
				}
				ret = Main.workouts.get(iIndexOfBeginning).getDate().toString();
			}
		}
		return ret;
	}
}
