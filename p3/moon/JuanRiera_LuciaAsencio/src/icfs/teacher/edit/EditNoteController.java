/**
 * 
 */
package icfs.teacher.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import moon.user.*;
import exception.DuplicateElementException;
import exception.EmptyTextFieldException;
import main.mainMoon;
import moon.Academy;
import moon.course.Note;

/**
 * class that controls the edition of note buttons
 * @author lucia and juan
 *
 */
public class EditNoteController implements ActionListener {
	
	private EditNoteView view;
	
	/**
	 * Controller constructor
	 * @param view of note edition
	 */
	public EditNoteController(EditNoteView view){
		this.view = view;
	}

	public void actionPerformed(ActionEvent e){
		
		JButton button = (JButton)e.getSource();
			
		
		if(button.getText().equals("Save & back to course tree")){
		
			UIManager UI=new UIManager();
			UI.put("OptionPane.background", Academy.DARK_GREEN);
			UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
			
			try{
				String name = view.getNoteName();
				String content = view.getNoteContent();
				
				view.getOldNote().setText(content);
				view.getOldNote().setTitle(name);
				
				if(view.isNoteVisible() == true) view.getOldNote().makeVisible();
				
				mainMoon.courseSetEverything((Teacher)Academy.getMoonApp().getTeacher(), view.getOldNote().getCourse());
				mainMoon.changeCard(mainMoon.COURSE);			
				
			}catch(EmptyTextFieldException err){
					JOptionPane.showMessageDialog(this.view, err.toString(), "Empty Note field", JOptionPane.ERROR_MESSAGE);
			}catch(DuplicateElementException ex){
				
				JOptionPane.showOptionDialog(view, ex.toString(), "Invalid name", JOptionPane.YES_OPTION, 
						JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			}
		}else if (button.getText().equals("Exit without saving")){
			mainMoon.courseSetEverything((Teacher)Academy.getMoonApp().getTeacher(), view.getOldNote().getCourse());
			mainMoon.changeCard(mainMoon.COURSE);
		}
	}
}
