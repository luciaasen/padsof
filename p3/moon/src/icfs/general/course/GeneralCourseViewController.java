/**
 * 
 */
package icfs.general.course;

import javax.swing.event.TreeSelectionListener;

import moon.course.Course;
import moon.user.User;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public abstract class GeneralCourseViewController implements TreeSelectionListener {
	protected User u;
	protected Course c;
	
	
	public void setEverything(User u, Course c){
		this.u=u;
		this.c=c;
	}
}
