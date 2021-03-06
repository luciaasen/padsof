package moon.course.question;

import java.io.Serializable;
import moon.mark.*;
import moon.course.Exercise;

/**
 * This class is a type of question. It is used for the true/false questions.
 * @author Juan Riera and Lucia Asencio
 *
 */
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

	
	/**
	  * Adds b to a TfAnswer which is added to the question studentMarks
	  * @param b, boolean answer to the question
	  * @param MExercise the ANswer will be associated to
	  */
	@Override
	public boolean answer(Object b, MExercise m) {
		if(b instanceof Boolean){
			if(super.answer(answer, m) == false){
				return false;
			}
			TfAnswer a = new TfAnswer(this, (Boolean)b);
			m.addMQuestion(a);
			this.studentMarks.add(a);
		}
		return false;
	}
}
