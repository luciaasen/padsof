package moon.mark;

import moon.course.question.*;


public abstract class MQuestion extends Mark{
	protected Question question;
	
	/**
	 * Constructor fot MQuestion
	 * @param question
	 */
	public MQuestion(Question question){
		super();
		this.question = question;
	}
	
	public abstract Boolean isCorrect();
}
