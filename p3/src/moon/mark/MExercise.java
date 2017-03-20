package moon.mark;

import moon.course.*;
import moon.user.*;
import java.util.ArrayList;

public class MExercise extends Mark{
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

	public Exercise getExercise() {
		return exercise;
	}

	public ArrayList<MQuestion> getmQuestions() {
		return mQuestions;
	}
	
	
}
