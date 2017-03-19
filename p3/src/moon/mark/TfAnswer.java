package moon.mark;

import moon.course.question.*;

public class TfAnswer extends MQuestion{
	private Boolean answer;
	
	/**
	 * TfAnswer constructor
	 * @param question
	 * @param answer
	 */
	public TfAnswer(Question question, boolean answer){
		super(question);
		this.answer = answer;
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
}
