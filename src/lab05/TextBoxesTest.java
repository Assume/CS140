package lab05;

import java.awt.Rectangle;

import junit.framework.TestCase;

public class TextBoxesTest extends TestCase {

	public void testNull() {
		TextBoxes box = new TextBoxes(null);
		assertTrue(box.getRectangle() == null);
	}

	public void testEmpty() {
		TextBoxes box = new TextBoxes(new TextBox[0]);
		assertTrue(box.getRectangle() == null);
	}

	public void testFull() {

		Rectangle rec1 = new Rectangle(5, 10);
		Rectangle rec2 = new Rectangle(10, 15);
		Rectangle rec3 = new Rectangle(15, 20);
		String text1 = "Blah";
		String text2 = "Blahh";
		String text3 = "Blahhh";

		TextBox[] boxes = { new TextBox(rec1, text1), new TextBox(rec2, text2), new TextBox(rec3, text3) };
		TextBoxes tboxes = new TextBoxes(boxes);

		assertEquals(tboxes.getRectangle(), rec3);
	}
	
	public void testNullString() {
		TextBoxes box = new TextBoxes(null);
		assertTrue(box.getString() == null);
	}

	public void testEmptyString() {
		TextBoxes box = new TextBoxes(new TextBox[0]);
		assertTrue(box.getString() == null);
	}

	public void testFullString() {

		Rectangle rec1 = new Rectangle(5, 10);
		Rectangle rec2 = new Rectangle(10, 15);
		Rectangle rec3 = new Rectangle(15, 20);
		String text1 = "Blah";
		String text2 = "Blahh";
		String text3 = "Blahhh";

		TextBox[] boxes = { new TextBox(rec1, text1), new TextBox(rec2, text2), new TextBox(rec3, text3) };
		TextBoxes tboxes = new TextBoxes(boxes);

		assertEquals(tboxes.getString(), text3);
	}

}
