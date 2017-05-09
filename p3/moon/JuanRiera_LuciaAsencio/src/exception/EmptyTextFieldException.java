/**
 * 
 */
package exception;

/**
 * Exception used to get when someone leaves a textfield with no content in it
 * @author lucia
 *
 */
public class EmptyTextFieldException extends Exception{
	public String toString(){
		return "Found empty text field";
	}
}
