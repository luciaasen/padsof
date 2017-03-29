/**
 * 
 */
package moon.course.question;

import java.io.Serializable;
import java.util.ArrayList;
import moon.course.*;
import moon.mark.ChoiceAnswer;
import moon.mark.MExercise;

/**
 * @author lucia and juan
 *
 */
public class OneChoiceQuestion extends ChoiceQuestion implements Serializable{	
	
	/**
	  * OneiChoiceQuestion constructor
	  * @param question
	  * @param relevance
	  * @param exercise
	  * @param options, the posible options
	  * @param correct (a list with the only correct option from the param options)
	  */
	public OneChoiceQuestion( String question, double relevance, ArrayList<Option> options, ArrayList<Option> correct, Exercise exe){
		super(question, relevance, options, correct, exe);
	}
	
	/**
	  * Adds option to a ChoiceANswer which is added to the question studentMarks AND to the MExercise
	  * @param ArrayList<Option> with the answer the studentMark will be associated to
	  * @param opt answer to the choice question
	  */
	 @Override
	 public boolean answer(Object opt, MExercise m) {

		 if(opt instanceof ArrayList<?> == false){
			 return false;
		 }
		 if(((ArrayList<?>)opt).get(0) instanceof Option == false){
			 return false;
		 }
		 if(super.answer(opt, m) == false){
			 return false;
		 }
		 ChoiceAnswer a = new ChoiceAnswer (this, (ArrayList<Option>)opt);
		 m.addMQuestion(a);
		 this.studentMarks.add(a);
		 return true;
	 } 
	
}
