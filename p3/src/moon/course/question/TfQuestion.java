package moon.course.question;

import java.io.Serializable;

public class TfQuestion extends Question implements Serializable{
	private Boolean answer;
	
	/**
	 * TfQuestion constructor
	 * @param question
	 * @param relevance
	 * @param answer
	 */
	public TfQuestion(String question, double relevance, boolean answer) {
		super(question, relevance);
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
