package assignment06;

import java.util.List;

public class CourseOffering {

	private String name;
	private String title;
	private int semester;
	private List<String> annotations;

	public CourseOffering(String name, String title, int semester, List<String> annotations) {
		this.name = name;
		this.title = title;
		this.semester = semester;
		this.annotations = annotations;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public int getSemester() {
		return semester;
	}

	public List<String> getAnnotations() {
		return annotations;
	}

}
