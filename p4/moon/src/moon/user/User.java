package moon.user;

import java.io.Serializable;

import moon.Academy;

/**
 * Class that stores all the information of a user.
 * @author Juan Riera and Lucia Asencio
 *
 */
public abstract class User implements Serializable{

	private String name;
	private String email;
	private String password;
	private String lastName;
	private int id;
	
	/**
	 * Constructor of the user.
	 * @param name
	 * @param lastName
	 * @param pwd
	 * @param id
	 * @param email
	 */
	public User(String name, String lastName, String pwd, int id, String email){
		this.name=name;
		this.lastName = lastName;
		this.id = id;
		password=pwd;
		this.email=email;
	}
	
	/**
	 * This abstract method will return true if the user it is applied
	 * to is a teacher, and false if it is a student.
	 * @return boolean
	 */
	public abstract boolean isTeacher();
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method checks if the password it is passed as an argument
	 * is the same as the password of the user it is applied to.
	 * This method could be substituted by a getter, but we thought
	 * this option was better for security purposes.
	 * @param pwd
	 * @return
	 */
	public boolean checkPwd(String pwd){
		return password.equals(pwd);
	}
	
	/**
	 * @return a string with a user info
	 */
	@Override
	public String toString(){
		return this.name + " " + this.lastName ;
	}
	
	/**
	 * 
	 * @param u
	 * @return true if the objects are equals, false in any other case
	 */
	public boolean equals(User u){
		
		return (u.email.equals(this.email));
	}
	
	/**
	 * @return integer hash code of the object it is applied to
	 */
	public int hashCode(){
		return email.hashCode();
	}
}
