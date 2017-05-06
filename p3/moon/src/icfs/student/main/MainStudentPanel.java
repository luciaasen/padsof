/**
 * 
 */
package icfs.student.main;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import icfs.LowerPanel;
import moon.course.Course;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
@SuppressWarnings("serial")
public class MainStudentPanel extends LowerPanel {
	
	MainStudentRightPanel right;
	MainStudentLeftPanel left;
	MainStudentController controller;
	
	public MainStudentPanel(){
		this.setLayout(new GridLayout(1, 2, 20, 20));
		right = new MainStudentRightPanel();
		left = new MainStudentLeftPanel(this);
		controller = new MainStudentController();
		this.add(left);
		this.add(right);
	}
	
	public void setEverything(Student s){
		controller.setEverything(s);
		right.setEverything(s, controller);
		left.setEverything(s);
	}
	
	
	
}
