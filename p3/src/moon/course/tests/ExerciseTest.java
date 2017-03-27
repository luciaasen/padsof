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
 * This is a tester for the class Exercise.
 * @author Lucia Asencio and Juan Riera
 *
 */
public class ExerciseTest extends Exercise {

	private Exercise e1, e2, e3;
	private TfQuestion q1, q2, q3, q4, q5;
	private MExercise me1, me2, me3, me4;
	private Student s1, s2, s3;
	private Course c1;
	private Unit u1, u2;
	
	/**
	 * Create and set 2 exercises up with different questions, we then emulate
	 * 2 students doing them
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		/*Set 2 exercises with its questions, 1 empty exercise and 3 students*/
		LocalDate from = LocalDate.of(2017, 1, 1);
		LocalDate to = LocalDate.of(2017, 12, 12);
		
		e1 = new Exercise();
		e1.setRelevance(2);
		e1.setPenalty(-2);
		e1.setName("Exe One");
		e1.setRandord(false);
		e1.setDates(from, to);
		e1.makeVisible();
		
		e2 = new Exercise();
		e2.setRelevance(1);
		e2.setPenalty(4);
		e2.setName("Exe 2");
		e2.setRandord(false);
		e2.setDates(to,from);
		e2.makeVisible();
		
		e3 = new Exercise();
		e3.setDates(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 12, 1));
		
		q1 = new TfQuestion("Am I silly?", 5, false, e1);
		q2 = new TfQuestion("Am I?", 10, true, e1);		
		q3 = new TfQuestion("Am I wrong?", -10, true, e2);
		q4= new TfQuestion("Are you okay?", 4, true, e2);
		/*This one will check removeQuestion*/
		q5 = new TfQuestion("uhm?", 5, false, e1);
		e1.removeQuestion(q5);
		
		s1 = new Student("Pepe", "Martin", "password", 1, "a.b@c.d");
		s2 = new Student("Mimi", "Gzlez", "wordpass", 2, "a.c@b.d");
		s3 = new Student("Marta", "Fdez", "pwwp", 3, "d.c@b.a");
		
		/*Emulate students do exercises*/
		c1 = new Course("Course 1");
		u1 = new Unit("Unit 1");
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
		
		me2 = new MExercise(e2);
		mc1.addMExe(me2);
		q3.answer(true, me2);
		q4.answer(true, me2);
		
		/*Second student answers to one question in each exercise. Wrong answer */
		c1.addStudent(s2);
		MCourse mc2 = new MCourse(c1, s2);
		
		me3 = new MExercise(e1);
		mc2.addMExe(me3);
		q1.answer(true, me3);
		//e1.addMExercise(me3);
		
		me4 = new MExercise(e2);
		mc2.addMExe(me4);
		q3.answer(false, me4);
		//e2.addMExercise(me4);	
		
		/*Third student wont answer anything*/
		c1.addStudent(s3);
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
		assertEquals(e1.getName(), "Exe One");
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
		assertFalse(e1.getRandord());
		assertFalse(e2.getRandord());
		
	}

	/**
	 * Test method for {@link moon.course.Exercise#setRandord(java.lang.Boolean)}.
	 */
	@Test
	public void testSetRandord() {
		/*Normal set randord is tested with setup and getRandord test*/
		/*In set up, we simulate someone does the exercise and try to set it again*/
		/*Randord shouldnt be changed*/
		e1.setRandord(true);
		assertFalse(e1.getRandord());
	}

	/**
	 * Test method for {@link moon.course.Exercise#calcAverage()}.
	 */
	@Test
	public void testCalcAverage() {
		assertTrue(e1.calcAverage() == 0.5);
		assertTrue(e2.calcAverage() == 0.5);
	}

	/**
	 * Test method for {@link moon.course.Exercise#calcNPasses()}.
	 */
	@Test
	public void testCalcNPasses() {
		assertTrue(e1.calcNPasses() == 1);
		assertTrue(e2.calcNPasses() == 1);
	}

	/**
	 * Test method for {@link moon.course.Exercise#calcNFails()}.
	 */
	@Test
	public void testCalcNFails() {
		assertTrue(e1.calcNFails() == 1);
		assertTrue(e2.calcNFails() == 1);
	}

	/**
	 * Test method for {@link moon.course.Exercise#addQuestion(moon.course.question.Question)}.
	 */
	@Test
	public void testAddQuestion() {
		/*Normal add question is tested with setup in the Question constructor*/
		/*In set up, we simulate someone does the exercise and now, we try to add again*/
		/*Question shouldnt be added*/
		
		e1.addQuestion(q5);
		assertFalse(e1.getQuestions().contains(q5));
	}

	/**
	 * Test method for {@link moon.course.Exercise#removeQuestion(moon.course.question.Question)}.
	 */
	@Test
	public void testRemoveQuestion() {
		/*We added and removed q5 before anyone doing the exercise, so q5 shouldnt be in e1*/
		assertFalse(e1.getQuestions().contains(q5));
	}

	/**
	 * Test method for {@link moon.course.Exercise#hasBeenDone()}.
	 */
	@Test
	public void testHasBeenDone() {
		assertTrue(e1.hasBeenDone());
		assertFalse(e3.hasBeenDone());
	}

	/**
	 * Test method for {@link moon.course.Exercise#getExerciseMark(moon.user.Student)}.
	 */
	@Test
	public void testGetExerciseMark() {
		assertTrue(e1.getExerciseMark(s1) == 1);
		assertTrue(e2.getExerciseMark(s2) == 0);
	}

	/**
	 * Test method for {@link moon.course.Exercise#getExercise(moon.user.Student)}.
	 */
	@Test
	public void testGetExercise() {
		assertEquals(e1.getExercise(s1), me1);
		assertEquals(e2.getExercise(s2), me4);
	}

	/**
	 * Test method for {@link moon.course.Exercise#isActive()}.
	 */
	@Test
	public void testIsActive() {
		assertTrue(e1.isActive());
		/*e2 dates were given in the wrong order, so we check they were swapped before setting them*/
		assertTrue(e2.isActive());
		assertFalse(e3.isActive());
	}

	/**
	 * Test method for {@link moon.course.Exercise#getStudentMarks()}.
	 */
	@Test
	public void testGetStudentMarks() {
		assert(e1.getStudentMarks().size() == 2);
		assert(e2.getStudentMarks().size() == 2);
		assert(e3.getStudentMarks().size() == 0);
	}

	/**
	 * Test method for {@link moon.course.Exercise#addMExercise(moon.mark.MExercise)}.
	 */
	@Test
	public void testAddMExercise() {
		/*Done in the constructor of MExe*/
		assertTrue(e1.getStudentMarks().contains(me1));
		assertTrue(e1.getStudentMarks().contains(me3));
		assertTrue(e2.getStudentMarks().contains(me2));
		assertTrue(e2.getStudentMarks().contains(me4));
	}

	/**
	 * Test method for {@link moon.course.Exercise#getQuestions()}.
	 */
	@Test
	public void testGetQuestions() {
		assertTrue(e1.getQuestions().size() == 2);
		assertTrue(e2.getQuestions().size() == 2);
		assertTrue(e3.getQuestions().size() == 0);
		assertTrue(e1.getQuestions().contains(q1));
		assertTrue(e1.getQuestions().contains(q2));
		assertTrue(e2.getQuestions().contains(q3));
		assertTrue(e2.getQuestions().contains(q4));
	}

	/**
	 * Test method for {@link moon.course.Exercise#setDates(java.time.LocalDate, java.time.LocalDate)}.
	 */
	@Test
	public void testSetDates() {
		/*This was tested with the setUp and the isActive*/
		/*We can now try to set e1 dates to check dates doesnt change (bc e1 has been done)*/
		e1.setDates(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 12, 1));
		assertTrue(e1.isActive());
	}
	
	/**
	 * Test method for {@link moon.course.Exercise#removeMExe(moon.mark.MExercise)}.
	 */
	@Test
	public void testRemoveMExe() {
		e1.removeMExe(me1);
		assertFalse(e1.getStudentMarks().contains(me1));
		/*We check what happens if an unexpected MExercise is given*/
		e2.removeMExe(me1);
	}
	
	/**
	 * Test method for {@link moon.course.CourseElement#getCourse()}.
	 */
	@Test
	public void testGetCourse() {
		assertEquals(e1.getCourse(), c1);
	}

	/**
	 * Test method for {@link moon.course.Exercise#setCourse(moon.course.Course)}.
	 */
	@Test
	public void testSetCourse() {
		/*We check the course is not setteable after the exercise has been done*/
		Course c2 = new Course("Course 2");
		e1.setCourse(c2);
		e3.setCourse(c2);
		assertEquals(e1.getCourse(), c1);
		assertEquals(e3.getCourse(), c2);
	}

	/**
	 * Test method for {@link moon.course.CourseElement#getUnit()}.
	 */
	@Test
	public void testGetUnit() {
		assertEquals(e1.getUnit(), u1);
		assertEquals(e2.getUnit(), u1);
		
	}

	/**
	 * Test method for {@link moon.course.Exercise#setUnit(moon.course.Unit)}.
	 */
	@Test
	public void testSetUnit() {
		/*We try to set unit after exercise has been done, check its not set*/
		/*Afterwards, we try to do a valid set with e3*/
		u2 = new Unit("Unit 1");
		e1.setUnit(u2);
		e3.setUnit(u2);
		assertEquals(e1.getUnit(), u1);
		assertEquals(e3.getUnit(), u2);
	}

	/**
	 * Test method for {@link moon.course.CourseElement#makeVisible()}.
	 */
	@Test
	public void testMakeVisible() {
		e1.makeInvisible();
		assertFalse(e1.getVisibility());
		e1.makeVisible();
		assertTrue(e1.getVisibility());
	}

	/**
	 * Test method for {@link moon.course.CourseElement#makeInvisible()}.
	 */
	@Test
	public void testMakeInvisible() {
		e1.makeVisible();
		assertTrue(e1.getVisibility());
		e1.makeInvisible();
		assertFalse(e1.getVisibility());
	}
	
	/**
	 * Test method for {@link moon.course.CourseElement#getVisibility()}.
	 */
	public void testGetVisibility(){
		assertTrue(e1.getVisibility());
		assertFalse(e3.getVisibility());
	}

}
