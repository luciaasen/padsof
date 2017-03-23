package moon.course.question;

import java.io.Serializable;
import java.util.ArrayList;

import moon.course.Exercise;

public class ChoiceQuestion extends Question implements Serializable{
	 private ArrayList<Option> correct;
	 private ArrayList<Option> options;
	 
	 /**
	  * ChoiceQuestion constructor
	  * @param question
	  * @param relevance
	  * @param exercise
	  */
	 public ChoiceQuestion( String question, double relevance, Exercise exe){
		 super(question, relevance, exe);
		 correct = new ArrayList<Option>();
		 options = new ArrayList<Option>();
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
	 public ArrayList<Option> getCorrect() {
		 return this.correct;
	 }
	
	 /**
	  * Returns the correct answers to the Question
	  * @return ArrayList
	  */
	 @Override
	 public ArrayList<Option> getAnswer(){
		 return this.correct;
	 }
	
}
