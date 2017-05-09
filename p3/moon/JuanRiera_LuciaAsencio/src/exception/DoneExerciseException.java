/**
 * 
 */
package exception;

/**
 * This is an Exception used  when an edition is done in a component that has a done exercise inside
 * @author lucia y juan
 *
 */
public class DoneExerciseException extends Exception{
	public String toString(){
		return "Uneditable, an exercise has been already done by a student";
	}
}
