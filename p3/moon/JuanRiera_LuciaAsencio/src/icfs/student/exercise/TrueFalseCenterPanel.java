/**
 * 
 */
package icfs.student.exercise;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import moon.course.question.Question;
import moon.mark.MExercise;

/**
 * Central panel associated with the true/false questions. 
 * (See documentation of StudentQuestionView)
 * @author Juan Riera and Lucia Asencio
 *
 */
public class TrueFalseCenterPanel extends CenterStudentQuestionPanel {
	private JRadioButton tre = new JRadioButton("True");
	private JRadioButton flse = new JRadioButton("False");
	
	public TrueFalseCenterPanel(Question quest){
		super(quest);
		center.setLayout(new GridLayout(2,1));
		ButtonGroup group = new ButtonGroup();
		group.add(tre);
		group.add(flse);
		center.add(tre);
		center.add(flse);
		
	}

	
	@Override
	public void generateMQuestion(MExercise me) {
		if(tre.isSelected()){
			q.answer(true, me);
		} else if (flse.isSelected()) {
			q.answer(false, me);
		}
	}
}
