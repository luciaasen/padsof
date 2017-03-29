package moon.mark;

import java.io.Serializable;

/**
 * Abstract class from which all the marks inherit the declaration of getMark().
 * @author Juan Riera and Lucia Asencio
 *
 */
public abstract class Mark implements Serializable{
	
	/**
	 * Mark getter
	 * @return double
	 */
	public abstract double getMark();
}
