/**
 * 
 */
package moon.course.question;


import moon.course.*;
import moon.mark.MExercise;
import moon.mark.MQuestion;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author lucia and juan
 *
 */
public abstract class ChoiceQuestion extends OpenQuestion implements Serializable{
	protected ArrayList<Option> options;
	
	/*
	public ChoiceQuestion(String question, double relevance,ArrayList<Option> options, ArrayList<Option> correct, Exercise exe){
		super(question, relevance, correct, exe);
		this.options = options;
	}
	*/
	
	
	/**
	  * ChoiceQuestion constructor
	  * If any of the correct options are not in the possible options, they are added to the possible
	  * @param question
	  * @param relevance
	  * @param exercise
	  * @param options, the posible options
	  * @param correct (the correct option/s from the param options)
	  */
	 public ChoiceQuestion( String question, double relevance, ArrayList<Option> options, ArrayList<Option> correct, Exercise exe){
		 super(question, relevance, correct, exe);
		 for(Option op: correct){
			 if(options.contains(op) == false){
				 options.add(op);
			 }
		 }
		 this.options = options;
	 }
	
	/**
	  * Question possible answers getter
	  * @return options
	  */
	 public ArrayList<Option> getOptions(){
		 return this.options;
	 }
	 
	 public boolean answer(Object o, MExercise m){
			/* Check no other answers to the same question in MExercise */
			for(MQuestion mq: m.getmQuestions()){
				if(mq.getQuestion().equals(this)){
					return false;
				}
			}
			return true;
		}

}
