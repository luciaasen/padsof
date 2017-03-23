package moon.course.question;

import java.io.Serializable;

import moon.course.Exercise;

public class TfQuestion extends Question implements Serializable{
	private Boolean answer;
	
	/**
	 * TfQuestion constructor
	 * @param question
	 * @param relevance
	 * @param answer
	 */
	public TfQuestion(String question, double relevance, boolean answer, Exercise exe) {
		super(question, relevance, exe);
		this.answer = answer;
	}

	/**
	 * Correct answer getter for the question
	 * @return
	 */
	@Override
	public Boolean getAnswer(){
		return this.answer;
	}
}
