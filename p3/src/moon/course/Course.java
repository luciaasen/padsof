package moon.course;

import java.io.Serializable;
import java.util.ArrayList;

import es.uam.eps.padsof.emailconnection.*;
import moon.user.*;
import moon.Academy;
import moon.mark.*;

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
	 */
	
	public Course(String name){
		units=new ArrayList<>();
		students=new ArrayList<>();
		expStudents=new ArrayList<>();
		studentMarks=new ArrayList<>();
		applications=new ArrayList<>();
		this.name = name;
		Academy.getMoonApp().addCourse(this);
	}
	
	public double calcAverage(){
		double avg=0;
		for(MCourse mcourse : studentMarks){
			avg+=mcourse.getMark();
		}
		avg/=studentMarks.size();
		return avg;
	}
	
	public int calcNPasses(){
		int passes=0;
		for(MCourse mcourse : studentMarks){
			if(mcourse.getMark()>=5){
				passes++;
			}
		}
		return passes;
	}
	
	public int calcNFails(){
		int fails=0;
		for(MCourse mcourse : studentMarks){
			if(mcourse.getMark()<5){
				fails++;
			}
		}
		return fails;
	}
	
	
	public double getCourseMark(Student s){
		double mark=-1;
			for(MCourse mcourse : studentMarks){
				if(mcourse.getStudent()==s){
					mark=mcourse.getMark();
				}
			}
		return mark;
	}
	
	public MCourse getMCourse(Student s){
			for(MCourse mcourse : studentMarks){
				if(mcourse.getStudent()==s){
					return mcourse;
				}
			}
		return null;
	}
	
	public ArrayList<Student> getStudents(){
		return this.students;
	}
	
	public boolean addStudent(Student s){
		return students.add(s);
	}
	
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
	
	
	public boolean addApplication(Application p){
		return applications.add(p);
	}
	
	public boolean removeApplication(Application p){
		return applications.remove(p);
	}
	
	public boolean isExpelled(Student s){
		return expStudents.contains(s);
	}
	
	public boolean addUnit(Unit u){
		if(this.units.contains(u) == false){
			return units.add(u);
		}
		return false;
	}
	
	public boolean addMark(MCourse mark){
		return studentMarks.add(mark);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Unit> getUnits() {
		return units;
	}

	public ArrayList<Student> getExpStudents() {
		return expStudents;
	}

	public ArrayList<MCourse> getStudentMarks() {
		return studentMarks;
	}

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
			for(CourseElement e: u.getContents()){
				if(e instanceof Exercise){
					exe.add((Exercise)e);
				}
			}
		}
		return exe;
	}
	
	
}
