/**
 * 
 */
package exception;

/**
 * @author lucia
 *
 */
public class DuplicateElementException extends Exception {
	Object element;
	public DuplicateElementException(Object element){
		this.element = element;
	}
	public String toString(){
		return "Element "+ element + " already exists.";
	}
}
