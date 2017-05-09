/**
 * 
 */
package icfs.teacher.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.*;

import icfs.*;
import icfs.teacher.create.AddCourseView;
import moon.Academy;
import moon.course.Course;


public class MainTeacherPanel extends JPanel{
	private LowerPanel lower;
	
	public MainTeacherPanel(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		this.setPreferredSize(Academy.DIMENSION);
		this.setVisible(true);
		this.setBackground(Academy.ORANGE);
		this.lower = new MainTeacherLower();

		//this.lower = new AddCourseView();
		
		layout.putConstraint(SpringLayout.EAST, lower, 0, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.WEST, lower, 0, SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.NORTH, lower, 0, SpringLayout.SOUTH, upper);
		//layout.putConstraint(SpringLayout.NORTH, upper, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, lower, 0, SpringLayout.SOUTH, this);
		//layout.putConstraint(SpringLayout.EAST, upper, 0, SpringLayout.EAST, this);
		//layout.putConstraint(SpringLayout.WEST, upper, 0, SpringLayout.WEST, this);
		
		//this.add(upper);
		this.add(lower);
	}
	
}
