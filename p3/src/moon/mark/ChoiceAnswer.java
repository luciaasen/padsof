package moon.mark;

import java.util.ArrayList;
import moon.course.question.*;

public class ChoiceAnswer extends MQuestion{
	private ArrayList<Option> answers;
	
	/**
	 * Constructor for ChoiceAnswer
	 * @param answers
	 */
	public ChoiceAnswer(Question question, ArrayList<Option> answers){
		super(question);
		this.answers = answers;
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
