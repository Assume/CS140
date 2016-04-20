package assignments.hw01;

public class Person {

	private String last_name;
	private String first_name;
	private char middle_initial;

	public Person(String last_name, String first_name, char middle_initial) {
		this.last_name = last_name;
		this.first_name = first_name;
		this.middle_initial = middle_initial;
	}

	public String getLastName() {
		return last_name;
	}

	public String getFirstName() {
		return first_name;
	}

	public char getMiddleInitial() {
		return middle_initial;
	}

	@Override
	public String toString() {
		return this.first_name + " " + this.middle_initial + ". "
				+ this.last_name;
	}

}
