package moon.mark;

import moon.course.*;
import moon.user.*;
import java.util.ArrayList;

public class MCourse extends Mark{
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
	
	
	

	
	
	
}
