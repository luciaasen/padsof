/**
 * 
 */
package icfs.teacher.create;

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
import moon.course.Note;
import moon.course.Unit;

/**
 * Controls the note creation
 * @author lucia and juan
 *
 */
public class AddNoteController implements ActionListener{
AddNoteView view;
	
	/**
	 * Constructor of the controller
	 * @param view
	 */
	public AddNoteController(AddNoteView view){
		this.view = view;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		if (button.getText().equals("Exit without saving")){			
			mainMoon.mainSetEverything();
			mainMoon.changeCard(mainMoon.MAIN);
			
		}else{
			
			UIManager UI=new UIManager();
			UI.put("OptionPane.background", Academy.DARK_GREEN);
			UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
			try{
				/*Create course*/
				String name = view.getNoteName();
				String content = view.getNoteContent();
				Note u = new Note(name,  content);
				if(this.view.isNoteVisible() == true) u.makeVisible();
				u.setUnit(this.view.getUnit());
				
				/*Differentiate between buttons*/
				if (button.getText().equals("Save & back to add unit")){
					this.view.getText().setEnabled(false);
					mainMoon.changeCard(mainMoon.ADD_UNIT);
				}else if (button.getText().equals("Save & back to main page")){
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
