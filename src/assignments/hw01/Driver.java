package assignments.hw01;

public class Driver {

	public static void main(String[] args) {
		Person p1 = new Person("Bob", "Bobbity", 'B');
		Person p2 = new Person("Cob", "Cobbity", 'C');
		Person p3 = new Person("Dob", "Dobbity", 'D');

		Student s1 = new Student(p1);
		Student s2 = new Student(p2);
		Student s3 = new Student(p3);

		Class class1 = new Class("Qwr", "001", 4, 0);
		Class class2 = new Class("Qwt", "002", 4, 0);
		Class class3 = new Class("Qwy", "003", 4, 0);
		Class class4 = new Class("Qwu", "004", 4, 0);
		Class class5 = new Class("Qwi", "005", 4, 0);
		Class class6 = new Class("Qwo", "006", 4, 0);
		Class class7 = new Class("Qwp", "007", 4, 0);
		

		s2.setClass1(class1);
		s2.setClass2(class2);
		s2.setClass3(class3);
		s3.setClass1(class4);
		s3.setClass2(class5);
		s3.setClass3(class6);
		s3.setClass4(class7);
		class1.setQualPoints(4);
		class2.setQualPoints(3.3);
		class3.setQualPoints(2.0);
		class4.setQualPoints(3.3);
		class5.setQualPoints(3.7);
		class6.setQualPoints(4);
		class7.setQualPoints(4);
		
		System.out.println("S1: "+s1.computeSemesterGPA() + " ev: "+0);
		System.out.println("S2: "+s2.computeSemesterGPA() + " ev: "+3.1);
		System.out.println("S3: "+s3.computeSemesterGPA() + " ev: 3.75");
		

	}

}
