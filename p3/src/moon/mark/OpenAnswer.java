package moon.mark;

import moon.course.question.*;

public class OpenAnswer extends MQuestion{
	private String answer;
	
	/**
	 * OpenAnswer constructor
	 * @param question
	 * @param answer
	 */
	public OpenAnswer(Question question, String answer){
		super(question);
		this.answer = answer;
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
