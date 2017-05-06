/**
 * 
 */
package main;

import java.awt.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import icfs.student.course.StudentCourseView;
import icfs.student.course.StudentNotePanel;
import icfs.student.exercise.StudentQuestionView;
import icfs.student.main.MainStudentPanel;
import icfs.student.main.StudentSelectCourseStatsPanel;
import icfs.student.stats.StudentCourseStats;
import icfs.teacher.course.TeacherCourseView;
import icfs.teacher.create.*;
import icfs.teacher.main.*;
import moon.Academy;
import moon.course.*;
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
	
	/* Student */
	private static MainStudentPanel mainStudentPanel;
	private static GeneralCourseView coursePanel;
	private static StudentQuestionView questionPanel;
	private static StudentNotePanel notePanel;
	private static StudentSelectCourseStatsPanel selectCourseStatsPanel;
	private static StudentCourseStats courseStatsPanel;
	
	public final static String MAIN = "mainPanel";
	public final static String COURSE = "coursePanel";
	public final static String QUESTION = "questionPanel";
	public final static String NOTE = "notePanel";
	public final static String SELECT_COURSE = "selectCoursePanel";
	public final static String COURSE_STATS = "courseStatsPanel";
	
	/*teacher*/
	private static MainTeacherLower mainTeacherPanel;
	private static AddCourseView addCourseView;
	private static AddUnitView addUnitView;
	private static AddNoteView addNoteView;
	private static AddExeView addExeView;
	
	public final static String ADD_COURSE = "addCourse";
	public final static String ADD_UNIT = "addUnit";
	public final static String ADD_NOTE = "addNote";
	public final static String ADD_EXE = "addExe";
	
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
		notePanel = new StudentNotePanel();
		selectCourseStatsPanel = new StudentSelectCourseStatsPanel();
		courseStatsPanel = new StudentCourseStats();
		
		lowerPanel.add(mainStudentPanel, MAIN);
		lowerPanel.add(coursePanel, COURSE);
		lowerPanel.add(questionPanel, QUESTION);
		lowerPanel.add(notePanel, NOTE);
		lowerPanel.add(selectCourseStatsPanel, SELECT_COURSE);
		lowerPanel.add(courseStatsPanel, COURSE_STATS);
		mainSetEverything(u);
	}
	
	public static void changeCard(String newCard){
		lowerLayout.show(lowerPanel, newCard);
	}
	
	public static void teacherMode(Teacher u){
		//TODO habla con juan el quitar todas las cards actuales, ¿cambio de window Exc?
		mainTeacherPanel = new MainTeacherLower();
		coursePanel = new TeacherCourseView();
		addCourseView = new AddCourseView();
		addUnitView = new AddUnitView();
		addNoteView = new AddNoteView();
		addExeView = new AddExeView();
		
		lowerPanel.add(mainTeacherPanel, MAIN);
		lowerPanel.add(addCourseView, ADD_COURSE);
		lowerPanel.add(addUnitView, ADD_UNIT);
		lowerPanel.add(coursePanel, COURSE);
		lowerPanel.add(addNoteView, ADD_NOTE);
		lowerPanel.add(addExeView, ADD_EXE);
		mainSetEverything();
	}
	
	
	/*Mine*/
	public static void mainSetEverything(){
		mainTeacherPanel.setEverything();
	}
	
	public static void courseSetEverything(Teacher s, Course c){
		coursePanel.setEverything(s,c);
	}
	
	public static void addCourseSetEverything(){
		addCourseView.setEverything();
	}
	public static void addUnitSetEverything(Course c){
		addUnitView.setEverything(c);
	}
	
	public static void addUnitSetEverything(Unit u){
		addUnitView.setEverything(u);
	}
	
	public static void addNoteSetEverything(Unit u){
		addNoteView.setEverything(u);
	}
	
	public static void addExeSetEverything(Unit u){
		addExeView.setEverything(u);
	}
	
	/*Juan*/
	
	public static void courseSetEverything(Student s, Course c){
		coursePanel.setEverything(s,c);
	}

	public static void mainSetEverything(Student s){
		mainStudentPanel.setEverything(s);
		selectCourseStatsPanel.setEverything(s);
	}
	
	public static void questionSetEverything(Student s, Course c, Exercise e){
		questionPanel.setEverything(s, c, e);
	}

	/**
	 * @param n the note
	 */
	public static void noteSetEverything(Note n) {
		notePanel.setEverything(n);
	}
	
	
}
