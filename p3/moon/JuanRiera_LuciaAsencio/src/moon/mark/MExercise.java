package moon.mark;

import moon.course.*;
import moon.course.question.Question;
import moon.user.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class stores the answers of a student (MQuestions) to an exercise.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class MExercise extends Mark implements Serializable{
	private Exercise exercise;
	private ArrayList<MQuestion> mQuestions;
	private Student student;
	
	/**
	 * Constructor for MExercise
	 * IMPORTANT: this constructor ALSO ADDS THE MEXERCISE TO THE 
	 * 		EXERCISE MEXERCISES LIST
	 * @param exercise associated to the MExercise
	 */
	public MExercise(Exercise exercise){
		super();
		
		this.exercise = exercise;
		/*We complete the relation the other way round*/
		exercise.addMExercise(this);
		this.mQuestions = new ArrayList<>();
	}
	
	/**
	 * MExercise Student getter
	 * @return student who owns the MExercise
	 */
	public Student getStudent(){
		return this.student;
	}
	
	/**
	 * Exercise Mark Student setter
	 * @param student
	 */
	public void setStudent(Student student){
		this.student = student;
	}

	/**
	 * Exercise getter
	 * @return Exercise related to the mark
	 */
	public Exercise getExercise() {
		return this.exercise;
	}

	/**
	 * Question getter
	 * @return Question related to the mark
	 */
	public ArrayList<MQuestion> getmQuestions() {
		return this.mQuestions;
	}
	
	/**
	 * If not already added, adds the question mark to the MExercise'ś list
	 * @param mq the MQuestion to add
	 */

	public void addMQuestion(MQuestion mq){
		if(this.mQuestions.contains(mq) == false){
			this.mQuestions.add(mq);
		}
	}
	
	/**
	 * Removes an MQuestion.
	 * @param mq the MQuestion.
	 */
	public void removeMQuestion(MQuestion mq){
		this.mQuestions.remove(mq);
	}
	
	/**
	 * Calculates mark in the exercise
	 * @return normalized mark in the Exercise
	 */
	public double getMark(){
		double mark = 0;
		double relev = 0;
		if(mQuestions.size()==0){
			return 0;
		}
		for( MQuestion  mQu: mQuestions){
			mark += mQu.getMark();
		}
		for(Question q: this.exercise.getQuestions()){
			relev += q.getRelevance();
		}
		if(mark < 0){
			return 0;
		}
		return mark/relev;
	}
	
	/**
	 * When an exercise is cancelled, we remove the student answers 
	 * from the correspondent question studentMarks list
	 * Also removes the MExercise from the Exercise marks 
	 * (its added there in the MExer constructor) 
	 */
	public void cancel(){
		for(MQuestion mq: this.mQuestions){
			mq.getQuestion().getStudentMarks().remove(mq);
		}
		this.getExercise().removeMExe(this);
	}
}
