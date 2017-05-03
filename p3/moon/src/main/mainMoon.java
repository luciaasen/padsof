/**
 * 
 */
package main;

import java.awt.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import icfs.student.course.StudentCourseView;
import icfs.student.main.MainStudentPanel;
import moon.Academy;
import moon.course.Course;
import moon.user.*;
import icfs.login.LoginWindowView;

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
	
	public static void userMode(User u, Academy a){
		window = new JFrame();
		//TODO discute con juan si esto no deberia de estar despues del if (caso de re log in)
		window.setVisible(true);
		window.setSize(Academy.DIMENSION);
	
		superPanel = new JPanel();
		
		superLayout = new CardLayout();
		superPanel.setLayout(superLayout);
		window.getContentPane().add(superPanel);
		superPanel.setVisible(true);
		
		if(u.isTeacher()){
			teacherMode((Teacher) u);
		}else{
			studentMode((Student) u);
		}
	}
	
	public static void studentMode(Student u){
		mainStudentPanel = new MainStudentPanel();
		coursePanel = new StudentCourseView();
	
		superPanel.add(mainStudentPanel, MAIN);
		superPanel.add(coursePanel, COURSE);
		mainStudentPanel.setEverything(u);
	}
	
	public static void changeCard(String newCard){
		superLayout.show(superPanel, newCard);
	}
	
	public static void backCard(){
		superLayout.previous(superPanel);
	}
	
	public static void teacherMode(Teacher u){
		
	}
	
	public static void courseSetEverything(Student s, Course c){
		coursePanel.setEverything(s,c);
	}
	
	public static void mainSetEverything(Student s){
		mainStudentPanel.setEverything(s);
	}
	
}
