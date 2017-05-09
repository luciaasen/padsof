/**
 * 
 */
package icfs.teacher.teacherWatchingStudents;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import icfs.LowerPanel;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class TeacherListOfStudentsCourse extends LowerPanel {
	DefaultListModel<Student> listModel = new DefaultListModel<>();
	JList<Student> list = new JList<>(listModel);
	TeacherListOfStudentsController controller = new TeacherListOfStudentsController(this);
	JRadioButton allStudents;
	
	public TeacherListOfStudentsCourse(){
		JPanel north = north();
		JPanel center = center();
		JPanel south = new JPanel();
		
		JButton button = new JButton("Back to course");
		south.setBackground(Academy.ORANGE);
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.COURSE));
		south.add(button);
		
		list.addMouseListener(controller);
		
		this.setLayout(new BorderLayout(20,20));
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.add(north, BorderLayout.NORTH);
		this.add(center,BorderLayout.CENTER);
		this.add(south,BorderLayout.SOUTH);
	}
	/**
	 * @return
	 */
	private JPanel center() {
		JPanel center = new JPanel();
		JPanel radioButtons = new JPanel();
		ButtonGroup group = new ButtonGroup();
		JRadioButton button;
		
		radioButtons.setBackground(Academy.ORANGE);
		allStudents = new JRadioButton("All students");
		allStudents.addActionListener(e -> controller.setAllStudents());
		group.add(allStudents);
		radioButtons.add(allStudents);
		button = new JRadioButton("Admitted students");
		button.addActionListener(e -> controller.setAdmittedStudents());
		group.add(button);
		radioButtons.add(button);
		button = new JRadioButton("Expelled students");
		button.addActionListener(e -> controller.setExpelledStudents());
		group.add(button);
		radioButtons.add(button);
		
		center.setLayout(new BorderLayout(10,10));
		center.add(radioButtons, BorderLayout.NORTH);
		JScrollPane scrollList = new JScrollPane(list);
		center.add(scrollList, BorderLayout.CENTER);
		center.setBackground(Academy.ORANGE);
		return center;
	}
	/**
	 * @return
	 */
	private JPanel north() {
		JPanel north = new JPanel();
		north.setBackground(Color.WHITE);
		north.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		north.add(new JLabel("List of students in the course"));
		return north;
	}
	/**
	 * @param c
	 */
	public void setEverything(Course c) {
		controller.setEverything(c);
	}
}
