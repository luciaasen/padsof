package moon.mark;

import java.io.Serializable;

import moon.course.question.*;

/**
 * Answer of a student to a true/false question.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class TfAnswer extends MQuestion implements Serializable{
	private Boolean answer;
	
	/**
	 * TfAnswer constructor
	 * @param question
	 * @param answer
	 */
	public TfAnswer(Question question, boolean answer){
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
		
		if (super.question instanceof TfQuestion){
			if(this.answer.equals(super.question.getAnswer())){
				return true;
			}
		}
		return false;
	}
	
	public boolean getAnswer(){
		return answer;
	}
}
