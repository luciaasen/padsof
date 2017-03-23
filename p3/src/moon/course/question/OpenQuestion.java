package moon.course.question;

import java.io.Serializable;

public class OpenQuestion extends Question implements Serializable{
	
	private String answer;
	
	/**
	 * OpenQuestion constructor
	 * @param question
	 * @param relevance
	 * @param answer
	 */
	public OpenQuestion(String question, double relevance, String answer) {
		super(question, relevance);
		this.answer = answer;
	}

	/**
	 * Correct question answer getter
	 * @return
	 */
	public String getAnswer(){
		return this.answer;
	}
	
}
