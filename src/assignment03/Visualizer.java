package assignment03;

import java.util.List;

public class Visualizer {

	public static void showElev(Elevator e) {
		for (int i = e.getNumFloors() - 1; i >= 0; i--) {
			if (i == e.getCurrentFloor()) {

				Line line = e.getLines().get(i);
				String blah = "";
				if (line != null) {
					List<Passenger> list = line.getLine();
					blah += list;
				}
				System.out.println(e.getFloorName(i) + "\t\t"
						+ e.getNumOccupants() + "\t\t" + blah);
			} else {
				Line line = e.getLines().get(i);
				String blah = "";
				if (line != null) {
					List<Passenger> list = line.getLine();
					blah += list;
				}
				System.out.println(e.getFloorName(i) + "\t\t0\t\t"+blah);
			}
		}
		System.out.println("+++++++++++++++++++++");
	}

	public static void main(String[] args) {
		Elevator elevator = new Elevator(15, 5, 10);
		Line line = new Line("G", elevator);
		line.getLine().add(new Passenger("7", elevator));
		line.getLine().add(new Passenger("7", elevator));
		line.getLine().add(new Passenger("7", elevator));
		line.getLine().add(new Passenger("7", elevator));
		line.getLine().add(new Passenger("7", elevator));
		line.getLine().add(new Passenger("7", elevator));
		line.getLine().add(new Passenger("3", elevator));
		line.getLine().add(new Passenger("3", elevator));
		line.getLine().add(new Passenger("3", elevator));
		line.getLine().add(new Passenger("B3", elevator));
		
		Line line1 = new Line("5", elevator);
		line1.getLine().add(new Passenger("B3", elevator));
		line1.getLine().add(new Passenger("B3", elevator));
		line1.getLine().add(new Passenger("8", elevator));
		line1.getLine().add(new Passenger("9", elevator));
		line1.getLine().add(new Passenger("6", elevator));
		line1.getLine().add(new Passenger("5", elevator));
		line1.getLine().add(new Passenger("4", elevator));
		line1.getLine().add(new Passenger("3", elevator));
		line1.getLine().add(new Passenger("2", elevator));
		line1.getLine().add(new Passenger("3", elevator));
		line1.getLine().add(new Passenger("B4", elevator));
		line1.getLine().add(new Passenger("B5", elevator));
		line1.getLine().add(new Passenger("B3", elevator));
		showElev(elevator);
		line.loadElevator();
		for (int i = 0; i < 100; i++) {
			showElev(elevator);
			elevator.move();
		}
	}

}
