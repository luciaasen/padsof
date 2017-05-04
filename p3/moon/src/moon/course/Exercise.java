package moon.course;

import moon.course.question.*;
import moon.mark.*;
import moon.user.Student;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This is a class that stores all the information of an exercise.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class Exercise extends CourseElement implements Serializable{
	private ArrayList<Question> questions;
	private ArrayList<MExercise> studentMarks;
	private double relevance;
	/*PENALTY IS < 0*/
	private double penalty;
	private String name;
	private Boolean randord;
	LocalDate activeFrom;
	LocalDate activeTo;
	
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
			if(relevance <= 0){
				relevance = 1;
			}
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
			if(penalty > 0){
				penalty = -1;
			}
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
	 * Sets the name of an exercise
	 * @param name
	 */
	public void setName(String name){
		if(this.hasBeenDone() == true){
			return;
		}
		this.name = name;
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
			if(m.getMark() >= 0.5){
				count ++;
			}
		}
		return count;
	}
	
	/**
	 * Returns number of students 	WHO DID and failed
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
		if(this.studentMarks.size() < 1){
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
	
	public Boolean isActive(){
		if(LocalDate.now().isAfter(this.activeFrom) && LocalDate.now().isBefore(this.activeTo)){
			return true;
		}
		return false;
	}
	
	/**
	 * Getter method of the list of student answers to the exercise
	 * @return list with all the MExercises
	 */
	public ArrayList<MExercise> getStudentMarks(){
		return this.studentMarks;
	}
	
	/**
	 * Adds me to the Exercise MExercises.
	 * IMPORTANT: THIS METHOD IS CALLED FROM THE MEXERCISE CONSTRUCTOR--> DONT NEED TO USE IT IF YOU HAVE ALREADY CONSTRUCTED THE ME
	 * @param me
	 */
	public void addMExercise(MExercise me){
		this.studentMarks.add(me);
	}
	
	/**
	 * Gets questions of an exercise
	 * @return list of questions
	 */
	public ArrayList<Question> getQuestions(){
		return this.questions;
	}
	
	/**
	 * Sets activity dates of an exercise
	 * If 'from' is after 'to', they're swapped
	 * @param from, date from which exercise will be active
	 * @param to, date until which exercise will be activa
	 */
	public void setDates(LocalDate from, LocalDate to){
		if(this.hasBeenDone() == false){
			if(to.isBefore(from)){
				this.activeFrom = to;
				this.activeTo = from;
			}
			else{
				this.activeFrom = from;
				this.activeTo = to;
			}
		}
	}
	
	/**
	 * Removes exercise mark from the exercise list
	 * This MExe is added in the MExe constructor
	 * @param me, the MExercise to remove
	 */
	public void removeMExe(MExercise me){
		if(this.studentMarks.contains(me)){
			this.studentMarks.remove(me);
		}
	}
	
	@Override
	/**
	 * Sets the course of an exercise
	 * @param course
	 */
	public void setCourse(Course c){
		if(this.hasBeenDone() == false){
			super.setCourse(c);
		}		
	}
	/**
	 * If no one has done the exercise, sets the unit of it
	 * @param unit, the unit to set in the exercise
	 */
	@Override
	public void setUnit(Unit unit) {
		if(this.hasBeenDone() == false){
			super.setUnit(unit);
		}
	}
	
	@Override 
	public void makeInvisible(){
		if(studentMarks.size()!=0){
			return;
		}
		this.visible=false;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
