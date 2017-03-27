package moon.course;

import java.io.Serializable;
import java.util.ArrayList;

public class Unit extends CourseElement implements Serializable{
	private ArrayList<CourseElement> contents;
	private String name;
	
	public Unit(String name){
		this.name=name;
		contents=new ArrayList<>();
	}
	
	/**
	 * You should never call this method, because it's only purpose is to be 
	 * called by element.setUnit()
	 * @param element
	 * @return boolean result of the operation of adding the element to contents.
	 */
	public boolean addElement(CourseElement element){
		if(contents.contains(element)==true){
			return false;
		}
		return contents.add(element);
	}
	
	public boolean removeElement(CourseElement element){
		return contents.remove(element);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<CourseElement> getContents() {
		return contents;
	}
	
	/**
	 * IMPORTANT sets the unit course but ALSO add the unit to the course list
	 * @param c course to be added
	 */
	@Override
	public void setCourse(Course c){
		super.setCourse(c);
		if(c.getUnits().contains(this)){
			return;
		}
		c.addUnit(this);
	}
}
