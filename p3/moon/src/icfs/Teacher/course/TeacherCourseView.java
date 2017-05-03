/**
 * 
 */
package icfs.Teacher.course;

import icfs.general.course.GeneralCourseView;
import icfs.Teacher.course.TeacherCourseViewController;

/**
 * @author juan
 *
 */
public class TeacherCourseView extends GeneralCourseView {
	
	public TeacherCourseView(){
		super();
		controller = new TeacherCourseViewController(this);
		getTree().addTreeSelectionListener(controller);
	}


}