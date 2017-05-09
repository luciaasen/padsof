/**
 * 
 */
package icfs.student.main;

import java.util.ArrayList;

import moon.Academy;
import moon.course.Course;
import moon.user.Student;

/**
 * Controller of the student's view of the main panel.
 * @author Juan Riera Gomez and Lucia Asencio
 *
 */
public class MainStudentController {
	
	Student s;
	/**
	 * Get's all the courses of moon.
	 * @return
	 */
	public ArrayList<Course> getAllCourses(){
		return Academy.getMoonApp().getCourses();
	}
	
	/**
	 * Gets the courses of the students.
	 * @return
	 */
	public ArrayList<Course> getStudentCourses(){
		return s.getCourses();
	}
	
	/**
	 * Gets an array of the stats in this order:
	 * Average
	 * Calculation of the maximum
	 * Calculation of the minimum
	 * @return
	 */
	public double[] getStats(){
		return new double[]{s.calcAverage(), s.calcMaximum(), s.calcMaximum()};
	}
	
	/**
	 * Sets everything to match the parameter.
	 * @param student
	 */
	public void setEverything(Student student){
		s=student;
	}
}
