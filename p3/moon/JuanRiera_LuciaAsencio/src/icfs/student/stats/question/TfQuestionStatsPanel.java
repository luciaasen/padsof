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
import moon.course.question.*;
import moon.mark.*;

/**
 * @author juan
 *
 */
public class TfQuestionStatsPanel extends QuestionCenterStats {

	
	/**
	 * @param s
	 * @param mq
	 */
	public TfQuestionStatsPanel(Student s, MQuestion mq) {
		super(s, mq);
	}


	@Override
	protected Component correctPanel(MQuestion mq) {
		JPanel correct= new JPanel();
		if(mq==null){
			return unansweredPanel();
		} else if(((TfQuestion)mq.getQuestion()).getAnswer()==true){
			correct.add(new JLabel("True"));
		} else if(((TfQuestion)mq.getQuestion()).getAnswer()==false) {
			correct.add(new JLabel("False"));
		}
		return correct;
	}

	
	@Override
	protected Component optionsPanel(MQuestion mq) {
		if(mq==null){
			return unansweredPanel();
		}
		JPanel answer = new JPanel();
		if(((TfAnswer)mq).getAnswer()==true){
			answer.add(new JLabel("True"));
		} else if (((TfAnswer)mq).getAnswer()==false) {
			answer.add(new JLabel("False"));
		}
		return answer;
	}

}
