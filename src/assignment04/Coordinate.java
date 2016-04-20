package assignment04;

public class Coordinate implements Comparable<Coordinate> {

	private Meridional north_south;
	private Zonal east_west;
	private int m_degrees; // m for Meridional
	private int m_minutes;
	private int m_seconds;
	private int z_degrees; // z for Zonal
	private int z_minutes;
	private int z_seconds;

	public Coordinate(Meridional north_south, Zonal east_west, int m_degrees,
			int m_minutes, int m_seconds, int z_degrees, int z_minutes,
			int z_seconds) {
		this.north_south = north_south;
		this.east_west = east_west;
		this.m_degrees = m_degrees;
		this.m_minutes = m_minutes;
		this.m_seconds = m_seconds;
		this.z_degrees = z_degrees;
		this.z_minutes = z_minutes;
		this.z_seconds = z_seconds;
	}

	public int howMuchWest() {
		int total = this.z_seconds;
		total += (this.z_degrees * 3600) + (this.z_minutes * 60);
		return this.east_west == Zonal.WEST ? total : total * -1;
	}

	public int howMuchSouth() {
		int total = this.m_seconds;
		total += (this.m_degrees * 3600) + (this.m_minutes * 60);
		return this.north_south == Meridional.SOUTH ? total : total * -1;
	}

	public int compareTo(Coordinate arg0) {
		int dif = this.howMuchWest() - arg0.howMuchWest();
		if (dif != 0)
			return dif;
		else
			return this.howMuchSouth() - arg0.howMuchSouth();
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Coordinate && compareTo((Coordinate) obj) == 0;
	}

}
