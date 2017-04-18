package moon.course;

import java.io.Serializable;

/**
 * This class stores all the information of a note, that is plain text
 * introduced by the techer when created.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class Note extends CourseElement implements Serializable{
	private String text;

	public Note(String text){
		this.text=text;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
