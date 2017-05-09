/**
 * 
 */
package icfs.teacher.teacherWatchingStudents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import icfs.LowerPanel;
import moon.Academy;
import moon.course.Course;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class TeacherStudentCard extends LowerPanel{
	
	TeacherStudentCardController controller = new TeacherStudentCardController(this);
	JLabel name = new JLabel("Name");
	JLabel expelledFrom = new JLabel("Expelled");
	JLabel average = new JLabel("Average");
	JButton expellOrReadmit = new JButton("Expell");
	
	public TeacherStudentCard(){
		JPanel north = new JPanel();
		JPanel northNorth = new JPanel();
		JPanel northSouth = new JPanel();
		JPanel south = new JPanel();
		JButton button;
		
		south.setBackground(Academy.ORANGE);
		northSouth.setBackground(Academy.ORANGE);
		northNorth.setBackground(Color.white);
		north.setBackground(Academy.ORANGE);
		
		northNorth.setLayout(new GridLayout(2,2,10,10));
		northNorth.add(name);
		northNorth.add(average);
		northNorth.add(expelledFrom);
		
		expellOrReadmit.addActionListener(e -> controller.expelOrReadmit());
		
		button = new JButton("See student's statistics");
		button.addActionListener(controller);
		northSouth.setLayout(new GridLayout(1,2,10,10));
		northSouth.add(button);
		northSouth.add(expellOrReadmit);
		north.setLayout(new GridLayout(2,1,10,10));
		north.add(northNorth);
		north.add(northSouth);
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setLayout(new BorderLayout(20,20));
		this.add(north,BorderLayout.CENTER);
		this.add(south,BorderLayout.SOUTH);
	}
	
	public void setEverything(Course c, Student s){
		controller.setEverything(c, s);
	}
}
