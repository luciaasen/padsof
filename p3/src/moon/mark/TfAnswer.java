package moon.mark;

import moon.course.question.*;

public class TfAnswer extends MQuestion{
	private boolean answer;
	
	/**
	 * TfAnswer constructor
	 * @param question
	 * @param answer
	 */
	public TfAnswer(Question question, boolean answer){
		super(question);
		this.answer = answer;
	}
}
