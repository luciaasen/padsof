package moon.user;

import moon.course.Course;

public class Application {
	Student student;
	Course course;
	
	public Application(Student s, Course c){
		student=s;
		course=c;
		s.addApplication(this);
		c.addApplication(this);
	}
	
	public boolean accept(){
		if(student.removeApplication(this) &&
		course.removeApplication(this) == false){
			return false;
		}
		return(student.addCourse(course) &&
		course.addStudent(student));
		
	}
	
	public boolean reject(){
		return(student.removeApplication(this) &&
		course.removeApplication(this));
		
	}
	
}
