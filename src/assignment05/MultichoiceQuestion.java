package assignment05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MultichoiceQuestion extends Question {

	private List<String> choices = new ArrayList<String>();
	private List<Integer> correct_choices = new ArrayList<Integer>();

	public MultichoiceQuestion(String questionText) {
		super(questionText);
	}

	public void addChoice(String choice, boolean correct) {
		choices.add(choice);
		if (correct)
			correct_choices.add(choices.size());
	}

	@Override
	public void display() {
		// Display the question text
		super.display();
		// Display the answer choices
		for (int i = 0; i < choices.size(); i++) {
			int choiceNumber = i + 1;
			System.out.println(choiceNumber + ": " + choices.get(i));
		}
	}

	@Override
	public String prompt() {
		return "Your answers (if more than one, separate answers by spaces): ";
	}

	@Override
	public boolean checkAnswer(String answer) {
		Set<Integer> answers = new HashSet<>();
		int correct = 0;
		int wrong = 0;
		try (Scanner scan = new Scanner(answer)) {
			while (scan.hasNextInt()) {
				int ans = scan.nextInt();
				answers.add(ans);
			}
		}
		for (Integer x : answers)
			if (correct_choices.contains(x))
				correct++;
			else
				wrong++;
		boolean value = correct == correct_choices.size() && wrong == 0;
		if (!value)
			System.out.println("Correct: " + correct + ", Incorrect: " + wrong);
		return value;
	}

}
