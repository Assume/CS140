package lab07;

import java.io.IOException;

public class Editor {

	private Buffer buffer;

	private StatusBar status_bar;

	public Editor(Buffer buffer) {
		this.buffer = buffer;
		this.status_bar = new StatusBar(buffer);
	}

	public void draw() {
		this.buffer.draw();
		this.status_bar.draw();
	}

	public void save() {
		try {
			this.buffer.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void type(String arg) {
		this.buffer.type(arg);
	}

}
