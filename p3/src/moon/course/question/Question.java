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
	protected ArrayList<MQuestion> studentMarks;
	
	/**
	 * Question constructor
	 * IMPORTANT: apart from setting this.exercise attribute, adds 'this' to the exercise questions
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
		exe.addQuestion(this);
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
		return this.studentMarks.size() - this.calcNPasses();
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
	 * Adds m to the list of answers to the question, only if the question associated to m is this
	 * @param o, object that would be a String, an ArrayList or a Boolean
	 * @param MExercise the ANswer will be associated to
	 */
	public boolean answer(Object o, MExercise m){
		/*Check no other answers to the same question in MExercise*/
		for(MQuestion mq: m.getmQuestions()){
			if(mq.getQuestion().equals(this)){
				return false;
			}
		}
		return true;
	}
	
	/** Gets the text of the question
	 * 
	 * @return  the string of the question
	 */
	public String getQuestion(){
		return question;
	}
		
	/**
	 * Returns the correct answer to the question
	 * @return 
	 */
	public abstract Object getAnswer();
	
	/**
	 * Gets student marks of the question
	 * @return list of queston marks
	 */
	//TODO add this to at least one of the three Question tests
	public ArrayList<MQuestion> getStudentMarks(){
		return this.studentMarks;
	}
}
