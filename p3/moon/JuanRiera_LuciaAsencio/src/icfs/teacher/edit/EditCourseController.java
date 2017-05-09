/**
 * 
 */
package icfs.teacher.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import exception.DuplicateElementException;
import exception.EmptyTextFieldException;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.user.Teacher;

/**
 * This class implements the controller of the edit course panel
 * @author lucia
 *
 */
public class EditCourseController implements ActionListener{

	private EditCourseView view;
	
	public EditCourseController(EditCourseView view){
		this.view = view;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
					
		if(button.getText().equals("Save & back to course tree")){
		
			UIManager UI=new UIManager();
			UI.put("OptionPane.background", Academy.DARK_GREEN);
			UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
			
			try{
				String name = view.getCourseName();
				
				view.getOldCourse().setName(name);
				
				mainMoon.courseSetEverything((Teacher)Academy.getMoonApp().getTeacher(), view.getOldCourse());
				mainMoon.changeCard(mainMoon.COURSE);			
				
			}catch(EmptyTextFieldException err){
					JOptionPane.showMessageDialog(this.view, err.toString(), "Empty Course field", JOptionPane.ERROR_MESSAGE);
			}catch(DuplicateElementException ex){
				JOptionPane.showOptionDialog(view, ex.toString(), "Invalid name", JOptionPane.YES_OPTION, 
						JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			}
		}else if (button.getText().equals("Exit without saving")){
			mainMoon.courseSetEverything((Teacher)Academy.getMoonApp().getTeacher(), view.getOldCourse());
			mainMoon.changeCard(mainMoon.COURSE);
		}else if (button.getText().equals("Save and add unit")){
			try{
				
				view.getOldCourse().setName(view.getCourseName());
				
				mainMoon.addUnitSetEverything(view.getOldCourse());	
				mainMoon.changeCard(mainMoon.ADD_UNIT);
				
			}catch(EmptyTextFieldException ex2){
				UIManager UI=new UIManager();
				UI.put("OptionPane.background", Academy.DARK_GREEN);
				UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
				//JOptionPane.showMessageDialog(this, ex2.toString(), "Empty Course name", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showOptionDialog(view, ex2.toString(), "Empty Course field", JOptionPane.YES_OPTION, 
						JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			}catch(DuplicateElementException ex){
				UIManager UI=new UIManager();
				UI.put("OptionPane.background", Academy.DARK_GREEN);
				UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
				JOptionPane.showOptionDialog(view, ex.toString(), "Invalid name", JOptionPane.YES_OPTION, 
						JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			}
		}
		
	}


}
