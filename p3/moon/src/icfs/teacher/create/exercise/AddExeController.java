/**
 * 
 */
package icfs.teacher.create.exercise;

import java.awt.HeadlessException;
import java.time.DateTimeException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import exception.DoneExerciseException;
import exception.DuplicateElementException;
import exception.EmptyTextFieldException;
import exception.InvalidDatesException;
import moon.course.Exercise;
import moon.course.Unit;
import moon.course.question.*;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class AddExeController {
	private AddExeView view;
	protected Unit container;
	protected Exercise exer;
	protected ArrayList<Question> questions;
	protected int maxIndex;
	
	public AddExeController(AddExeView view){
		this.view = view;
	}
	
	public void setEverything(Unit container){
		this.container = container;
		exer = new Exercise();
		questions = new ArrayList<>();
		questions.add(null);
		maxIndex=0;
	}
	
	public boolean addQuestion(int index, Question q){
		index--;
		if(index > maxIndex){
			for(int i=maxIndex;i<index;i++){
				questions.add(null);
			}
			maxIndex=index;
		} else if(questions.get(index)!=null){
			int answer = JOptionPane.showOptionDialog(view, "There is already a question with this number. This one will be put after it", 
					"Caution", JOptionPane.YES_NO_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok", "Cancel"}, null);
			if(answer==1){
				return false;
			}
		}
		questions.remove(questions.get(index));
		questions.add(index,q);
		return true;
	}
	
	public int save() {
		
		try{
			
			if(view.getVisibility().isSelected()) exer.makeVisible();
			else exer.makeInvisible();
			
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
			
			exer.setDates(view.getIni(), view.getEnd());
			
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
			exer.setName(view.getExerciseName());
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
			exer.setPenalty((double)view.getPenalty());			
			exer.setRandord(view.getRandom());
			exer.setRelevance((double)view.getRelevance());
			
		} catch (DoneExerciseException e) {
			/* This is impossible to happen, because we have just created the empty exercise */
			JOptionPane.showOptionDialog(view, "Internal error", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return -1;
		}
		
		int questionCount = 0;
		for(Question q : questions){
			if(q!=null){
				exer.addQuestion(q);
				questionCount++;
			}
		}
		
		if(questionCount==0){
			JOptionPane.showOptionDialog(view, "The exercise must have at least one question", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return -1;
		}
			
		try {
			exer.setUnit(container);
		} catch (DuplicateElementException e) {
			JOptionPane.showOptionDialog(view, "Cyclic illegal addition", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return -1;
		}
			
		return 0;
	}

	/**
	 * @return
	 */
	public void openAnswerQuestion() {
		new OpenAnswerPopUp(this, exer);
	}
	
	/**
	 * @return
	 */
	public void TfQuestion() {
		new TrueFalsePopup(this, exer);
	}

	/**
	 * @return
	 */
	public void multiChoiceQuestion() {
		new MultipleChoicePopup(this,exer);
	}

	/**
	 * @return
	 */
	public void singleChoiceQuestion() {
		new SingleChoicePopup(this,exer);
	}

	public Exercise getExer(){
		return exer;
	}
	
	public void setExer(Exercise exer){
		this.exer = exer;
	}
	
}
