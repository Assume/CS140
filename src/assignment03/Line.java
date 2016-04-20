package assignment03;

import java.util.ArrayList;
import java.util.List;

public class Line {

	private String floor;
	private List<Passenger> line = new ArrayList<Passenger>();

	private Elevator elevator;

	public Line(String floor, Elevator elevator) {
		this.floor = floor;
		this.elevator = elevator;
		this.elevator.addLine(this.floor, this);
	}

	public List<Passenger> getLine() {
		return this.line;
	}

	public void loadElevator() {
		Passenger[] temp = line.toArray(new Passenger[line.size()]);
		int this_floor = elevator.getFloorIndex(this.floor);
		if (elevator.getCurrentDirection() == Direction.UP) {
			for (Passenger p : temp)
				if (elevator.getFloorIndex(p.getDesitinationFloor()) > this_floor)
					if (elevator.addOccupants(p))
						line.remove(p);
		} else
			for (Passenger p : temp)
				if (elevator.getFloorIndex(p.getDesitinationFloor()) < this_floor)
					if (elevator.addOccupants(p))
						line.remove(p);
	}

}
