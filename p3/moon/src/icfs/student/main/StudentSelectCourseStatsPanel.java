/**
 * 
 */
package icfs.student.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import icfs.LowerPanel;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class StudentSelectCourseStatsPanel extends LowerPanel{
	JPanel centerPanel = new JPanel();
	JPanel buttons = new JPanel();
	JLabel label = new JLabel("Select a course to see it's statistics:");
	private DefaultListModel<Course> coursesM = new DefaultListModel<Course>();
	JList<Course> list = new JList<>(coursesM);
	StudentSelectCourseStatsController controller = new StudentSelectCourseStatsController(this);

	public StudentSelectCourseStatsPanel(){
		this.setLayout(new BorderLayout(10,10));
		centerPanel.setLayout(new BorderLayout(20,20));
		centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		centerPanel.add(label, BorderLayout.NORTH);
		centerPanel.add(list, BorderLayout.CENTER);
		list.setBorder(BorderFactory.createLineBorder(Academy.DARK_GREEN));
		list.addMouseListener(controller);
		centerPanel.setBackground(Color.WHITE);
		
		JButton button = new JButton("Back");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.MAIN));
		buttons.add(button);
		buttons.setBackground(Color.WHITE);
		
		this.add(buttons,BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}
	
	public void setEverything(Student s){
		coursesM.removeAllElements();
		for(Course c : s.getCourses()){
			System.out.println("Curso");
			coursesM.addElement(c);
		}
		controller.setEverything(s);
	}

	
	

}
