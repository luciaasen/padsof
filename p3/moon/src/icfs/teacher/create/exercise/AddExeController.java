/**
 * 
 */
package icfs.teacher.create.exercise;

import java.time.DateTimeException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exception.DoneExerciseException;
import exception.DuplicateElementException;
import moon.course.Exercise;
import moon.course.Unit;
import moon.course.question.*;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class AddExeController {
	AddExeView view;
	Unit container;
	Exercise exer;
	ArrayList<Question> questions;
	int maxIndex;
	
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
	
	public void addQuestion(int index, Question q){
		index--;
		if(index > maxIndex){
			for(int i=maxIndex;i<index;i++){
				questions.add(null);
			}
			maxIndex=index;
		}
		
		questions.add(index,q);
	}
	
	public int save(){
		try {
			view.getIni();
			view.getEnd();
			
			if(view.getIni().isAfter(view.getEnd())){
				throw new NumberFormatException();
			}
		}catch(DateTimeException | NumberFormatException e) {
				JOptionPane.showOptionDialog(null, "Invalid dates", "Error", JOptionPane.YES_OPTION, 
						JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
				//TODO eliminar:
				e.printStackTrace();
				return -1;
		}
		
		try {
			exer.setUnit(container);
		} catch (DuplicateElementException e) {
			JOptionPane.showOptionDialog(null, "Cyclic illegal addition", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return -1;
		}
		
		exer.setDates(view.getIni(), view.getEnd());
		exer.setName(view.getName());
		exer.setPenalty(view.getPenalty());
		try {
			exer.setRandord(view.getRandom());
		} catch (DoneExerciseException e) {
			/* This is impossible to happen, because we have just created the empty exercise */
			JOptionPane.showOptionDialog(null, "Internal error", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return -1;
		}
		exer.setRelevance(view.getRelevance());
		
		for(Question q : questions){
			if(q!=null){
				exer.addQuestion(q);
			}
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

	
}
