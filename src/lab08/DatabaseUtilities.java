package lab08;

import java.util.Comparator;
import java.util.stream.DoubleStream;

public class DatabaseUtilities {

	/**
	 * Determines number of students in db
	 * 
	 * @param db
	 *            the database to operate on
	 * @return number of students in db
	 */
	public static long numStudents(StudentDatabase db) {
		return db.stream().count();
	}

	/**
	 * Determines maximum GPA in db
	 * 
	 * @param db
	 *            the database to operate on
	 * @return 0 if db is empty, otherwise, maximum GPA over db
	 */
	public static double maxGPA(StudentDatabase db) {
		DoubleStream stream = db.stream().mapToDouble(d -> d.getGPA());
		return stream.max().orElse(0);
	}

	/**
	 * Determines average GPA in db
	 * 
	 * @param db
	 *            the database to operate on
	 * @return 0 if db is empty, otherwise, average GPA over db
	 */
	public static double averageGPA(StudentDatabase db) {
		DoubleStream stream = db.stream().mapToDouble(d -> d.getGPA());
		return stream.average().orElse(0);
	}

	/**
	 * Determines number of students whose GPA is above threshold
	 * 
	 * @param db
	 *            the database to operate on
	 * @param threshold
	 *            threshold a GPA must be above
	 * @return number of students whose GPA is above threshold
	 */
	public static long numGPAAbove(StudentDatabase db, double threshold) {
		DoubleStream stream = db.stream().mapToDouble(d -> d.getGPA());
		return stream.filter(d -> d > threshold).count();
	}

	/**
	 * Sorts db according to comp, then prints the students
	 * 
	 * @param db
	 *            the database to operate on
	 * @param comp
	 *            the comparator to use to compare two Students
	 */
	public static void sortAndPrint(StudentDatabase db, Comparator<Student> comp) {
		db.stream().sorted(comp).forEach(s -> System.out.println(s));

	}
}
