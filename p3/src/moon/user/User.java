package moon.user;



public abstract class User {

	private String name;
	private String email;
	private String password;
	
	public User(String name, String pwd, String email){
		this.name=name;
		password=pwd;
		this.email=email;
	}
	
	public abstract boolean isTeacher();
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public boolean checkPwd(String pwd){
		return password.equals(pwd);
	}
}