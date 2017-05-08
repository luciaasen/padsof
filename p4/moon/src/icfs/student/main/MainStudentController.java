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
	
	Student s;
	
	public ArrayList<Course> getAllCourses(){
		return Academy.getMoonApp().getCourses();
	}
	
	public ArrayList<Course> getStudentCourses(){
		return s.getCourses();
	}
	
	public double[] getStats(){
		return new double[]{s.calcAverage(), s.calcMaximum(), s.calcMaximum()};
	}
	
	public void setEverything(Student student){
		s=student;
	}
}
