/**
 * 
 */
package moon.course.question.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import moon.course.*;
import moon.course.question.*;
import org.junit.Before;
import org.junit.Test;
import moon.mark.*;
import moon.user.*;
/**
 * Test class for the class OpenQuestion.
 * @author Lucia Asencio and Juan Riera
 *
 */
public class OpenQuestionTest {

	private Exercise e1;
	private OpenQuestion q1, q2, q3;
	private MExercise me1;
	private Option o1, o2, o3;
	private ArrayList<Option> correct1 = new ArrayList<>(), correct2 = new ArrayList<>();
	
	/**
	 * Set Up creates an exercise and associate to it 3 questions, and add answers to each.
	 * Also creates a unit and a course to associate to the exercise where questions are, and students to associate to the answers.
	 * Emulates the actions that would be performed if these students answered some of the questions
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		e1 = new Exercise();
		o1 = new Option("No");
		o2 = new Option("Yes");
		o3 = new Option("Maybe");
		correct1.add(o1);
		correct2.add(o2);
		correct2.add(o3);
		q1 = new OpenQuestion("Am I silly?", 5, correct1, e1);
		q2 = new OpenQuestion("Am I?", 10, correct2, e1);		
		q3 = new OpenQuestion("Am I?", -10, correct2, e1);	
		
		
		
		//Add 3 students to c1 and simulate 2 of them answer to q1
		
		Course c1 = new Course("Course 1");
		Unit u1 = new Unit("Unit 1");
		u1.setCourse(c1);
		e1.setUnit(u1);
		Student s1 = new Student("Pepe", "Martin", "password", 1, "a.b@c.d"), s2 = new Student("Mimi", "Gzlez", "wordpass", 2, "a.c@b.d"), s3 = new Student("Marta", "Fdez", "pwwp", 3, "d.c@b.a");
		
		c1.addStudent(s1);
		MCourse mc1 = new MCourse(c1, s1);
		me1 = new MExercise(e1);
		mc1.addMExe(me1);
		q1.answer(o1, me1);
		q2.answer(o1, me1);
		
		
		c1.addStudent(s2);
		MCourse mc2 = new MCourse(c1, s2);
		MExercise me2 = new MExercise(e1);
		mc2.addMExe(me2);
		q1.answer(o2, me2);		
		
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
		assertEquals(q1.getAnswer(), correct1);
		assertEquals(q2.getAnswer(), correct2);
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
		assertTrue(q1.calcNUnanswered() == 1);
		assertTrue(q2.calcNUnanswered() == 2);
		assertTrue(q3.calcNUnanswered() == 3);
	}

	/**
	 * Test method for {@link moon.course.question.Question#answer(moon.mark.MQuestion)}.
	 */
	@Test
	public void testAnswer() {
		/*This method has been used in the previous tests. Just in case, we check the method has added the correct number of answers to the correct question */
		
		assertTrue(q1.calcNAnswered() == 2);
		assertTrue(q1.calcNUnanswered() == 1);
		int numQ1 = 0, numQ2 = 0;
		for(MExercise me: e1.getStudentMarks()){
			for(MQuestion mq : me.getmQuestions()){
				if(mq.getQuestion() == q1){
					numQ1 ++;
				}else if(mq.getQuestion() == q2){
					numQ2 ++;
				}
			}
		}
		
		assertTrue(numQ1 == 2 & numQ2 == 1);
	}
	
	/**
	 * Test method for {@link moon.course.question.Question#getStudentMarks(moon.mark.MQuestion)}.
	 */
	@Test
	public void testGetStudentMarks() {
		ArrayList<MQuestion> mq1 = q1.getStudentMarks();
		ArrayList<MQuestion> mq2 = q2.getStudentMarks();
		ArrayList<MQuestion> mq3 = q3.getStudentMarks();
		assertEquals(mq1.size(), 2);
		assertEquals(mq2.size(), 1);
		assertEquals(mq3.size(), 0);
	}


}
