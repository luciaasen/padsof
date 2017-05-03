/**
 * 
 */
package icfs.student.main;

import java.util.ArrayList;

import moon.Academy;
import moon.course.Course;
import moon.user.Student;

/**
 * @author Juan Riera Gomez and Lucia Asencio
 *
 */
public class MainStudentController {
	
	private Student s;
	
	public ArrayList<Course> getAllCourses(){
		return Academy.getMoonApp().getCourses();
	}
	
	public ArrayList<Course> getStudentCourses(){
		return s.getCourses();
	}
	
	public void setEverything(Student student){
		s=student;
	}
}
