package assignment04;

import java.util.ArrayList;

public class TownListTester {

	static Town t1 = new Town("Lima", "Peru", Meridional.SOUTH, Zonal.WEST, 12,
			2, 36, 77, 1, 30);
	static Town t2 = new Town("Williamsport, PA", "USA", Meridional.NORTH,
			Zonal.WEST, 41, 14, 40, 77, 1, 30);
	static Town t3 = new Town("London", "UK", Meridional.NORTH, Zonal.WEST, 51,
			30, 26, 0, 7, 39);
	static Town t4 = new Town("Valencia", "Spain", Meridional.NORTH,
			Zonal.WEST, 39, 28, 0, 0, 23, 0);
	static Town t5 = new Town("Mumbai", "India", Meridional.NORTH, Zonal.EAST,
			18, 58, 30, 72, 49, 33);

	static Town t6 = null;

	public static void main(String[] args) {
		TownList list = new TownList();
		ArrayList<Town> towns = new ArrayList<Town>();
		towns.add(t1);
		towns.add(t2);
		towns.add(t3);

		System.out.println("Except value: true, actual: " + list.add(t1));
		System.out.println("Except value: false, actual: " + list.add(t1));
		System.out.println("Previous size: " + list.size()
				+ " before calling add(index, element), expected after = 2");
		list.add(1, t4);
		System.out.println("Size after calling add(index, element): "
				+ list.size());
		System.out.println("Size before calling addAll(collection): "
				+ list.size() + ", expected: 4");
		list.addAll(towns);
		System.out.println("Size after calling addAll(collection): "
				+ list.size());
		list.add(t5);
		System.out.println("Size before calling addAll(index, collection): "
				+ list.size() + ", expected: 5");
		list.addAll(4, towns);
		System.out.println("Size after calling addAll(index, collection): "
				+ list.size());

		try {
			list.add(t6);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

}
