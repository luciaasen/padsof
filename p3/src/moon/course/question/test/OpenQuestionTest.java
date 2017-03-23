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
/**
 * @author lucia
 *
 */
public class OpenQuestionTest {

	private Exercise e1;
	private OpenQuestion q1, q2, q3;
	private OpenAnswer mq1, mq2, mq3;
	/**
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
		Unit u1 = q1.getExercise().getUnit();
		
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