/**
 * 
 */
package icfs.teacher.create.exercise;

import java.awt.BorderLayout;
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
import moon.course.question.Option;

/**
 * @author juan
 *
 */
public class OptionsPanel extends JPanel{
	private ArrayList<Option> options = new ArrayList<>();
	private DefaultListModel<Option> model;
	private JList<Option> list;
	private JTextField text;
	
	public OptionsPanel(String s, String s2){
		JPanel north = new JPanel();
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		north.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		north.add(new JLabel(s));
		text = new JTextField(20);
		north.add(text);
		JButton button = new JButton("Add");
		button.addActionListener(e -> {
			Option o = new Option(text.getText());
			options.add(o);
			model.addElement(o);
			text.setText("");
		});
		north.add(button);
		
		model = new DefaultListModel<>();
		list = new JList<>(model);
		list.setBorder(BorderFactory.createTitledBorder( 
				BorderFactory.createLineBorder(Academy.DARK_GREEN, 5), s2));
		this.setLayout(new BorderLayout(20,20));
		this.add(north,BorderLayout.NORTH);
		this.add(new JScrollPane(list), BorderLayout.CENTER);
		
	}
	
	public ArrayList<Option> getOptions(){
		return options;
	}

}
