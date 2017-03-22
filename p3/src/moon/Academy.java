package moon;

import java.io.*;
import java.util.ArrayList;

import moon.user.*;
import moon.course.Course;

import moon.user.Application;

import es.uam.eps.padsof.emailconnection.*;

public class Academy {
	
	public static Academy moonApp = new Academy();
	public static EmailSystem emailSystem = new EmailSystem();
	
	public User teacher;
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
	
	public boolean setTeacher(User t){
		if(users.add(t)==true){
			teacher = t;
			return true;
		} else {
			return false;
		}
	}
	
	public User getTeacher(){
		return teacher;
	}
	
	public boolean addUser(User u){
		return users.add(u);
	}
	
	public boolean removeUser(User u){
		return users.remove(u);
	}
	
	public static EmailSystem getEmailSystem(){
		return emailSystem;
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
	
	/**
	 * This function reads a file with users and add them to the app
	 * Format: name;surname;e.m@i.l;id;pwd;
	 * Substr before first ; is the name, substr between 2º and 3º is surname, substr between 3º and 4º is email, ..., and end with a ; after 5 attributes
	 * For the email to be readable, it must have 2 '.' and one '@' that has to be between the two '.'
	 * @param txt file
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * 
	 */

	public void loadUsers(String txt) throws NumberFormatException, IOException{
		String name, last, pwd, email;
		int id, index1, index2, index3, index4, index5;
		// Open the file
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(txt)));

		String strLine;
		//First line useless
		if((strLine = br.readLine()) != null){
			//Read File Line By Line
			while ((strLine = br.readLine()) != null){
				index1 = strLine.indexOf(';', 0);
				if(index1 != -1){
					name = strLine.substring(0, index1);
					index2 = strLine.indexOf(';', index1+1);
					if(index2 != -1){
						last = strLine.substring(index1+1, index2);
						index3 = strLine.indexOf(';', index2+1);
						if(index3 != -1){
							/*Comprobamos q email tiene formato necesario: '.', '@', '.'*/
							email = strLine.substring(index2+1, index3);
							index1 = email.indexOf('.');
							index2 = email.indexOf('@');
							if(index1 != -1 && index2 > index1){
								/*Comprobamos que solo haya 1 punto  despues del @ y que entre el primer punto y el @ no haya puntos*/
								index4 = email.indexOf('.', index1+1);
								if( (index4 == email.lastIndexOf('.')) && (index4 > index2) ){
									index4 = strLine.indexOf(';', index3+1);
									if(index4 != -1){
										id = Integer.parseInt(strLine.substring(index3+1, index4));
										index5 = strLine.indexOf(';', index4 + 1);
										if(index5 == strLine.charAt(strLine.length())){
											pwd = strLine.substring(index4+1,  index5);
											Student s = new Student(name, last, pwd, id, email);
											this.addUser(s);
										}
									}
								}
							}
						}						
					}
				}				
			}
		}
		//Close the input stream
		br.close();
	}
	
	
}
