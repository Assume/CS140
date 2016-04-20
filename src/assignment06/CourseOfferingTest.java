package assignment06;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CourseOfferingTest {

	@Test
	public void test1() {
		CourseOffering[] o1 = { new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("W", "J", "C")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("W")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C", "J", "A")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C")) };
		DegreeAudit a1 = new HarpurAudit();
		assertTrue(a1.hasWritingSatisfied(Arrays.asList(o1)));
	}

	@Test
	public void test2() {
		CourseOffering[] o1 = { new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("W", "J", "C")),
				new CourseOffering("CS301", "Blahblah", 201610, Arrays.asList("C")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("W")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C", "J", "A")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C")) };
		DegreeAudit a1 = new CSAudit();
		assertTrue(a1.hasWritingSatisfied(Arrays.asList(o1)));
	}

	@Test
	public void test3() {
		CourseOffering[] o1 = { new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("A", "B", "C")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("D")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("E")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("F", "A")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C")) };
		DegreeAudit a1 = new SOMAudit();
		assertTrue(a1.hasWritingSatisfied(Arrays.asList(o1)));
	}

	@Test
	public void test4() {
		CourseOffering[] o1 = { new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("A", "B", "C")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("D")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("E")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("F", "A")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("F")) };
		DegreeAudit a1 = new SOMAudit();
		assertFalse(a1.hasWritingSatisfied(Arrays.asList(o1)));
	}

	@Test
	public void test5() {
		CourseOffering[] o1 = { new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("A", "B", "J")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("D")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("E")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("J", "A")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("F")) };
		DegreeAudit a1 = new SOMAudit();
		assertTrue(a1.hasWritingSatisfied(Arrays.asList(o1)));
	}

	@Test
	public void test6() {
		CourseOffering[] o1 = { new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C", "B", "J")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("J", "W")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("W")) };
		DegreeAudit a1 = new HarpurAudit();
		assertTrue(a1.hasWritingSatisfied(Arrays.asList(o1)));
	}

	@Test
	public void test7() {
		CourseOffering[] o1 = { new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C", "B", "J")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("A")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("J", "W")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("W")) };
		DegreeAudit a1 = new HarpurAudit();
		assertFalse(a1.hasWritingSatisfied(Arrays.asList(o1)));
	}

	@Test
	public void test8() {
		CourseOffering[] o1 = { new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("W", "J", "C")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("W")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C", "J", "A")),
				new CourseOffering("Blah", "Blahblah", 201610, Arrays.asList("C")) };
		DegreeAudit a1 = new CSAudit();
		assertFalse(a1.hasWritingSatisfied(Arrays.asList(o1)));
	}

}
