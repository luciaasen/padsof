/**
 * 
 */
package icfs.student.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.mainMoon;
import moon.course.Course;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentSelectCourseStatsController  implements MouseListener {
	Student s;
	StudentSelectCourseStatsPanel view;
	
	StudentSelectCourseStatsController(StudentSelectCourseStatsPanel view){
		this.view = view;
	}
	public void setEverything(Student s){
		this.s = s;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Course selected = view.list.getSelectedValue();
		if(selected == null){
			return;
		} else {
			mainMoon.studentCourseStatsSetEverything(s,selected);
			mainMoon.changeCard(mainMoon.COURSE_STATS);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	
	@Override
	public void mouseExited(MouseEvent arg0) {}

	
	@Override
	public void mousePressed(MouseEvent arg0) {}

	
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	
}
