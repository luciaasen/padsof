/**
 * 
 */
package icfs.teacher.main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import icfs.LowerPanel;
import moon.Academy;
import moon.course.Course;
import moon.user.Student;

/**
 * @author lucia
 *
 */
public class MainTeacherLower extends LowerPanel{
	private int separation = 70;
	public MainTeacherLower(){
		super();
		SpringLayout layout = new SpringLayout();
		//this.setLayout(layout);
		this.setLayout(new BorderLayout());

		Dimension d = new Dimension(this.WIDTH/2, this.HEIGHT);
		JPanel right = right(d);
		JPanel left = left(d);
		/*layout.putConstraint(SpringLayout.NORTH, right, 0,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, left, 0,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, right, 0,SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.WEST, left, 0,SpringLayout.WEST, this);
		
		this.add(left);
		this.add(right);
		*/
		this.add(left, BorderLayout.WEST);
		this.add(right, BorderLayout.EAST);
		this.setVisible(true);

	}
	
	/**
	 * Creates the left panel of the main teacher lower vie wwith the scrolled lists
	 * @return Left panel
	 */
	private JPanel left(Dimension d){
		/*Create left Panel, sey size and layout*/
		JPanel left = new JPanel();
		left.setPreferredSize(d);
		left.setBackground(Academy.ORANGE);
		SpringLayout layout = new SpringLayout();
		left.setLayout(layout);
		
		/*Get the 2 panels with lists that should be inside*/
		Dimension listDimension = new Dimension(listWidth(), listHeight());
		FilteredList<Course> courses = new FilteredList(listDimension, Academy.getMoonApp().getCourses());
		FilteredList<Student> students = new FilteredList(listDimension, Academy.getMoonApp().getUsers());
		
		/*Set constraints and add panels*/
		layout.putConstraint(SpringLayout.NORTH, courses, this.separation, SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.NORTH, students, 2*this.separation, SpringLayout.SOUTH, courses);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, courses, 0, SpringLayout.HORIZONTAL_CENTER, left);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, students, 0, SpringLayout.HORIZONTAL_CENTER, left);
		left.add(students);
		left.add(courses);
		
		return left;
	}
	
	/**
	 * This method returns the separation between the panel borders and the lists
	 * @return separation 
	 */
	private int listWidth(){
		return this.WIDTH/2 - 2*separation;
	}
	
	/**
	 * This method returns the lists height according to the separation
	 * @return height 
	 */
	private int listHeight(){
		return this.HEIGHT/2 - 2*separation;
	}
	
	/**
	 * Creates the right panel of the main teacher lower window with the calendar etc
	 * @return right panel
	 */
	private JPanel right(Dimension d){
		JPanel right = new JPanel();
		right.setBackground(Academy.LIGHT_GREEN);
		right.setPreferredSize(d);
		//right.add(new JButton("qtal"));
		
		
		String[] opt1 =  {"Add", "Edit"};
		JComboBox<String> combo1= new JComboBox<String>(opt1);
		String[] opt2 =  {"Course", "Unit", "Note", "Exercise"};
		JComboBox<String> combo2 = new JComboBox<String>(opt2);
		
		return right;
	}

}
