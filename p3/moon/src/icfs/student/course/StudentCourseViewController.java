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
	private JPanel oldPanel;
	private StudentCourseView view;
	
	StudentCourseViewController(Student s, Course c, JPanel oldPanel){
		this.s=s;
		this.c=c;
		this.oldPanel=oldPanel;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
