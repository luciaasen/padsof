package moon.mark;

import java.io.Serializable;

import moon.course.question.*;


public abstract class MQuestion extends Mark implements Serializable{
	protected Question question;
	protected double mark;
	
	
	/**
	 * Constructor fot MQuestion
	 * @param question
	 */
	public MQuestion(Question question){
		super();
		this.question = question;
		this.mark = 0;
		//TODO ask if this works: would execute the child isCorrect?
	}
	
	/**
	 * Question getter
	 * @return the question related to the MQuestion
	 */
	public Question getQuestion(){
		return this.question;
	}
	
	/**
	 * Mark getter
	 * @return mark of the question
	 */
	public double getMark(){
		return this.mark;
	}
	
	public abstract Boolean isCorrect();
}
