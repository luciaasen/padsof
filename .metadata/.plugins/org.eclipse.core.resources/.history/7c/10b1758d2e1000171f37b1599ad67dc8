package moon.course.question;

import java.io.Serializable;

import moon.course.Exercise;

public class OpenQuestion extends Question implements Serializable{
	
	private String answer;
	
	/**
	 * OpenQuestion constructor
	 * @param question
	 * @param relevance
	 * @param answer
	 */
	public OpenQuestion(String question, double relevance, String answer, Exercise exe) {
		super(question, relevance, exe);
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
