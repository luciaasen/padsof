package moon.course;

import java.io.Serializable;
import java.util.ArrayList;

import es.uam.eps.padsof.emailconnection.*;
import exception.DoneExerciseException;
import exception.DuplicateElementException;
import moon.user.*;
import moon.Academy;
import moon.mark.*;

/**
 * Class to store the information of a course. 
 * It contains all the units that compose the course, all the students
 * that have been accepted, all the students that have been expeled, 
 * all the MCourses (marks of the students), and all the applications
 * that students have made to the course.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class Course implements Serializable{
	
	private ArrayList<Unit> units;
	private ArrayList<Student> students;
	private ArrayList<Student> expStudents;
	private ArrayList<MCourse> studentMarks;
	private ArrayList<Application> applications;
	private String name;
	
	/**
	 * Course Students getter
	 * @return
	 * @throws DuplicateElementException 
	 */
	
	public Course(String name) throws DuplicateElementException{
		Academy moon = Academy.getMoonApp();
		this.name = name;
		units=new ArrayList<>();
		students=new ArrayList<>();
		expStudents=new ArrayList<>();
		studentMarks=new ArrayList<>();
		applications=new ArrayList<>();

		if(moon.getCourses().contains(this) == false){
			moon.addCourse(this);
		}else{
			throw new DuplicateElementException(this);
		}
	}
	
	/**
	 * Method used to calculate the average mark of the students in the
	 * Course.
	 * @return the average (double type)
	 */
	public double calcAverage(){
		double avg=0, mc;
		for(MCourse mcourse : studentMarks){
			mc =mcourse.getMark();
			avg += mc;
		}
		if(studentMarks.size()==0){
			return 0;
		}
		avg/=studentMarks.size();
		return avg;
	}
	
	/**
	 * This method calculates the number of students that have passed the
	 * course up to that point.
	 * @return integer of the number of passes.
	 */
	public int calcNPasses(){
		int passes=0;
		for(MCourse mcourse : studentMarks){
			if(mcourse.getMark() >= 0.5){
				passes++;
			}
		}
		return passes;
	}
	
	/**
	 * This method calculates the number of students that have failed
	 * up to that point.
	 * @return integer with the number of fails.
	 */
	public int calcNFails(){
		int fails=0;
		double mc;
		for(MCourse mcourse : studentMarks){
			mc = mcourse.getMark();
			if(mc < 0.5){
				fails++;
			}
		}
		return fails;
	}
	
	/**
	 * Method that calculates the course mark of a student up to that point.
	 * @param a student
	 * @return a double value with the mark
	 */
	public double getCourseMark(Student s){
		double mark=-1;
			for(MCourse mcourse : studentMarks){
				if(mcourse.getStudent()==s){
					mark=mcourse.getMark();
				}
			}
		return mark;
	}
	
	/**
	 * Method that gets the mark structure associated with this course.
	 * @param a student
	 * @return the associted MCourse
	 */
	public MCourse getMCourse(Student s){
			for(MCourse mcourse : studentMarks){
				if(mcourse.getStudent()==s){
					return mcourse;
				}
			}
		return null;
	}
	
	/**
	 * 
	 * @return the list of accepted students
	 */
	public ArrayList<Student> getStudents(){
		return this.students;
	}
	
	/**
	 * Adds a student to the accepted student list.
	 * @param student
	 * @return true if everything went well and false if it didn't
	 */
	public boolean addStudent(Student s){
		return students.add(s);
	}
	
	/**
	 * Adds a student to the expelled list. It also notifies the student.
	 * @param student
	 * @return true if everything went well and false if it didn't
	 * @throws InvalidEmailAddressException
	 * @throws FailedInternetConnectionException
	 */
	public boolean expelStudent(Student s) throws InvalidEmailAddressException, 
		FailedInternetConnectionException{
		
		boolean ret = expStudents.add(s);
		
		if(ret==true){
			EmailSystem.send(s.getEmail(), 
					"Expeltion", 
					"We are sorry to communicate you that you have " +
					"been expeled from " + 
					name + "\n\nGood bye.");	
		}
		
		return ret;
	}
	
	/**
	 * Removes a student from the expelled list.
	 * @param student
	 * @return true if everything went well and false if something failed
	 * @throws InvalidEmailAddressException
	 * @throws FailedInternetConnectionException
	 */
	public boolean readmitStudent(Student s) throws InvalidEmailAddressException, 
		FailedInternetConnectionException{
		
		boolean ret = expStudents.remove(s);
		
		if(ret==true){
			EmailSystem.send(s.getEmail(), 
					"Readmision", 
					"Congratulations, you have been reaccepted in " +
					name + "\n\nBe good and take care.");	
		}
		
		return ret;
	}
	
	/**
	 * Adds an application to the applications list (applications from
	 * student to courses)
	 * @param application
	 * @return true if everything went well and false if something failed
	 */
	public boolean addApplication(Application p){
		return applications.add(p);
	}
	
	/**
	 * Removes an application from the applications list (applications from
	 * student to courses)
	 * @param application
	 * @return true if everything went well and false if something failed
	 */
	public boolean removeApplication(Application p){
		return applications.remove(p);
	}
	
	/**
	 * Checks if a student has been expelled.
	 * @param student
	 * @return true if it was expeled and false if it didn't
	 */
	public boolean isExpelled(Student s){
		return expStudents.contains(s);
	}
	
	/**
	 * Adds a unit to the unit list
	 * @param unit
	 * @return true if it was properly added and false if it wasn't
	 */
	public boolean addUnit(Unit u){
		if(this.units.contains(u) == false){
			return units.add(u);
		}
		return false;
	}
	
	/**
	 * Adds an MCourse to the studentsMarks list.
	 * @param mark
	 * @return true if it was properly added and false if it wasn't.
	 */
	public boolean addMark(MCourse mark){
		return studentMarks.add(mark);
	}
	
	/**
	 * 
	 * @return the name of the course (String)
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the course.
	 * @param name
	 * @throws DuplicateElementException 
	 */
	public void setName(String name) throws DuplicateElementException {
		for(Course c: Academy.getMoonApp().getCourses()){
			if(c.getName().equals(name) && !(c.equals(this))){
				throw new DuplicateElementException(name);
			}
		}
		this.name = name;
	}
	
	/**
	 * 
	 * @return the ArrayList of units of the course.
	 */
	public ArrayList<Unit> getUnits() {
		return units;
	}
	
	/**
	 * 
	 * @return the ArrayList of expelled students.
	 */
	public ArrayList<Student> getExpStudents() {
		return expStudents;
	}

	/** 
	 * @return The ArrayList of MCourses (the mark structure of the students)..
	 */
	public ArrayList<MCourse> getStudentMarks() {
		return studentMarks;
	}
	
	/**
	 * @return The ArrayList of the applications.
	 */
	public ArrayList<Application> getApplications() {
		return applications;
	}
	
	/**
	 * Given a course, returns a list from all exercises related to its different units
	 * @return list of exercise of a course
	 */
	public ArrayList<Exercise> getExercises(){
		ArrayList<Exercise> exe = new ArrayList<>();
		for(Unit u: this.units){
			exe.addAll(u.getExercises());
		}
		return exe;
	}

	public void removeUnit(Unit u) throws DoneExerciseException{
		for(Exercise e: u.getExercises()){
			if(e.hasBeenDone() == true){
				throw new DoneExerciseException();
			}
		}
		this.units.remove(u);
	}
	
	/**
	 * Equals method that consider equal two courses if they have the same name
	 * @param obj, the object to compare to
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
	@Override
	public int hashCode(){
		return this.name.hashCode();
	}
	@Override
	public String toString(){
		return name;
	}
	
}
