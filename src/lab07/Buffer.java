package lab07;

import java.io.IOException;
import java.util.List;

public class Buffer {

	protected List<String> lines;

	public int getNumLines() {
		return lines.size();
	}

	public String getText() {
		return String.join("\n", this.lines);
	}

	public void draw() {
		System.out.println(this.getText());
	}

	public void type(String toType) {
		for (char x : toType.toCharArray())
			if (x == '\n' || lines.size() == 0)
				lines.add("");
			else {
				lines.set(lines.size() - 1, lines.get(lines.size() - 1).concat("" + x));
			}

	}

	public void save() throws IOException {
		throw new UnsupportedOperationException();
	}

}
