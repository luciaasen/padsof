package moon.course;

import moon.course.question.*;
import moon.mark.*;
import moon.user.Student;

import java.util.ArrayList;

public class Exercise extends CourseElement{
	private ArrayList<Question> questions;
	private ArrayList<MExercise> studentMarks;
	private double relevance;
	/*PENALTY IS < 0*/
	private double penalty;
	private String name;
	private Boolean randord;
	
	/**
	 * Exercise constructor
	 */
	public Exercise(){
		this.questions = new ArrayList<Question>();
		this.studentMarks = new ArrayList<MExercise>();
	}
	
	
	
	/**
	 * Exercise relevance getter
	 * @return relevance
	 */
	public double getRelevance() {
		return relevance;
	}



	/**
	 * Sets relevance if noone has done the exercise
	 * @param relevance
	 */
	public void setRelevance(double relevance) {
		if(this.hasBeenDone() == false){
			this.relevance = relevance;
		}
	}



	/**
	 * Gets penalty of the exercise
	 * @return penalty
	 */
	public double getPenalty() {
		return penalty;
	}



	/**
	 * Sets penalty if noone has done it
	 * @param penalty
	 */
	public void setPenalty(double penalty) {
		if(this.hasBeenDone() == false){
			this.penalty = penalty;
		}
	}



	/**
	 * Gets name of exercise
	 * @return name
	 */
	public String getName() {
		return name;
	}



	/**
	 * Returns true if the orderr is random
	 * @return randord
	 */
	public Boolean getRandord() {
		return randord;
	}



	/**
	 * Sets the order to random if randord = true
	 * @param randord
	 */
	public void setRandord(Boolean randord) {
		if(this.hasBeenDone() == false){
			this.randord = randord;
		}
	}



	/**
	 * Returns the average mark of students who did the exercise
	 * @return double
	 */
	public double calcAverage(){
		double count = 0;
		for (MExercise m: this.studentMarks){
			count += m.getMark();
		}
		count /= this.studentMarks.size();
		return count;
	}
	
	/**
	 * Returns number of students who did and passed
	 * @return int
	 */
	public int calcNPasses(){
		int count = 0;
		for(MExercise m: this.studentMarks){
			if(m.getMark() >= 5){
				count ++;
			}
		}
		return count;
	}
	
	/**
	 * Returns number of students who did and failed
	 * @return int
	 */
	public int calcNFails(){
		return this.studentMarks.size() - this.calcNPasses();
	}
	
	/**
	 * Adds a new question to the exercise if it has not been done and it wasnt there before
	 * @param question
	 */
	public void addQuestion(Question question){
		if(this.hasBeenDone() == false){
			if(this.questions.contains(question) == false){
				this.questions.add(question);
			}
		}
	}
	
	/**
	 * Removes question to the exercise if it has not been done and the question was there before
	 * IMPORTANT: SAME REFERENCE, if when used the parameter is just a copy, we have to change implementation
	 * @param question
	 */
	public void removeQuestion(Question question){
		if(this.hasBeenDone() == false){
			if(this.questions.contains(question)){
				this.questions.remove(question);
			}
		}
	}
	
	/**
	 * Tells whether or not an exercise has been done
	 * @return true if anyone has done it, else false
	 */
	public Boolean hasBeenDone(){
		if(this.studentMarks.size() > 0){
			return false;
		}
		return true;
	}
	
	/**
	 * Gets the exercise mark for student
	 * @param student
	 * @return mark of that student, or  NaN if not found
	 */
	public double getExerciseMark(Student student){
		for(MExercise m: this.studentMarks){
			if(m.getStudent().equals(student)){
				return m.getMark();
			}
		}
		return Double.NaN;
	}
	
	/**
	 * Gets the exercise MExercise for student
	 * @param student
	 * @return MExercise of that student, or  null if not found
	 */
	public MExercise getExercise(Student student){
		for(MExercise m: this.studentMarks){
			if(m.getStudent().equals(student)){
				return m;
			}
		}
		return null;
	}
}
