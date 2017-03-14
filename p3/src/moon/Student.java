package moon;

import java.util.ArrayList;

public class Student extends User {
	
	ArrayList<MCourse> mCourses = new ArrayList<>();
	ArrayList<Student> students = new ArrayList<>();
	
	public Application addApplication(Course c){
		//TODO hacer add Application
	}
	
	public double calcAverage(){
		double avg;
	
		for(MCourse mcourse : mCourses){
			avg+=mcourse.getMark();
		}
		avg/=mCourses.length();
		return avg;
	}
	
	public double calcMaximum(){
		int max;
		for(MCourse)
		return max;
	}
}
