/**
 * 
 */
package icfs.student.exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;



import moon.course.question.*;
import moon.mark.MExercise;

/**
 * @author e336799
 *
 */
public class SingleChoiceCenterPanel extends CenterStudentQuestionPanel {
	
	//private JScrollPane answers = new JScrollPane(center);
	private List<Option> options;
	private ArrayList<JRadioButton> buttons = new ArrayList<>();
	ButtonGroup group = new ButtonGroup();
	/**
	 * @param quest
	 */
	
	public SingleChoiceCenterPanel(Question quest) {
		super(quest);
		options = ((OneChoiceQuestion)quest).getOptions();
		if(((OneChoiceQuestion)quest).isRandom()){
			Collections.shuffle(options);
		}
		center.setLayout(new GridLayout(options.size(), 1));
		
		JRadioButton button;
		for(Option o : options){
			button = new JRadioButton(o.getOption());
			button.setVisible(true);
			center.add(button);
			group.add(button);
		}
	}
	
	@Override
	public void generateMQuestion(MExercise me) {
		((JRadioButton)group.getSelection()).getText();
		q.answer(true, me);
		
	}
}


