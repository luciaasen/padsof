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
	private ArrayList<Option> options = new ArrayList<>();
	private DefaultListModel<Option> model = new DefaultListModel<>();
	private JList<Option> list = new JList<>(model);
	private JTextField text = new JTextField(20);
	private JTextArea contentsT = new JTextArea();
	
	
	public OpenAnswerPopUp(AddExeController controller, Exercise exe){
		super(controller, "Open answer question wizard", exe);
	}

	@Override
	protected JPanel getCentralPanel() {
		JPanel superPanel = new JPanel();
		JPanel upper = new JPanel();
		superPanel.setLayout(new GridLayout(2,1));
		
		upper.setLayout(new BorderLayout(10,10));
		upper.add(new JLabel("Question text: "), BorderLayout.WEST);
		contentsT.setBorder(BorderFactory.createLineBorder(Academy.DARK_GREEN));
		contentsT.setLineWrap(true);
		upper.add(contentsT, BorderLayout.CENTER);
		
		superPanel.add(upper);
		superPanel.add(lower());
		return superPanel;
	}
	
	private JPanel lower(){
		JPanel panel = new JPanel();
		JPanel north = new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		north.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		north.add(new JLabel("Add a correct answer: "));
		north.add(text);
		JButton button = new JButton("Add");
		button.addActionListener(e -> {
			Option o = new Option(text.getText());
			options.add(o);
			model.addElement(o);
			text.setText("");
		});
		north.add(button);
		
		list.setBorder(BorderFactory.createTitledBorder( 
				BorderFactory.createLineBorder(Academy.DARK_GREEN, 5),"Correct answers:"));
		panel.setLayout(new BorderLayout(20,20));
		panel.add(north,BorderLayout.NORTH);
		panel.add(new JScrollPane(list), BorderLayout.CENTER);
		
		return panel;
	}
	@Override
	protected Question getQuestion(double relevance) {
		return new OpenQuestion(contentsT.getText(), relevance, options, exe);
	}
	
	
}
