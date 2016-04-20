package assignment03;

public class Passenger {

	private String destination_floor;
	private int id;

	private static int next_id = 0;

	public Passenger(String destination_floor, Elevator elevator) {
		if (destination_floor == null) {
			throw new IllegalArgumentException("Cannot give null arguments");
		}
		int dest = elevator.getFloorIndex(destination_floor);
		if (dest < 0)
			dest = 0;
		if (dest > elevator.getNumFloors())
			dest = elevator.getNumFloors() - 1;
		this.destination_floor = elevator.getFloorName(dest);
		this.id = ++next_id;
	}

	public int getId() {
		return id;
	}

	public String getDesitinationFloor() {
		return this.destination_floor;
	}

	@Override
	public String toString() {
		return "" + id;
	}

}
