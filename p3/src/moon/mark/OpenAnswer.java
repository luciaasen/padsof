package moon.mark;

import java.io.Serializable;

import moon.course.question.*;

/**
 * Answer of a student to an open answer question.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class OpenAnswer extends MQuestion implements Serializable{
	private String answer;
	
	/**
	 * OpenAnswer constructor
	 * @param question
	 * @param answer
	 */
	public OpenAnswer(Question question, String answer){
		super(question);
		this.answer = answer;
		if(this.isCorrect()){
			this.mark = this.getQuestion().getRelevance();			
		}else{
			this.mark = this.getQuestion().getExercise().getPenalty();
		}
	}
	
	/**
	 * Returns true if the question was correctly answered
	 * @return Boolean
	 */ 
	@Override
	public Boolean isCorrect(){
		
		if(this.answer.equals(super.question.getAnswer())){
			return true;
		}
		return false;
	}
}