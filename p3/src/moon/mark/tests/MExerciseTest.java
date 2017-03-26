/**
 * 
 */
package moon.mark.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import moon.course.Course;
import moon.course.Exercise;
import moon.course.Unit;
import moon.course.question.*;
import moon.mark.MCourse;
import moon.mark.MExercise;

/**
 * @author lucia
 *
 */
public class MExerciseTest {

	Exercise e1, e2;
	Question q1, q2, q3, q4;
	MExercise me1, me2, me3, me4;
	MCourse mc1, mc2;
	Course c1, c2;
	Unit u1, u2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
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
		
		mc1 = new MCourse(c1, null);
		mc2 = new MCourse(c2, null);
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
	}

	/**
	 * Test method for {@link moon.mark.MExercise#MExercise(moon.course.Exercise)}.
	 */
	@Test
	public void testMExercise() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.mark.MExercise#getStudent()}.
	 */
	@Test
	public void testGetStudent() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.mark.MExercise#setStudent(moon.user.Student)}.
	 */
	@Test
	public void testSetStudent() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.mark.MExercise#getExercise()}.
	 */
	@Test
	public void testGetExercise() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.mark.MExercise#getmQuestions()}.
	 */
	@Test
	public void testGetmQuestions() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link moon.mark.MExercise#addMQuestion()}.
	 */
	@Test
	public void testAddMQuestion() {
		fail("Not yet implemented");
	}

}
