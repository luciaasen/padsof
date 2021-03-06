package moon.course;

import java.io.Serializable;

import exception.DuplicateElementException;

/**
 * This class stores all the information of a note, that is plain text
 * introduced by the techer when created.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class Note extends CourseElement implements Serializable{
	private String text;
	private String title;
	
	/**
	 * Constructor with no paremeters
	 */
	public Note(){
		this("", "");
	}
	
	/**
	 * Contructor that receives only the text of the note.
	 * @param text
	 */
	public Note(String text){
		this("", text);
	}
	
	/**
	 * Constructor that recieves the text and the title.
	 * @param title
	 * @param text
	 * @throws DuplicateElementException 
	 */
	public Note(String title, String text){
	
		this.title = title;
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
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 * @throws DuplicateElementException 
	 */
	public void setTitle(String title) throws DuplicateElementException {
		for(CourseElement c: this.getUnit().getContents()){
			if(c instanceof Note){
				if(((Note) c).getTitle().equals(title) && !(c.equals(this))) throw new DuplicateElementException(title);
			}
		}
		this.title = title;
	}
	
	public String toString(){
		return title;
	}
	@Override
	public boolean equals(Object o){
		if(o == null) return false;
		if(o instanceof Note == false) return false;
		return ((Note)o).getTitle().equals(title);
	}
	@Override
	public int hashCode(){
		return title.hashCode();
	}
	
	
	
}
