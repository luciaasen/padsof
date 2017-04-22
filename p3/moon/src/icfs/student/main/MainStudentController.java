/**
 * 
 */
package icfs.student.main;

import java.util.ArrayList;

import moon.Academy;
import moon.course.Course;

/**
 * @author juan
 *
 */
public class MainStudentController {
	public static ArrayList<Course> getAllCourses(){
		
		return Academy.getMoonApp().getCourses();
	}
}
