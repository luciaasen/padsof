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
	Student s;
	MainStudentPanel view;
	
	/**
	 * Constructor of the controller
	 * @param Student
	 * @param MainStudentLeftPanel
	 */
	public MainStudentJListController(Student s, MainStudentPanel view){
		this.s=s;
		this.view=view;
	}

	

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		Course selected = view.left.actual.getSelectedValue();
		/*if(!(s.getCourses().contains(selected))){
			//TODO ask the user if he wants to send an application
			return;
		}*/
		JPanel newPanel = new StudentCourseView(s, selected, view);
		
		mainMoon.window.setContentPane(newPanel);
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
