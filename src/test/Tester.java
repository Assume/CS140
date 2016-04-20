package test;

import java.awt.Point;

public class Tester {

	public static void main(String[] args) {
		System.out.println(isPolygonSquare(p1));
	}

	static Point[] p = { new Point(3232, 3224), new Point(3232, 3220), new Point(3236, 3220), new Point(3236, 3224) };

	static Point[] p1 = { new Point(5, 5), new Point(5, 10), new Point(10, 5), new Point(10, 10) };

	public static int distance(Point p, Point p1) {
		return (int) Math.sqrt(Math.pow(p1.x - p.x, 2) + (Math.pow(p1.y - p.y, 2)));
	}

	public static boolean isPolygonSquare(Point[] array) {

		// we will check if it has atleast 4 points
		if (array.length < 4) {
			return false;
		}
		// we will now simply calculate the centre of the square.
		double totalX = 0;
		double totalY = 0;
		// I'm going to store them as seperate ints for future reference upon
		// expansion

		for (Point tile : array) {
			totalX = totalX + tile.getX();
			totalY = totalY + tile.getY();
		}

		// I'm assuming plane is 0 at this point, I'll edit this later
		Point centreTile = new Point((int) totalX / array.length, (int) totalY / array.length);

		// we are going to check if all points are equal to the same distance
		int distance = 0;
		for (Point tile : array) {
			if (distance != 0) {
				if (distance != distance(centreTile, tile)) {
					return false;
				}
			} else {
				distance = (int) distance(centreTile, tile);
			}
		}
		// return true since it surpassed all checks
		return true;
	}

}
