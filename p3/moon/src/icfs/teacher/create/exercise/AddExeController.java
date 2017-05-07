/**
 * 
 */
package icfs.teacher.create.exercise;

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
	ArrayList<Question> questions = new ArrayList<>();
	
	public AddExeController(AddExeView view){
		this.view = view;
	}
	
	public void setEverything(Unit container){
		this.container = container;
		exer = new Exercise();
	}
	
	public void addQuestion(int index, Question q){
		questions.add(index,q);
	}
	
	public void save(){
		if(view.getIni().isAfter(view.getEnd())){
			JOptionPane.showOptionDialog(null, "Invalid dates", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
		}
		try {
			exer.setUnit(container);
		} catch (DuplicateElementException e) {
			JOptionPane.showOptionDialog(null, "Cyclic illegal addition", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
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
		}
		exer.setRelevance(view.getRelevance());
		
		for(Question q : questions){
			if(q!=null){
				exer.addQuestion(q);
			}
		}
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
		
	}

	/**
	 * @return
	 */
	public void multiChoiceQuestion() {
		
	}

	/**
	 * @return
	 */
	public void singleChoiceQuestion() {
		
	}

	
}
