package moon.course.question;

import java.io.Serializable;
import java.util.ArrayList;
import moon.course.*;
import moon.course.question.*;
import moon.mark.*;

abstract public class Question implements Serializable{
	private String question;
	private double relevance;
	private Exercise exe;
	private ArrayList<MQuestion> studentMarks;
	
	/**
	 * Question constructor
	 * @param question
	 * @param exe
	 * @param relevance > 0. Else, it will be set up as 1
	 */
	public Question (String question, double relevance, Exercise exe){
		if(relevance < 1){
			relevance = 1;
		}
		this.question= question;
		this.relevance = relevance;
		this.exe = exe;
		studentMarks = new ArrayList<MQuestion>();
	}
	
	/**
	 * Relevance getter
	 * @return relevance of the exercise
	 */
	public double getRelevance(){
		return this.relevance;
	}
	
	public Exercise getExercise(){
		return this.exe;
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
	
	/** Gets the text of the question
	 * 
	 * @return  the string of the question
	 */
	public String getQuestion(){
		return question;
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
