package moon.mark;

import moon.course.*;
import moon.course.question.Question;
import moon.user.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class stores the mark structure of a student in a course.
 * @author Juan Riera and Lucia Asencio
 *
 */
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
	
	
	/**
	 * 
	 * @return the course associated with this MCourse
	 */
	
	public Course getCourse() {
		return course;
	}

	/**
	 * Sets the course this MCourse belongs to.
	 * @param course
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * 
	 * @return the student associated with the course.
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * Associates this MCourse with a student.
	 * @param student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * 
	 * @return All the MExercises that this MCourse contains (all
	 * the exercises this student has done)
	 */
	public ArrayList<MExercise> getmExes() {
		return mExes;
	}
	
	/**
	 * Adds, if not already added, an exercise mark to the course mark
	 * IMPORTANT Also sets the MExercise student to the MCourse student
	 * @param me, MExercise to add
	 */
	public void addMExe(MExercise me){
		if(this.mExes.contains(me) == false){
			this.mExes.add(me);
			}
		me.setStudent(this.student);
	}
	
	/**
	 * Calculates mark in the course
	 * @return normalized mark in the Course
	 */
	public double getMark(){
		double mark = 0;
		double relev = 0;
		if(mExes.size()==0){
			return 0;
		}
		for( MExercise mExe: mExes ){
			mark += mExe.getMark() *
					mExe.getExercise().getRelevance();
		}
		for(Exercise e: course.getExercises()){
			relev += e.getRelevance();
		}
		if(mark < 0){
			return 0;
		}
		return mark/relev;
	}
		
}
