/**
 * 
 */
package icfs.teacher.course;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;

import icfs.general.course.GeneralCourseViewController;
import icfs.teacher.course.TeacherCourseView;
import moon.course.Exercise;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class TeacherCourseViewController extends GeneralCourseViewController {
	
	TeacherCourseView view;
	public TeacherCourseViewController(TeacherCourseView view){
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
