/**
 * 
 */
package exception;

/**
 * 
 * Exception used to get errors, for example, when a deadline is set before the activity begining date
 * @author lucia
 *
 */
public class InvalidDatesException extends Exception{
	public String toString(){
		return "Invalid dates, try again";
	}
}
