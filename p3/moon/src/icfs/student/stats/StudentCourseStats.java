/**
 * 
 */
package icfs.student.stats;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import icfs.LowerPanel;
import icfs.teacher.stats.TeacherCourseStatsController;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.course.CourseElement;
import moon.course.Exercise;
import moon.course.Unit;
import moon.user.Student;
import moon.user.User;

/**
 * @author juan
 *
 */
public class StudentCourseStats extends LowerPanel{
	JPanel north = new JPanel();
	JPanel central;
	JPanel south = new JPanel();
	JLabel courseName = new JLabel("Name");
	JLabel courseMark = new JLabel("Mark");
	StudentCourseStatsController controller = new StudentCourseStatsController(this);
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Course contents");;
	JTree tree = new JTree(root);
	
	public StudentCourseStats(){
		
		this.setLayout(new BorderLayout(20,20));
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		north.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		north.setLayout(new GridLayout(1,2));
		north.add(courseName);
		north.add(courseMark);
		north.setBackground(Color.white);
		
		central = generateCentralPanel();
		
		JButton button = new JButton("Back to course selection");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.SELECT_COURSE));
		south.add(button);
		button = new JButton("Back to main");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.MAIN));
		south.add(button);
		south.setBackground(Color.white);
		
		this.add(north, BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);
		this.add(central, BorderLayout.CENTER);
	}

	/**
	 * @return
	 */
	private JPanel generateCentralPanel() {
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout(15,15));
		centralPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		centralPanel.add(tree,BorderLayout.CENTER);
		tree.addMouseListener(controller);
		centralPanel.setBackground(Color.WHITE);
		
		return centralPanel;
	}

	/**
	 * @param s
	 * @param selected
	 */
	public void setEverything(Student s, Course c) {
		controller.setEverything(s, c);
		root.removeAllChildren();
		courseName.setText(c.getName());
		courseMark.setText("Mark: "+c.getCourseMark(s));
		for(Unit unit : c.getUnits()){
			if(unit.getVisibility()){
				setNodes(root, unit);
			}
		}
	}
	
	/**
	 * Recursive method to set the nodes of the tree.
	 * @param fatherNode
	 * @param element
	 * @param u
	 */
	public void setNodes(DefaultMutableTreeNode fatherNode, CourseElement element){
		if(element.getVisibility()){	
			DefaultMutableTreeNode node = new DefaultMutableTreeNode();
			if(element instanceof Unit){
				Unit unit = (Unit) element;
				node.setUserObject(element);
				for(CourseElement elem : unit.getContents()){
					setNodes(node, elem);
				}
				fatherNode.add(node);
			} else {
				node.setUserObject(element);
				fatherNode.add(node);
			}
		}
	}
}
