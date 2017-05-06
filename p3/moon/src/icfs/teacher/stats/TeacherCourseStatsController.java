/**
 * 
 */
package icfs.teacher.stats;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import icfs.teacher.stats.TeacherCourseStats;
import main.mainMoon;
import moon.course.Course;
import moon.course.Exercise;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class TeacherCourseStatsController implements MouseListener{
	 
	Course c;
	TeacherCourseStats view;
	
	public TeacherCourseStatsController(TeacherCourseStats view){
		this.view= view;
	}
	
	public void setEverything(Course c){
		this.c=c;
		view.listModel.removeAllElements();
		for(Exercise ce : c.getExercises()){
			view.listModel.addElement(ce);
		}
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Exercise selected = view.list.getSelectedValue();
		if(selected == null){
			return;
		} else {
			//Falta setear todos los campos.
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
