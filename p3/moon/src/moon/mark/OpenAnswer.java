package moon.mark;

import java.io.Serializable;

import moon.course.question.*;
import java.util.*;
/**
 * Answer of a student to an open answer question.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class OpenAnswer extends MQuestion implements Serializable{
	private Option answer;
	
	/**
	 * OpenAnswer constructor
	 * @param question
	 * @param answer
	 */
	public OpenAnswer(Question question, Option answer){
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
		for(Option o: (ArrayList<Option>)(super.question.getAnswer())){
			if(this.answer.equals(o)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the answer given by the student.
	 * @return
	 */
	public String getAnswer(){
		return answer.getOption();
	}
}