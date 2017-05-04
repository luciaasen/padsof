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

import icfs.general.course.GeneralCourseView;
import main.mainMoon;
import moon.course.*;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentCourseView extends GeneralCourseView {
	
	public StudentCourseView(){
		super();
		controller = new StudentCourseViewController(this);
		getTree().addTreeSelectionListener(controller);
	}


}
