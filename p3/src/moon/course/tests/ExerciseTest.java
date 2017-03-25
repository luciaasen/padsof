/**
 * 
 */
package moon.course.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import moon.course.*;
import moon.course.question.*;
import moon.mark.*;

/**
 * @author lucia
 *
 */
public class ExerciseTest extends Exercise {

	private Exercise e1;
	private TfQuestion q1, q2, q3;
	private MExercise me1;
	
	/**
	 * Create and set 2 exercises up with different questions, we then emulate
	 * 2 students doing them
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		e1 = new Exercise();
		e1.setRelevance(3);
		e1.setPenalty(-2);
		e1.setName("Exe One");
		e1.setRandord(false);
		LocalDate from = LocalDate.of(2017, 1, 1);
		LocalDate to = LocalDate.of(2017, 12, 12);
		e1.setDates(from, to);
		
		q1 = new TfQuestion("Am I silly?", 5, false, e1);
		q2 = new TfQuestion("Am I?", 10, true, e1);		
		q3 = new TfQuestion("Am I wrong?", -10, true, e1);
		
	}

	/**
	 * Test method for {@link moon.course.Exercise#Exercise()}.
	 */
	@Test
	public void testExercise() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#getRelevance()}.
	 */
	@Test
	public void testGetRelevance() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#setRelevance(double)}.
	 */
	@Test
	public void testSetRelevance() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#getPenalty()}.
	 */
	@Test
	public void testGetPenalty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#setPenalty(double)}.
	 */
	@Test
	public void testSetPenalty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#getName()}.
	 */
	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link moon.course.Exercise#setName()}.
	 */
	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#getRandord()}.
	 */
	@Test
	public void testGetRandord() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#setRandord(java.lang.Boolean)}.
	 */
	@Test
	public void testSetRandord() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#calcAverage()}.
	 */
	@Test
	public void testCalcAverage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#calcNPasses()}.
	 */
	@Test
	public void testCalcNPasses() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#calcNFails()}.
	 */
	@Test
	public void testCalcNFails() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#addQuestion(moon.course.question.Question)}.
	 */
	@Test
	public void testAddQuestion() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#removeQuestion(moon.course.question.Question)}.
	 */
	@Test
	public void testRemoveQuestion() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#hasBeenDone()}.
	 */
	@Test
	public void testHasBeenDone() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#getExerciseMark(moon.user.Student)}.
	 */
	@Test
	public void testGetExerciseMark() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#getExercise(moon.user.Student)}.
	 */
	@Test
	public void testGetExercise() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#isActive()}.
	 */
	@Test
	public void testIsActive() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#getStudentMarks()}.
	 */
	@Test
	public void testGetStudentMarks() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#addMExercise(moon.mark.MExercise)}.
	 */
	@Test
	public void testAddMExercise() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#getQuestions()}.
	 */
	@Test
	public void testGetQuestions() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.Exercise#setDates(java.time.LocalDate, java.time.LocalDate)}.
	 */
	@Test
	public void testSetDates() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link moon.course.CourseElement#getCourse()}.
	 */
	@Test
	public void testGetCourse() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.CourseElement#setCourse(moon.course.Course)}.
	 */
	@Test
	public void testSetCourse() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.CourseElement#getUnit()}.
	 */
	@Test
	public void testGetUnit() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.CourseElement#setUnit(moon.course.Unit)}.
	 */
	@Test
	public void testSetUnit() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.CourseElement#makeVisible()}.
	 */
	@Test
	public void testMakeVisible() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.CourseElement#makeInvisible()}.
	 */
	@Test
	public void testMakeInvisible() {
		fail("Not yet implemented");
	}

}
