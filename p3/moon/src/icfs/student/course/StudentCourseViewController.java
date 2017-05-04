/**
 * 
 */
package icfs.student.course;


import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;

import icfs.general.course.GeneralCourseViewController;
import moon.course.Exercise;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentCourseViewController extends GeneralCourseViewController {
	
	StudentCourseView view;
	public StudentCourseViewController(StudentCourseView view){
		super();
		this.view=view;
		
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) view.getTree().getLastSelectedPathComponent();
		if(node==null){
			return;
		} else if (node.getUserObject() instanceof Exercise) {
			System.out.println("VAMOBIEN");
		}
		
	}
}
