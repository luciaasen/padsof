/**
 * 
 */
package icfs.student.main;

import java.util.ArrayList;

import moon.Academy;
import moon.course.Course;

/**
 * @author Juan Riera Gomez and Lucia Asencio
 *
 */
public class MainStudentController {
	public static ArrayList<Course> getAllCourses(){
		return Academy.getMoonApp().getCourses();
	}
}
