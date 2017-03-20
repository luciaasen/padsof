package moon.user;

import java.util.ArrayList;

import moon.course.Course;

import moon.user.Application;

import moon.mark.MCourse;

public class Student extends User {
	
	ArrayList<MCourse> marks = new ArrayList<>();
	ArrayList<Application> apps = new ArrayList<>();
	ArrayList<Course> courses = new ArrayList<>();
	
	public Student(String name, String pwd, String email){
		super(name, pwd, email);
		
	}
	
	public Application apply(Course c){
		Application app=new Application(this, c);
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
