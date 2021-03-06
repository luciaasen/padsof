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
import javax.swing.ImageIcon;
import javax.swing.Icon;

import icfs.LowerPanel;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.course.CourseElement;
import moon.course.Exercise;
import moon.course.Unit;
import moon.course.question.Question;
import moon.user.User;

/**
 * This class is a JPanel that Student a Teacher can use where they enter a course
 * @author Juan Riera and Lucia Asencio
 *
 */
public abstract class GeneralCourseView extends LowerPanel {
	
	protected GeneralCourseViewController controller;
	protected JButton backButton = new JButton("Back");
	protected JTree tree;
	protected JPanel southPanel = new JPanel();
	protected JPanel centerPanel = new JPanel();
	DefaultMutableTreeNode root;
	
	/** Constructor without parameters.
	 */
	public GeneralCourseView() {
		this.setLayout(new BorderLayout(20,20));
		this.setVisible(true);
		tree= new JTree();
		tree.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		centerPanel.setBackground(Academy.ORANGE);
		southPanel.setBackground(Academy.ORANGE);
		backButton.setVisible(true);
		southPanel.add(backButton, FlowLayout.LEFT);
		this.add(southPanel, BorderLayout.SOUTH);
		backButton.addActionListener((e) -> {
			mainMoon.changeCard(mainMoon.MAIN);
			});
		Border border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		centerPanel.add(tree, BorderLayout.CENTER);
		centerPanel.setBorder(border1);
		centerPanel.setLayout(new BorderLayout());
		this.add(centerPanel, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		/*ImageIcon note = new ImageIcon("note.jpg");
		ImageIcon exe = new ImageIcon("exe.jpg");
		ImageIcon course = new ImageIcon("course.jpg");
		ImageIcon unit = new ImageIcon("unit.jpg");
		if(note!= null  && exe!= null  && unit!=null && course!= null){
			tree.setCellRenderer(new WeWantBeautifulTrees(note, exe, course, unit));
		}		*/
	}
	
	/**
	 * Sets everything according to the user and the course it receives.
	 * @param u
	 * @param c
	 */
	public void setEverything(User u, Course c){
		controller.setEverything(u, c);
		centerPanel.remove(tree);
		root = new DefaultMutableTreeNode(c.getName());
		root.setUserObject(c);
		tree = new JTree(root);

		tree.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		for(Unit unit : c.getUnits()){
			if(unit.getVisibility() || u.isTeacher()){
				setNodes(root, unit, u);
			}
		}
		tree.getSelectionModel()
		.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		centerPanel.add(tree, BorderLayout.CENTER);
		
		ImageIcon note = new ImageIcon("note.jpg");
		ImageIcon exe = new ImageIcon("exe.jpg");
		ImageIcon course = new ImageIcon("course.jpg");
		ImageIcon unit = new ImageIcon("unit.jpg");
		ImageIcon question = new ImageIcon("question.jpg");
		
		if(note!= null  && exe!= null  && unit!=null && course!= null && question != null){
			tree.setCellRenderer(new WeWantBeautifulTrees(note, exe, course, unit, question));
		}else{
			System.out.println("we went wrong");
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
			} else if ((element instanceof Exercise) && u.isTeacher()){
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
	
	/**
	 * @return the tree
	 */
	public JTree getTree() {
		return tree;
	}
}
