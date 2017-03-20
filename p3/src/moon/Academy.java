package moon;

import java.util.ArrayList;

import moon.user.User;

import moon.course.Course;

import moon.user.Application;

public class Academy {
	
	public static Academy moonApp = new Academy();
	
	public ArrayList<Course> courses = new ArrayList<>();
	public ArrayList<User> users = new ArrayList<>();
	
	/**Login function
	 * 
	 * @param username
	 * @param pwd
	 * @return the user if everything went well
	 * @return null if the email or the password were incorrect
	 */
	
	public User login(String email, String pwd){
		for(User u : users){
			if(u.getEmail()==email){
				if(u.checkPwd(pwd)){
					return u;
				} else {
					return null;
				}
				
			}
		}
		
		return null;
	}
	
	public ArrayList<Application> getApplications(){
		ArrayList<Application> apps = new ArrayList<>();
		for(Course c : courses){
			apps.addAll(c.getApplications());
		}
		return apps;
	}
	
	public boolean addUser(User u){
		return users.add(u);
	}
	
	public boolean removeUser(User u){
		return users.remove(u);
	}
	
	public boolean addCourse(Course c){
		return courses.add(c);
	}
	
	public boolean removeCourse(Course c){
		return courses.remove(c);
	}

	public static Academy getMoonApp() {
		return moonApp;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public ArrayList<User> getUsers() {
		return users;
	}
	
	
}
