/**
 * 
 */
package icfs.student.main;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import moon.course.Course;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
@SuppressWarnings("serial")
public class MainStudentPanel extends JPanel {
	
	MainStudentRightPanel right;
	MainStudentLeftPanel left;
	
	public MainStudentPanel(){
		this.setLayout(new GridLayout(1, 2, 20, 20));
		right = new MainStudentRightPanel();
		left = new MainStudentLeftPanel();
		this.add(left);
		this.add(right);
	}
	
	
	
}
