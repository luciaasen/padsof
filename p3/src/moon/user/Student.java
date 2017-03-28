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

/**
 * Class to store the information of a student.
 * @author Juan Riera and Lucia Asencio
 *
 */
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
	
	/**
	 * Adds an application to the application list. This method should
	 * not be called under normal circumstances, Student.apply() will call it.
	 * @param a
	 * @return
	 */
	public boolean addApplication(Application a){
		return apps.add(a);
		
	}
	
	/**
	 * Removes an application to the application list. This method
	 * should not be called under normal circumstances. It will be called
	 * by Application.accept() or Application.reject()
	 * @param a
	 * @return
	 */
	public boolean removeApplication(Application a){
		return apps.remove(a);
	}
	
	/**
	 * Calculates the average mark of the student in all the subjects.
	 * @return double value of the average.
	 */
	public double calcAverage(){
		double avg=0;
		if(courses.size()==0){
			return 0;
		}
		for(MCourse mcourse : marks){
			avg+=mcourse.getMark();
		}
		avg/=courses.size();
		return avg;
	}
	
	/**
	 * Calculates the maximum mark a student has got 
	 * among all the courses.
	 * @return Double value with the mark.
	 */
	public double calcMaximum(){
		double max=0;
		double auxMark=0;
		if(marks.size()==0){
			return 0;
		}
		for(MCourse mark : marks){
			auxMark=mark.getMark();
			if(max<auxMark){
				max=auxMark;
			}
			
		}
		return max;
	}
	
	/**
	 * Calculates the minimum mark a student has got in all
	 * the courses it is in.
	 * @return double value of the minimum mark.
	 */
	public double calcMinimum(){
		double min=1;
		double auxMark=0;
		if(marks.size()==0){
			return 0;
		}
		for(MCourse mark : marks){
			auxMark=mark.getMark();
			if(min>auxMark){
				min=auxMark;
			}
			
		}
		return min;
	}
	
	/**
	 * 
	 * @return the ArrayList of courses in which the student has been accepted and is not expelled.
	 */
	public ArrayList<Course> coursesInButNotExpelled(){
		ArrayList<Course> notExpelled = new ArrayList<>();
		for(Course course : courses){
			if(course.isExpelled(this)==false){
				notExpelled.add(course);
			}
		}
		return notExpelled;
	}
	
	/**
	 * Returns false, because the student is not a teacher.
	 */
	public boolean isTeacher(){
		return false;
	}
	
	/**
	 * Adds a mark to the Student's marks array.
	 * @param mark
	 * @return true if everything went well and false if it didn't
	 */
	public boolean addMark(MCourse mark){
		return marks.add(mark);
	}
	
	/**
	 * Adds a course to the list of courses where the student has been accepted.
	 * @param course
	 * @return
	 */
	public boolean addCourse(Course course){
		return courses.add(course);
	}

	/**
	 * 
	 * @return all the MCourses associated with the student.
	 */
	public ArrayList<MCourse> getMarks() {
		return marks;
	}

	/**
	 * Get's all the applications the student has sent.
	 * @return ArrayList
	 */
	public ArrayList<Application> getApps() {
		return apps;
	}
	
	/**
	 * Gets all the courses the student is in.
	 * @return ArrayList
	 */

	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	
}
