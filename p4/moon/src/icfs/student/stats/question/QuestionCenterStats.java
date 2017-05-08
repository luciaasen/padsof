/**
 * 
 */
package icfs.student.stats.question;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import moon.mark.MQuestion;
import moon.user.Student;

/**
 * @author juan
 *
 */
public abstract class QuestionCenterStats extends JPanel {
	/**
	 * @param s
	 * @param q
	 */
	public QuestionCenterStats(Student s, MQuestion mq) {
		this.setLayout(new GridLayout(3,2));
		this.add(new JLabel("Points: "));
		if(mq == null){
			this.add(new JLabel("0"));
		} else { 
			this.add(new JLabel((new Double(mq.getMark())).toString()));
		}
		this.add(new JLabel("Correct answer: "));
		this.add(optionsPanel(mq));
		this.add(new JLabel("Student's answer: "));
		this.add(correctPanel(mq));
	}
	
	/**
	 * @param mq
	 * @return
	 */
	protected abstract Component correctPanel(MQuestion mq);

	/**
	 * @param answer
	 * @return
	 */
	protected abstract Component optionsPanel(MQuestion mq);

	protected JPanel unansweredPanel(){
		JPanel panel = new JPanel();
		panel.add(new JLabel("Unnanswered"));
		return panel;
	}
	
}
