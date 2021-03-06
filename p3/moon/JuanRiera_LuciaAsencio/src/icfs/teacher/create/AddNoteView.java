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
 * Class that implement the note creating view
 * @author lucia
 *
 */
public class AddNoteView extends LowerPanel{
	private AddUnitView view;
	protected Unit parentUnit;
	protected int separation = 70;
	protected JLabel nameLabel;
	protected JTextField name;
	protected JLabel message;
	protected JPanel down;
	protected JCheckBox visibility;
	protected JLabel contentsLabel;
	protected JTextArea content;
	protected JButton save;
	protected JButton exit;
	protected SpringLayout layout;
	
	/**
	 * Constructor of the view
	 */
	public AddNoteView(){
		super();
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		this.layout = layout;
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
		this.save = save;
		this.exit = exit;
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
		this.nameLabel = name;
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
		this.contentsLabel = contents;
		
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





	private JPanel up() {
		JLabel label = new JLabel("Add Note to unit " + this.parentUnit);
		
		JPanel panel = new JPanel();
		panel.add(label, BorderLayout.WEST);
		panel.setBackground(Color.WHITE);
		this.message = label;
		
		return panel;
	}


	/**
	 * Gets the unit
	 * @return Unit
	 */
	public Unit getUnit(){
		return this.parentUnit;
	}
	
	/**
	 * Gets the result in the visibikity checkbox
	 * @return  true if the visibility is selecte
	 */
	public boolean isNoteVisible(){
		return this.visibility.isSelected();
	}

	/**
	 * Gets the string in the name field
	 * @return name
	 * @throws EmptyTextFieldException
	 */
	public String getNoteName() throws EmptyTextFieldException{
		if(this.name.getText().equals("")) throw new EmptyTextFieldException();
		return this.name.getText();
	}

	/**
	 * Gets the name textfiel
	 * @return
	 */
	public JTextField getText(){
		return this.name;
	}
	
	/**
	 * Gets the note conten
	 * @return
	 * @throws EmptyTextFieldException
	 */
	public String getNoteContent() throws EmptyTextFieldException{
		if(this.content.getText().equals("")) throw new EmptyTextFieldException();
		
		return this.content.getText();
	}
	/**
	 * Sets the view to mar¡tch the parent unit
	 * @param u
	 */
	public void setEverything(Unit parentUnit) {
		name.setEnabled(true);
		content.setEnabled(true);
		this.visibility.setSelected(false);
		this.parentUnit = parentUnit;		
		message.setText("Add Note to unit " + this.parentUnit);
		name.setText(null);
		content.setText(null);
	}

}
