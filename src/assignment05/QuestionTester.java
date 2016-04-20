package assignment05;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionTester {

	@Test
	public void test1() {
		ChoiceQuestion q = new ChoiceQuestion("What is the value of 2");
		q.addChoice("1", false);
		q.addChoice("2", true);
		q.addChoice("3", false);
		assertTrue(q.checkAnswer("2"));
		assertFalse(q.checkAnswer("3"));
	}

	@Test
	public void test2() {
		MultichoiceQuestion third = new MultichoiceQuestion(
				"Which colleges are part of SUNY?");
		third.addChoice("Binghamton", true);
		third.addChoice("St. Bonaventure", false);
		third.addChoice("Stony Brook", true);
		third.addChoice("Elmira College", false);
		assertTrue(third.checkAnswer("1 3"));
		assertFalse(third.checkAnswer("1 3 4"));
	}

}
