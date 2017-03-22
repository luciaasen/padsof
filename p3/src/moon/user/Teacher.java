package moon.user;


public class Teacher extends User{
	
	public Teacher(String name, String lastName, String pwd, int id, String email) {
		super(name, lastName, pwd, id, email);
	}

	public boolean isTeacher(){
		return true;
	}
	
	
}
