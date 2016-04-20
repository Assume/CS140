package lab07;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ScratchBuffer extends Buffer {

	public ScratchBuffer() {
		super.lines = new ArrayList<String>();
	}

	public void save() throws IOException {
		Path path = FileSystems.getDefault().getPath("scratch");
		Files.write(path, lines, Charset.defaultCharset());
	}

	
	
}
