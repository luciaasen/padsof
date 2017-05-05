/**
 * 
 */
package main;

import java.awt.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import icfs.student.course.StudentCourseView;
import icfs.student.exercise.StudentQuestionView;
import icfs.student.main.MainStudentPanel;
import icfs.teacher.course.TeacherCourseView;
import icfs.teacher.create.AddCourseView;
import icfs.teacher.main.MainTeacherLower;
import icfs.teacher.main.MainTeacherPanel;
import moon.Academy;
import moon.course.Course;
import moon.course.Exercise;
import moon.user.*;
import icfs.UpperPanel;
import icfs.general.course.GeneralCourseView;
import icfs.login.LoginWindowView;

/**
 * @author e336799
 *
 */
public class mainMoon {
	public static JFrame window;
	private static JPanel lowerPanel;
	private static JPanel upperPanel;
	private static JPanel superPanel;
	private static CardLayout lowerLayout;
	
	private static MainStudentPanel mainStudentPanel;
	private static GeneralCourseView coursePanel;
	private static StudentQuestionView questionPanel;
	
	public final static String MAIN = "mainPanel";
	public final static String COURSE = "coursePanel";
	public final static String QUESTION = "questionPanel";
	
	/*teacher*/
	private static MainTeacherLower mainTeacherPanel;
	private static AddCourseView addCourseView;
	private static TeacherCourseView teacherCoursePanel;
	
	public final static String ADD_COURSE = "addCourse";
	public final static String ADD_UNIT = "addUnit";
	
	public static void main(String[] args){
		
	}
	
	public static void userMode(User u, Academy a){
		window = new JFrame();
		//TODO discute con juan si esto no deberia de estar despues del if (caso de re log in)
		window.setVisible(true);
		window.setSize(Academy.DIMENSION);
	
		lowerPanel = new JPanel();
		superPanel = new JPanel();
		upperPanel = new UpperPanel();
		
		lowerLayout = new CardLayout();
		lowerPanel.setLayout(lowerLayout);
		superPanel.setLayout(new BorderLayout());
		superPanel.add(lowerPanel, BorderLayout.CENTER);
		superPanel.add(upperPanel, BorderLayout.NORTH);
		
		window.getContentPane().add(superPanel);
		lowerPanel.setVisible(true);
		
		if(u.isTeacher()){
			teacherMode((Teacher) u);
		}else{
			studentMode((Student) u);
		}
	}
	
	public static void studentMode(Student u){
		mainStudentPanel = new MainStudentPanel();
		coursePanel = new StudentCourseView();
		questionPanel = new StudentQuestionView();
		
		lowerPanel.add(mainStudentPanel, MAIN);
		lowerPanel.add(coursePanel, COURSE);
		lowerPanel.add(questionPanel, QUESTION);
		mainStudentPanel.setEverything(u);
	}
	
	public static void changeCard(String newCard){
		lowerLayout.show(lowerPanel, newCard);
	}
	
	public static void backCard(){
		lowerLayout.previous(lowerPanel);
		lowerPanel.add(mainTeacherPanel, MAIN);
		
	}
	
	public static void teacherMode(Teacher u){
		//TODO habla con juan el quitar todas las cards actuales, ¿cambio de window Exc?
		mainTeacherPanel = new MainTeacherLower();
		addCourseView = new AddCourseView();
		coursePanel = new TeacherCourseView();
		
		lowerPanel.add(mainTeacherPanel, MAIN);
		lowerPanel.add(addCourseView, ADD_COURSE);
		lowerPanel.add(coursePanel, COURSE);
	}
	
	public static void mainSetEverything(){
		mainTeacherPanel.setEverything();
	}
	
	public static void courseSetEverything(Student s, Course c){
		coursePanel.setEverything(s,c);
	}
	
	public static void courseSetEverything(Teacher s, Course c){
		coursePanel.setEverything(s,c);
	}
	
	public static void mainSetEverything(Student s){
		mainStudentPanel.setEverything(s);
	}
	
	public static void questionSetEverything(Student s, Course c, Exercise e){
		questionPanel.setEverything(s, c, e);
	}
	
}
