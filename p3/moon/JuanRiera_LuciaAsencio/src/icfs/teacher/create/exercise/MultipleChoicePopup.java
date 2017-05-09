/**
 * 
 */
package icfs.teacher.create.exercise;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import moon.course.Exercise;
import moon.course.question.MultiChoiceQuestion;
import moon.course.question.OneChoiceQuestion;
import moon.course.question.Option;
import moon.course.question.Question;

/**
 * Class of a multiple choice question creation popup.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class MultipleChoicePopup extends BasicPopup {
	OptionsPanel correct;
	OptionsPanel incorrect;
	JCheckBox random;
	
	/**
	 * Constructor of the popup.
	 * @param controller
	 * @param exe
	 */
	public MultipleChoicePopup(AddExeController controller, Exercise exe) {
		super(controller, "Multiple choice question wizard", exe);
	}
	
	@Override
	protected Component getCentralPanel() {
		JPanel panel= new JPanel();
		JPanel superPanel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		correct = new OptionsPanel("Add correct answers", "Correct answers: ");
		incorrect = new OptionsPanel("Add incorrect answers", "Incorrect aswers: ");
		random = new JCheckBox("Random order of options");
		panel.add(random,BorderLayout.SOUTH);
		panel.add(correct);
		panel.add(incorrect);
		superPanel.setLayout(new BorderLayout());
		superPanel.add(panel, BorderLayout.CENTER);
		superPanel.add(random, BorderLayout.SOUTH);
		return new JScrollPane(superPanel);
	}

	
	@Override
	protected Question getQuestion(double relevance) {
		if(correct.getOptions().size()==0 || incorrect.getOptions().size()==0){
			return null;
		}
		ArrayList<Option>all = new ArrayList<>(correct.getOptions());
		all.addAll(incorrect.getOptions());
		MultiChoiceQuestion q = new MultiChoiceQuestion(contentsT.getText(), relevance, all, correct.getOptions(), exe);
		q.setRandom(random.isSelected());
		return q;
	}

}
