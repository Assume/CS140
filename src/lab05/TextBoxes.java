package lab05;

import java.awt.Rectangle;

public class TextBoxes {

	private int next_int;

	private TextBox[] boxes;

	public TextBoxes(int n) {
		this.boxes = new TextBox[n];
	}

	public TextBoxes(int next_int, TextBox[] boxes) {
		this.next_int = next_int;
		this.boxes = boxes;

		if (boxes == null && next_int != 0)
			throw new IllegalArgumentException();
		if (next_int < 0 || (boxes != null && next_int > boxes.length))
			throw new IllegalArgumentException();
	}

	public TextBoxes(TextBox[] array) {
		this.boxes = array;
		if (boxes != null)
			this.next_int = this.boxes.length;
	}

	public boolean addBox(TextBox box) {
		if (next_int == this.boxes.length)
			return false;
		this.boxes[this.next_int++] = box;
		return true;
	}

	/**
	 * 
	 * @return the Rectangle contained in the TextBox with the longest text
	 */
	public Rectangle getRectangle() {
		if (boxes == null || boxes.length == 0)
			return null;
		int longest = 0;
		Rectangle largest = null;
		for (TextBox box : boxes) {
			int length = box.getText().length();
			if (length > longest) {
				longest = length;
				largest = box.getBox();
			}
		}
		return largest;
	}

	public String getString() {
		if (boxes == null || boxes.length == 0)
			return null;
		int longest = 0;
		String largest = null;
		for (TextBox box : boxes) {
			int length = box.getArea();
			if (length > longest) {
				longest = length;
				largest = box.getText();
			}
		}
		return largest;
	}

}
