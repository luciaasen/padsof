/**
 * 
 */
package icfs.student.main;

import java.awt.*;

import javax.swing.*;

import moon.course.Course;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
@SuppressWarnings("serial")
public class MainStudentPanel extends JPanel {
	
	public MainStudentPanel(){
		this.add(leftPanel());
		this.add(rightPanel());
	}
	
	private JPanel leftPanel(){
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout(10,10));
		String[] whatToShow = {"All Courses", "My Courses"};
		Course[] a = new Course[0];
		JList<Course> courses = new JList<Course>(MainStudentController.getAllCourses().toArray(a));
		JComboBox<String> options = new JComboBox<>(whatToShow);
		courses.setSize(300, 900);
		JScrollPane s = new JScrollPane(courses);
		
		leftPanel.add(options, BorderLayout.NORTH);
		leftPanel.add(courses, BorderLayout.CENTER);
		leftPanel.setBackground(Color.black);
		leftPanel.setVisible(true);
		leftPanel.setSize(100, 200);
		
		return leftPanel;
	}
	
	private JPanel rightPanel(){
		/* This right panel will have two panels inside of it: an upper and a lower one */
		JPanel rightPanel = new JPanel();
		JPanel upperPanel = new JPanel();
		JPanel lowerPanel = new JPanel();
		SpringLayout upperLayout = new SpringLayout();
		JLabel average = new JLabel("Average mark:  ");
		upperPanel.setLayout(upperLayout);
		upperLayout.putConstraint(SpringLayout.NORTH, average, 10, SpringLayout.NORTH, upperPanel);
		upperLayout.putConstraint(SpringLayout.WEST, average, 10, SpringLayout.WEST, upperPanel);
		
		upperPanel.setSize(50, 50);
		upperPanel.setBackground(Color.pink);
		rightPanel.setSize(51, 51);
		rightPanel.setBackground(Color.blue);
		upperPanel.add(average);
		rightPanel.add(upperPanel);
		upperPanel.setVisible(true);
		rightPanel.setVisible(true);
		return rightPanel;
	}
	
}
