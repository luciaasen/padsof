/**
 * 
 */
package icfs.student.stats;

import icfs.teacher.stats.TeacherCourseStatsController;
import moon.course.Course;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class StudentCourseStatsController  {

	StudentCourseStats view;
	Student s;
	Course c;
	/**
	 * @param studentCourseStats
	 */
	public StudentCourseStatsController(StudentCourseStats studentCourseStats) {
		this.view = view;
	}
	
	public void setEverything(Student s, Course c){
		this.s=s;
		this.c=c;
	}
}
