/**
 * 
 */
package icfs.student.exercise;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

import moon.course.question.MultiChoiceQuestion;
import moon.course.question.Option;
import moon.course.question.Question;
import moon.mark.MExercise;


//TODO preparar esta clase para mostrar aleatoriamente las respuestas.


/**
 * @author e336799
 *
 */
public class MultipleChoiceCenterPanel extends CenterStudentQuestionPanel {

	//private JScrollPane answers = new JScrollPane(center);
		private List<Option> options;
		private ArrayList<JCheckBox> buttons = new ArrayList<>();
		/**
		 * @param quest
		 */
		
		public MultipleChoiceCenterPanel(Question quest) {
			super(quest);
			options = ((MultiChoiceQuestion)quest).getOptions();
			
			center.setLayout(new GridLayout(options.size(), 1));
			
			JCheckBox button;
			for(Option o : options){
				button = new JCheckBox(o.getOption());
				button.setVisible(true);
				center.add(button);
			}
		}
		
		
		/* (non-Javadoc)
		 * @see icfs.student.exercise.CenterStudentQuestionPanel#generateMQuestion(moon.mark.MExercise)
		 */
		@Override
		public void generateMQuestion(MExercise me) {
			//q.answer(, me);
		}

}
