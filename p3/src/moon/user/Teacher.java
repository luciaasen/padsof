package moon.user;

import java.io.Serializable;

public class Teacher extends User implements Serializable{
	
	public Teacher(String name, String lastName, String pwd, int id, String email) {
		super(name, lastName, pwd, id, email);
	}

	public boolean isTeacher(){
		return true;
	}
	
	
}
