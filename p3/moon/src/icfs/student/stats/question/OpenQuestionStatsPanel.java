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
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import moon.mark.*;
import moon.user.Student;
import moon.course.question.*;


/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class OpenQuestionStatsPanel extends QuestionCenterStats {

	/**
	 * @param s
	 * @param mq
	 */
	public OpenQuestionStatsPanel(Student s, MQuestion mq) {
		super(s, mq);
	}

	
	@Override
	protected Component correctPanel(MQuestion mq) {
		JPanel correct= new JPanel();
		if(mq==null){
			return unansweredPanel();
		} else {
			List<Option> list =((OpenQuestion)mq.getQuestion()).getAnswer();
			
			if(list.size()==0){
				return unansweredPanel();
			} 
			correct.setLayout(new GridLayout(list.size(),1, 5, 5));
			JTextPane text;
			for(Option o : list){
				text= new JTextPane();
				text.setText(o.getOption());
				correct.add(text);
			}	
			JScrollPane scroll = new JScrollPane(correct);
			return scroll;
		}
	}
	
	
	@Override
	protected Component optionsPanel(MQuestion mq) {
		JPanel option = new JPanel();
		option.add(new JLabel(((OpenAnswer)mq).getAnswer()));
		return option;
	}

}
