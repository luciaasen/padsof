/**
 * 
 */
package moon.user.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;

import moon.user.*;
import moon.Academy;
import moon.course.*;
import moon.course.question.Question;
import moon.course.question.TfQuestion;
import moon.mark.MCourse;
import moon.mark.MExercise;

import org.junit.Test;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Test for the class Student.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentTest {

	Student s1, s2, s3, s4;
	Course c1, c2;
	Application a11, a12, a21, a22, anull1, anull2;
	Exercise e11, e12, e21, e22;
	Question q111, q112, q113, q121, q122, q123, q211, q212, q213, q221, q222, q223;
	MExercise me111, me112, me121, me122, me211, me212, me221, me222;
	
	/**
	 * In this setup we create 4 students (s1, s2, s3 and s4), 2 courses (c1 and c2)
	 * and a bunch of exercises with their questions.
	 */
	@Before
	public void setUp(){
		Academy moon = new Academy();
		Academy.setMoon(moon);
		s1 = new Student("Juanito", "Perales", "password", 2, "juan.perales@uam.es");
		s2 = new Student("Emilio", "Cuesta", "password", 3, "emi.asturias@uam.es");
		s3 = new Student("Pepito", "Aviador", "pesswerd", 4, "pepito.aviador@uam.es");
		s4 = new Student("Jaimito", "Asencio", "pussword", 5, "tiriri.a@uam.es");
		c1 = new Course("Bioquimica aplicada");
		c2 = new Course("SADFOP");
		
		/* For the next variables:
		 * 		- e12 is the exercise 1 of course c2
		 * 		- q123 is the question 3 of exercise 1 of course c2
		 * 		- mc12 is the MCourse associated with the course c1 
		 * 			and the student s1
		 */
		e11 = new Exercise();
		e11.setPenalty(-33.2);
		e11.setRelevance(4);
		q111 = new TfQuestion("Is this question boring? HUH?!", 300, false, e11);
		q112 = new TfQuestion("Am I a paranoid android?", 11, true, e11);		
		q113 = new TfQuestion("Are we here?", 21, true, e11);
		
		e12 = new Exercise();
		e12.setPenalty(0);
		e12.setRelevance(4);
		q121 = new TfQuestion("Is this question boring? HUH?!", 10, false, e12);
		q122 = new TfQuestion("Am I a paranoid android?", 9, true, e12);		
		q123 = new TfQuestion("Are we here?", 21, true, e12);
		
		e21 = new Exercise();
		e21.setPenalty(-2);
		e21.setRelevance(6);
		q211 = new TfQuestion("Is this question boring? HUH?!", 10, false, e21);
		q212 = new TfQuestion("Am I a paranoid android?", 9, true, e21);		
		q213 = new TfQuestion("Are we here?", 21, true, e21);
		
		e22 = new Exercise();
		e22.setPenalty(0);
		e22.setRelevance(6);
		q221 = new TfQuestion("Is this question boring? HUH?!", 10, false, e22);
		q222 = new TfQuestion("Am I a paranoid android?", 9, true, e22);		
		q223 = new TfQuestion("Are we here?", 21, true, e22);
		
		
		
		
	}
	
	/**
	 * Test method for {@link moon.user.Student#Student()}
	 * We also test the getters for the name, last name, email and password.
	 * Technically, the latter is not exactly a getter, because it checks if 
	 * the password it receives as an argument is equal to the password of 
	 * the user. This is also tested in this tester.
	 */
	@Test
	public void testStudent(){
		/* Let's make sure that the Students have been properly intialized */
		assertNotNull(s1);
		assertNotNull(s2);
		
		assertEquals(s1.getName(), "Juanito");
		assertEquals(s2.getName(), "Emilio");
		assertEquals(s1.getLastName(), "Perales");
		assertEquals(s2.getLastName(), "Cuesta");
		assertEquals(s1.getEmail(), "juan.perales@uam.es");
		assertEquals(s2.getEmail(), "emi.asturias@uam.es");
	}
	
	/**
	 * Test method for {@link moon.user.Student#addMark(moon.mark.MCourse)}.
	 */
	@Test
	public void testAddMark() {
		Application a;
		try {
			a=s1.apply(c1);
			a.accept();
			a=s1.apply(c2);
			a.accept();
			a=s2.apply(c1);
			a.accept();
			a=s2.apply(c2);
			a.reject();
			
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			fail("Error with the email system");
			e.printStackTrace();
		}
		
		MCourse mc11 = c1.getMCourse(s1);
		MCourse mc21 = c2.getMCourse(s1);
		MCourse mc12 = c1.getMCourse(s2);
		
		assertTrue(s4.getMarks().size()==0);
		assertTrue(s1.getMarks().contains(mc11));
		assertTrue(s1.getMarks().contains(mc21));
		assertTrue(s1.getMarks().size()==2);
		assertTrue(s2.getMarks().contains(mc12));
		assertTrue(s2.getMarks().size()==1);
		
	}
	
	/**
	 * Test method for {@link moon.user.Student#isTeacher()}.
	 */
	@Test
	public void testIsTeacher() {
		assertFalse(s1.isTeacher());
		assertFalse(s2.isTeacher());
	}
	
	/**
	 * Test method for {@link moon.user.Student#addCourse(moon.course.Course)}.
	 */
	@Test
	public void testAddAndGetCourse() {
		assertTrue(s1.addCourse(c1));
		assertTrue(s1.addCourse(c2));
		assertTrue(s2.addCourse(c1));
		
		/* It is important to note that this method will never be called
		 * in a case where the course has already been added, since it will 
		 * be called always by the method Application.accept(), and that
		 * Application will be constructed by Student.apply(Course c) that
		 * makes sure that the student is not in the course when he applies 
		 * for it, and that there is no other application between the same
		 * student and the same course as the one you are trying to create.
		 * 
		 * The method apply() is tested below.
		 */
		
		/*Lets now make sure that the lists have been updated */
		
		assertTrue(s1.getCourses().contains(c1));
		assertTrue(s1.getCourses().contains(c2));
		assertTrue(s2.getCourses().contains(c1));
	}
	
	/**
	 * Test method for {@link moon.user.Student#addApplication(moon.user.Application)}.
	 */
	@Test
	public void testAddApplicationAndGetApps() {
		a11 = new Application(s1, c1);
		a12 = new Application(s1, c2);
		
		/* The constructor of application calls to addApplication ,
		 * so let's check that the applications have been added to the list.
		 */
		assertTrue(s1.getApps().contains(a11));
		assertTrue(s1.getApps().contains(a12));
	}
	
	/**
	 * Test method for {@link moon.user.User#checkPwd(java.lang.String)}.
	 */
	@Test
	public void testCheckPwd() {
		assertTrue(s1.checkPwd("password"));
		assertTrue(s2.checkPwd("password"));
		assertFalse(s1.checkPwd("passworD"));
		assertFalse(s2.checkPwd("Password"));
	}

	/**
	 * Test method for {@link moon.user.Student#apply(moon.course.Course)}.
	 */
	@Test
	public void testApply() {
		
		try {
			a11 = s1.apply(c1);
			a12 = s1.apply(c2);
			a22 = s2.apply(c2);
			a21 = s2.apply(c1);
			/* You cannot apply for a course you have already applied for */
			anull1 = s1.apply(c1);
			anull2 = s2.apply(c2);
		} catch(InvalidEmailAddressException | FailedInternetConnectionException e){
			e.printStackTrace();
			fail("Failed with the email system");
		}
		
		/* We are going to check that all the lists have been properly updated */
		/* First let's check that the objects were created */
		assertNotNull(a11);
		assertNotNull(a12);
		assertNotNull(a21);
		assertNotNull(a22);
		assertNull(anull1);
		assertNull(anull2);
		
		/*Now let's check that they have been added 
		 * to every list they should be in*/
		assertTrue(s1.getApps().contains(a11));
		assertTrue(s1.getApps().contains(a12));
		assertTrue(s2.getApps().contains(a21));
		assertTrue(s2.getApps().contains(a22));
		
		/* The method Academy.getApplications() looks for all the applications
		 * in the lists stored in the courses.
		 */
		assertTrue(Academy.getMoonApp().getApplications().contains(a11));
		assertTrue(Academy.getMoonApp().getApplications().contains(a21));
		assertTrue(Academy.getMoonApp().getApplications().contains(a12));
		assertTrue(Academy.getMoonApp().getApplications().contains(a22));
		
		/* You can not apply for a course you are already in */
		try {
			a12.accept();
			a21.accept();
			anull1 = s1.apply(c2);
			anull2 = s2.apply(c1);
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			fail("Email error");
			e.printStackTrace();
		}
		assertNull(anull1);
		assertNull(anull2);
		
	}

	

	/**
	 * Test method for {@link moon.user.Student#removeApplication(moon.user.Application)}.
	 */
	@Test
	public void testRemoveApplication() {
		a11 = new Application(s1, c1);
		a12 = new Application(s1, c2);
		
		/* The constructor of application calls addAppliation,
		 * so they are added now to the list of applications.
		 * This has already been tested to work.
		 */
		assertTrue(s1.removeApplication(a11));
		assertTrue(s1.removeApplication(a12));
		/* They can not be removed twice */
		assertFalse(s1.removeApplication(a11));
		assertFalse(s1.removeApplication(a12));
		
		/* Now they should not be there anymore */
		assertFalse(s1.getApps().contains(a11));
		assertFalse(s1.getApps().contains(a12));
	}

	/**
	 * Test method for {@link moon.user.Student#calcAverage()}.
	 * 
	 * 		This test is very long, because we had to build a hole structure
	 * of students that have answered questions, in units, in courses.
	 * 
	 *     This test is very long, because we had to build a hole structure
	 * of students that have answered questions, in units, in courses.
	 * 
	 * 		The student s1 will be a student that applies and is accepted to the 
	 * courses c1 and c2. These courses will have 2 exercises each and s1
	 * will answer to the four of them, in some exercises he will get the 
	 * highest mark and will get more average marks in the others.
	 * 
	 * 		The student s2 will apply for courses c1 and c2, but will only
	 * be accepted in c1. He will leave questions unanswered and get the 
	 * lowest possible mark (meaning that he will have a negative mark 
	 * because of the penalty, resulting in a 0 in the exercise mark
	 * because no negative marks are allowed)
	 * 
	 * 		The student s3 will apply for course c1 and c2, and will be accepted
	 * in both, but will not do any exercise.
	 * 
	 * 		The student s4 will not apply to any course.
	 * 
	 * 		The averages of each student have been approximated. That is why
	 * we won't usually be comparing them with "==", but with a upper bound 
	 * and a lower bound to our approximations, using the operators "<" and ">".
	 */
	
	@Test
	public void testCalcAverage() {
		Application a;
		
		try {
			a=s1.apply(c1);
			a.accept();
			a=s1.apply(c2);
			a.accept();
			a=s2.apply(c1);
			a.accept();
			a=s2.apply(c2);
			a.reject();
			a=s3.apply(c1);
			a.accept();
			a=s3.apply(c2);
			a.accept();
			
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			fail("Error with the email system");
			e.printStackTrace();
		}
		
		MCourse mc11 = c1.getMCourse(s1);
		MCourse mc21 = c2.getMCourse(s1);
		MCourse mc12 = c1.getMCourse(s2);
		
		Unit u11 = new Unit("Unit 1 of Course 1");
		u11.setCourse(c1);
		e11.setUnit(u11);
		Unit u21 = new Unit("Unit 2 of Course 1");
		u21.setCourse(c1);
		e21.setUnit(u21);
		Unit u12 = new Unit("Unit 1 of Course 2");
		u12.setCourse(c2);
		e12.setUnit(u12);
		Unit u22 = new Unit("Unit 2 of Course 2");
		u22.setCourse(c2);
		e22.setUnit(u22);

		/* MExercise of student 1 course 1 exercise 1 */
		me111 = new MExercise(e11);
		mc11.addMExe(me111);
		q111.answer(false, me111);
		q112.answer(false, me111);
		q113.answer(true, me111);
		
		/* MExercise of student 1 course 1 exercise 2 */
		me112 = new MExercise(e21);
		mc11.addMExe(me112);
		q211.answer(true, me112);
		q212.answer(true, me112);
		q213.answer(false, me112);
		
		/* MExercise of student 1 course 2 exercise 1 */
		me121 = new MExercise(e12);
		mc21.addMExe(me121);
		q121.answer(true, me121);
		q122.answer(false, me121);
		q123.answer(true, me121);
		
		/* MExercise of student 1 course 2 course 2 */
		me122 = new MExercise(e22);
		mc21.addMExe(me122);
		q221.answer(false, me122);
		q222.answer(true, me122);
		q223.answer(true, me122);
		
		/* MExercise of student 2 course 1 exercise 1 */
		me211 = new MExercise(e11);
		mc12.addMExe(me211);
		q111.answer(false, me211);
		q112.answer(false, me211);
		
		/* MExercise of student 2 course 1 exercise 2 */
		me212 = new MExercise(e21);
		mc12.addMExe(me212);
		q211.answer(true, me212);
		q212.answer(false, me212);
		
		
		

		assertTrue(s1.calcAverage()<0.617);
		assertTrue(s1.calcAverage()>0.615);
		assertTrue(s2.calcAverage()< 0.322);
		assertTrue(s2.calcAverage()> 0.321);
		assertTrue(s3.calcAverage() == 0);
		assertTrue(s4.calcAverage() == 0);
	}

	/**
	 * Test method for {@link moon.user.Student#calcMaximum()}.
	 * 
	 * 		This test is very long, because we had to build a hole structure
	 * of students that have answered questions, in units, in courses.
	 * 
	 *     This test is very long, because we had to build a hole structure
	 * of students that have answered questions, in units, in courses.
	 * 
	 * 		The student s1 will be a student that applies and is accepted to the 
	 * courses c1 and c2. These courses will have 2 exercises each and s1
	 * will answer to the four of them, in some exercises he will get the 
	 * highest mark and will get more average marks in the others.
	 * 
	 * 		The student s2 will apply for courses c1 and c2, but will only
	 * be accepted in c1. He will leave questions unanswered and get the 
	 * lowest possible mark (meaning that he will have a negative mark 
	 * because of the penalty, resulting in a 0 in the exercise mark
	 * because no negative marks are allowed)
	 * 
	 * 		The student s3 will apply for course c1 and c2, and will be accepted
	 * in both, but will not do any exercise.
	 * 
	 * 		The student s4 will not apply to any course.
	 * 
	 * 		The maximums of each student have been approximated. That is why
	 * we won't be comparing them with "==" unless they are 0, 
	 * but with an upper bound and a lower bound to our approximations, 
	 * using the operators "<" and ">".
	 */
	 
	@Test
	public void testCalcMaximum() {
		Application a;
		
		try {
			a=s1.apply(c1);
			a.accept();
			a=s1.apply(c2);
			a.accept();
			a=s2.apply(c1);
			a.accept();
			a=s2.apply(c2);
			a.reject();
			a=s3.apply(c1);
			a.accept();
			a=s3.apply(c2);
			a.accept();
			
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			fail("Error with the email system");
			e.printStackTrace();
		}
		
		MCourse mc11 = c1.getMCourse(s1);
		MCourse mc21 = c2.getMCourse(s1);
		MCourse mc12 = c1.getMCourse(s2);
		
		Unit u11 = new Unit("Unit 1 of Course 1");
		u11.setCourse(c1);
		e11.setUnit(u11);
		Unit u21 = new Unit("Unit 2 of Course 1");
		u21.setCourse(c1);
		e21.setUnit(u21);
		Unit u12 = new Unit("Unit 1 of Course 2");
		u12.setCourse(c2);
		e12.setUnit(u12);
		Unit u22 = new Unit("Unit 2 of Course 2");
		u22.setCourse(c2);
		e22.setUnit(u22);

		/* MExercise of student 1 course 1 exercise 1 */
		me111 = new MExercise(e11);
		mc11.addMExe(me111);
		q111.answer(false, me111);
		q112.answer(false, me111);
		q113.answer(true, me111);
		
		/* MExercise of student 1 course 1 exercise 2 */
		me112 = new MExercise(e21);
		mc11.addMExe(me112);
		q211.answer(true, me112);
		q212.answer(true, me112);
		q213.answer(false, me112);
		
		/* MExercise of student 1 course 2 exercise 1 */
		me121 = new MExercise(e12);
		mc21.addMExe(me121);
		q121.answer(true, me121);
		q122.answer(false, me121);
		q123.answer(true, me121);
		
		/* MExercise of student 1 course 2 course 2 */
		me122 = new MExercise(e22);
		mc21.addMExe(me122);
		q221.answer(false, me122);
		q222.answer(true, me122);
		q223.answer(true, me122);
		
		/* MExercise of student 2 course 1 exercise 1 */
		me211 = new MExercise(e11);
		mc12.addMExe(me211);
		q111.answer(false, me211);
		q112.answer(false, me211);
		
		/* MExercise of student 2 course 1 exercise 2 */
		me212 = new MExercise(e21);
		mc12.addMExe(me212);
		q211.answer(true, me212);
		q212.answer(false, me212);
		
		
		
		assertTrue(s1.calcMaximum()<0.82);
		assertTrue(s1.calcMaximum()>0.8);
		assertTrue(s2.calcMaximum()<0.33);
		assertTrue(s2.calcMaximum()>0.31);
		assertTrue(s3.calcMaximum()==0);
		assertTrue(s4.calcMaximum()==0);
	}

	/**
	 * Test method for {@link moon.user.Student#calcMinimum()}.
	 * 
	 * 		This test is very long, because we had to build a hole structure
	 * of students that have answered questions, in units, in courses.
	 * 
	 *     This test is very long, because we had to build a hole structure
	 * of students that have answered questions, in units, in courses.
	 * 
	 * 		The student s1 will be a student that applies and is accepted to the 
	 * courses c1 and c2. These courses will have 2 exercises each and s1
	 * will answer to the four of them, in some exercises he will get the 
	 * highest mark and will get more average marks in the others.
	 * 
	 * 		The student s2 will apply for courses c1 and c2, but will only
	 * be accepted in c1. He will leave questions unanswered and get the 
	 * lowest possible mark (meaning that he will have a negative mark 
	 * because of the penalty, resulting in a 0 in the exercise mark
	 * because no negative marks are allowed)
	 * 
	 * 		The student s3 will apply for course c1 and c2, and will be accepted
	 * in both, but will not do any exercise.
	 * 
	 * 		The student s4 will not apply to any course.
	 * 
	 * 		The averages of each student have been approximated. That is why
	 * we won't be comparing them with "==" unless they are 0, but with an 
	 * upper bound and a lower bound to our approximations, using the operators 
	 * "<" and ">".
	 */
	
	@Test
	public void testCalcMinimum() {
		Application a;
		
		try {
			a=s1.apply(c1);
			a.accept();
			a=s1.apply(c2);
			a.accept();
			a=s2.apply(c1);
			a.accept();
			a=s2.apply(c2);
			a.reject();
			a=s3.apply(c1);
			a.accept();
			a=s3.apply(c2);
			a.accept();
			
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			fail("Error with the email system");
			e.printStackTrace();
		}
		
		MCourse mc11 = c1.getMCourse(s1);
		MCourse mc21 = c2.getMCourse(s1);
		MCourse mc12 = c1.getMCourse(s2);
		
		Unit u11 = new Unit("Unit 1 of Course 1");
		u11.setCourse(c1);
		e11.setUnit(u11);
		Unit u21 = new Unit("Unit 2 of Course 1");
		u21.setCourse(c1);
		e21.setUnit(u21);
		Unit u12 = new Unit("Unit 1 of Course 2");
		u12.setCourse(c2);
		e12.setUnit(u12);
		Unit u22 = new Unit("Unit 2 of Course 2");
		u22.setCourse(c2);
		e22.setUnit(u22);

		/* MExercise of student 1 course 1 exercise 1 */
		me111 = new MExercise(e11);
		mc11.addMExe(me111);
		q111.answer(false, me111);
		q112.answer(false, me111);
		q113.answer(true, me111);
		
		/* MExercise of student 1 course 1 exercise 2 */
		me112 = new MExercise(e21);
		mc11.addMExe(me112);
		q211.answer(true, me112);
		q212.answer(true, me112);
		q213.answer(false, me112);
		
		/* MExercise of student 1 course 2 exercise 1 */
		me121 = new MExercise(e12);
		mc21.addMExe(me121);
		q121.answer(true, me121);
		q122.answer(false, me121);
		q123.answer(true, me121);
		
		/* MExercise of student 1 course 2 course 2 */
		me122 = new MExercise(e22);
		mc21.addMExe(me122);
		q221.answer(false, me122);
		q222.answer(true, me122);
		q223.answer(true, me122);
		
		/* MExercise of student 2 course 1 exercise 1 */
		me211 = new MExercise(e11);
		mc12.addMExe(me211);
		q111.answer(false, me211);
		q112.answer(false, me211);
		
		/* MExercise of student 2 course 1 exercise 2 */
		me212 = new MExercise(e21);
		mc12.addMExe(me212);
		q211.answer(true, me212);
		q212.answer(false, me212);
		
		
		assertTrue(s1.calcMinimum()<0.43);
		assertTrue(s1.calcMinimum()>0.42);
		assertTrue(s2.calcMinimum()<0.33);
		assertTrue(s2.calcMinimum()>0.31);
		assertTrue(s3.calcMinimum()==0);
		assertTrue(s4.calcMinimum()==0);
	}

	/**
	 * Test method for {@link moon.user.Student#coursesInButNotExpelled()}.
	 */
	@Test
	public void testCoursesInButNotExpelled() {
		Application a;
		ArrayList<Course> courses;
		try {
			a=s1.apply(c1);
			a.accept();
			a=s1.apply(c2);
			a.accept();
			a=s2.apply(c1);
			a.accept();
			a=s3.apply(c1);
			a.accept();
			a=s3.apply(c2);
			a.accept();
			c1.expelStudent(s1);
			c2.expelStudent(s1);
			c1.expelStudent(s3);
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			fail("Error with the email system");
			e.printStackTrace();
		}
		
		courses=s1.coursesInButNotExpelled();
		assertFalse(courses.contains(c1));
		assertFalse(courses.contains(c2));
		courses=s2.coursesInButNotExpelled();
		assertTrue(courses.contains(c1));
		courses=s3.coursesInButNotExpelled();
		assertFalse(courses.contains(c1));
		assertTrue(courses.contains(c2));
		
		/* Let's make sure that they have been expeled but they are 
		 * stll in the course.
		 */
		courses=s1.getCourses();
		assertTrue(courses.contains(c1));
		assertTrue(courses.contains(c2));
		courses=s2.getCourses();
		assertTrue(courses.contains(c1));
		courses=s3.getCourses();
		assertTrue(courses.contains(c1));
		assertTrue(courses.contains(c2));
	}
	
	
}
