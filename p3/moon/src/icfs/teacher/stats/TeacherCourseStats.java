/**
 * 
 */
package icfs.teacher.stats;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import icfs.LowerPanel;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.course.Exercise;

/**
 * @author Juan RIera and Lucia Asencio
 *
 */
public class TeacherCourseStats extends LowerPanel {
	JPanel central = new JPanel();
	JPanel south = new JPanel();
	JLabel average = new JLabel("Average mark: ");
	JLabel nPasses = new JLabel("Number of passes: ");
	JLabel nFails = new JLabel("Number of fails: ");
	JLabel courseName = new JLabel("Course name: ");
	TeacherCourseStatsController controller = new TeacherCourseStatsController(this);
	DefaultListModel<Exercise> listModel = new DefaultListModel<Exercise>();
	JList<Exercise> list = new JList<>(listModel);
	
	public TeacherCourseStats(){
		
		this.setLayout(new BorderLayout(20,20));
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		central = generateCentralPanel();
		JButton button = new JButton("Back to course selection");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.SELECT_COURSE));
		south.add(button);
		button = new JButton("Back to main");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.MAIN));
		south.add(button);
		this.add(south, BorderLayout.SOUTH);
		this.add(central, BorderLayout.CENTER);
	}

	/**
	 * @return
	 */
	private JPanel generateCentralPanel() {
		JPanel up = new JPanel();
		JPanel center = new JPanel();
		JPanel down = new JPanel();
		JPanel superPanel = new JPanel();
		superPanel.setLayout(new GridLayout(3,1,10,10));
		superPanel.setBackground(Academy.ORANGE);
		
		up.add(courseName);
		up.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		up.setBackground(Color.WHITE);
		
		center.setLayout(new GridLayout(3,1,10,10));
		center.add(average);
		center.add(nPasses);
		center.add(nFails);
		center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		center.setBackground(Color.WHITE);
				
		down.setLayout(new BorderLayout(20, 20));
		down.add(new JLabel("Exercise  statistics: "), BorderLayout.WEST);
		down.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		down.setBackground(Color.white);
		
		superPanel.add(up);
		superPanel.add(center);
		superPanel.add(down);
		return superPanel;
	}

	/**
	 * @param s
	 * @param selected
	 */
	public void setEverything(Course selected) {
		controller.setEverything(selected);
	}
}
