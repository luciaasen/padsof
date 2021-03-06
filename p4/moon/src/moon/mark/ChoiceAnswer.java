package moon.mark;

import java.io.Serializable;
import java.util.ArrayList;
import moon.course.question.*;

/**
 * Class in which the answer to a question of multiple choices 
 * of a student is stored. It extends MQuestion.
 * @author Juan Riera and Lucia Asencio.
 *
 */
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
	 * IMPORTANT: ASSUME OPTIONS ARE NOT REPEATED IN THE CORRECT OPTIONS LIST, NEITHER IN THE ANSWER OPTIONS LIST
	 * I.e.: just checks if the size of the answer options and the correct options are the same, and if for each
	 * option in the answer list, that option is in the correct list
	 * @return Boolean
	 */
	@Override
	public Boolean isCorrect(){
		/*I assume options and answers wont be repeated, so we just check that the correct an the answers are the 
		 * same size and that, for each option in the answer, the option is in the correct*/
		if (this.answers.size() == ((ArrayList<Option>)this.question.getAnswer()).size()){
			for (Option ans: this.answers){
				if(((ArrayList<Option>)this.question.getAnswer()).contains(ans) == false){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public ArrayList<Option> getAnswers(){
		return answers;
	}
	
}
