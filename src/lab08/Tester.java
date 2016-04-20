package lab08;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Tester {

	Student s1;
	Student s2;
	Student s3;
	Student s4;

	StudentDatabase sb;

	@Before
	public void setup() {
		s1 = new Student("Bob", "Rob", 2014, 3.75, 256798, 36);
		s2 = new Student("Dan", "Hen", 2013, 2.75, 259316, 64);
		s3 = new Student("Fred", "Sty", 2012, 4.00, 396618, 95);
		s4 = new Student("Rob", "Org", 2011, 3.15, 556281, 124);
		sb = new StudentDatabase();
		sb.add(s1);
		sb.add(s2);
		sb.add(s3);
		sb.add(s4);
	}

	@Test
	public void testNumStudents() {
		assertEquals(DatabaseUtilities.numStudents(sb), 4);
	}

	@Test
	public void testMaxGPA() {
		assertEquals(DatabaseUtilities.maxGPA(sb), 4.0, .000001);
	}

	@Test
	public void testAverageGPA() {
		assertEquals(DatabaseUtilities.averageGPA(sb), 3.4125, .01);
	}

	@Test
	public void testNumGPAABove() {
		assertEquals(DatabaseUtilities.numGPAAbove(sb, 3.0), 3, .01);
	}

}
