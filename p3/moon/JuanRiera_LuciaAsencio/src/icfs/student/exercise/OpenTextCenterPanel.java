/**
 * 
 */
package icfs.student.exercise;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import moon.course.question.Option;
import moon.course.question.Question;
import moon.mark.MExercise;

/**
 * Central panel of the question view associated with open answer questions.
 * (See documentation of StudentQuestionView)
 * @author Juan Riera and Lucia Asencio
 *
 */
public class OpenTextCenterPanel extends CenterStudentQuestionPanel {
	
	private JTextArea text = new JTextArea(20,60);
	/**
	 * Constructor.
	 * @param quest the questions
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
