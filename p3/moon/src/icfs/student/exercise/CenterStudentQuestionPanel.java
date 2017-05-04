/**
 * 
 */
package icfs.student.exercise;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class CenterStudentQuestionPanel extends JPanel {
	JLabel question = new JLabel();
	JPanel north = new JPanel();
	JPanel center = new JPanel();
	
	
	public CenterStudentQuestionPanel(){
		this.setLayout(new BorderLayout(10, 10));
		north.add(question, FlowLayout.CENTER);
		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
	}
	
	
}
