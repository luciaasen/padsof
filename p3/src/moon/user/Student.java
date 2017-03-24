package moon.user;

import java.io.Serializable;
import java.util.ArrayList;

import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import moon.Academy;
import moon.course.Course;

import moon.user.Application;

import moon.mark.MCourse;

public class Student extends User implements Serializable{
	
	ArrayList<MCourse> marks = new ArrayList<>();
	ArrayList<Application> apps = new ArrayList<>();
	ArrayList<Course> courses = new ArrayList<>();
	
	/**
	 * Constructor of the student
	 * @param name
	 * @param lastName
	 * @param pwd
	 * @param id
	 * @param email
	 */
	public Student(String name, String lastName, String pwd, int id, String email){
		super(name, lastName, pwd, id, email);

	}
	
	/**
	 * This method is used to apply for a course. It generates an object
	 * Application that is returned. It returns null if the student has already
	 * applied for that course.
	 * @param c, the course we want to apply for
	 * @return The resulting Application or null
	 * @throws InvalidEmailAddressException
	 * @throws FailedInternetConnectionException
	 */
	public Application apply(Course c) throws InvalidEmailAddressException, 
		FailedInternetConnectionException {
		/* We check that we have not applied to the course */
		for(Application a : apps){
			if(a.getCourse().equals(c)){
				return null;
			}
		}
		if(courses.contains(c)){
			return null;
		}
		
		Application app=new Application(this, c);
		
		EmailSystem.send(Academy.getMoonApp().getTeacher().getEmail(),
				"Application", "The student "+ this.getName() + " has applied "+
				"for the course in " + c.getName());
		
	
		return app;
	}
	
	public boolean addApplication(Application a){
		return apps.add(a);
		
	}
	
	public boolean removeApplication(Application a){
		return apps.remove(a);
	}
	
	public double calcAverage(){
		double avg=0;
	
		for(MCourse mcourse : marks){
			avg+=mcourse.getMark();
		}
		avg/=marks.size();
		return avg;
	}
	
	public double calcMaximum(){
		double max=0;
		for(MCourse mark : marks){
			max+=mark.getMark();
		}
		return max;
	}
	
	public double calcMinimum(){
		double min=0;
		for(MCourse mark : marks){
			min+=mark.getMark();
		}
		return min;
	}
	
	public ArrayList<Course> coursesInButNotExpelled(){
		ArrayList<Course> notExpelled = new ArrayList<>();
		for(Course course : courses){
			if(course.isExpelled(this)==false){
				notExpelled.add(course);
			}
		}
		return notExpelled;
	}
	
	public boolean isTeacher(){
		return false;
	}
	public boolean addMark(MCourse mark){
		return marks.add(mark);
	}
	
	public boolean addCourse(Course course){
		return courses.add(course);
	}

	public ArrayList<MCourse> getMarks() {
		return marks;
	}


	public ArrayList<Application> getApps() {
		return apps;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	
}
