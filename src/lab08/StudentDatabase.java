package lab08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class StudentDatabase {

	private List<Student> students = new ArrayList<Student>();
	
	public void add(Student student){
		this.students.add(student);
	}
	
	public Stream<Student> stream(){
		return students.stream();
	}
	
	
	
}
