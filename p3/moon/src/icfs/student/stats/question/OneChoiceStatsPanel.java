/**
 * 
 */
package icfs.student.stats.question;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import moon.course.question.MultiChoiceQuestion;
import moon.course.question.OneChoiceQuestion;
import moon.course.question.Option;
import moon.mark.ChoiceAnswer;
import moon.mark.MQuestion;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class OneChoiceStatsPanel extends QuestionCenterStats {
	/**
	 * @param s
	 * @param mq
	 */
	public OneChoiceStatsPanel(Student s, MQuestion mq) {
		super(s, mq);
	}


	@Override
	protected Component optionsPanel(MQuestion mq) {
		if(mq==null){
			return unansweredPanel();
		}
		ChoiceAnswer answer = (ChoiceAnswer)mq;
		return getPane(answer.getAnswers());
	}

	
	@Override
	protected Component correctPanel(MQuestion mq) {
		if(mq==null){
			return unansweredPanel();
		}
		return getPane(((OneChoiceQuestion)mq.getQuestion()).getAnswer());
	}
	
	private Component getPane(List<Option> list){

		JPanel pane = new JPanel();
		if(list.size()==0){
			pane.add(new JLabel("Unanswered"));
			return pane;
		} else {
			pane.setLayout(new GridLayout(list.size(),1));
			for(Option o : list){
				pane.add(new JRadioButton(o.getOption()));
			}
			JScrollPane scroll = new JScrollPane(pane);
			return scroll;
		}
	}
}
