/**
 * 
 */
package icfs.student.main;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import moon.user.Student;

/**
 * @author juan
 *
 */
public class MainStudentRightPanel extends JPanel{
	/* This right panel will have two panels inside of it: an upper and a lower one */
	
	JPanel upperPanel = new JPanel();
	JPanel lowerPanel = new JPanel();
	SpringLayout upperLayout = new SpringLayout();
	JLabel average = new JLabel("Average mark:  ");
	
	/**
	 * Constructor of the class with package security.
	 */
	MainStudentRightPanel(Student s){
		
		this.setLayout(new GridLayout(2,1,10,10));
		upperPanel.setLayout(upperLayout);
		upperLayout.putConstraint(SpringLayout.NORTH, average, 10, SpringLayout.NORTH, upperPanel);
		upperLayout.putConstraint(SpringLayout.WEST, average, 10, SpringLayout.WEST, upperPanel);
		
		Border border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		this.setBorder(border1);
		upperPanel.setBorder(border1);
		lowerPanel.setBorder(border1);
		upperPanel.setSize(50, 50);
		upperPanel.setBackground(Color.pink);
		this.setSize(51, 51);
		this.setBackground(Color.blue);
		upperPanel.add(average);
		this.add(upperPanel);
		upperPanel.setVisible(true);
		this.setVisible(true);
	}
}
