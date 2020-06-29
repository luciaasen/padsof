package moon.course.question;

import java.io.Serializable;
import moon.mark.*;
import java.util.ArrayList;

import moon.course.Exercise;
import moon.mark.TfAnswer;

/**
 * This class is a type of question, the one in which you have to choose
 * between some options.
 * @author Juan Riera and Lucia Asencio
 */
public class MultiChoiceQuestion extends ChoiceQuestion implements Serializable{
	 
	 /**
	  * MultiChoiceQuestion constructor
	  * If any of the correct options are not in the possible options, they are added to the possible
	  * @param question
	  * @param relevance
	  * @param exercise
	  * @param options, the posible options
	  * @param correct (the correct option/s from the param options)
	  */	
	public MultiChoiceQuestion( String question, double relevance, ArrayList<Option> options, ArrayList<Option> correct, Exercise exe){
		super(question, relevance, options, correct, exe);
	}
	 	 
	 /**
	  * Adds option to a ChoiceANswer which is added to the question studentMarks AND to the MExercise
	  * @param ArrayList<Option> with the answer the studentMark will be associated to
	  * @param opt answer to the choice question
	  */
	 @Override
	 public boolean answer(Object opt, MExercise m) {
		boolean valid = true;
	 	if(opt instanceof ArrayList<?>){
	 		for(Object o: (ArrayList<?>)opt){
	 			if((o instanceof Option) == false){
	 				valid = false;
	 			}	 			
	 		}
	 		if(valid == false){
	 			return false;
	 		}	 		
	 		/*If it hasnt returned yet, the Object is an ArrayList<Option> so we can crete de ChoiceAnswer */
	 		
	 		if(super.answer(opt, m) == false){
	 			return false;
	 		}
	 		ChoiceAnswer a = new ChoiceAnswer (this, (ArrayList<Option>)opt);
			m.addMQuestion(a);
			this.studentMarks.add(a);
			return true;	 
	 	}
	 	return false;
	 }
}
