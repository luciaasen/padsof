/**
 * 
 */
package icfs.teacher.course;

import java.awt.event.MouseEvent;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import icfs.general.course.GeneralCourseViewController;
import icfs.teacher.course.TeacherCourseView;
import moon.course.Course;
import moon.course.Exercise;
import moon.course.Note;
import moon.course.Unit;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class TeacherCourseViewController extends GeneralCourseViewController implements TreeSelectionListener{
	
	TeacherCourseView view;
	public TeacherCourseViewController(TeacherCourseView view){
		this.view=view;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	/*	DefaultMutableTreeNode node = (DefaultMutableTreeNode) view.getTree().getLastSelectedPathComponent();
		if(node==null){
			return;
		} else if (node.getUserObject() instanceof Unit) {
			
			view.getEdit().setEnabled(true);
			view.getRemove().setEnabled(true);
			view.getVisibility().setEnabled(true);
			
		}else if (node.getUserObject() instanceof Course) {

			view.getEdit().setEnabled(true);
			view.getRemove().setEnabled(false);
			view.getVisibility().setEnabled(false);
			
		}else if (node.getUserObject() instanceof Exercise) {

			view.getEdit().setEnabled(true);
			view.getRemove().setEnabled(true);
			view.getVisibility().setEnabled(true);
			
		}else if (node.getUserObject() instanceof Note) {

			view.getEdit().setEnabled(true);
			view.getRemove().setEnabled(true);
			view.getVisibility().setEnabled(true);
			
		}*/
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.event.TreeSelectionListener#valueChanged(javax.swing.event.TreeSelectionEvent)
	 */
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) view.getTree().getLastSelectedPathComponent();
		if(node==null){
			return;
		} else if (node.getUserObject() instanceof Unit) {
			
			view.getEdit().setEnabled(true);
			view.getRemove().setEnabled(true);
			view.getVisibility().setEnabled(true);
			
		}else if (node.getUserObject() instanceof Course) {

			view.getEdit().setEnabled(true);
			view.getRemove().setEnabled(false);
			view.getVisibility().setEnabled(false);
			
		}else if (node.getUserObject() instanceof Exercise) {

			view.getEdit().setEnabled(true);
			view.getRemove().setEnabled(true);
			view.getVisibility().setEnabled(true);
			
		}else if (node.getUserObject() instanceof Note) {

			view.getEdit().setEnabled(true);
			view.getRemove().setEnabled(true);
			view.getVisibility().setEnabled(false);
			
		}
	}
}
/*Unit: edit element and contents, remove, visib*/
/*Note: edit element and contents, visib*/
/*Exercise: edit element and contents, remove, visib*/
/*Course: edit element*/