package moon.course;

import java.io.Serializable;

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
