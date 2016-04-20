package lab05;

import java.awt.Rectangle;

public class TextBox {

	private Rectangle box;
	private String text;

	public TextBox(Rectangle box, String text) {
		this.box = box;
		this.text = text;
	}

	public double getWidth() {
		return box.getWidth();
	}

	public double getHeight() {
		return box.getHeight();
	}

	public Rectangle getBox() {
		return box;
	}

	public void setBox(Rectangle box) {
		this.box = box;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getArea() {
		return box.width * box.height;
	}

}
