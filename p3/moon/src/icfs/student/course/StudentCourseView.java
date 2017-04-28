/**
 * 
 */
package icfs.student.course;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import icfs.student.main.MainStudentPanel;
import main.mainMoon;
import moon.course.Course;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentCourseView extends JPanel{
	
	StudentCourseViewController controller = new StudentCourseViewController();
	JButton backButton = new JButton("Back");
	JTree tree;
	JPanel southPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	DefaultMutableTreeNode root2;
	/**
	 * @param s
	 * @param selected
	 * @param view
	 */
	public StudentCourseView() {
		this.setLayout(new BorderLayout(20,20));
		this.setVisible(true);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Holas");
		root2 = new DefaultMutableTreeNode("HAS PULSADO EL BOTON");
		tree = new JTree(root);
		backButton.setVisible(true);
		southPanel.add(backButton, FlowLayout.LEFT);
		this.add(southPanel, BorderLayout.SOUTH);
		backButton.addActionListener((e) -> mainMoon.backCard());
		//backButton.addActionListener((e) -> tree.);
		Border border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		centerPanel.setBorder(border1);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(tree, BorderLayout.CENTER);
		this.add(centerPanel, BorderLayout.CENTER);
		
		/* Let's configure the tree */
		tree.getSelectionModel()
		.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		
	}
	
	public void setEverything(Student s, Course c){
		controller.setEverything(s, c);
	}

	
	

}
