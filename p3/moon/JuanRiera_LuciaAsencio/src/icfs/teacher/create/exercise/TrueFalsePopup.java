/**
 * 
 */
package icfs.teacher.create.exercise;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import moon.Academy;
import moon.course.Exercise;
import moon.course.question.OpenQuestion;
import moon.course.question.Option;
import moon.course.question.Question;
import moon.course.question.TfQuestion;

/**
 * Popup class to create true false popup
 * @author Juan Riera and Lucia Asencio
 *
 */
public class TrueFalsePopup extends BasicPopup{
	private ButtonGroup group;
	private JRadioButton tre;
	private JRadioButton flse;
	
	/**
	 * Constructor of the popup.
	 * @param controller
	 * @param exe
	 */
	public TrueFalsePopup(AddExeController controller, Exercise exe){
		super(controller, "True/false answer question wizard", exe);
	}

	
	@Override
	protected JPanel getCentralPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		tre = new JRadioButton("True");
		flse = new JRadioButton("False");
		panel.add(new JLabel("Correct answer:"));
		panel.add(tre);
		panel.add(flse);
		group = new ButtonGroup();
		group.add(tre);
		group.add(flse);
		return panel;
	}
	@Override
	protected Question getQuestion(double relevance) {
		if(contentsT.getText().length()==0){
			return null;
		}
		if(tre.isSelected()){
			return new TfQuestion(contentsT.getText(), relevance, true, exe);
		} else if(flse.isSelected()) {
			return new TfQuestion(contentsT.getText(), relevance, false, exe);
		} else {
			return null;
		}
	}
}
