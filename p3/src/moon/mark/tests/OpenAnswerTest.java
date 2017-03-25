/**
 * 
 */
package moon.mark.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import moon.mark.*;
import moon.course.Course;
import moon.course.Exercise;
import moon.course.Unit;
import moon.course.question.OpenQuestion;
import moon.user.Student;

/**
 * @author lucia
 *
 */
public class OpenAnswerTest {

	private Exercise e1;
	private OpenQuestion q1;
	private OpenAnswer answer1, answer2;
	
	/**
	 * Creates an exercise, sets its penalty and add a question to it.
	 * Creates a correct and a wrong answer to the question
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		e1 = new Exercise();
		e1.setPenalty(-3);
		q1 = new OpenQuestion("Am I silly?", 5, "No", e1);
		answer1 = new OpenAnswer(q1, "No");
		answer2 = new OpenAnswer(q1, "Yes");		
	}

	/**
	 * Test method for {@link moon.mark.OpenAnswer#isCorrect()}.
	 */
	@Test
	public void testIsCorrect() {
		assertTrue(answer1.isCorrect() & (answer2.isCorrect() == false));
	}

	/**
	 * Test method for {@link moon.mark.OpenAnswer#OpenAnswer(moon.course.question.Question, java.lang.String)}.
	 */
	@Test
	public void testOpenAnswer() {
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
	 * Test method for {@link moon.mark.MQuestion#getQuestion()}.
	 */
	@Test
	public void testGetQuestion() {
		assertTrue(answer1.getQuestion() == q1 & answer2.getQuestion() == q1);
	}

}
