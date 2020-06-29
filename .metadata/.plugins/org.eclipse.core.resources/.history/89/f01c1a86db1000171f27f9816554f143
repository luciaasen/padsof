/**
 * 
 */
package moon.course.question.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import moon.course.Exercise;
import moon.course.question.TfQuestion;
import moon.mark.TfAnswer;

/**
 * @author lucia
 *
 */
public class TfQuestionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Exercise e = new Exercise();
		TfQuestion a1 = new TfQuestion("Is your answer wrong?", 5, true, e);
		TfQuestion a2 = new TfQuestion("Is your wrong an answer?", 6, false, e);	
		
		TfAnswer tf1right = new TfAnswer(a1, true);
		TfAnswer tf1wrong = new TfAnswer(a1, false);
		TfAnswer tf1wrong2 = new TfAnswer(a1, false);
		TfAnswer tf2right = new TfAnswer(a2, false);
		TfAnswer tf2right2 = new TfAnswer(a2, false);
		TfAnswer tf2wrong = new TfAnswer(a2, true);
		
	}

	/**
	 * Test method for {@link moon.course.question.TfQuestion#TfQuestion(java.lang.String, double, boolean)}.
	 */
	@Test
	public void testTfQuestion() {
		assertNotNull(a1);
	}

	/**
	 * Test method for {@link moon.course.question.TfQuestion#getAnswer()}.
	 */
	@Test
	public void testGetAnswer() {
		assertTrue(a1.getAnswer());
		assertFalse(a2.getAnswer());
	}

	/**
	 * Test method for {@link moon.course.question.Question#getRelevance()}.
	 */
	@Test
	public void testGetRelevance() {
		assertEquals(a1.getRelevance, 5);
		assertEquals(a2.getRelevance, 6);
	}

	/**
	 * Test method for {@link moon.course.question.Question#getExercise()}.
	 */
	@Test
	public void testGetExercise() {
		assertEquals(a1.getExercise(), e);
		assertEquals(a2.getExercise(), e);
		
	}

	/**
	 * Test method for {@link moon.course.question.Question#calcNPasses()}.
	 */
	@Test
	public void testCalcNPasses() {
		assertEquals(a1.calcNPasses(), 1);
		assertEquals(a2.calcNPasses(), 2);
	}

	/**
	 * Test method for {@link moon.course.question.Question#calcNFails()}.
	 */
	@Test
	public void testCalcNFails() {
		assertEquals(a1.calcNFails(), 2);
		assertEquals(a2.calcNFails(), 1);
	}

	/**
	 * Test method for {@link moon.course.question.Question#calcNAnswered()}.
	 */
	@Test
	public void testCalcNAnswered() {
		assertEquals(a1.calcNAnswered(), 1);
		assertEquals(a2.calcNAnswered(), 2);
	}

	/**
	 * Test method for {@link moon.course.question.Question#calcNUnanswered()}.
	 */
	@Test
	public void testCalcNUnanswered() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.question.Question#answer(moon.mark.MQuestion)}.
	 */
	@Test
	public void testAnswer() {
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
