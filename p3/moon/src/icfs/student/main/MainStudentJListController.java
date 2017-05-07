/**
 * 
 */
package icfs.student.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import icfs.student.course.StudentCourseView;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.user.Application;
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
		if(!(s.getCourses().contains(selected))){
			for(Application a : s.getApps()){
				if(a.getCourse()==selected){
					JOptionPane.showOptionDialog(null, "You have already sent an application for this course", 
							"You will have to wait", JOptionPane.YES_NO_OPTION, 
							JOptionPane.QUESTION_MESSAGE, null, new String[]{"Ok"}, null);
				}
			}
			int choice = JOptionPane.showOptionDialog(null, "Do you want to apply for this course?", " ", JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null, new String[]{"Yes", "No"}, null);
			if(choice==0){
				try {
					s.apply(selected);
				} catch (InvalidEmailAddressException except){
					JOptionPane.showMessageDialog(null, "Error: invalid email.", "Ok", JOptionPane.ERROR_MESSAGE);
				} catch (FailedInternetConnectionException except){
					
				}
			}
			return;
		} 
		mainMoon.courseSetEverything(s, selected);
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
