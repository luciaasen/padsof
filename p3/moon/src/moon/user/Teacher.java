package moon.user;

import java.io.Serializable;

/**
 * Class that stores all the information of a teacher.It extends User.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class Teacher extends User implements Serializable{
	
	/**
	 * Constructor for the teacher.
	 * @param name
	 * @param lastName
	 * @param pwd
	 * @param id
	 * @param email
	 */
	public Teacher(String name, String lastName, String pwd, int id, String email) {
		super(name, lastName, pwd, id, email);
	}

	/**
	 * Returns true, because this user is a teacher.
	 */
	public boolean isTeacher(){
		return true;
	}
	
	
}
