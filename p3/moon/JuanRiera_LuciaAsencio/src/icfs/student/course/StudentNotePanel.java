/**
 * 
 */
package icfs.student.course;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import icfs.LowerPanel;
import main.mainMoon;
import moon.Academy;
import moon.course.Note;

/**
 * Extension of JPanel for the student to see his notes (text notes).
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentNotePanel extends LowerPanel {
	private JTextPane text;
	private JPanel buttons;
	public StudentNotePanel(){
		text = new JTextPane();
		text.setEditable(false);
		buttons = new JPanel();
		JButton button = new JButton("Back");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.COURSE));
		buttons.add(button);
		buttons.setBackground(Academy.ORANGE);
		this.setLayout(new BorderLayout(20, 20));
		this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		this.add(text,BorderLayout.CENTER);
		this.add(buttons,BorderLayout.SOUTH);
	}
	
	/**
	 * Sets everything to match the parameter
	 * @param n
	 */
	public void setEverything(Note n){
		text.setText(n.getText());
	}
}