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
import moon.user.Student;

/**
 * @author lucia
 *
 */
public class ExerciseTest extends Exercise {

	private Exercise e1, e2;
	private TfQuestion q1, q2, q3, q4;
	private MExercise me1, me2, me3, me4;
	
	/**
	 * Create and set 2 exercises up with different questions, we then emulate
	 * 2 students doing them
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		/*Set 2 exercises with its questions, and 2 students*/
		LocalDate from = LocalDate.of(2017, 1, 1);
		LocalDate to = LocalDate.of(2017, 12, 12);
		
		e1 = new Exercise();
		e1.setRelevance(2);
		e1.setPenalty(-2);
		e1.setName("Exe One");
		e1.setRandord(false);
		e1.setDates(from, to);
		
		e2 = new Exercise();
		e2.setRelevance(1);
		e2.setPenalty(4);
		e2.setName("Exe 2");
		e2.setRandord(false);
		e2.setDates(from, to);
		
		q1 = new TfQuestion("Am I silly?", 5, false, e1);
		q2 = new TfQuestion("Am I?", 10, true, e1);		
		q3 = new TfQuestion("Am I wrong?", -10, true, e2);
		q4= new TfQuestion("Are you okay?", 4, true, e2);
		
		Student s1 = new Student("Pepe", "Martin", "password", 1, "a.b@c.d"), s2 = new Student("Mimi", "Gzlez", "wordpass", 2, "a.c@b.d");
		
		/*Emulate students do exercises*/
		Course c1 = new Course("Course 1");
		Unit u1 = new Unit("Unit 1");
		u1.setCourse(c1);
		e1.setUnit(u1);
		e2.setUnit(u1);
		
		/*First student answers correctly to all answers in all exercises*/
		c1.addStudent(s1);
		MCourse mc1 = new MCourse(c1, s1);
		
		me1 = new MExercise(e1);
		mc1.addMExe(me1);
		q1.answer(false, me1);
		q2.answer(true, me1);
		e1.addMExercise(me1);
		
		me2 = new MExercise(e2);
		mc1.addMExe(me2);
		q3.answer(true, me2);
		q4.answer(true, me2);
		e2.addMExercise(me2);
		
		/*Second student answers to one question in each exercise. Wrong answer */
		c1.addStudent(s2);
		MCourse mc2 = new MCourse(c1, s2);
		
		me3 = new MExercise(e1);
		mc2.addMExe(me3);
		q1.answer(true, me3);
		e1.addMExercise(me3);
		
		me4 = new MExercise(e2);
		mc2.addMExe(me4);
		q3.answer(false, me4);
		e2.addMExercise(me4);	
	}

	/**
	 * Test method for {@link moon.course.Exercise#Exercise()}.
	 */
	@Test
	public void testExercise() {
		assertNotNull(e1);
		assertNotNull(e2);
	}

	/**
	 * Test method for {@link moon.course.Exercise#getRelevance()}.
	 */
	@Test
	public void testGetRelevance() {
		assertTrue(e1.getRelevance() == 2);
		assertTrue(e2.getRelevance() == 1);
	}

	/**
	 * Test method for {@link moon.course.Exercise#setRelevance(double)}.
	 */
	@Test
	public void testSetRelevance() {
		/*Normal set relevance is tested with setup and getRelevance test*/
		/*In set up, we simulate someone does the exercise and try to set it again*/
		/*Relevance shouldnt be changed*/
		e1.setRelevance(100);
		assertTrue(e1.getRelevance() == 2);
		
	}

	/**
	 * Test method for {@link moon.course.Exercise#getPenalty()}.
	 */
	@Test
	public void testGetPenalty() {
		assertTrue(e1.getPenalty() == -2);
		assertTrue(e2.getPenalty() == -1);
	}

	/**
	 * Test method for {@link moon.course.Exercise#setPenalty(double)}.
	 */
	@Test
	public void testSetPenalty() {
		/*Normal set penalty is tested with setup and getPenalty test*/
		/*In set up, we simulate someone does the exercise and try to set it again*/
		/*Penalty shouldnt be changed*/
		e1.setPenalty(-100);
		assertTrue(e1.getPenalty() == -2);
	}

	/**
	 * Test method for {@link moon.course.Exercise#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals(this.getName(), "Exe One");
	}
	
	/**
	 * Test method for {@link moon.course.Exercise#setName()}.
	 */
	@Test
	public void testSetName() {
		/*Normal set name is tested with setup and getName test*/
		/*In set up, we simulate someone does the exercise and try to set it again*/
		/*Name shouldnt be changed*/
		e1.setName("Hola Pepito");
		assertTrue(e1.getName().equals("Exe One"));
	}

	/**
	 * Test method for {@link moon.course.Exercise#getRandord()}.
	 */
	@Test
	public void testGetRandord() {
		assert
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
