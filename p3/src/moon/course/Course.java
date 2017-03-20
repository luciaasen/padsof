package moon.course;

import java.util.ArrayList;
import moon.user.*;
import moon.mark.*;

public class Course {
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
	}
	
	public ArrayList<Student> getStudents(){
		return this.students;
	}
	
	public boolean addStudent(Student s){
		return students.add(s);
	}
	
	public boolean addExpeltion(Student s){
		return expStudents.add(s);
	}
	
	public boolean removeExpeltion(Student s){
		return expStudents.remove(s);
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
		return units.add(u);
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
	
	
}
