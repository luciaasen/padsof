/**
 * 
 */
package icfs.general.course;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import icfs.LowerPanel;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.course.CourseElement;
import moon.course.Exercise;
import moon.course.Unit;
import moon.user.User;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public abstract class GeneralCourseView extends LowerPanel {
	
	protected GeneralCourseViewController controller;
	protected JButton backButton = new JButton("Back");
	protected JTree tree;
	JPanel southPanel = new JPanel();
	protected JPanel centerPanel = new JPanel();
	DefaultMutableTreeNode root;
	
	/** Constructor without parameters.
	 */
	public GeneralCourseView() {
		this.setLayout(new BorderLayout(20,20));
		this.setVisible(true);

		root = new DefaultMutableTreeNode("Course contents");
		
		tree = new JTree(root) ;
		getTree().setRootVisible(true);
		centerPanel.setBackground(Academy.ORANGE);
		southPanel.setBackground(Academy.ORANGE);
		backButton.setVisible(true);
		southPanel.add(backButton, FlowLayout.LEFT);
		this.add(southPanel, BorderLayout.SOUTH);
		backButton.addActionListener((e) -> mainMoon.changeCard(mainMoon.MAIN));
		Border border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		centerPanel.setBorder(border1);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(getTree(), BorderLayout.CENTER);
		this.add(centerPanel, BorderLayout.CENTER);
		/* Let's configure the tree */
		getTree().getSelectionModel()
		.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		
	}
	
	/**
	 * Sets everything according to the user and the course it receives.
	 * @param u
	 * @param c
	 */
	public void setEverything(User u, Course c){
		controller.setEverything(u, c);
		root.removeAllChildren();
		
		for(Unit unit : c.getUnits()){
			if(unit.getVisibility() || u.isTeacher()){
				setNodes(root, unit, u);
			}
		}
	}
	
	/**
	 * Recursive method to set the nodes of the tree.
	 * @param fatherNode
	 * @param element
	 * @param u
	 */
	public void setNodes(DefaultMutableTreeNode fatherNode, CourseElement element, User u){
		if(element.getVisibility() || u.isTeacher()){	
			DefaultMutableTreeNode node = new DefaultMutableTreeNode();
			if(element instanceof Unit){
				Unit unit = (Unit) element;
				node.setUserObject(element);
				for(CourseElement elem : unit.getContents()){
					setNodes(node, elem, u);
				}
				fatherNode.add(node);
			} else {
				node.setUserObject(element);
				fatherNode.add(node);
			}
		}
	}

	/**
	 * @return the tree
	 */
	public JTree getTree() {
		return tree;
	}
	
	

}
