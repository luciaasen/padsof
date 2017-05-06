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

import moon.course.question.Option;
import moon.course.question.*;
import moon.mark.ChoiceAnswer;
import moon.mark.MQuestion;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class MultiChoiceStatsPanel extends QuestionCenterStats {

	/**
	 * @param s
	 * @param mq
	 */
	public MultiChoiceStatsPanel(Student s, MQuestion mq) {
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
		return getPane(((MultiChoiceQuestion)mq.getQuestion()).getAnswer());
	}
	
	private Component getPane(List<Option> list){

		JPanel pane = new JPanel();
		if(list.size()==0){
			return unansweredPanel();
		} else {
			pane.setLayout(new GridLayout(list.size(),1));
			for(Option o : list){
				pane.add(new JCheckBox(o.getOption()));
			}
			JScrollPane scroll = new JScrollPane(pane);
			return scroll;
		}
	}
	
	
	
}
