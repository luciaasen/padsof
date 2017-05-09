/**
 * 
 */
package icfs.teacher.edit;

import javax.swing.JButton;
import javax.swing.SpringLayout;

import icfs.LowerPanel;
import icfs.teacher.create.AddCourseView;
import moon.course.Course;
import moon.course.Note;
import moon.course.Unit;

/**
 * this class implements what the teacher sees when editing a course
 * @author lucia and juan
 *
 */
public class EditCourseView extends AddCourseView{
	private Course oldCourse;
	
	public EditCourseView(){
		super();
		message.setText("Edit Course " );
		nameLabel.setText("Edit name: ");
		name.setText(null);
		save.setVisible(false);
		add.setVisible(false);
		exit.setVisible(false);
		
		JButton newSave = new JButton("Save & back to course tree");
		JButton newExit = new JButton("Exit without saving");
		JButton newAdd = new JButton("Save and add unit");
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, newSave, 0, SpringLayout.HORIZONTAL_CENTER, down);
		layout.putConstraint(SpringLayout.EAST, newExit, 0, SpringLayout.EAST, down);
		layout.putConstraint(SpringLayout.NORTH, newSave, separation, SpringLayout.SOUTH, down);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, newExit, 0, SpringLayout.VERTICAL_CENTER, newSave);
		layout.putConstraint(SpringLayout.WEST,  newAdd, 0, SpringLayout.WEST, down);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, newAdd, 0, SpringLayout.VERTICAL_CENTER, newSave);
		
		
		this.add(newSave);
		this.add(newExit);
		this.add(newAdd);
		
		newSave.addActionListener(new EditCourseController(this));
		newExit.addActionListener(new EditCourseController(this));
		newAdd.addActionListener(new EditCourseController(this));
		
	}

	/**
	 * Sets everything in the panel to match the paramete
	 * @param oldCourserthe course to edit
	 */
	public void setEverything(Course oldCourse){
		name.setEnabled(true);
		this.oldCourse = oldCourse;
		message.setText("Edit Course " + oldCourse);
		nameLabel.setText("Edit name: ");
		name.setText(oldCourse.getName());
	}
	
	public Course getOldCourse(){
		return oldCourse;
	}
}
