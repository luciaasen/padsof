package moon.user;

public class Teacher extends User{
	
	public Teacher(String name, String pwd, String email) {
		super(name, pwd, email);
	}

	public boolean isTeacher(){
		return true;
	}
}
