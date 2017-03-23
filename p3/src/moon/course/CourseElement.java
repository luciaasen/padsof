package moon.course;

import java.io.Serializable;

abstract class CourseElement implements Serializable{
	boolean visible;
	private Unit unit;
	private Course course;
	
	/**
	 * CourseElement's course getter 
	 * @return course
	 */
	public Course getCourse(){
		return this.course;
	}
	
	/**
	 * Sets the course of an exercise
	 * @param course
	 */
	public void setCourse(Course c){
		//TODO necesitamos revisar que el course element no esta ya en el curso: necesitamos un course.getCourseElements?
		this.course = c;
	}
	
	/**
	 * Exercise unit getter
	 * @return unit
	 */
	public Unit getUnit(){
		return this.unit;
	}
	
	public void makeVisible(){
		visible=true;
	}
	
	public void makeInvisible(){
		visible=false;
	}
}
