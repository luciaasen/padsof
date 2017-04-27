/**
 * 
 */
package icfs.student.course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import icfs.student.main.MainStudentPanel;
import moon.course.Course;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class StudentCourseViewController implements ActionListener {
	private Student s;
	private Course c;
	private StudentCourseView view;
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void setEverything(Student s, Course c){
		this.s=s;
		this.c=c;
	}
	
}
