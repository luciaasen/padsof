/**
 * 
 */
package icfs.teacher.course;

import icfs.general.course.GeneralCourseView;
import icfs.teacher.course.TeacherCourseViewController;

/**
 * @author juan
 *
 */
public class TeacherCourseView extends GeneralCourseView {
	
	public TeacherCourseView(){
		super();
		controller = new TeacherCourseViewController(this);
		getTree().addMouseListener(controller);
	}
}