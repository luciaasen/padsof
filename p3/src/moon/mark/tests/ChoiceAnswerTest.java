package moon.mark.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import moon.course.Exercise;
import moon.course.question.*;
import moon.mark.*;


public class ChoiceAnswerTest {
	private Exercise e1;
	private ChoiceQuestion q1;
	private ChoiceAnswer answer1, answer2;
	private ArrayList<Option> op1;
	private ArrayList<Option> correct1;
	
	/**
	 * Creates some list of options 
	 * Creates an exercise, sets its penalty and add a question to it.
	 * Creates a correct and a wrong answer to the question
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		/*Creates list of options*/
		Option option1 = new Option("Yes");
		Option option2 = new Option("No");
		
		op1 = new ArrayList<Option>();
		correct1 = new ArrayList<Option>();
				
		op1.add(option1);
		op1.add(option2);
		correct1.add(option2);
		
		/*Creates exercise, question and answers*/
		e1 = new Exercise();
		e1.setPenalty(-3);
		q1 = new ChoiceQuestion("Am I silly?", 5, op1, correct1, e1);
		answer1 = new ChoiceAnswer(q1, correct1);
		answer2 = new ChoiceAnswer(q1, op1);
	}

	@Test
	public void testIsCorrect() {
		assertTrue(answer1.isCorrect() & (answer2.isCorrect() == false));
	}

	@Test
	public void testChoiceAnswer() {
		assertNotNull(answer1);
		assertNotNull(answer2);
	}

	@Test
	public void testGetMark() {
		assertTrue((answer1.getMark() == 5) & (answer2.getMark() == -3));
	}

	
	@Test
	public void testGetQuestion() {
		assertTrue(answer1.getQuestion() == q1 & answer2.getQuestion() == q1);
	}

}
