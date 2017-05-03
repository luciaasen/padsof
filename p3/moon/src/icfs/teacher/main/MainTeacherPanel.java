/**
 * 
 */
package icfs.teacher.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.*;

import icfs.*;
import moon.Academy;
import moon.course.Course;

/**
 * @author lucia
 *
 */
public class MainTeacherPanel extends JPanel{
	private UpperPanel upper;
	private LowerPanel lower;
	
	public static void main(String[] args){
		mainPruebas.setMoon();
		Academy a = Academy.getMoonApp();
		a.addCourse(new Course("J"));
		a.addCourse(new Course("Ju"));
		a.addCourse(new Course("Jua"));
		a.addCourse(new Course("Juan"));
		a.addCourse(new Course("Juan "));
		a.addCourse(new Course("Juan n"));
		a.addCourse(new Course("Juan no"));
		
		
		JFrame window = new JFrame("TeacherView");
		window.setSize(Academy.DIMENSION);
	
		Container pane = window.getContentPane();
		pane.setLayout(new BorderLayout());
		//pane.setBackground(Academy.LIGHT_GREEN);
		MainTeacherPanel p = new MainTeacherPanel();
		pane.add(p, BorderLayout.CENTER);
		
		window.setVisible(true);
	}
	public MainTeacherPanel(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		this.setPreferredSize(Academy.DIMENSION);
		this.setVisible(true);
		this.setBackground(Academy.ORANGE);
		this.upper = new UpperPanel();
		this.lower = new MainTeacherLower();

		//this.lower = new LowerPanel();
		
		layout.putConstraint(SpringLayout.EAST, lower, 0, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.WEST, lower, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, lower, 0, SpringLayout.SOUTH, upper);
		layout.putConstraint(SpringLayout.NORTH, upper, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, lower, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, upper, 0, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.WEST, upper, 0, SpringLayout.WEST, this);
		
		this.add(upper);
		this.add(lower);
	}
	
}
