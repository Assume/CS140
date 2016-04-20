package assignment05;

import java.util.Scanner;

/**
 * A question with a text and an answer.
 * @author modified from Horstmann "Big Java"
 */
public class Question {
	private String text = "";
	private String answer = "";

	/**
	 * Construct a Question with the specified text
	 * @param questionText the text of this question
	 */
	public Question(String questionText) {
		text = questionText;
	}

	/**
	 * Sets the answer for this question.
	 * @param correctResponse the answer
	 */
	public void setAnswer(String correctResponse) {
		answer = correctResponse;
	}

	/**
	 * Checks a given response for correctness.
	 * @param response the response to check
	 * @return true if the response was correct, false otherwise
	 */
	public boolean checkAnswer(String response) {
		return response.equals(answer);
	}

	/**
	 * Displays this question.
	 */
	public void display() {
		System.out.println(text);
	}
	
	/**
	 * The prompt to show after presenting the question. The basic
	 * case is: "Your answer: " but it can be overridden.
	 * @return the prompt to show in presentQuestion
	 */
	public String prompt() {
		return "Your answer: ";
	}

	/**
	 * So called "template method" in Design Pattern
	 * terminology. The exact behavior depends on 
	 * dynamic dispatching of "display" and "check answer."
	 * Presents a question to the user and checks the response. 
	 */
	public void presentQuestion() {
		display();
		System.out.print(prompt());
		// important: accept the warning otherwise the 
		// program will break because in.close() 
		// will close all keyboard input to the program
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		System.out.println(checkAnswer(response));
	}
}