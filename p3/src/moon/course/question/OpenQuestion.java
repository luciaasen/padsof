package moon.course.question;

import java.io.Serializable;
import java.util.ArrayList;

import moon.mark.*;
import moon.course.Exercise;

/**
 * This class is a type of Question that can recieve an open text answer.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class OpenQuestion extends Question implements Serializable{
	
	protected ArrayList<Option> correct;
	
	/**
	 * OpenQuestion constructor
	 * @param question
	 * @param relevance
	 * @param exe
	 * @param answer, an ArrayList<Option> with the correct answers
	 */
	public OpenQuestion(String question, double relevance, ArrayList<Option> answer, Exercise exe) {
		super(question, relevance, exe);
		this.correct = answer;
	}

	/**
	 * Correct question answer getter
	 * @return
	 */
	public ArrayList<Option> getAnswer(){
		return this.correct;
	}
	
	/**
	 * Adds a new OpenAnswer to the OpenQuestion student marks with the string "answer"
	 * @param String with the answer
	 * @param answer to the OpenQuestion
	 */
	@Override
	public boolean answer(Object answer, MExercise m){
		if (answer instanceof Option){
			
			if(super.answer(answer, m) == false){
				return false;
			}			
			//TODO check que studentMarks no tiene ya un mq de ese student ¿
			OpenAnswer mq = new OpenAnswer(this, (Option)answer);
			m.addMQuestion(mq);
			this.studentMarks.add(mq);	
			return true;
		}
		return false;
	}
	
}
