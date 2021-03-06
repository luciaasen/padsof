/**
 * 
 */
package moon.mark.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import moon.course.Course;
import moon.course.Exercise;
import moon.course.Unit;
import moon.course.question.*;
import moon.mark.*;
import moon.user.Application;
import moon.user.Student;

/**
 * Testmethod for MExercise.
 * @author Lucia Asencio and Juan Riera
 *
 */
public class MExerciseTest {

	Exercise e1, e2;
	Question q1, q2, q3, q4;
	MExercise me1, me2, me3, me4;
	MCourse mc1, mc2, mc3, mc4;
	Course c1, c2;
	Unit u1, u2;
	Student s1, s2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Application a;
		s1=new Student("Juan", "Pepitez", "passwrd", 6, "Juan.pepitez@uam.es");
		s2=new Student("Lucia", "Strepsils", "passwrd", 7, "Lucia.strepsils@uam.es");
		c1 = new Course("Padsof");
		c2 = new Course("Mathematics");
		e1 = new Exercise();
		e1.setRelevance(1);
		e1.setPenalty(-4);
		e2 = new Exercise();
		e2.setRelevance(2);
		e2.setPenalty(-5);
		u1 = new Unit("Unit of course c1");
		u2 = new Unit("Unit of course c2");
		u1.setCourse(c1);
		u2.setCourse(c2);
		c1.addUnit(u1);
		c2.addUnit(u2);
		u1.addElement(e1);
		u2.addElement(e2);
		
		try {
			a=s1.apply(c1);
			a.accept();
			a=s1.apply(c2);
			a.accept();
			a=s2.apply(c1);
			a.accept();
			a=s2.apply(c2);
			a.accept();
			
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			fail("Error with the email system");
			e.printStackTrace();
		}
		
		mc1 = new MCourse(c1, s1);
		mc2 = new MCourse(c2, s1);
		mc3 = new MCourse(c1, s2);
		mc4 = new MCourse(c2, s2);
		q1 = new TfQuestion("This is a sample question 1", 4, false, e1);
		q2 = new TfQuestion("This is a sample question 2", 6, true, e1);
		q3 = new TfQuestion("This is a sample question 3", 7, true, e2);
		q4 = new TfQuestion("This is a sample question 4", 3, false, e2);
		
		me1 = new MExercise(e1);
		mc1.addMExe(me1);
		q1.answer(true, me1);
		q2.answer(false, me1);
		
		me2 = new MExercise(e2);
		mc2.addMExe(me2);
		q3.answer(true, me2);
		q4.answer(true, me2);
		
		me3 = new MExercise(e1);
		mc3.addMExe(me3);
		q2.answer(true, me3);
		
		me4 = new MExercise(e2);
		mc4.addMExe(me4);
		
	}

	/**
	 * Test method for {@link moon.mark.MExercise#MExercise(moon.course.Exercise)}.
	 */
	@Test
	public void testMExercise() {
		/* Lets first check that the objects have been created */
		assertNotNull(me1);
		assertNotNull(me2);
		assertNotNull(me3);
		assertNotNull(me4);
		
		/* Now let's check that the list of mexercises in the exercises
		 * have been properly updated
		 */
		assertTrue(e1.getStudentMarks().contains(me1));
		assertTrue(e1.getStudentMarks().contains(me3));
		assertTrue(e2.getStudentMarks().contains(me2));
		assertTrue(e2.getStudentMarks().contains(me4));
		
		/* Now let's check that the values have been properly initialized */
		assertEquals(me1.getExercise(), e1);
		assertEquals(me2.getExercise(), e2);
		assertEquals(me3.getExercise(), e1);
		assertEquals(me4.getExercise(), e2);
		
		
		
	}
	
	/**
	 * Test method for {@link moon.mark.MExercise#getMark()}.
	 */
	@Test
	public void testGetMark() {
		/* Answer to an exercise where all the answers are wrong, 
		 * this would result in a mark below 0 because of the penalty
		 * but marks can not go below 0, so the result should be 0
		 */
		assertTrue(me1.getMark()==0);
		
		/*
		 * Normal answer, with one wrong and one right answer, normalized 
		 * over to 1.
		 */
		assertTrue(me2.getMark()==0.2);

		/*
		 * Answer where the student left one question unanswered.
		 */
		assertTrue(me3.getMark()==0.6);

		/*
		 * Answer where the student left all questions unanswered.
		 */
		assertTrue(me4.getMark()==0);
	}

	

	/**
	 * Test method for {@link moon.mark.MExercise#getStudent()}.
	 */
	@Test
	public void testSetAndGetStudent() {
		me1.setStudent(s1);
		me2.setStudent(s1);
		me3.setStudent(s2);
		me4.setStudent(s2);
		
		assertEquals(me1.getStudent(), s1);
		assertEquals(me2.getStudent(), s1);
		assertEquals(me3.getStudent(), s2);
		assertEquals(me4.getStudent(), s2);
	}

	/**
	 * Test method for {@link moon.mark.MExercise#getExercise()}.
	 */
	@Test
	public void testGetExercise() {
		assertEquals(me1.getExercise(), e1);
		assertEquals(me2.getExercise(), e2);
		assertEquals(me3.getExercise(), e1);
		assertEquals(me4.getExercise(), e2);
	}

	/**
	 * Test method for {@link moon.mark.MExercise#getmQuestions()}.
	 */
	@Test
	public void testAddAndGetmQuestions() {
		MQuestion mq1, mq2;
		MExercise me5 = new MExercise(e1);
		mq1=new TfAnswer(q1, false);
		mq2=new TfAnswer(q2, true);
		me5.addMQuestion(mq1);
		me5.addMQuestion(mq2);
		assertTrue(me5.getmQuestions().contains(mq1));
		assertTrue(me5.getmQuestions().contains(mq2));
		assertEquals(me5.getmQuestions().size(), 2);
		
		/* Let's now remove one of them */
		me5.removeMQuestion(mq1);
		assertFalse(me5.getmQuestions().contains(mq1));
		assertTrue(me5.getmQuestions().contains(mq2));
		assertEquals(me5.getmQuestions().size(), 1);
	}
	
	/**
	 * Test method for {@link moon.mark.MExercise#cancel()}
	 */
	
	@Test
	public void testCancel() {
		me1.cancel(); 
		me2.cancel(); 
		me3.cancel();
		me4.cancel();
		
		/* We have canceled all the exercises, so no answers should 
		 * have been saved in the questions.
		 */
		
		assertEquals(q1.getStudentMarks().size(), 0);
		assertEquals(q2.getStudentMarks().size(), 0);
		assertEquals(q3.getStudentMarks().size(), 0);
		assertEquals(q4.getStudentMarks().size(), 0);
	}

}
