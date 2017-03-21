package moon.course;

abstract class CourseElement {
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
	 * Exerciseś unit getter
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
