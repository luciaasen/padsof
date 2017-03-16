package moon.user;



public class Application {
	Student student;
	Student course;
	
	public Application(Student s, Course c){
		student=s;
		course=c;
		s.addApplication(this);
		c.addApplication(this);
	}
	
	
}
