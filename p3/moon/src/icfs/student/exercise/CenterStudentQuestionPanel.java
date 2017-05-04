/**
 * 
 */
package icfs.student.exercise;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import moon.course.question.*;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public abstract class CenterStudentQuestionPanel extends JPanel {
	JLabel question = new JLabel();
	JPanel north = new JPanel();
	JPanel center = new JPanel();
	
	public CenterStudentQuestionPanel(Question quest){
		this.setLayout(new BorderLayout(10, 10));
		north.add(question, FlowLayout.CENTER);
		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		question.setText(quest.getQuestion());
	}
	
}
