/**
 * 
 */
package exception;

/**
 * Exception used when you try to create an element that has the same name as another existing element in the same container
 * @author lucia and juan
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
