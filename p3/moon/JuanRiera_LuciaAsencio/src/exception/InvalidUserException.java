/**
 * 
 */
package exception;

import javax.swing.JOptionPane;

/**
 * Exception thrown when the credentials are wrongly typed
 * @author lucia and juan
 *
 */
public class InvalidUserException extends Exception{
	public String toString(){
		return "Error in your username/password. You may want to type them again";
	}
}
