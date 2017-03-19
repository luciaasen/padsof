package moon.course.question;

import java.util.ArrayList;
import moon.course.*;
import moon.course.question.*;
import moon.mark.*;

abstract public class Question {
	private String question;
	private double relevance;
	private Exercise exe;
	private ArrayList<MQuestion> studentMarks;
	
	/**
	 * Question constructor
	 * @param question
	 * @param relevance
	 */
	public Question (String question, double relevance){
		this.question= question;
		this.relevance = relevance;
		studentMarks = new ArrayList<MQuestion>();
	}
	
	/**
	 * Calculate number of students who passed the question
	 * @return
	 */
	public int calcNPasses(){
		int count = 0;
		for(MQuestion mq: this.studentMarks){
			if(mq.isCorrect() == true){
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Calculate number of students who failed the question
	 * @return
	 */
	public int calcNFails(){
		return this.exe.getCourse().getStudents().size() - this.calcNPasses();
	}
	
	/**
	 * Calculate number of students who answered the question
	 * @return
	 */
	public int calcNAnswered(){
		return this.studentMarks.size();
	}
	
	/**
	 * Calculate number of students who didnt answer the question
	 * @return
	 */
	public int calcNUnanswered(){
		return this.exe.getCourse().getStudents().size() - this.studentMarks.size();
	}
	
	/**
	 * Adds m to the list of answers to the question
	 * @param m
	 */
	public void answer(MQuestion m){
		this.studentMarks.add(m);
	}
	
	
	
	/**
	 * Equals method for the abstract class
	 */
	@Override
	public boolean equals(Object obj){
		return false;
	}
		
	/**
	 * Returns the correct answer to the question
	 * @return 
	 */
	public abstract Object getAnswer();
}
