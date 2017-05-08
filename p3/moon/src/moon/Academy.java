package moon;

import java.awt.Color;
import java.awt.Dimension;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

import moon.user.*;
import moon.course.Course;
import es.uam.eps.padsof.emailconnection.*;
import exception.InvalidUserException;

/**
 * Class that stores all the information of the academy. It also contains a 
 * static variable, moonApp, that is the singleton of our architecture.
 * 
 * It also has defined teacher credentials:
 * 		Email: tea.cher@edu.es
 * 		Password: IsALotOfWork13579
 * @author Juan Riera and Lucia Asencio
 *
 */

public class Academy implements Serializable{
	public static final Color ORANGE= new Color(254, 206, 158);
	public static final Dimension DIMENSION = new Dimension(1000,600);
	public static final Color DARK_GREEN = new Color(6, 114, 92);
	public static final Color LIGHT_GREEN = new Color(205, 227, 224);
	
	public static Academy moonApp = new Academy();
	public static EmailSystem emailSystem = new EmailSystem();
	
	public User teacher;
	public ArrayList<Course> courses = new ArrayList<Course>();
	public HashSet<User> users = new HashSet<>();
	
	
	/**
	 * Constructor for the Academy. Even though we are using a singleton
	 * architecture, the constructor is public because in our design we will
	 * be likely to call it somewhere in the Interface.
	 */
	public Academy(){
		//teacher = new Teacher("Tea", "cher", "IsALotOfWork13579", 1, "tea.cher@edu.es");
		teacher = new Teacher("Tea", "cher", "0", 1, "0.0@0.0");
		
		users.add(teacher);
	}
	

	/**Login function
	 * 
	 * @param username
	 * @param pwd
	 * @return the user if everything went well
	 * @return null if the email or the password were incorrect
	 */
	
	public User login(String email, String pwd) throws InvalidUserException{
		for(User u : users){
			if(u.getEmail().equals(email)){
				if(u.checkPwd(pwd)){
					return u;
				} else {
					throw new InvalidUserException();
				}
				
			}
		}
		
		throw new InvalidUserException();
	}
	
	/** Returns the set of all the applications that the students have sent.
	 *  
	 * @return the ArrayList of all the applications
	 */
	public ArrayList<Application> getApplications(){
		ArrayList<Application> apps = new ArrayList<>();
		for(Course c : courses){
			apps.addAll(c.getApplications());
		}
		return apps;
	}
	
	
	
	/**
	 * 
	 * @return the teacher of the academy.
	 */
	public User getTeacher(){
		return teacher;
	}
	
	/**
	 * Adds a user to the user list.
	 * @param u
	 * @return
	 */
	public boolean addUser(User u){
		return users.add(u);
	}
	
	/**
	 * 
	 * @return gets the email system of the academy.
	 */
	public static EmailSystem getEmailSystem(){
		return emailSystem;
	}
	
	/**
	 * Adds a course to the course list.
	 * @param c
	 * @return
	 */
	public boolean addCourse(Course c){
		if(courses.contains(c) == false){
			return courses.add(c);
		}
		return false;
	}
	
	/**
	 * 
	 * @return the singleton moonApp
	 */
	public static Academy getMoonApp() {
		return moonApp;
	}

	/**
	 * 
	 * @return ArrayList with all the courses.
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}

	/**
	 * 
	 * @return HashSet with all the users.
	 */
	public HashSet<User> getUsers() {
		return users;
	}
	
	public HashSet<Student> getStudents(){
		HashSet<Student> students= new HashSet<Student>();
		for (User s: users){
			if(!s.isTeacher()) students.add((Student) s);
		}
		return students;
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

	public int loadUsers(String txt) throws NumberFormatException, IOException{
		String name, last, pwd, email;
		int id, count = 0;
		int index1, index2, index3, index4, index5;
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
										if(index5 == strLine.length()-1){
											pwd = strLine.substring(index4+1,  index5);
											Student s = new Student(name, last, pwd, id, email);
											this.users.add(s);
											count ++;
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
		return count;
	}
	
	/**
	 * Method to change the moonApp,
	 * so that when it is deserialized
	 * it can be restored.
	 * @param newMoon
	 * @return 
	 */
	public static void setMoon(Academy newMoon){
		Academy.moonApp = newMoon;
	}
	
	/**
	 * Auxiliar method to deserialize moon.
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void deserialize() throws IOException, ClassNotFoundException{
			
		FileInputStream fileIn =
				new FileInputStream("moon.ser");
		ObjectInputStream in =
				new ObjectInputStream(fileIn);
		moonApp = (Academy) in.readObject();
		in.close();
		fileIn.close();
	}
	
	/**
	 * Auxiliar method to serialize moon.
	 * @param moon
	 * @throws IOException
	 */
	public static void serialize() throws IOException {
		
		FileOutputStream fileOut =
				new FileOutputStream("moon.ser");
		ObjectOutputStream out = 
				new ObjectOutputStream(fileOut);
		out.writeObject(moonApp);
		out.close();
		fileOut.close();
		
	}
}
