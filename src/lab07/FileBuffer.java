package lab07;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileBuffer extends Buffer {

	private String field;

	public FileBuffer(String field) {
		this.field = field;
		Path path = Paths.get(field);
		System.out.println(path.toString());
		try {
			super.lines = Files.readAllLines(path);
		} catch (IOException e) {
			super.lines = new ArrayList<String>();
			e.printStackTrace();
		}
	}

	public void save() throws IOException {
		Path path = FileSystems.getDefault().getPath(field);
		Files.write(path, lines, Charset.defaultCharset());
	}
	
	
	

}
