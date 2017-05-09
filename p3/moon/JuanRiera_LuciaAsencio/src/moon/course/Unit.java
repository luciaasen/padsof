package moon.course;

import java.io.Serializable;
import java.util.ArrayList;
import exception.*;

/**
 * This class stores all the information of a Unit
 * @author Juan Riera and Lucia Asencio
 *
 */
public class Unit extends CourseElement implements Serializable{
	private ArrayList<CourseElement> contents;
	private String name;
	
	/**
	 * Constructor method.
	 * @param name
	 */
	public Unit(String name){
		
		this.name=name;
		contents=new ArrayList<>();
	}
	
	/**
	 * You should never call this method, because it's only purpose is to be 
	 * called by element.setUnit()
	 * @param element
	 * @return boolean result of the operation of adding the element to contents.
	 * @throws DuplicateElementException 
	 */
	public boolean addElement(CourseElement element) throws DuplicateElementException{
		if(contents.contains(element)==true){
			throw new DuplicateElementException(element.toString());
		}
		return contents.add(element);
	}
	 /**
	  * Removes an element from the element list
	  * @param element
	  * @return true if it was properly removed and false if it wasn't.
	  */
	public boolean removeElement(CourseElement element){
		if(element instanceof Exercise){
			if(((Exercise)element).hasBeenDone()==false){
				return contents.remove(element);
			} else {
				return false;
			}
		} else if(element instanceof Note){
			return contents.remove(element);
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return the name of the unit.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the unit.
	 * @param name
	 * @throws DuplicateElementException 
	 */
	public void setName(String name) throws DuplicateElementException {
		if(this.getUnit() == null){
			for (Unit u: this.getCourse().getUnits()){
				if(u.getName().equals(name) && !(u.equals(this))) throw new DuplicateElementException(name);
			}
		}else{
			for(CourseElement c: this.getUnit().getContents()){
				if(c instanceof Unit){
					if(((Unit) c).getName().equals(name) && !(c.equals(this))) throw new DuplicateElementException(name);
				}
			}				
		}
		this.name = name;
		
	}

	/**
	 * 
	 * @return ArrayList of the contents (Course elements) in the unit.
	 */
	public ArrayList<CourseElement> getContents() {
		return contents;
	}
	
	/**
	 * IMPORTANT sets the unit course but ALSO add the unit to the course list
	 * @param c course to be added
	 * @throws exception.DuplicateElementException 
	 */
	@Override
	public void setCourse(Course c) throws exception.DuplicateElementException{
		super.setCourse(c);
		if(c.getUnits().contains(this)){
			throw new DuplicateElementException(this);
		}
		c.addUnit(this);
	}

	/**
	 * Makes a Unit invisible. The unit will check if it has subunits and 
	 * try to make them invisible. If this unit has a child exercise that
	 * has already been answered by a student, this unit will not be made
	 * invisible.
	 */
	@Override
	public void makeInvisible() throws DoneExerciseException{
		/* We start trying to make every subunit invisible */
		for(CourseElement e : this.contents){
			if(e instanceof Unit){
				((Unit)e).makeInvisible();
			}
		}
		
		/* Now we check if some subunit could not be made invisible */
		/*for(CourseElement e : this.contents){
			if(e instanceof Unit){
				if(((Unit)e).getVisibility()==true){
					return;
				}
			}
		}*/
		
		for(CourseElement e : this.contents){
			if(e instanceof Exercise){
				if(((Exercise)e).getStudentMarks().size()!=0){
					throw new DoneExerciseException();
				}
			}
		}
		visible=false;
	}
	
	/**
	 * This method will make visible a unit and also al of the elements 
	 * below that had become invisible.
	 */
	@Override
	public void makeVisible(){
		for(CourseElement e: this.contents){
			e.makeVisible();
		}
		this.visible = true;
	}
	
	/**
	 * Gets an array with añl the exercise in the unit aj¡nd its subunits	
	 * @return array of exercises
	 */
	public ArrayList<Exercise> getExercises(){
		ArrayList<Exercise> exes = new ArrayList<>();
		for (CourseElement e: this.getContents()){
			if(e instanceof Exercise){
				exes.add((Exercise)e);
			}
			else if(e instanceof Unit){
				exes.addAll(((Unit) e).getExercises());
			}
		}
		return exes;
	}

	public boolean equals(Object o){
		if(o == null) return false;
		if(!(o instanceof Unit)) return false;
		return ((Unit)o).getName().equals(this.name) ;
	}
	
	public int hashCode(){
		return this.name.hashCode();
	}
	@Override
	public String toString(){
		return name;
	}
}



