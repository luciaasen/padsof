/**
 * 
 */
package icfs.teacher.edit;

import icfs.LowerPanel;
import icfs.teacher.create.exercise.AddExeView;
import moon.course.Exercise;

/**
 * @author lucia
 *
 */
public class EditExeView extends AddExeView{
	private Exercise oldExercise;
	private EditExeController controller = new EditExeController(this);
	
	public EditExeView(){
		super();
		message.setText("Edit exercise");
		name.setText("");
		randomOrder.setSelected(false);
		visibility.setSelected(false);
		
		save.setText("Save & back to course page");
		exit.setText("Exit without saving");
		
		save.removeActionListener(save.getActionListeners()[0]);
		exit.removeActionListener(exit.getActionListeners()[0]);
	
		save.addActionListener(new EditExeController(this));
		exit.addActionListener(new EditExeController(this));
	}
	
	public void setEverything(Exercise oldExercise){
		this.oldExercise = oldExercise;
		message.setText("Edit exercise "+ oldExercise.getName());
		name.setText(oldExercise.getName());
		randomOrder.setSelected(oldExercise.getRandord());
		visibility.setSelected(oldExercise.getVisibility());
		relevanceModel.setValue(oldExercise.getRelevance());
		penaltyModel.setValue(oldExercise.getPenalty());
		dateIni.setDate(oldExercise.getIni());
		dateEnd.setDate(oldExercise.getEnd());
		controller.setExer(oldExercise);
	}
	
	public Exercise getOldExercise(){
		return oldExercise;
	}
	
}
