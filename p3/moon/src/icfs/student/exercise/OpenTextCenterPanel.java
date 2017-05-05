/**
 * 
 */
package icfs.student.exercise;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import moon.course.question.Option;
import moon.course.question.Question;
import moon.mark.MExercise;

/**
 * @author e336799
 *
 */
public class OpenTextCenterPanel extends CenterStudentQuestionPanel {
	
	private JTextField text = new JTextField();
	/**
	 * @param quest
	 */
	public OpenTextCenterPanel(Question quest) {
		super(quest);
		center.setLayout(new GridLayout(1,1));
		center.add(text);
	}
	
	@Override
	public void generateMQuestion(MExercise me) {
		q.answer(new Option(text.getText()), me);	
	}
	

}
