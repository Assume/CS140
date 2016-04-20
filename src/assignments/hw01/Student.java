package assignments.hw01;

public class Student {

	private Person self;

	private Class class1 = Class.DUMMY_CLASS;
	private Class class2 = Class.DUMMY_CLASS;
	private Class class3 = Class.DUMMY_CLASS;
	private Class class4 = Class.DUMMY_CLASS;

	public Student(Person self) {
		this.self = self;
	}

	public void setQualPoints1(double qual_points) {
		this.class1.setQualPoints(qual_points);
	}

	public void setQualPoints2(double qual_points) {
		this.class2.setQualPoints(qual_points);
	}

	public void setQualPoints3(double qual_points) {
		this.class3.setQualPoints(qual_points);
	}

	public void setQualPoints4(double qual_points) {
		this.class4.setQualPoints(qual_points);
	}

	public String getName() {
		return this.self.toString();
	}

	public Class getClass1() {
		return class1;
	}

	public void setClass1(Class class1) {
		this.class1 = class1;
	}

	public Class getClass2() {
		return class2;
	}

	public void setClass2(Class class2) {
		this.class2 = class2;
	}

	public Class getClass3() {
		return class3;
	}

	public void setClass3(Class class3) {
		this.class3 = class3;
	}

	public Class getClass4() {
		return class4;
	}

	public void setClass4(Class class4) {
		this.class4 = class4;
	}

	public double computeSemesterGPA() {
		double total_points = class1.getQualPoints() + class2.getQualPoints()
				+ class3.getQualPoints() + class4.getQualPoints();
		int total_credits = class1.getNumCredits() + class2.getNumCredits()
				+ class3.getNumCredits() + class4.getNumCredits();
		return total_credits > 0 ? (total_points / total_credits) * 4 : 0;
	}

}
