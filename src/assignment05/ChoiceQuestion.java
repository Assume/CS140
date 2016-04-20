package assignment05;
import java.util.ArrayList;

/**
 * A question with multiple choices.
 * @author modified from Horstmann "Big Java"
 */
public class ChoiceQuestion extends Question {

	private ArrayList<String> choices = new ArrayList<>();

	public ChoiceQuestion(String questionText) {
		super(questionText);
	}

	/**
      Adds an answer choice to this question.
      @param choice the choice to add
      @param correct true if this is the correct choice, false otherwise
	 */
	public void addChoice(String choice, boolean correct) {
		choices.add(choice);
		if (correct) {
			// Convert choices.size() to string
			String choiceString = "" + choices.size();
			setAnswer(choiceString);
		}
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
}