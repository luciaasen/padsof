package moon.course;

import java.util.ArrayList;
import moon.user.*;
import moon.mark.*;

public class Course {
	private ArrayList<Unit> units;
	private ArrayList<Student> students;
	private ArrayList<Student> expStudents;
	private ArrayList<MCourse> studentMarks;
	private String name;
	
	/**
	 * Course Students getter
	 * @return
	 */
	public ArrayList<Student> getStudents(){
		return this.students;
	}
}
