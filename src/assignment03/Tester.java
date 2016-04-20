package assignment03;

public class Tester {

	public static void main(String[] args) {
		Elevator elev = new Elevator(15,5,10);
		System.out.println(elev.getFloorIndex("10") + " expected: 15");
		System.out.println(elev.getFloorIndex("B5") + " expected: 0");
		System.out.println(elev.getFloorIndex("G") + " expected: 5");
		System.out.println(elev.getFloorName(4) + " expected: B1");
		System.out.println(elev.getFloorName(0) + " expected: B5");
		System.out.println(elev.getFloorName(5) + " expected: G");
	}
	
}
