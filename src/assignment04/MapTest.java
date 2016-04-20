package assignment04;

import java.util.Collections;

public class MapTest {
	public static void main(String[] args) {
		TownList towns = new TownList();
		towns.add(new Town("Lima", "Peru", Meridional.SOUTH, Zonal.WEST, 12, 2,
				36, 77, 1, 30));
		towns.add(new Town("Williamsport, PA", "USA", Meridional.NORTH,
				Zonal.WEST, 41, 14, 40, 77, 1, 30));
		towns.add(new Town("London", "UK", Meridional.NORTH, Zonal.WEST, 51,
				30, 26, 0, 7, 39));
		towns.add(new Town("Valencia", "Spain", Meridional.NORTH, Zonal.WEST,
				39, 28, 0, 0, 23, 0));
		towns.add(new Town("Mumbai", "India", Meridional.NORTH, Zonal.EAST, 18,
				58, 30, 72, 49, 33));
		towns.add(new Town("Beijing", "China", Meridional.NORTH, Zonal.EAST,
				39, 55, 0, 116, 23, 0));
		towns.add(new Town("Valencia", "Spain", Meridional.NORTH, Zonal.WEST,
				39, 28, 0, 0, 23, 0));
		towns.add(new Town("Christchurch", "New Zealand", Meridional.SOUTH,
				Zonal.EAST, 43, 31, 48, 172, 37, 13));
		towns.add(new Town("Aberdeen", "Scotland", Meridional.NORTH,
				Zonal.WEST, 57, 9, 0, 2, 9, 0));
		towns.add(new Town("Athens", "Greece", Meridional.NORTH,
				Zonal.EAST, 37, 58, 0, 23, 43, 0));
		towns.add(new Town("Berlin", "Germany", Meridional.NORTH,
				Zonal.EAST, 52, 30, 0, 13, 25, 0));
		towns.add(new Town("Birmingham", "England", Meridional.NORTH,
				Zonal.WEST, 52, 25, 0, 1, 55, 0));
		towns.add(new Town("Lyons", "France", Meridional.NORTH,
				Zonal.EAST, 45, 45, 0, 4, 50, 0));
		towns.add(new Town("Rio De Janeiro", "Brazil", Meridional.SOUTH,
				Zonal.WEST, 22, 57, 0, 43, 12, 0));
		towns.add(new Town("Tripoli", "Libya", Meridional.NORTH,
				Zonal.EAST, 32, 57, 0, 13, 12, 0));
		towns.add(new Town("Wellington", "New Zealand", Meridional.SOUTH,
				Zonal.EAST, 41, 17, 0, 174, 47, 0));
		towns.add(new Town("Venice", "Italy", Meridional.NORTH,
				Zonal.EAST, 45, 26, 0, 12, 20, 0));
		towns.add(new Town("Zurich", "Switzerland", Meridional.NORTH,
				Zonal.EAST, 47, 21, 0, 8, 31, 0));
		Collections.sort(towns);
		System.out.println(towns);
	}
}