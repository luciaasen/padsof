package moon.course.question;

import java.io.Serializable;
import moon.mark.*;
import java.util.ArrayList;

import moon.course.Exercise;
import moon.mark.TfAnswer;

public class ChoiceQuestion extends Question implements Serializable{
	 private ArrayList<Option> correct;
	 private ArrayList<Option> options;
	 
	 /**
	  * ChoiceQuestion constructor
	  * @param question
	  * @param relevance
	  * @param exercise
	  * @param options
	  * @param correct (the correct option/s from the param options)
	  */
	 public ChoiceQuestion( String question, double relevance, ArrayList<Option> options, ArrayList<Option> correct, Exercise exe){
		 super(question, relevance, exe);
		 boolean valid = true;
		 for(Option op: correct){
			 if(options.contains(op) == false){
				 valid = false;
			 }
		 }
		 /*All correct options were in the possible options*/
		 if(valid == true){
			 this.options = options;
			 this.correct = correct;
		 }
	 }
	 
	 /**
	  * Question possible answers getter
	  * @return options
	  */
	 public ArrayList<Option> getOptions(){
		 return this.options;
	 }
	 /**
	  * Question correct answer/s getter
	  * @return correct
	  */
	 
	 @Override
	 public ArrayList<Option> getAnswer(){
		 return this.correct;
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
