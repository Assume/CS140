package assignment03;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

	private int current_floor;
	private int ground_floor;
	private int capacity;
	private int num_floors;

	private List<Passenger> occupants = new ArrayList<Passenger>();
	private List<Line> lines = new ArrayList<Line>();

	private Direction current_direction = Direction.UP;

	public Elevator(int num_floors, int ground_floor, int capacity) {
		this.capacity = capacity;
		this.num_floors = num_floors;
		this.ground_floor = ground_floor;
		this.current_floor = ground_floor;
		for (int i = 0; i < num_floors; i++)
			lines.add(null);
	}

	public int getNumFloors() {
		return this.num_floors;
	}

	public int getCurrentFloor() {
		return this.current_floor;
	}

	public List<Line> getLines() {
		return this.lines;
	}

	public int getNumOccupants() {
		return occupants.size();
	}

	public Direction getCurrentDirection() {
		return this.current_direction;
	}

	public String getFloorName(int index) {
		if (index < 0 || index >= num_floors)
			throw new IllegalArgumentException("Illegal floor number");
		if (index == ground_floor)
			return "G";
		else if (index < ground_floor)
			return "B" + (ground_floor - index);
		else
			return "" + (index - ground_floor + 1);
	}

	/**
	 * returns the index of the floor from the name
	 * 
	 * @param <name>
	 *            Used to find the index of passed floor name
	 * @return int index of the floor
	 */
	public int getFloorIndex(String floor) {
		if (floor.equalsIgnoreCase("G"))
			return ground_floor;
		else if (floor.startsWith("B"))
			return Integer.parseInt(floor.substring(1)) - ground_floor;
		else
			return Integer.parseInt(floor) +ground_floor;
	}

	public boolean addOccupants(Passenger p) {
		if (occupants.size() < capacity)
			return occupants.add(p);
		return false;
	}

	public void addLine(String floor, Line line) {
		int index = getFloorIndex(floor);
		lines.set(index, line);
	}

	/**
	 * Moves the elevator and loads and unloads
	 */
	public void move() {
		if (this.current_direction == Direction.UP
				&& this.current_floor < (num_floors - 1))
			this.current_floor++;
		else if (this.current_direction == Direction.UP
				&& this.current_floor == (num_floors - 1)) {
			this.current_direction = Direction.DOWN;
			this.current_floor--;
		} else if (this.current_direction == Direction.DOWN
				&& this.current_floor > 0)
			this.current_floor--;
		else if (this.current_direction == Direction.DOWN
				&& this.current_floor == 0) {
			this.current_direction = Direction.UP;
			this.current_floor++;
		}

		Passenger[] temp = occupants.toArray(new Passenger[occupants.size()]);
		for (Passenger p : temp)
			if (this.getFloorIndex(p.getDesitinationFloor()) == current_floor)
				occupants.remove(p);
		Line line = lines.get(current_floor);
		if (line != null)
			line.loadElevator();
	}

}
