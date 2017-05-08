package moon.mark;

import java.io.Serializable;

import moon.course.question.*;
/**
 * Class in which the answer of a student is stored
 * @author Juan Riera and Lucia Asencio.
 *
 */
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
	
	/**
	 * Abstract declaration of isCorrect, that will check if the answer
	 * given by the student is correct or not.
	 * @return true if it is correct and false if it is not.
	 */
	public abstract Boolean isCorrect();
}
