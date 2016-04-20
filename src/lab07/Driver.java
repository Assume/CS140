package lab07;

public class Driver {

	public static void main(String[] args) {
		Buffer buffer;
		if (args.length > 0)
			buffer = new FileBuffer(args[0]);
		else
			buffer = new ScratchBuffer();
		Editor edit = new Editor(buffer);
		edit.type("blah");
		edit.type("blah");
		edit.draw();
		edit.save();
	}

}
