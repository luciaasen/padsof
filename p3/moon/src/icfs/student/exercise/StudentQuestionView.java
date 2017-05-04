/**
 * 
 */
package icfs.student.exercise;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import icfs.LowerPanel;
import moon.course.Course;
import moon.course.Exercise;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentQuestionView extends LowerPanel{

	protected JPanel south, center, north;
	StudentQuestionViewController controller = new StudentQuestionViewController();
	
	public StudentQuestionView(){
		this.setLayout(new BorderLayout(10, 10));
		Border border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		this.setBorder(border1);
		north = questionNumbers();
		south = questionButtons();
		center = new CenterStudentQuestionPanel();
	}
	
	private JPanel questionNumbers(){
		JPanel questionNumbers = new JPanel();
		
		return questionNumbers;
	}
	
	private JPanel questionButtons(){
		JPanel buttons = new JPanel();
		JButton previous = new JButton("Previous");
		JButton next = new JButton("Next");
		JButton save = new JButton("End exercise and send my answers");
		JButton exit = new JButton("Exit without saving");
		
		previous.addActionListener(e -> { });
		next.addActionListener(e -> { });
		save.addActionListener(e -> { });
		exit.addActionListener(e -> { });
		
		buttons.add(previous);
		buttons.add(next);
		buttons.add(save);
		buttons.add(exit);
		return buttons;
	}
	
	public void setEverything(Student s, Course c, Exercise e){
		controller.setEverything(s, c, e);
	}
	
	public void changeQuestion(int num){
		
	}
}
