/**
 * 
 */
package icfs.teacher.edit;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import exception.DoneExerciseException;
import exception.DuplicateElementException;
import exception.EmptyTextFieldException;
import exception.InvalidDatesException;
import icfs.teacher.create.exercise.AddExeController;
import icfs.teacher.create.exercise.MultipleChoicePopup;
import icfs.teacher.create.exercise.OpenAnswerPopUp;
import icfs.teacher.create.exercise.SingleChoicePopup;
import icfs.teacher.create.exercise.TrueFalsePopup;
import main.mainMoon;
import moon.Academy;
import moon.course.Exercise;
import moon.course.Unit;
import moon.course.question.Question;
import moon.user.Teacher;

/**
 * This class controls the edition of an exercise panel
 * @author lucia and juan
 *
 */
public class EditExeController extends AddExeController implements ActionListener {

	private EditExeView view;
	private Exercise oldExercise;
	
	/**
	 * Prepares the controller to match the edition of the given exercise
	 * @param e the exercise to edit
	 */
	public void setEverything(Exercise e){
		this.oldExercise = e;
		this.container = e.getUnit();
		this.exer=oldExercise;
		questions = new ArrayList<>();
		questions.addAll(e.getQuestions());
		maxIndex=questions.size();
	}
	
	/**
	 * Constructor of the controller
	 * @param view
	 */
	public EditExeController(EditExeView view){
		super(view);
		this.view = view;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
			
		if (button.getText().equals("Exit without saving")){
			
			mainMoon.courseSetEverything((Teacher)Academy.getMoonApp().getTeacher(), oldExercise.getCourse());
			mainMoon.changeCard(mainMoon.COURSE);
			
		}else if(button.getText().equals("Save & back to course page")){
			
			UIManager.put("OptionPane.background", Academy.DARK_GREEN);
			UIManager.put("OptionPane.messageForeground", Academy.DARK_GREEN);
			try{
				String name = view.getExerciseName();
				LocalDate ini = view.getIni();
				LocalDate end = view.getEnd();
				
				oldExercise.setName(name);
				oldExercise.setDates(ini, end);
				oldExercise.setRandord(view.getRandom());
				if(view.getVisibility().isSelected()) oldExercise.makeVisible();
				else oldExercise.makeInvisible();
				oldExercise.setPenalty((double)view.getPenaltyModel().getValue());
				oldExercise.setRelevance((double)view.getRelevanceModel().getValue());
				
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
			
			
			
			mainMoon.courseSetEverything((Teacher)Academy.getMoonApp().getTeacher(), oldExercise.getCourse());
			mainMoon.changeCard(mainMoon.COURSE);
		}
	}
	
	public int save() {
		
		try{
			
			if(view.getVisibility().isSelected()) oldExercise.makeVisible();
			else oldExercise.makeInvisible();
			
		}catch(DoneExerciseException e){
			JOptionPane.showOptionDialog(view, e.toString(), "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return -1;
		}
		
		try {
			if(view.getExerciseName().length()==0){
				JOptionPane.showOptionDialog(view, "The exercise must have a name", "Error", JOptionPane.YES_OPTION, 
						JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			}
		} catch (HeadlessException | EmptyTextFieldException e1) {
			JOptionPane.showOptionDialog(view, "The exercise must have a name", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
		}
		
		
		try {
			view.getIni();
			view.getEnd();
			
			oldExercise.setDates(view.getIni(), view.getEnd());
			
		}catch(DateTimeException  | NumberFormatException e) {
				JOptionPane.showOptionDialog(view, "Invalid dates", "Error", JOptionPane.YES_OPTION, 
						JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
				return -1;
		}catch(InvalidDatesException e2){
			JOptionPane.showOptionDialog(view, e2.toString(), "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return -1;
		} catch (DoneExerciseException e) {
			JOptionPane.showOptionDialog(view, e.toString(), "Uneditable exercise", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return -1;
		}
		
		try{
			oldExercise.setName(view.getExerciseName());
		}catch(EmptyTextFieldException e){
			JOptionPane.showOptionDialog(view, e.toString(), "Empty field", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return -1;
		} catch (DoneExerciseException e) {
			JOptionPane.showOptionDialog(view, e.toString(), "Uneditable exercise", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return -1;
		} catch (DuplicateElementException e) {
			JOptionPane.showOptionDialog(view, e.toString(), "Duplicate", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return -1;
		}
		try {
			oldExercise.setPenalty((double)view.getPenalty());			
			oldExercise.setRandord(view.getRandom());
			oldExercise.setRelevance((double)view.getRelevance());
			
		} catch (DoneExerciseException e) {
			/* This is impossible to happen, because we have just created the empty exercise */
			JOptionPane.showOptionDialog(view, "Internal error", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return -1;
		}
		
		oldExercise.removeAllQuestions();
		for(Question q : questions){
			if(q!=null){
				oldExercise.addQuestion(q);
			}
		}
	
			
		return 0;
	}
	
	/**
	 * Creates a popup for the open answer question
	 * @return
	 */
	public void openAnswerQuestion() {
		new OpenAnswerPopUp(this, oldExercise);
	}
	
	/**
	 * Creates a pop up for the tf question
	 * @return
	 */
	public void TfQuestion() {
		new TrueFalsePopup(this, oldExercise);
	}

	/**
	 * Creates pop up for multi choice questions
	 * @return
	 */
	public void multiChoiceQuestion() {
		new MultipleChoicePopup(this,oldExercise);
	}

	/**
	 * creates popups ffot single choice questions
	 * @return
	 */
	public void singleChoiceQuestion() {
		new SingleChoicePopup(this,oldExercise);
	}

}
