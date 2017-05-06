/**
 * 
 */
package icfs.student.stats.question;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import icfs.LowerPanel;
import moon.course.question.Question;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentQuestionStats extends LowerPanel{
	JPanel north;
	JPanel south;
	JPanel center = new JPanel();
	
	public StudentQuestionStats(){
		this.setLayout(new BorderLayout(10,10));
		
		north = newNorth();
		south = newSouth();
		
		this.add(north, BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);
		this.add(center, BorderLayout.CENTER);
	}
	
	/**
	 * @return
	 */
	private JPanel newSouth() {
		return null;
	}

	/**
	 * @return
	 */
	private JPanel newNorth() {
		return null;
	}

	public void setEverything(Student s, Question q){
		this.remove(center);
	}
	
	private JPanel newCenter(Student s, Question q){
		//if(q instanceof )
		return null;
	}
}
