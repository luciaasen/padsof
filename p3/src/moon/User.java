package moon;

public abstract class User {
	private String name;
	private String email;
	private String password;
	
	
	
	private boolean checkPwd(String pwd){
		return password.equals(pwd);
	}
}
