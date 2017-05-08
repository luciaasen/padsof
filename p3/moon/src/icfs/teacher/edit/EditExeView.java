/**
 * 
 */
package icfs.teacher.edit;

import javax.swing.JButton;

import icfs.LowerPanel;
import icfs.teacher.create.exercise.AddExeView;
import moon.course.Exercise;

/**
 * @author lucia
 *
 */
public class EditExeView extends AddExeView{
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
	
		save.addActionListener(controller);
		exit.addActionListener(controller);
		
		TfQuestion.removeActionListener(TfQuestion.getActionListeners()[0]);
		MCQuestion.removeActionListener(MCQuestion.getActionListeners()[0]); 
		SCQuestion.removeActionListener(SCQuestion.getActionListeners()[0]);
		OAQuestion.removeActionListener(OAQuestion.getActionListeners()[0]);
		
		TfQuestion.addActionListener(e -> controller.TfQuestion());
		MCQuestion.addActionListener(e -> controller.multiChoiceQuestion());
		SCQuestion.addActionListener(e -> controller.singleChoiceQuestion());
		OAQuestion.addActionListener(e -> controller.openAnswerQuestion());
	}
	
	public void setEverything(Exercise oldExercise){
		controller.setEverything(oldExercise);
		message.setText("Edit exercise "+ oldExercise.getName());
		name.setText(oldExercise.getName());
		randomOrder.setSelected(oldExercise.getRandord());
		visibility.setSelected(oldExercise.getVisibility());
		relevanceModel.setValue(oldExercise.getRelevance());
		penaltyModel.setValue(oldExercise.getPenalty());
		dateIni.setDate(oldExercise.getIni());
		dateEnd.setDate(oldExercise.getEnd());
	}
	
	
}
