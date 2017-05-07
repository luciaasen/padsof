/**
 * 
 */
package icfs.teacher.create.exercise;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

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
 * @author juan
 *
 */
public class MultipleChoicePopup extends BasicPopup {
	OptionsPanel correct;
	OptionsPanel incorrect;
	/**
	 * @param controller
	 * @param exe
	 */
	public MultipleChoicePopup(AddExeController controller, Exercise exe) {
		super(controller, "Multiple choice question wizard", exe);
	}
	
	@Override
	protected Component getCentralPanel() {
		JPanel panel= new JPanel();
		panel.setLayout(new GridLayout(2,1));
		correct = new OptionsPanel("Add correct answers");
		incorrect = new OptionsPanel("Add incorrect answers");
		panel.add(correct);
		panel.add(incorrect);
		return new JScrollPane(panel);
	}

	
	@Override
	protected Question getQuestion(double relevance) {
		if(correct.getOptions().size()==0 || incorrect.getOptions().size()==0){
			return null;
		}
		ArrayList<Option>all = new ArrayList<>(correct.getOptions());
		all.addAll(incorrect.getOptions());
		return new MultiChoiceQuestion(contentsT.getText(), relevance, all, correct.getOptions(), exe);
	}

}
