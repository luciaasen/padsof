package moon.course;

import java.io.Serializable;

/**
 * This is an abstract class that is inherited by the course elements.
 * It stores a boolean value to mark if it is visible, the unit it belongs to
 * and the course it belongs to.
 * @author Juan Riera and Lucia Asencio
 *
 */
public abstract class CourseElement implements Serializable{
	boolean visible = false;
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
	 * Sets the course of a course element
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
	 * TO BE USED AFTER SETTING THE UNIT. OTHERWISE, THIS.COURSE WILL BE NULL
	 * 
	 * Another thing is that, if you want to make a realtionship between
	 * a unit and a courseElement, you should call this method and not 
	 * Unit.addElement() because this method do the referrencing in both ways
	 * @param unit the unit to set
	 */
	//TODO add this method to the tests
	public void setUnit(Unit unit) {
		if(unit.getContents().contains(this) == false){
			this.unit = unit;
			this.course = this.unit.course;
			unit.addElement(this);
		}
	}

	
	public void makeVisible(){
		visible=true;
	}
	
	public void makeInvisible(){
		visible=false;
	}
	
	/**
	 * Gets the visibility of the element
	 * @return true if visibility is set to true, else false
	 */
	public boolean getVisibility(){
		return this.visible;
	}
}
