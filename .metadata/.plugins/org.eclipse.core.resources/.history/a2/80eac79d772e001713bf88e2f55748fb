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

/**
 * @author lucia
 *
 */
public class MainTeacherPanel extends JPanel{
	private UpperPanel upper;
	private LowerPanel lower;
	
	public static void main(String[] args){
		JFrame window = new JFrame("TeacherView");
		window.setSize(Academy.DIMENSION);
	
		Container pane = window.getContentPane();
		pane.setLayout(new BorderLayout());
		pane.setBackground(Academy.ORANGE);
		MainTeacherPanel p = new MainTeacherPanel();
		pane.add(p, BorderLayout.CENTER);
		
		window.setVisible(true);
	}
	public MainTeacherPanel(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		this.setPreferredSize(Academy.DIMENSION);
		this.setVisible(true);
		this.upper = new UpperPanel();
		this.lower = new MainTeacherLower();
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lower, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.SOUTH, lower, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, upper, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, upper, 0, SpringLayout.NORTH, this);
		
		this.add(upper);
		this.add(lower);
	}
	
}
