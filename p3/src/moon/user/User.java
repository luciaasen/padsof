package moon.user;



public abstract class User {

	private String name;
	private String email;
	private String password;
	private String lastName;
	private int id;
	
	public User(String name, String lastName, String pwd, int id, String email){
		this.name=name;
		this.lastName = lastName;
		this.id = id;
		password=pwd;
		this.email=email;
	}
	
	public abstract boolean isTeacher();
	
	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}

	public boolean checkPwd(String pwd){
		return password.equals(pwd);
	}
	
	/**
	 * @return a string with a user info
	 */
	@Override
	public String toString(){
		return "User " + this.name + " " + this.lastName + " " + this.email + " " + this.id + " " + this.password;
	}
}
