/**
 * 
 */
package icfs.student.exercise;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

import moon.course.question.MultiChoiceQuestion;
import moon.course.question.Option;
import moon.course.question.Question;
import moon.mark.MExercise;


/**
 * Central panel associated with mutiple choice questions.
 * (See documentation of StudentQuestionView)
 * @author Juan Riera and Lucia Asencio
 *
 */
public class MultipleChoiceCenterPanel extends CenterStudentQuestionPanel {

	//private JScrollPane answers = new JScrollPane(center);
		private List<Option> options;
		private ArrayList<JCheckBox> buttons = new ArrayList<>();
		/**
		 * Constructor of the panel
		 * @param quest
		 */
		
		public MultipleChoiceCenterPanel(Question quest) {
			super(quest);
			options = ((MultiChoiceQuestion)quest).getOptions();
			if(((MultiChoiceQuestion)quest).isRandom()){
				Collections.shuffle(options);
			}
			center.setLayout(new GridLayout(options.size(), 1));
			
			JCheckBox button;
			for(Option o : options){
				button = new JCheckBox(o.getOption());
				button.setVisible(true);
				center.add(button);
			}
		}
		
		
		
		@Override
		public void generateMQuestion(MExercise me) {
			ArrayList<Option> listO = new ArrayList<>();
			for(JCheckBox box : buttons){
				if(box.isSelected()){
					listO.add(new Option(box.getText()));
				}
			}
			q.answer(listO, me);
		}

}
