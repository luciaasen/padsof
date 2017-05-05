/**
 * 
 */
package icfs.student.exercise;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import moon.course.question.*;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public abstract class CenterStudentQuestionPanel extends JPanel {
	JLabel question = new JLabel(" ");
	JPanel north = new JPanel();
	JPanel center = new JPanel();
	
	public CenterStudentQuestionPanel(Question quest){
		this.setLayout(new BorderLayout(10, 10));
		north.setBorder(BorderFactory.createDashedBorder(Color.BLACK, 5f, 5f, 2f, true));
		//north.setPreferredSize(new Dimension(30, 30));
		north.add(question);
		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		question.setText(quest.getQuestion());
		
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}
	
}
