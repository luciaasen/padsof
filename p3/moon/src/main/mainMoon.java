/**
 * 
 */
package main;

import java.awt.*;

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
	private static JPanel superPanel;
	private static CardLayout superLayout;
	private static MainStudentPanel mainStudentPanel;
	private static StudentCourseView coursePanel;
	
	public final static String MAIN = "mainPanel";
	public final static String COURSE = "coursePanel";
	
	public static void main(String[] args){
		
		
		
	}
	
	public static void studentMode(User u){
		if(!(u instanceof Student)){
			return;
		}
		window = new JFrame();
		window.setVisible(true);
		window.setSize(1000, 600);
		
		superPanel = new JPanel();
		mainStudentPanel = new MainStudentPanel();
		coursePanel = new StudentCourseView();
		
		superLayout = new CardLayout();
		superPanel.setLayout(superLayout);
		window.getContentPane().add(superPanel);
		superPanel.setVisible(true);
		
		superPanel.add(mainStudentPanel, "mainPanel");
		superPanel.add(coursePanel, "coursePanel");
		if(!(u instanceof Student)){ throw new IllegalArgumentException(); }
		mainStudentPanel.setEverything((Student)u);
	}
	
	public static void changeCard(String newCard){
		superLayout.show(superPanel, newCard);
	}
	
	public static void backCard(){
		superLayout.previous(superPanel);
	}
	
	public static void teacherMode(User u){
		
	}
	
	public static void courseSetEverything(Student s, Course c){
		coursePanel.setEverything(s,c);
	}
	
	public static void mainSetEverything(Student s){
		mainStudentPanel.setEverything(s);
	}
	
}
