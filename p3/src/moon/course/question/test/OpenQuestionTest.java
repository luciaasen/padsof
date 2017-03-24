/**
 * 
 */
package moon.course.question.test;

import static org.junit.Assert.*;
import moon.course.*;
import moon.course.question.*;
import org.junit.Before;
import org.junit.Test;
import moon.mark.*;
import moon.user.*;
/**
 * @author lucia
 *
 */
public class OpenQuestionTest {

	private Exercise e1;
	private OpenQuestion q1, q2, q3;
	private OpenAnswer mq1, mq2, mq3;
	/**
	 * Set Up creates an exercise and associate to it 3 questions, and add answers to 2 questions.
	 * Also creates a unit and a course to associate to the exercise where questions are, and students to associate to the answers.
	 * Creat
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Exercise e1 = new Exercise();
		OpenQuestion q1 = new OpenQuestion("Am I silly?", 5, "No", e1);
		OpenQuestion q2 = new OpenQuestion("Am I?", 10, "Yes", e1);		
		OpenQuestion q3 = new OpenQuestion("Am I?", -10, "Yes", e1);	
		OpenAnswer mq1 =  new OpenAnswer(q1, "No");
		OpenAnswer mq2 = new OpenAnswer(q1, "Yes");
		OpenAnswer mq3 = new OpenAnswer(q2, "No");
		Unit u1 = new Unit("Unit 1");
		Course c1 = new Course("Course 1");
		MCourse mc1;
		MExercise me1 = new MExercise(e1);
		Student s1, s2, s3;
		
		//Add MExercise the 2 questions of e1, then add e1 to u1 and u1 to c1.
		//Add 3 students to c1 and 2 of them(the ones which answer) to the MCourse associated to e1 and to c1
		me1.addMQuestion(mq1);
		me1.addMQuestion(mq2);
		//Necesito: curso relacionado con lo 3 estudiantes. MQuestion relacionado con Mexercise relacionado con los 3 estudiantes.
		e1.setUnit(u1);
		u1.setCourse(c1);
		
		s1 = new Student("Pepe", "Martin", "password", 1, "a.b@c.d");
		s2 = new Student("Mimi", "Gzlez", "wordpass", 2, "a.c@b.d");
		s3 = new Student("Marta", "Fdez", "pwwp", 3, "d.c@b.a");
		c1.addStudent(s1);
		c1.addStudent(s2);
		c1.addStudent(s3);
		
	}

	/**
	 * Test method for {@link moon.course.question.OpenQuestion#OpenQuestion(java.lang.String, double, java.lang.String)}.
	 */
	@Test
	public void testOpenQuestion() {
		assertNotNull(q1);
		assertNotNull(q3);
	}

	/**
	 * Test method for {@link moon.course.question.OpenQuestion#getAnswer()}.
	 */
	@Test
	public void testGetAnswer() {
		assertEquals(q1.getAnswer(), "No");
		assertEquals(q2.getAnswer(), "Yes");
	}

	/**
	 * Test method for {@link moon.course.question.Question#getRelevance()}.
	 */
	@Test
	public void testGetRelevance() {
		assertTrue(q1.getRelevance() == 5);
		assertTrue(q3.getRelevance() == 1);
	}

	/**
	 * Test method for {@link moon.course.question.Question#getExercise()}.
	 */
	@Test
	public void testGetExercise() {
		assertEquals(q1.getExercise(), e1);
		assertEquals(q2.getExercise(), e1);
	}

	/**
	 * Test method for {@link moon.course.question.Question#calcNPasses()}.
	 */
	@Test
	public void testCalcNPasses() {
		assertEquals(q1.calcNPasses(), 1);
		assertEquals(q2.calcNPasses(), 0);
	}

	/**
	 * Test method for {@link moon.course.question.Question#calcNFails()}.
	 */
	@Test
	public void testCalcNFails() {
		assertEquals(q1.calcNFails(), 1);
		assertEquals(q2.calcNFails(), 1);
	}

	/**
	 * Test method for {@link moon.course.question.Question#calcNAnswered()}.
	 */
	@Test
	public void testCalcNAnswered() {
		assertEquals(q1.calcNAnswered(), 2);
		assertEquals(q2.calcNAnswered(), 1);
	}

	/**
	 * Test method for {@link moon.course.question.Question#calcNUnanswered()}.
	 */
	@Test
	public void testCalcNUnanswered() {
		int total = q1.getExercise().getUnit().getCourse().getStudents().size();
		assert()
	}

	/**
	 * Test method for {@link moon.course.question.Question#answer(moon.mark.MQuestion)}.
	 */
	@Test
	public void testAnswer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.question.Question#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.question.Question#getAnswer()}.
	 */
	@Test
	public void testGetAnswer1() {
		fail("Not yet implemented");
	}

}
