/**
 * 
 */
package icfs.teacher.course;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import icfs.general.course.GeneralCourseView;
import icfs.student.course.StudentCourseViewController;
import icfs.teacher.course.TeacherCourseViewController;
import moon.Academy;
import moon.course.Course;
import moon.user.User;

/**
 * @author juan
 *
 */
public class TeacherCourseView extends GeneralCourseView {
	private JPanel options;
	private int separation = 20;
	private JCheckBox visibility;
	private JButton remove;
	private JButton edit;
	
	public TeacherCourseView(){
		super();
		controller = new TeacherCourseViewController(this);
		this.tree.addMouseListener(controller);
		//getTree().addMouseListener(controller);
		
		JPanel options = options();		
		centerPanel.add(options, BorderLayout.EAST);
		//tree.addTreeSelectionListener(new TeacherCourseViewController(this));
		//getTree().addMouseListener(new TeacherCourseViewController(this));
	}

	private JPanel options(){
		
		/*Unit: edit element and contents, remove, visib*/
		/*Note: edit element and contents, visib*/
		/*Exercise: edit element and contents, remove, visib*/
		/*Course: edit element*/
		
		JPanel options = new JPanel();
		options.setBackground(Color.WHITE);
		options.setPreferredSize(new Dimension(400, 250));
		SpringLayout layout = new SpringLayout();
		options.setLayout(layout);
	
		
		JPanel inner = new JPanel();
		SpringLayout layout2 = new SpringLayout();
		inner.setLayout(layout2);
		inner.setBackground(Academy.ORANGE);
		inner.setPreferredSize(new Dimension(300, 250));

		JButton remove = new JButton("Remove");
		JButton edit = new JButton("Edit element and contents");
		JCheckBox visibility = new JCheckBox("Visibility");
		visibility.setBackground(Academy.ORANGE);
		this.remove = remove;
		this.edit = edit;
		this.visibility = visibility;
		
		layout2.putConstraint(SpringLayout.HORIZONTAL_CENTER, edit, 0, SpringLayout.HORIZONTAL_CENTER, inner);
		layout2.putConstraint(SpringLayout.HORIZONTAL_CENTER, remove, 0, SpringLayout.HORIZONTAL_CENTER, edit);
		layout2.putConstraint(SpringLayout.HORIZONTAL_CENTER, visibility, 0, SpringLayout.HORIZONTAL_CENTER, edit);
		layout2.putConstraint(SpringLayout.SOUTH, edit, -2*separation, SpringLayout.VERTICAL_CENTER, inner);
		layout2.putConstraint(SpringLayout.VERTICAL_CENTER, remove, 0, SpringLayout.VERTICAL_CENTER, inner);
		layout2.putConstraint(SpringLayout.NORTH, visibility, 2*separation, SpringLayout.VERTICAL_CENTER, inner);
		
		inner.add(remove);
		inner.add(edit);
		inner.add(visibility);
		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, inner, 0, SpringLayout.VERTICAL_CENTER, options);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, inner, 0, SpringLayout.HORIZONTAL_CENTER, options);
		//layout.putConstraint(SpringLayout.EAST, inner, -2*separation, SpringLayout.EAST, options);
		
		options.add(inner);
		
		return options;
	}
	
	/**
	 * Gets de Edit JButton
	 * @return JButton
	 */
	public JButton getEdit(){
		return edit;
	}
	
	/**
	 * Gets the remove JButton
	 * 
	 * @return JButton
	 */
	public JButton getRemove(){
		return remove;
	}
	
	/**
	 * Gets the visibility JButton
	 * @return  JButton visibility
	 */
	public JCheckBox getVisibility(){
		return visibility;
	}
	@Override
	public void setEverything(User u, Course c){
		super.setEverything(u, c);
		getEdit().setEnabled(false);
		getRemove().setEnabled(false);
		getVisibility().setEnabled(false);
		this.tree.addMouseListener(controller);
	}

}