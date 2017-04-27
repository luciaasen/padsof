/**
 * 
 */
package main;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import icfs.student.course.StudentCourseView;
import icfs.student.main.MainStudentPanel;
import moon.course.Course;
import moon.user.Student;
import moon.user.User;

/**
 * @author e336799
 *
 */
public class mainMoon {
	public static JFrame window;
	public static void main(String[] args){
		
		
		window = new JFrame();
		

		window.setVisible(true);
		window.setSize(1000, 600);
	}
	
	public static void studentMode(User u){
		if(!(u instanceof Student)){
			return;
		}
		JPanel superPanel = new JPanel();
		JPanel mainPanel = new MainStudentPanel((Student)u);
		JPanel coursePanel = new StudentCourseView();
		superPanel.setLayout(new CardLayout());
		window.getContentPane().add(superPanel);
		superPanel.setVisible(true);
		
		superPanel.add(mainPanel, "mainPanel");
		superPanel.add(coursePanel, "coursePanel");
	}
	
	public static void teacherMode(User u){
		
	}
	
}
