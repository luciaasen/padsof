/**
 * 
 */
package icfs.student.exercise;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import moon.course.question.Question;

/**
 * @author e336799
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

	/* (non-Javadoc)
	 * @see icfs.student.exercise.CenterStudentQuestionPanel#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}
}
