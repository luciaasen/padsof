/**
 * 
 */
package icfs.teacher.create.exercise;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import moon.Academy;
import moon.course.Exercise;
import moon.course.question.OneChoiceQuestion;
import moon.course.question.OpenQuestion;
import moon.course.question.Option;
import moon.course.question.Question;

/**
 * @author juan
 *
 */
public class SingleChoicePopup extends BasicPopup{
	private OptionsPanel opPanel;
	private JTextField correct;
	
	
	public SingleChoicePopup(AddExeController controller, Exercise exe){
		super(controller, "Single choice question wizard", exe);
	}

	
	
	protected JPanel central(){
		opPanel = new OptionsPanel("Add incorrect answers");
		return opPanel;
	}
	
	@Override
	protected Question getQuestion(double relevance) {
		if(opPanel.getOptions().size()==0 || correct.getText().length()==0){
			return null;
		}
		ArrayList<Option>options = opPanel.getOptions();
		options.add(new Option(correct.getText()));
		ArrayList<Option>correctList = new ArrayList<>();
		correctList.add(new Option(correct.getText()));
		return new OneChoiceQuestion(contentsT.getText(), relevance, options, correctList, exe);
	}



	
	@Override
	protected Component getCentralPanel() {
		JPanel panel = new JPanel();
		JPanel north = new JPanel();
		panel.setLayout(new BorderLayout(10,10));
		north.add(new JLabel("Introduce the correct answer: "));
		north.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		correct = new JTextField(20);
		north.add(correct);
		panel.add(north, BorderLayout.NORTH);
		panel.add(central(), BorderLayout.CENTER);
		return new JScrollPane(panel);
	}
	
}
