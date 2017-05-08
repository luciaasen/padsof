/**
 * 
 */
package icfs.student.stats;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import icfs.LowerPanel;
import icfs.general.course.WeWantBeautifulTrees;
import icfs.teacher.stats.TeacherCourseStatsController;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.course.CourseElement;
import moon.course.Exercise;
import moon.course.Unit;
import moon.course.question.Question;
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
	JPanel centralPanel;
	
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
		button.addActionListener(e -> {
			mainMoon.mainSetEverything(controller.getStudent());
			mainMoon.changeCard(mainMoon.MAIN);});
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
		centralPanel = new JPanel();
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
		centralPanel.remove(tree);
		root = new DefaultMutableTreeNode(c.getName());
		root.setUserObject(c);
		tree = new JTree(root);

		tree.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		for(Unit unit : c.getUnits()){
			if(unit.getVisibility()){
				setNodes(root, unit);
			}
		}
		tree.getSelectionModel()
		.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		centralPanel.add(tree, BorderLayout.CENTER);
		
		ImageIcon note = new ImageIcon("note.jpg");
		ImageIcon exe = new ImageIcon("exe.jpg");
		ImageIcon course = new ImageIcon("course.jpg");
		ImageIcon unit = new ImageIcon("unit.jpg");
		if(note!= null  && exe!= null  && unit!=null && course!= null){
			tree.setCellRenderer(new WeWantBeautifulTrees(note, exe, course, unit));
		}
	}
	
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
			} else if ((element instanceof Exercise)){
				Exercise exer = (Exercise)element;
				node.setUserObject(element);
				DefaultMutableTreeNode questionNode;
				for(Question q : exer.getQuestions()){
					questionNode = new DefaultMutableTreeNode();
					questionNode.setUserObject(q);
					node.add(questionNode);
				}
				fatherNode.add(node);
			} else {
				node.setUserObject(element);
				fatherNode.add(node);
			}
		}
	}
}
