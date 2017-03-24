package moon.course;

import java.io.Serializable;

abstract class CourseElement implements Serializable{
	boolean visible;
	private Unit unit;
	protected Course course;
	
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
		
		this.course = c;
	}
	
	/**
	 * Exercise unit getter
	 * @return unit
	 */
	public Unit getUnit(){
		return this.unit;
	}
	
	/**
	 * Sets the unit of a course element, if it not already added
	 * IMPORTANT: Additionally, sets the CourseElement's course to the unit's course
	 * TO BE USED AFTER SETTING HE UNIT. OTHERWISE, THIS.COURSE WILL BE NULL
	 * @param unit the unit to set
	 */
	//TODO add this method to the tests
	public void setUnit(Unit unit) {
		if(unit.getContents().contains(this) == false){
			this.unit = unit;
			this.course = this.unit.course;
		}
	}

	
	public void makeVisible(){
		visible=true;
	}
	
	public void makeInvisible(){
		visible=false;
	}
}
