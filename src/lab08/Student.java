package lab08;

public class Student {

	private String first_name;
	private String last_name;
	private int year_enrolled;
	private double GPA;
	private int b_number;
	private int num_credits;

	public Student(String first_name, String last_name, int year_enrolled, double GPA, int b_number, int num_credits) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.year_enrolled = year_enrolled;
		this.GPA = GPA;
		this.b_number = b_number;
		this.num_credits = num_credits;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public int getYearEnrolled() {
		return year_enrolled;
	}

	public void setYearEnrolled(int year_enrolled) {
		this.year_enrolled = year_enrolled;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public int getBNumber() {
		return b_number;
	}

	public void setBNumber(int b_number) {
		this.b_number = b_number;
	}

	public int getNumCredits() {
		return num_credits;
	}

	public void setNumCredits(int num_credits) {
		this.num_credits = num_credits;
	}

	@Override
	public String toString() {
		return this.first_name + " " + this.last_name + " " + this.year_enrolled + " " + this.GPA + " " + this.b_number
				+ " " + this.num_credits;
	}

}
