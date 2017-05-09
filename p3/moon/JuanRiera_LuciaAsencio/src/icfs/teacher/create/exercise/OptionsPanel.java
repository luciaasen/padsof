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
 * Panel that has a list, a text field and a button with the text "add".
 * Whenever you click on add, an Option (moon.course.question.Option) 
 * with the text of the text field will be added to the list.
 * 
 * It will be used by the popups in multiple ocasions.
 * 
 * @author Juan Riera and Lucia Asencio
 *
 */
public class OptionsPanel extends JPanel{
	private ArrayList<Option> options = new ArrayList<>();
	private DefaultListModel<Option> model;
	private JList<Option> list;
	private JTextField text;
	
	/**
	 * Constructor of the panel.
	 * @param s string to put in the label
	 * @param s2 string to put in the border
	 */
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
	
	/**
	 * Gets the elements of the list.
	 * @return
	 */
	public ArrayList<Option> getOptions(){
		return options;
	}

}
