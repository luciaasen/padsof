/**
 * 
 */
package exception;

import javax.swing.JOptionPane;

/**
 * @author e337572
 *
 */
public class InvalidUserException extends Exception{
	public String toString(){
		return "Error in your username/password. You may want to type them again";
	}
}
