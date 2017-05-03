/**
 * 
 */
package icfs.student.course;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import icfs.student.main.MainStudentPanel;
import main.mainMoon;
import moon.course.Course;
import moon.course.Exercise;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class StudentCourseViewController implements TreeSelectionListener {
	private Student s;
	private Course c;
	private StudentCourseView view;
	
	
	public StudentCourseViewController(StudentCourseView view){
		this.view=view;
	}
	public void setEverything(Student s, Course c){
		this.s=s;
		this.c=c;
	}


	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) view.tree.getLastSelectedPathComponent();
		if(node==null){
			return;
		} else if (node.getUserObject() instanceof Exercise) {
			System.out.println("VAMOBIEN");
		}
		
	}
	
}
