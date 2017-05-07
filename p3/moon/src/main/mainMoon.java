/**
 * 
 */
package main;

import java.awt.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import icfs.student.course.*;
import icfs.student.exercise.StudentQuestionView;
import icfs.student.main.*;
import icfs.student.stats.*;
import icfs.student.stats.question.StudentQuestionStats;
import icfs.teacher.course.TeacherCourseView;
import icfs.teacher.create.*;
import icfs.teacher.edit.*;
import icfs.teacher.main.*;
import icfs.teacher.stats.*;
//import icfs.teacher.teacherWatchingStudents.TeacherListOfStudentsCourse;
//import icfs.teacher.teacherWatchingStudents.TeacherStudentCard;
//import icfs.teacher.teacherWatchingStudents.TeacherStudentStatisticsMenu;
import moon.Academy;
import moon.course.*;
import moon.course.question.Question;
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
	private static StudentCourseStats studentCourseStatsPanel;
	private static StudentExerciseStats exerciseStatsPanel;
	private static StudentQuestionStats studentQuestionStatsPanel;
	
	public final static String MAIN = "mainPanel";
	public final static String COURSE = "coursePanel";
	public final static String QUESTION = "questionPanel";
	public final static String NOTE = "notePanel";
	public final static String SELECT_COURSE = "selectCoursePanel";
	public final static String COURSE_STATS = "courseStatsPanel";
	public final static String EXERCISE_STATS = "exercieStatsPanel";
	public final static String QUESTION_STATS = "questionStatsPanel";
	
	/*teacher*/
	private static MainTeacherLower mainTeacherPanel;
	private static AddCourseView addCourseView;
	private static AddUnitView addUnitView;
	private static AddNoteView addNoteView;
	private static AddExeView addExeView;
	private static EditCourseView editCourseView;
	private static EditUnitView editUnitView;
	private static EditNoteView editNoteView;
	private static EditExeView editExeView;
	private static TeacherCourseStats courseStatsPanel;
	private static TeacherExerciseStats teacherExerciseStatsPanel;
	private static TeacherQuestionStats teacherQuestionStats;
//	private static TeacherListOfStudentsCourse listOfStudentsPanel;
	//private static TeacherStudentCard studentCardPanel;
	//private static TeacherStudentStatisticsMenu teacherStudentSatsMenu;
	
	public final static String ADD_COURSE = "addCourse";
	public final static String ADD_UNIT = "addUnit";
	public final static String ADD_NOTE = "addNote";
	public final static String ADD_EXE = "addExe";
	public final static String EDIT_COURSE = "editCourse";
	public final static String EDIT_UNIT = "editUnit";
	public final static String EDIT_NOTE = "editNote";
	public final static String EDIT_EXE = "editExe";
	public final static String LIST_STUDENTS = "listStudents";
	public final static String STUDENT_CARD = "studentCard";
	public final static String STUDENT_STATS_MENU = "studentStatsMenu";
	public final static String TEACHER_COURSE_STATS = "tcourseStatsPanel";
	public final static String TEACHER_EXERCISE_STATS = "texercieStatsPanel";
	public final static String TEACHER_QUESTION_STATS = "tquestionStatsPanel";
	
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
		studentCourseStatsPanel = new StudentCourseStats();
		exerciseStatsPanel = new StudentExerciseStats();
		studentQuestionStatsPanel = new StudentQuestionStats();
		
		lowerPanel.add(mainStudentPanel, MAIN);
		lowerPanel.add(coursePanel, COURSE);
		lowerPanel.add(questionPanel, QUESTION);
		lowerPanel.add(notePanel, NOTE);
		lowerPanel.add(selectCourseStatsPanel, SELECT_COURSE);
		lowerPanel.add(studentCourseStatsPanel, COURSE_STATS);
		lowerPanel.add(exerciseStatsPanel, EXERCISE_STATS);
		lowerPanel.add(studentQuestionStatsPanel, QUESTION_STATS);
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
		editCourseView = new EditCourseView();
		editUnitView = new EditUnitView();
		editNoteView = new EditNoteView();
		editExeView = new EditExeView();
		courseStatsPanel = new TeacherCourseStats();
		teacherExerciseStatsPanel = new TeacherExerciseStats();
	//	listOfStudentsPanel = new TeacherListOfStudentsCourse();
		teacherQuestionStats = new TeacherQuestionStats();
		//studentCardPanel = new TeacherStudentCard();
		//teacherStudentSatsMenu = new TeacherStudentStatisticsMenu();
		studentCourseStatsPanel = new StudentCourseStats();
		exerciseStatsPanel = new StudentExerciseStats();
		studentQuestionStatsPanel = new StudentQuestionStats();
		
		lowerPanel.add(mainTeacherPanel, MAIN);
		lowerPanel.add(addCourseView, ADD_COURSE);
		lowerPanel.add(addUnitView, ADD_UNIT);
		lowerPanel.add(addNoteView, ADD_NOTE);
		lowerPanel.add(addExeView, ADD_EXE);
		lowerPanel.add(editCourseView, EDIT_COURSE);
		lowerPanel.add(editUnitView, EDIT_UNIT);
		lowerPanel.add(editNoteView, EDIT_NOTE);
		lowerPanel.add(editExeView, EDIT_EXE);
		lowerPanel.add(coursePanel, COURSE);
		lowerPanel.add(courseStatsPanel, TEACHER_COURSE_STATS);
		lowerPanel.add(teacherExerciseStatsPanel, TEACHER_EXERCISE_STATS);
		lowerPanel.add(teacherQuestionStats, TEACHER_QUESTION_STATS);
		//lowerPanel.add(listOfStudentsPanel, LIST_STUDENTS);
		//lowerPanel.add(studentCardPanel, STUDENT_CARD);
		//lowerPanel.add(teacherStudentSatsMenu, STUDENT_STATS_MENU);
		lowerPanel.add(studentCourseStatsPanel, COURSE_STATS);
		lowerPanel.add(exerciseStatsPanel, EXERCISE_STATS);
		lowerPanel.add(studentQuestionStatsPanel, QUESTION_STATS);
		mainSetEverything();
	}
	
	
	/*Mine*/
	public static void mainSetEverything(){
		mainTeacherPanel.setEverything();
	}
	
	public static void courseSetEverything(Teacher s, Course c){
		coursePanel.setEverything(s,c);
	//	listOfStudentsPanel.setEverything(c);
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
	
	public static void editNoteSetEverything(Unit parent, Note oldNote){
		editNoteView.setEverything(parent, oldNote);
	}
	
	public static void editCourseSetEverything(Course oldCourse){
		editCourseView.setEverything(oldCourse);
	}
	public static void teacherExerciseStatisticsSetEverything(Exercise e){
		teacherExerciseStatsPanel.setEverything(e);
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

	/**
	 * @param s 
	 * @param selected
	 */
	public static void teacherCourseStatsSetEverything(Course selected) {
		courseStatsPanel.setEverything(selected);
		
	}

	/**
	 * @param s
	 * @param c
	 * @param selected
	 */
	public static void studentExerciseStatsSetEverything(Student s, Course c, Exercise e) {
		exerciseStatsPanel.setEverything(s, e);
		
	}

	/**
	 * @param s
	 * @param selected
	 */
	public static void studentCourseStatsSetEverything(Student s, Course c) {
		studentCourseStatsPanel.setEverything(s, c);
	}

	/**
	 * @param s
	 * @param e
	 * @param question2
	 */
	public static void studentQuestionStatsSetEverything(Student s, Exercise e, Question q) {
		studentQuestionStatsPanel.setEverything(s,q);
	}

	/**
	 * @param selected
	 */
	public static void teacherQuestionsStatisticsSetEverything(Question selected) {
		teacherQuestionStats.setEverything(selected);
	}

	/**
	 * @param c
	 * @param selected
	 */
	public static void teacherStudentCardSetEverything(Course c, Student s) {
		//studentCardPanel.setEverything(c, s);
	}

	/**
	 * @param s
	 */
	public static void teacherStudentStatsSelectSetEverything(Student s) {
		//teacherStudentSatsMenu.setEverything(s);
		
	}
	
	
	
}
