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
import main.mainMoon;
import moon.course.Course;
import moon.course.Exercise;
import moon.course.Note;
import moon.course.Unit;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
//public class TeacherCourseViewController extends GeneralCourseViewController implements TreeSelectionListener{
public class TeacherCourseViewController extends GeneralCourseViewController{
	
	TeacherCourseView view;
	public TeacherCourseViewController(TeacherCourseView view){
		super();
		this.view=view;
		
	}
	
	/*@Override
	public void mouseClicked(MouseEvent event) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) view.getTree().getLastSelectedPathComponent();
		if(node==null){
			return;
		} else if (node.getUserObject() instanceof Exercise) {
			Exercise e = (Exercise)node.getUserObject();
			if(e.getExercise((Student)u)==null && e.isActive()){
				mainMoon.questionSetEverything((Student)u, c, (Exercise)node.getUserObject());
				mainMoon.changeCard(mainMoon.QUESTION);
			}
		} else if (node.getUserObject() instanceof Note){
			mainMoon.noteSetEverything((Note)node.getUserObject());
			mainMoon.changeCard(mainMoon.NOTE);
		}		
	}*/
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
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
			view.getVisibility().setEnabled(true);
			
		}
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.event.TreeSelectionListener#valueChanged(javax.swing.event.TreeSelectionEvent)
	 */
	/*@Override
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
	}*/
}