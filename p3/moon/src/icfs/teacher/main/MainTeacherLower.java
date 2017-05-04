/**
 * 
 */
package icfs.teacher.main;

import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Properties;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import icfs.LowerPanel;
import icfs.calendar.MonthPanel;
import moon.Academy;
import moon.course.Course;
import moon.user.Student;

/**
 * @author lucia
 *
 */
public class MainTeacherLower extends LowerPanel{
	private int separation = 70;
	private JComboBox<String> action;
	private JComboBox<String> element;
	
	public MainTeacherLower(){
		super();
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		//this.setLayout(new BorderLayout());

		Dimension d = new Dimension(this.WIDTH/2, this.HEIGHT);
		JPanel right = right(d);
		JPanel left = left(d);
		
		layout.putConstraint(SpringLayout.NORTH, right, 0,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, left, 0,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, right, 0,SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.SOUTH, left, 0,SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, right, 0,SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.WEST, left, 0,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, right, 0,SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.EAST, left, 0,SpringLayout.HORIZONTAL_CENTER, this);
		
		
		this.add(left);
		this.add(right);
		
		/*this.add(left, BorderLayout.WEST);
		this.add(right, BorderLayout.EAST);
		*/this.setVisible(true);

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
		layout.putConstraint(SpringLayout.EAST, courses, 0, SpringLayout.EAST, left);
		layout.putConstraint(SpringLayout.EAST, students, 0, SpringLayout.EAST, left);
		layout.putConstraint(SpringLayout.WEST, courses, 0, SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.WEST, students, 0, SpringLayout.WEST, left);
		
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
		right.setBackground(Academy.ORANGE);
		right.setPreferredSize(d);
		SpringLayout layout = new SpringLayout();
		right.setLayout(layout);
		
		String[] opt1 =  {"Add", "Edit"};
		JComboBox<String> combo1= new JComboBox<String>(opt1);
		this.action = combo1;
		String[] opt2 =  {"Course", "Unit", "Note", "Exercise"};
		JComboBox<String> combo2 = new JComboBox<String>(opt2);
		JButton go = new JButton("Go");
		this.element = combo2;
		
		/*JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(1,2));
		grid.add(combo1);
		grid.add(combo2);
		
		
		layout.putConstraint(SpringLayout.NORTH, grid, this.separation, SpringLayout.NORTH, right);
		layout.putConstraint(SpringLayout.WEST, grid, this.separation, SpringLayout.WEST, right);
		layout.putConstraint(SpringLayout.NORTH, go, this.separation, SpringLayout.NORTH, right);
		layout.putConstraint(SpringLayout.WEST, go, this.separation, SpringLayout.EAST, grid);
		right.add(grid);
		right.add(go);*/
		JPanel combos = combos();
		layout.putConstraint(SpringLayout.NORTH, combos, this.separation, SpringLayout.NORTH, right);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, combos, 0, SpringLayout.HORIZONTAL_CENTER, right);
		right.add(combos);
		
		
		MonthPanel calendar = new MonthPanel(LocalDate.now().getMonth().getValue()-1, LocalDate.now().getYear());

		layout.putConstraint(SpringLayout.NORTH, calendar, this.separation, SpringLayout.SOUTH, combos);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, calendar, 0, SpringLayout.HORIZONTAL_CENTER, right);
		right.add(calendar);
		
		return right;
	}
	

	public JPanel combos(){
		
		String[] opt1 =  {"Add", "Edit"};
		JComboBox<String> combo1= new JComboBox<String>(opt1);
		this.action = combo1;
		String[] opt2 =  {"Course", "Unit", "Note", "Exercise"};
		JComboBox<String> combo2 = new JComboBox<String>(opt2);
		this.element = combo2;
		
		JButton go = new JButton("Go");
		
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(1,2));
		grid.add(combo1);
		grid.add(combo2);
		
		JPanel combos = new JPanel();
		SpringLayout layout = new SpringLayout();
		combos.setLayout(layout);
		
		layout.putConstraint(SpringLayout.NORTH, grid, 0, SpringLayout.NORTH, combos);
		layout.putConstraint(SpringLayout.WEST, grid, 0, SpringLayout.WEST, combos);
		layout.putConstraint(SpringLayout.NORTH, go, 0, SpringLayout.NORTH, combos);
		layout.putConstraint(SpringLayout.WEST, go, this.separation, SpringLayout.EAST, grid);
		
		combos.add(grid);
		combos.add(go);
		
		combos.setBackground(Academy.ORANGE);
		
		combos.setPreferredSize(new Dimension(Academy.DIMENSION.width/2 - 2*this.separation, 25));
		
		this.setPreferredSize(new Dimension(300, 300));
		return combos;
	
	}
	public String getAction(){
		return this.action.getSelectedItem().toString();
	}
	
	public String getElement(){
		return this.action.getSelectedItem().toString();
	}
}
