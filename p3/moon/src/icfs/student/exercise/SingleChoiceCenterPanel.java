/**
 * 
 */
package icfs.student.exercise;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JScrollPane;

import moon.course.question.*;

/**
 * @author e336799
 *
 */
public class SingleChoiceCenterPanel extends CenterStudentQuestionPanel {
	
	private JScrollPane answers = new JScrollPane(center);
	private Option options;
	/**
	 * @param quest
	 */
	public SingleChoiceCenterPanel(Question quest) {
		super(quest);
		((MultiChoiceQuestion)quest).getOptions();
		options = center.setLayout(new GridLayout());
	}

}
