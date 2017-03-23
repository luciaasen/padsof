package moon.mark;

import java.io.Serializable;
import java.util.ArrayList;
import moon.course.question.*;

public class ChoiceAnswer extends MQuestion implements Serializable{
	private ArrayList<Option> answers;
	
	/**
	 * Constructor for ChoiceAnswer
	 * @param answers
	 */
	public ChoiceAnswer(Question question, ArrayList<Option> answers){
		super(question);
		this.answers = answers;
		if(this.isCorrect()){
			this.mark = this.getQuestion().getRelevance();			
		}else{
			this.mark = this.getQuestion().getExercise().getPenalty();
		}
	}
	
	/**
	 * Returns true if the student answers are correct
	 * IMPORTANT: ANSWERS MUST BE IN THE SAME ORDER!
	 * @return Boolean
	 */
	@Override
	public Boolean isCorrect(){
		if (this.answers.equals(super.question.getAnswer())){
			return true;
		}
		return false;
	}
	
}
