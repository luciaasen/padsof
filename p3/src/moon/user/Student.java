package moon.user;

import java.util.ArrayList;

import moon.course.Course;

import moon.user.Application;

public class Student extends User {
	
	ArrayList<MCourse> marks = new ArrayList<>();
	ArrayList<Student> students = new ArrayList<>();
	ArrayList<Application> apps = new ArrayList<>();
	ArrayList<Course> courses = new ArrayList<>();
	
	public Student(String name, String pwd, String email){
		super(name, pwd, email);
		
	}
	
	public Application apply(Course c){
		Application app=new Application(this, c);
		return app;
	}
	
	public Application addApplication(Application a){
		apps.add(a);
		return app;
	}
	
	public double calcAverage(){
		double avg;
	
		for(MCourse mcourse : marks){
			avg+=mcourse.getMark();
		}
		avg/=marks.length();
		return avg;
	}
	
	public double calcMaximum(){
		double max;
		for(MCourse mark : marks){
			max+=mark.getMark();
		}
		return max;
	}
	
	public double calcMinimum(){
		double min;
		for(MCourse mark : marks){
			min+=mark.getMark();
		}
		return min;
	}
	
	public ArrayList<Course> coursesInButNotExpelled(){
		ArrayList<Course> notExpelled = new ArrayList<>();
		for(Course course : courses){
			if(course.isExpelled(this)==FALSE){
				notExpelled.add(course);
			}
		}
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

	public ArrayList<Student> getStudents() {
		return students;
	}

	public ArrayList<Application> getApps() {
		return apps;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	
}
