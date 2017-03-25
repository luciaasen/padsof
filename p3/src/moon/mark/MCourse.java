package moon.mark;

import moon.course.*;
import moon.course.question.Question;
import moon.user.*;

import java.io.Serializable;
import java.util.ArrayList;

public class MCourse extends Mark implements Serializable{
	private Course course;
	private Student student;
	private ArrayList<MExercise> mExes;
	
	/**
	 * Constructor for MCourse
	 * @param course
	 * @param student
	 */
	public MCourse(Course course, Student student){
		super();
		this.course = course;
		this.student = student;
		course.addMark(this);
		student.addMark(this);
		this.mExes = new ArrayList<MExercise>();
	}
	
	
	/*Getters and setters*/
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ArrayList<MExercise> getmExes() {
		return mExes;
	}
	
	/**
	 * Adds, if not already added, an exercise mark to the course mark
	 * @param me, MExercise to add
	 */
	public void addMExe(MExercise me){
		if(this.mExes.contains(me) == false){
			this.mExes.add(me);
			}
	}
	
	/**
	 * Calculates mark in the course
	 * @return normalized mark in the Course
	 */
	public double getMark(){
		double mark = 0;
		double relev = 0;
		for( MExercise mExe: this.getmExes() ){
			mark += mExe.getMark() *
					mExe.getExercise().getRelevance();
		}
		for(Exercise e: this.getCourse().getExercises()){
			relev += e.getRelevance();
		}
		if(mark < 0){
			return 0;
		}
		return mark/relev;
	}
		
}
