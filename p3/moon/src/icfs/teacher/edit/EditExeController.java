/**
 * 
 */
package icfs.teacher.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import exception.DoneExerciseException;
import exception.DuplicateElementException;
import exception.EmptyTextFieldException;
import exception.InvalidDatesException;
import main.mainMoon;
import moon.Academy;
import moon.user.Teacher;

/**
 * @author lucia
 *
 */
public class EditExeController implements ActionListener {

	private EditExeView view;
	
	public EditExeController(EditExeView view){
		this.view = view;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
			
		if (button.getText().equals("Exit without saving")){
			
			mainMoon.courseSetEverything((Teacher)Academy.getMoonApp().getTeacher(), view.getOldExercise().getCourse());
			mainMoon.changeCard(mainMoon.COURSE);
			
		}else if(button.getText().equals("Save & back to course page")){
			
			UIManager UI=new UIManager();
			UI.put("OptionPane.background", Academy.DARK_GREEN);
			UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
			try{
				String name = view.getExerciseName();
				LocalDate ini = view.getIni();
				LocalDate end = view.getEnd();
				
				view.getOldExercise().setName(name);
				view.getOldExercise().setDates(ini, end);
				view.getOldExercise().setRandord(view.getRandom());
				if(view.getVisibility().isSelected()) view.getOldExercise().makeVisible();
				else view.getOldExercise().makeInvisible();
				view.getOldExercise().setPenalty((double)view.getPenaltyModel().getValue());
				view.getOldExercise().setRelevance((double)view.getRelevanceModel().getValue());
				
			}catch(EmptyTextFieldException err){
				JOptionPane.showMessageDialog(this.view, err.toString(), "Empty Exercise name", JOptionPane.ERROR_MESSAGE);
			} catch (DuplicateElementException err2) {
				JOptionPane.showOptionDialog(view, err2.toString(), "Invalid name", JOptionPane.YES_OPTION, 
						JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			}catch (InvalidDatesException err3){
				JOptionPane.showOptionDialog(view, err3.toString(), "Invalid dates", JOptionPane.YES_OPTION, 
						JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			} catch (DoneExerciseException err4) {
				JOptionPane.showOptionDialog(view, err4.toString(), "Uneditable exercisse", JOptionPane.YES_OPTION, 
						JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			}
			
			mainMoon.courseSetEverything((Teacher)Academy.getMoonApp().getTeacher(), view.getOldExercise().getCourse());
			mainMoon.changeCard(mainMoon.COURSE);
		}
	}

}
