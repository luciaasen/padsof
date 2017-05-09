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
import moon.course.Unit;
import moon.user.Teacher;

/**
 * Controls the buttons in the unit edition view
 * @author lucia and juan
 *
 */
public class EditUnitController implements ActionListener{
	private EditUnitView view;
	
	/**
	 * Controller constructor
	 * @param view
	 */
	public EditUnitController(EditUnitView view){
		this.view = view;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		if (button.getText().equals("Back to course page")){
			
			mainMoon.courseSetEverything((Teacher)Academy.getMoonApp().getTeacher(), view.getOldUnit().getCourse());
			mainMoon.changeCard(mainMoon.COURSE);
			
		}else{
			
			UIManager UI=new UIManager();
			UI.put("OptionPane.background", Academy.DARK_GREEN);
			UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
			try{
				/*Edit*/
				String name = view.getUnitName();
				view.getOldUnit().setName(name);
				if(this.view.isUnitVisible() == true) view.getOldUnit().makeVisible();
				
				/*Differentiate between buttons*/
				if (button.getText().equals("Save & add subunit")){
					mainMoon.addUnitSetEverything(view.getOldUnit());
					mainMoon.changeCard(mainMoon.ADD_UNIT);
				}else if (button.getText().equals("Save & add note")){
					mainMoon.addNoteSetEverything(view.getOldUnit());
					mainMoon.changeCard(mainMoon.ADD_NOTE);
				}else if (button.getText().equals("Save & add exe")){
					mainMoon.addExeSetEverything(view.getOldUnit());
					mainMoon.changeCard(mainMoon.ADD_EXE);
				}else if (button.getText().equals("Save & exit")){
					mainMoon.courseSetEverything((Teacher)Academy.getMoonApp().getTeacher(), view.getOldUnit().getCourse());
					mainMoon.changeCard(mainMoon.COURSE);
				}

			
			}catch(EmptyTextFieldException err){
				JOptionPane.showMessageDialog(this.view, err.toString(), "Empty Unit name", JOptionPane.ERROR_MESSAGE);
			} catch (DuplicateElementException err2) {
				JOptionPane.showOptionDialog(view, err2.toString(), "Invalid name", JOptionPane.YES_OPTION, 
						JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			}
		}
			
	}
}
