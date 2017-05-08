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
import moon.user.User;

/**
 * JPanel that shows the view a students has of a course
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentCourseView extends GeneralCourseView {
	Student s;
	public StudentCourseView(){
		super();
		controller = new StudentCourseViewController(this);
		getTree().addMouseListener(controller);
		backButton.removeActionListener(backButton.getActionListeners()[0]);
		backButton.addActionListener(e -> {
			mainMoon.mainSetEverything((s));
			mainMoon.changeCard(mainMoon.MAIN);
		});
	}
	
	@Override
	public void setEverything(User u, Course c){
		super.setEverything(u, c);
		s = (Student)u;
		this.tree.addMouseListener(controller);
	}


}
