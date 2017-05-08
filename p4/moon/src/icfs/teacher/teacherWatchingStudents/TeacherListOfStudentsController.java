/**
 * 
 */
package icfs.teacher.teacherWatchingStudents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.mainMoon;
import moon.course.Course;
import moon.course.Exercise;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class TeacherListOfStudentsController implements MouseListener{

	TeacherListOfStudentsCourse view;
	Course c;
	
	public TeacherListOfStudentsController(TeacherListOfStudentsCourse view){
		this.view=view;
	}
	
	public void setEverything(Course c){
		this.c = c;
		setAllStudents();
		view.allStudents.setSelected(true);
	}
	
	public void setAdmittedStudents(){
		view.listModel.removeAllElements();
		for(Student s : c.getStudents()){
			if(c.isExpelled(s)==false){
				view.listModel.addElement(s);
			}
		}
	}
	
	public void setExpelledStudents(){
		view.listModel.removeAllElements();
		for(Student s : c.getExpStudents()){
			view.listModel.addElement(s);
		}
	}
	
	public void setAllStudents(){
		view.listModel.removeAllElements();
		for(Student s : c.getStudents()){
			view.listModel.addElement(s);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Student selected = view.list.getSelectedValue();
		if(selected == null){
			return;
		} else {
			mainMoon.teacherStudentCardSetEverything(c,selected);
			mainMoon.changeCard(mainMoon.STUDENT_CARD);
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
