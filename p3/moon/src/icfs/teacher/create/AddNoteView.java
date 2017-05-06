/**
 * 
 */
package icfs.teacher.create;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import exception.EmptyTextFieldException;
import icfs.LowerPanel;
import moon.Academy;
import moon.course.Note;
import moon.course.Unit;

/**
 * @author lucia
 *
 */
public class AddNoteView extends LowerPanel{
	private AddUnitView view;
	public Unit parentUnit;
	private int separation = 70;
	private JTextField name;
	private JLabel message;
	private JPanel down;
	private JCheckBox visibility;
	private JTextArea content;
	
	public AddNoteView(){
		super();
		this.view = view;
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		JPanel up = up();
		
		layout.putConstraint(SpringLayout.NORTH, up, this.separation , SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, up, this.separation, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, up, -this.separation, SpringLayout.EAST, this);
		
		JPanel down = down();
		this.down = down;
		
		layout.putConstraint(SpringLayout.NORTH, down, this.separation, SpringLayout.SOUTH, up);
		layout.putConstraint(SpringLayout.SOUTH, down, -2*this.separation, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, down, this.separation, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, down, -this.separation, SpringLayout.EAST, this);
		
		this.add(up);
		this.add(down);
		
		JButton add = new JButton ("Save & back to add unit");
		JButton save = new JButton("Save & back to main page");
		JButton exit = new JButton("Exit without saving");	
		
		layout.putConstraint(SpringLayout.WEST, save, 0, SpringLayout.WEST, down);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, add, 0, SpringLayout.HORIZONTAL_CENTER, down);
		layout.putConstraint(SpringLayout.EAST, exit, 0, SpringLayout.EAST, down);
		layout.putConstraint(SpringLayout.NORTH, save, separation, SpringLayout.SOUTH, down);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, add, 0, SpringLayout.VERTICAL_CENTER, save);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, exit, 0, SpringLayout.VERTICAL_CENTER, save);
		
		
		add.addActionListener(new AddNoteController(this));
		exit.addActionListener(new AddNoteController(this));
		save.addActionListener(new AddNoteController(this));
		
		//this.add(add);
		this.add(exit);
		this.add(save);
	}
	
	
	
	
	
	
	
	/**
	 * @return
	 */
	private JPanel down() {
		int separation = 10;
		JPanel down = new JPanel();
		down.setBackground(Color.WHITE);
		SpringLayout layout = new SpringLayout();
		down.setPreferredSize(new Dimension(Academy.DIMENSION.width - 2*this.separation, Academy.DIMENSION.height*2/5));
		down.setLayout(layout);
		down.setBackground(Color.WHITE);
		
		/*Add unit name things*/
		JLabel name = new JLabel("Note name: ");
		JTextField nameT = new JTextField(10);
		this.name = nameT;
		
		layout.putConstraint(SpringLayout.NORTH, name, 2*separation, SpringLayout.NORTH, down);
		layout.putConstraint(SpringLayout.NORTH, nameT, 2*separation, SpringLayout.NORTH, down);
		layout.putConstraint(SpringLayout.EAST, name, -separation/2, SpringLayout.HORIZONTAL_CENTER, down);
		layout.putConstraint(SpringLayout.WEST, nameT, separation/2, SpringLayout.HORIZONTAL_CENTER, down);
		
		/*Add visibility*/
		JCheckBox visibility = new JCheckBox("Visible");
		visibility.setBackground(Color.white);
		this.visibility = visibility;
		layout.putConstraint(SpringLayout.NORTH, visibility, 2*separation, SpringLayout.SOUTH, name);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, visibility, 0, SpringLayout.HORIZONTAL_CENTER, down);
		
		/*Add contents*/
		JLabel contents = new JLabel("Contents: ");
		JTextArea contentsT = new JTextArea();
		contentsT.setSize(new Dimension(Academy.DIMENSION.width - 6*this.separation, Academy.DIMENSION.height*2/15));
		contentsT.setBorder(BorderFactory.createLineBorder(Academy.DARK_GREEN));
		contentsT.setLineWrap(true);
		this.content = contentsT;
		
		layout.putConstraint(SpringLayout.NORTH, contents, 2*separation, SpringLayout.SOUTH, visibility);
		layout.putConstraint(SpringLayout.NORTH, contentsT, 2*separation, SpringLayout.SOUTH, visibility);
		layout.putConstraint(SpringLayout.SOUTH, contentsT, -2*separation, SpringLayout.SOUTH, down);
		layout.putConstraint(SpringLayout.WEST, contents, this.separation, SpringLayout.WEST, down);
		layout.putConstraint(SpringLayout.WEST, contentsT, separation, SpringLayout.EAST, contents);
		layout.putConstraint(SpringLayout.EAST, contentsT, -2*separation, SpringLayout.EAST, down);
				
		down.add(name);
		down.add(nameT);
		down.add(visibility);
		down.add(contents);
		down.add(contentsT);
		
		return down;
	}









	/**
	 * @return
	 */
	private JPanel up() {
		JLabel label = new JLabel("Add Note to unit " + this.parentUnit);
		
		JPanel panel = new JPanel();
		panel.add(label, BorderLayout.WEST);
		panel.setBackground(Color.WHITE);
		this.message = label;
		
		return panel;
	}



	public Unit getUnit(){
		return this.parentUnit;
	}
	
	public boolean isNoteVisible(){
		return this.visibility.isSelected();
	}

	public String getNoteName() throws EmptyTextFieldException{
		if(this.name.getText().equals("")) throw new EmptyTextFieldException();
		return this.name.getText();
	}

	public JTextField getText(){
		return this.name;
	}
	
	public String getNoteContent(){
		return this.content.getText();
	}
	/**
	 * @param u
	 */
	public void setEverything(Unit parentUnit) {
		name.setEnabled(true);
		this.visibility.setSelected(false);
		this.parentUnit = parentUnit;		
		message.setText("Add Note to unit " + this.parentUnit);
		name.setText(null);
	}

}
