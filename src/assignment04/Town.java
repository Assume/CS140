package assignment04;

public class Town implements Comparable<Town> {

	private String name;
	private String country;
	private Coordinate coordinates;

	public Town(String name, String country, Meridional north_south,
			Zonal east_west, int m_degrees, int m_minutes, int m_seconds,
			int z_degrees, int z_minutes, int z_seconds) {

		this.name = name;
		this.country = country;
		this.coordinates = new Coordinate(north_south, east_west, m_degrees,
				m_minutes, m_seconds, z_degrees, z_minutes, z_seconds);

	}

	public int compareTo(Town arg0) {
		return this.coordinates.compareTo(arg0.coordinates);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Town
				&& coordinates.equals(((Town) obj).coordinates);
	}

	@Override
	public String toString() {
		return name + ", " + country;
	}

}
