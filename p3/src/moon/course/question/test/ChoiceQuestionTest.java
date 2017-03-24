/**
 * 
 */
package moon.course.question.test;

import static org.junit.Assert.*;
import moon.mark.*;
import org.junit.Before;
import org.junit.Test;
import moon.course.Exercise;
import moon.course.question.*;
import java.util.*;

/**
 * @author lucia
 *
 */
public class ChoiceQuestionTest {
	
	private Exercise e1;
	private ChoiceQuestion q1, q2, q3;
	private MExercise me1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Option option1 = new Option("Yes");
		Option option2 = new Option("No");
		Option opAnswer2 = new Option("Yes");
		Option opAnswer1 = new Option("No");
		
		ArrayList<Option> op1 = new ArrayList();
		ArrayList<Option> correct1 = new ArrayList();
		ArrayList<Option> op2 = new ArrayList();
		ArrayList<Option> correct2 = new ArrayList();
				
		op1.add(option1);
		op1.add(option2);
		correct1.add(option2);
		op2.add(option1);
		op2.add(option2);
		correct2.add(option1);
		
		e1 = new Exercise();
		q1 = new ChoiceQuestion("Am I silly?", 5, e1);
		q2 = new ChoiceQuestion("Am I?", 10, e1);		
		q3 = new ChoiceQuestion("Am I?", -10, e1);	
	}

	/**
	 * Test method for {@link moon.course.question.ChoiceQuestion#ChoiceQuestion(java.lang.String, double)}.
	 */
	@Test
	public void testChoiceQuestion() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.question.ChoiceQuestion#getOptions()}.
	 */
	@Test
	public void testGetOptions() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.question.ChoiceQuestion#getCorrect()}.
	 */
	@Test
	public void testGetCorrect() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.question.ChoiceQuestion#getAnswer()}.
	 */
	@Test
	public void testGetAnswer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.question.Question#Question(java.lang.String, double, moon.course.Exercise)}.
	 */
	@Test
	public void testQuestion() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.question.Question#getRelevance()}.
	 */
	@Test
	public void testGetRelevance() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.question.Question#getExercise()}.
	 */
	@Test
	public void testGetExercise() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.question.Question#calcNPasses()}.
	 */
	@Test
	public void testCalcNPasses() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.question.Question#calcNFails()}.
	 */
	@Test
	public void testCalcNFails() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.course.question.Question#calcNAnswered()}.
	 */
	@Test
	public void testCalcNAnswered() {
		fail("Not yet implemented");
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
