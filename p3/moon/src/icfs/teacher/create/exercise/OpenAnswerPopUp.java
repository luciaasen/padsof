/**
 * 
 */
package icfs.teacher.create.exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import moon.Academy;
import moon.course.Exercise;
import moon.course.question.*;




/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class OpenAnswerPopUp extends BasicPopup {
	private OptionsPanel opPanel;
	
	
	public OpenAnswerPopUp(AddExeController controller, Exercise exe){
		super(controller, "Open answer question wizard", exe);
	}

	
	@Override
	protected JPanel getCentralPanel(){
		opPanel = new OptionsPanel("Add correct answers", "Correct answers: ");
		return opPanel;
	}
	
	@Override
	protected Question getQuestion(double relevance) {
		if(opPanel.getOptions().size()==0){
			return null;
		}
		return new OpenQuestion(contentsT.getText(), relevance, opPanel.getOptions(), exe);
	}
	
	
}
