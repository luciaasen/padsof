package moon.course;

import java.time.LocalDate;

abstract class CourseElement {
	private LocalDate visibFrom;
	private LocalDate visibTo;
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
	 * Exerciseś unit getter
	 * @return unit
	 */
	public Unit getUnit(){
		return this.unit;
	}
}
