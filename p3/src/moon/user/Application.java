package moon.user;

import moon.course.Course;
import moon.mark.MCourse;
import moon.*;

import java.io.Serializable;

import es.uam.eps.padsof.emailconnection.*;


public class Application implements Serializable{
	Student student;
	Course course;
	
	public Application(Student s, Course c){
		student=s;
		course=c;
		s.addApplication(this);
		c.addApplication(this);
	}
	
	/** This method is used to accept a student that has applied 
	 * to a course. It also creates the MCourse associated with
	 * the student and course, so  you should never call the 
	 * constructor of MCourse in normal circumstances.
	 * @return false if everything went well and false if it did not
	 * @throws InvalidEmailAddressException
	 * @throws FailedInternetConnectionException
	 */
	public boolean accept() throws InvalidEmailAddressException, 
		FailedInternetConnectionException{
		if((student.removeApplication(this) && 
				course.removeApplication(this))== false){
			return false;
		}
		
		
		EmailSystem.send(student.getEmail(), 
				"Acceptation", 
				"Congratulations!\n\nYou have been accepted in " +
				course.getName() + "\n\nBest wishes.");		
		
		if((student.addCourse(course) &&
		course.addStudent(student))==false){
			student.addApplication(this);
			course.addApplication(this);
			return false;
		}
		new MCourse(course, student);
		return true;
		
		
	}
	
	/** This method is used to reject a student that has applied 
	 * to a course.
	 * @return false if everything went well and false if it did not
	 * @throws InvalidEmailAddressException
	 * @throws FailedInternetConnectionException
	 */
	public boolean reject() throws InvalidEmailAddressException, 
		FailedInternetConnectionException{
		
		boolean ret = student.removeApplication(this) &&
		course.removeApplication(this);
		
		if(ret==true){
			EmailSystem.send(student.getEmail(), 
					"Rejection", 
					"We are sorry to communicate you that you have " +
					"been rejected from " + 
					course.getName() + "\n\nBetter luck next time.");	
		}
		
		return ret;
		
	}
	
	/**
	 * Getter for the course
	 * @return The Course associated with this application.
	 */
	public Course getCourse(){
		return course;
	}
	
}
