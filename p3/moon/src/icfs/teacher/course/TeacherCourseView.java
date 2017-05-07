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
	
	private int separation = 20;
	private JCheckBox visibility;
	private JCheckBox randomQuest;
	private JCheckBox randomOpt;
	private JButton remove;
	private JButton edit;
	
	public TeacherCourseView(){
		super();
		controller = new TeacherCourseViewController(this);
		this.tree.addMouseListener(controller);
		
		JPanel options = options();		
		centerPanel.add(options, BorderLayout.EAST);
		JButton button = new JButton("Students list");
		button.addActionListener(e -> controller.changeToStudentsList());
		this.southPanel.add(button);
		button = new JButton("Statistics");
		button.addActionListener(e -> controller.changeToStatistics());
		this.southPanel.add(button);
		//tree.addTreeSelectionListener(new TeacherCourseViewController(this));
		//getTree().addMouseListener(new TeacherCourseViewController(this));
	}

	private JPanel options(){
		
		/*Unit: edit element and contents, remove, visib*/
		/*Note: edit element and contents, remove, visib*/		
		/*Exercise: edit element and contents, remove, visib, randQuest */
		/*Question: edit element and contents, remove, randOpt*/
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
		inner.setPreferredSize(new Dimension(300, 350));

		JButton remove = new JButton("Remove");
		JButton edit = new JButton("Edit element and contents");
		JCheckBox visibility = new JCheckBox("Visibility");
		JCheckBox randomOpt = new JCheckBox("Random options order");
		JCheckBox randomQuest = new JCheckBox("Random questions order");
		visibility.setBackground(Academy.ORANGE);
		randomQuest.setBackground(Academy.ORANGE);
		randomOpt.setBackground(Academy.ORANGE);
		this.remove = remove;
		this.edit = edit;
		this.visibility = visibility;
		this.randomOpt = randomOpt;
		this.randomQuest = randomQuest;
		
		layout2.putConstraint(SpringLayout.HORIZONTAL_CENTER, edit, 0, SpringLayout.HORIZONTAL_CENTER, inner);
		layout2.putConstraint(SpringLayout.HORIZONTAL_CENTER, remove, 0, SpringLayout.HORIZONTAL_CENTER, edit);
		layout2.putConstraint(SpringLayout.HORIZONTAL_CENTER, visibility, 0, SpringLayout.HORIZONTAL_CENTER, edit);
		layout2.putConstraint(SpringLayout.HORIZONTAL_CENTER, randomQuest, 0, SpringLayout.HORIZONTAL_CENTER, edit);
		layout2.putConstraint(SpringLayout.HORIZONTAL_CENTER, randomOpt, 0, SpringLayout.HORIZONTAL_CENTER, edit);
		
		layout2.putConstraint(SpringLayout.SOUTH, edit, -2*separation, SpringLayout.VERTICAL_CENTER, remove);
		layout2.putConstraint(SpringLayout.SOUTH, remove, -2*separation, SpringLayout.VERTICAL_CENTER, inner);
		layout2.putConstraint(SpringLayout.VERTICAL_CENTER, visibility, 0, SpringLayout.VERTICAL_CENTER, inner);
		layout2.putConstraint(SpringLayout.NORTH, randomQuest, 2*separation, SpringLayout.VERTICAL_CENTER, inner);
		layout2.putConstraint(SpringLayout.NORTH, randomOpt, 2*separation, SpringLayout.VERTICAL_CENTER, randomQuest);
		
		inner.add(remove);
		inner.add(edit);
		inner.add(visibility);
		inner.add(randomQuest);
		inner.add(randomOpt);
		
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
	
	/**
	 * Gets the random questions jcheckbox
	 * @return jcheckbox random question order
	 */
	public JCheckBox getRandQuest(){
		return randomQuest;
	}
	
	/**
	 * Gets de random option order jcheckbox
	 * @return jcheckbox random option order
	 */
	public JCheckBox getRandOpt(){
		return randomOpt;
	}
	
	
	/**
	 * Sets the teacher course view
	 * @param u the user
	 * @param c the course to set
	 */
	@Override
	public void setEverything(User u, Course c){
		super.setEverything(u, c);
		getEdit().setEnabled(false);
		getRemove().setEnabled(false);
		getVisibility().setEnabled(false);
		getRandQuest().setEnabled(false);
		getRandOpt().setEnabled(false);
		this.tree.addMouseListener(controller);
	}

}