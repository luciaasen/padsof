/**
 * 
 */
package icfs.student.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import icfs.student.course.StudentCourseView;
import main.mainMoon;
import moon.course.Course;
import moon.user.Student;

/**
 * @author Juan Riera Gomez and Lucia Asencio Martin
 *
 */
public class MainStudentJListController implements MouseListener {
	private Student s;
	private MainStudentPanel view;
	
	/**
	 * Constructor of the controller
	 * @param Student
	 * @param MainStudentLeftPanel
	 */
	public MainStudentJListController(MainStudentPanel view){
		this.view=view;
	}

	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		Course selected = view.left.coursesL.getSelectedValue();
		/*if(!(s.getCourses().contains(selected))){
			//TODO ask the user if he wants to send an application
			return;
		}*/
		
		//mainMoon.courseSetEverything(s, selected);
		mainMoon.changeCard(mainMoon.COURSE);
		
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void setEverything(Student s){
		this.s=s;
	}
	
}
