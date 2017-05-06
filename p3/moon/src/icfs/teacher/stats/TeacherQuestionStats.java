/**
 * 
 */
package icfs.teacher.stats;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import icfs.LowerPanel;

/**
 * @author juan
 *
 */
public class TeacherQuestionStats extends LowerPanel {
	JLabel name = new JLabel("Name");
	JPanel correctAnwer = new JPanel();
	JLabel penalty = new JLabel("penalty");
	JLabel correctAnswers = new JLabel("Correct answers");
	JLabel incorrectAnswers = new JLabel("Incorrect answers ");
	JLabel notAnswered = new JLabel("Not answered");
	JLabel answered = new JLabel("Answered");
	
	public TeacherQuestionStats(){
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setLayout(new BorderLayout());
		this.add(north,BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
	}
}
