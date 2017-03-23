package moon.mark;

import moon.course.*;
import moon.user.*;

import java.io.Serializable;
import java.util.ArrayList;

public class MExercise extends Mark implements Serializable{
	private Exercise exercise;
	private ArrayList<MQuestion> mQuestions;
	private Student student;
	
	/**
	 * Constructor for MExercise
	 * @param exercise
	 */
	public MExercise(Exercise exercise){
		super();
		this.exercise = exercise;
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
	 * Calculates mark in the course
	 * @return normalized mark in the Course
	 */
	public double getMark(){
		double mark = 0;
		double relev = 0;
		for( MQuestion  mQu: this.getmQuestions()){
			mark += mQu.getMark();
			relev += mQu.getQuestion().getRelevance();
		}
		if(mark < 0){
			return 0;
		}
		return mark/relev;
	}
	
}
