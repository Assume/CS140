package assignments.hw01;

public class Class {

	public static final Class DUMMY_CLASS = new Class("Dummy", "000", 0, 0);

	private String name;
	private String number;
	private int num_credits;
	private int crn;
	private double qual_points;

	public Class(String name, String number, int num_credits, int crn) {
		this.name = name;
		this.number = number;
		this.num_credits = num_credits;
		this.crn = crn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getNumCredits() {
		return num_credits;
	}

	public void setNumCredits(int num_credits) {
		this.num_credits = num_credits;
	}

	public int getCrn() {
		return crn;
	}

	public void setCrn(int crn) {
		this.crn = crn;
	}

	public double getQualPoints() {
		return qual_points;
	}

	public void setQualPoints(double qual_points) {
		this.qual_points = qual_points;
	}

}
