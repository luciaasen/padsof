/**
 * 
 */
package icfs.student.course;


import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;

import icfs.general.course.GeneralCourseViewController;
import main.mainMoon;
import moon.Academy;
import moon.course.Exercise;
import moon.course.Note;
import moon.user.Student;

/**
 * Controls the course view of a student
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
	public void mouseClicked(MouseEvent event) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) view.getTree().getLastSelectedPathComponent();
		if(node==null){
			return;
		} else if (node.getUserObject() instanceof Exercise) {
			Exercise e = (Exercise)node.getUserObject();
			if(e.isActive() == false){
				JOptionPane.showOptionDialog(view, "Inactive exercise", "Error", JOptionPane.YES_OPTION, 
						JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);			}
			if(e.getExercise((Student)u)==null){
				mainMoon.questionSetEverything((Student)u, c, (Exercise)node.getUserObject());
				mainMoon.changeCard(mainMoon.QUESTION);
			}
		} else if (node.getUserObject() instanceof Note){
			mainMoon.noteSetEverything((Note)node.getUserObject());
			mainMoon.changeCard(mainMoon.NOTE);
		}		
	}
	

	
	
}
