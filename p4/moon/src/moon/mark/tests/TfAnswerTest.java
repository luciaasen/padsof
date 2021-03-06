/**
 * 
 */
package moon.mark.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import moon.course.Exercise;
import moon.course.question.*;
import moon.mark.*;

/**
 * Test class for the TfAnswer class.
 * @author Lucia Asencio and Juan Riera
 *
 */
public class TfAnswerTest {
	private Exercise e1;
	private TfQuestion q1;
	private TfAnswer answer1, answer2;
	
	/**
	 * Creates an exercise, sets its penalty and add a question to it.
	 * Creates a correct and a wrong answer to the question
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		e1 = new Exercise();
		e1.setPenalty(-3);
		q1 = new TfQuestion("Am I silly?", 5, false, e1);
		answer1 = new TfAnswer(q1, false);
		answer2 = new TfAnswer(q1, true);		
	}

	/**
	 * Test method for {@link moon.mark.TfAnswer#isCorrect()}.
	 */
	@Test
	public void testIsCorrect() {
		assertTrue(answer1.isCorrect() & (answer2.isCorrect() == false));
	}

	/**
	 * Test method for {@link moon.mark.TfAnswer#TfAnswer(moon.course.question.Question, boolean)}.
	 */
	@Test
	public void testTfAnswer() {
		assertNotNull(answer1);
		assertNotNull(answer2);
	}

	/**
	 * Test method for {@link moon.mark.MQuestion#getMark()}.
	 */
	@Test
	public void testGetMark() {
		assertTrue((answer1.getMark() == 5) & (answer2.getMark() == -3));
	}

	/**
	 * Test method for {@link moon.mark.MQuestion#MQuestion(moon.course.question.Question)}.
	 */
	@Test
	public void testMQuestion() {
		assertTrue(answer1.getQuestion() == q1 & answer2.getQuestion() == q1);
	}

	/**
	 * Test method for {@link moon.mark.MQuestion#getQuestion()}.
	 */
	@Test
	public void testGetQuestion() {
		assertTrue(answer1.getQuestion() == q1 & answer2.getQuestion() == q1);
	}

}
