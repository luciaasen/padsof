/**
 * 
 */
package icfs.teacher.create;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import exception.DuplicateElementException;
import exception.EmptyTextFieldException;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.course.Unit;

/**
 * Controls the buttons and fields in the add unit view
 * @author lucia
 *
 */
public class AddUnitController implements ActionListener{

	AddUnitView view;
	
	/**
	 * Constructs the controller
	 * @param view
	 */
	public AddUnitController(AddUnitView view){
		this.view = view;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		if (button.getText().equals("Back to main page")){
			
			mainMoon.mainSetEverything();
			mainMoon.changeCard(mainMoon.MAIN);
			
		}else{
			
			UIManager UI=new UIManager();
			UI.put("OptionPane.background", Academy.DARK_GREEN);
			UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
			try{
				/*Create course*/
				String name = view.getUnitName();
				Unit u = new Unit(name);
				if(this.view.isUnitVisible() == true) u.makeVisible();
				Unit parent = this.view.getParentUnit();
				Course parent2 = this.view.getParentCourse();
				if(parent != null)	u.setUnit(parent);
				else if(parent2 != null) u.setCourse(parent2);
				
				/*Differentiate between buttons*/
				if (button.getText().equals("Save & add subunit")){
					mainMoon.addUnitSetEverything(u);
					mainMoon.changeCard(mainMoon.ADD_UNIT);
				}else if (button.getText().equals("Save & add note")){
					mainMoon.addNoteSetEverything(u);
					mainMoon.changeCard(mainMoon.ADD_NOTE);
				}else if (button.getText().equals("Save & add exe")){
					mainMoon.addExeSetEverything(u);
					mainMoon.changeCard(mainMoon.ADD_EXE);
				}else if (button.getText().equals("Save & exit")){
					mainMoon.mainSetEverything();
					mainMoon.changeCard(mainMoon.MAIN);
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
