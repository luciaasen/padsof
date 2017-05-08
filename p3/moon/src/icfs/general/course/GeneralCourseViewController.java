/**
 * 
 */
package icfs.general.course;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.TreeSelectionListener;

import main.mainMoon;
import moon.course.Course;
import moon.user.Student;
import moon.user.User;

/**
 * Controller of the buttons in a course view
 * @author Juan Riera and Lucia Asencio
 *
 */
public abstract class GeneralCourseViewController implements MouseListener {
	protected User u;
	protected Course c;
	
	
	public void setEverything(User u, Course c){
		this.u=u;
		this.c=c;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	public void changeToStudentsList(){
		mainMoon.changeCard(mainMoon.LIST_STUDENTS);
	}
	
	public void changeToStatistics(){
		mainMoon.teacherCourseStatsSetEverything(c);
		mainMoon.changeCard(mainMoon.TEACHER_COURSE_STATS);
	}

	/**
	 * @return
	 */
	public void changeToApplications() {
		mainMoon.applicationsSetEverything(c);
		mainMoon.changeCard(mainMoon.APPLICATIONS);
	}

}
