/**
 * 
 */
package icfs.student.course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import icfs.student.main.MainStudentPanel;
import main.mainMoon;
import moon.course.Course;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class StudentCourseView extends JPanel{
	
	StudentCourseViewController controller;
	JPanel back;
	JButton backButton = new JButton("Back");
	/**
	 * @param s
	 * @param selected
	 * @param view
	 */
	public StudentCourseView() {
		this.back=back;
		this.setVisible(true);
		backButton.setVisible(true);
		this.add(backButton);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainMoon.window.setContentPane(back);
				
			}
			
		});
	}

	
	

}
