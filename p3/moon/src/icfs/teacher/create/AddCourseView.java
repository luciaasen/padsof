/**
 * 
 */
package icfs.teacher.create;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import exception.DuplicateElementException;
import exception.EmptyTextFieldException;
import icfs.DatePanel;
import icfs.LowerPanel;
import icfs.login.LoginWindowView;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDate;;

/**
 * @author lucia
 *
 */
public class AddCourseView extends LowerPanel{
	protected int separation = 70;
	protected JTextField name;
	protected SpringLayout layout;
	protected JButton add;
	protected JButton save;
	protected JButton exit;
	protected JLabel message;
	protected JLabel nameLabel;
	protected JPanel down;
	
	public AddCourseView(){
		super();
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		this.layout = layout;
		JPanel up = up();
		
		layout.putConstraint(SpringLayout.NORTH, up, this.separation, SpringLayout.NORTH, this);
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
	
		JButton add = new JButton ("Save and add unit");
		JButton save = new JButton("Save and exit");
		JButton exit = new JButton("Back to main page");
		
		
		save.addActionListener(e-> {
									String nameT;
									try{
										nameT = getCourseName();
										new Course(nameT);
									}catch(EmptyTextFieldException ex2){
										UIManager UI=new UIManager();
										UI.put("OptionPane.background", Academy.DARK_GREEN);
										UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
										//JOptionPane.showMessageDialog(this, ex2.toString(), "Empty Course name", JOptionPane.ERROR_MESSAGE);
										JOptionPane.showOptionDialog(this, ex2.toString(), "Empty Course name", JOptionPane.YES_OPTION, 
												JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
									}catch(DuplicateElementException ex){
										UIManager UI=new UIManager();
										UI.put("OptionPane.background", Academy.DARK_GREEN);
										UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
										//JOptionPane.showMessageDialog(this, ex2.toString(), "Empty Course name", JOptionPane.ERROR_MESSAGE);
										JOptionPane.showOptionDialog(this, ex.toString(), "Invalid name", JOptionPane.YES_OPTION, 
												JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
									}
									mainMoon.mainSetEverything();
									mainMoon.changeCard(mainMoon.MAIN);
								});
		add.addActionListener(e -> {
									String nameT;
									try{
										nameT = getCourseName();
										Course c = new Course(nameT);
										mainMoon.addUnitSetEverything(c);	
										mainMoon.changeCard(mainMoon.ADD_UNIT);
									}catch(EmptyTextFieldException ex2){
										UIManager UI=new UIManager();
										UI.put("OptionPane.background", Academy.DARK_GREEN);
										UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
										//JOptionPane.showMessageDialog(this, ex2.toString(), "Empty Course name", JOptionPane.ERROR_MESSAGE);
										JOptionPane.showOptionDialog(this, ex2.toString(), "Empty Course name", JOptionPane.YES_OPTION, 
												JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
									}catch(DuplicateElementException ex){
										UIManager UI=new UIManager();
										UI.put("OptionPane.background", Academy.DARK_GREEN);
										UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
										//JOptionPane.showMessageDialog(this, ex2.toString(), "Empty Course name", JOptionPane.ERROR_MESSAGE);
										JOptionPane.showOptionDialog(this, ex.toString(), "Invalid name", JOptionPane.YES_OPTION, 
												JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
									}
								});
		exit.addActionListener(e->{
			mainMoon.mainSetEverything();
			mainMoon.changeCard(mainMoon.MAIN);
		});
		
		layout.putConstraint(SpringLayout.SOUTH, add, 3*separation/2, SpringLayout.SOUTH, down);
		layout.putConstraint(SpringLayout.SOUTH, save, 3*separation/2, SpringLayout.SOUTH, down);	
		layout.putConstraint(SpringLayout.SOUTH, exit, 3*separation/2, SpringLayout.SOUTH, down);
		layout.putConstraint(SpringLayout.WEST, add, 0, SpringLayout.WEST, down);
		layout.putConstraint(SpringLayout.EAST, exit, 0, SpringLayout.EAST, down);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, save, 0, SpringLayout.HORIZONTAL_CENTER, down);
		
		this.add(add);
		this.add(save);
		this.add(exit);
		
		this.save = save;
		this.exit = exit;
		this.add = add;
		this.setVisible(true);
	
	}
	
	private JPanel up(){
		JLabel label = new JLabel("Add Course");
		this.message = label;
		
		JPanel panel = new JPanel();
		panel.add(label, BorderLayout.WEST);
		panel.setBackground(Color.WHITE);
		return panel;
	}
	
	private JPanel down(){
		int separation = 10;
		JPanel down = new JPanel();
		down.setBackground(Color.WHITE);
		SpringLayout layout = new SpringLayout();
		down.setPreferredSize(new Dimension(Academy.DIMENSION.width - 2*this.separation, Academy.DIMENSION.height*2/5));
		down.setLayout(layout);
		down.setBackground(Color.WHITE);
		
		JLabel name = new JLabel("Course name: ");
		this.nameLabel = name;
		JTextField nameT = new JTextField(10);
		this.name = nameT;
		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, name, 0, SpringLayout.VERTICAL_CENTER, down);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, nameT, 0, SpringLayout.VERTICAL_CENTER, down);
		layout.putConstraint(SpringLayout.EAST, name, -separation/2, SpringLayout.HORIZONTAL_CENTER, down);
		layout.putConstraint(SpringLayout.WEST, nameT, separation/2, SpringLayout.HORIZONTAL_CENTER, down);
				
		down.add(name);
		down.add(nameT);
		
		return down;
	}
	
	public String getCourseName() throws EmptyTextFieldException{
		if(this.name.getText().equals("")) throw new EmptyTextFieldException();
		return this.name.getText();
	}
	
	public JTextField getText(){
		return this.name;
	}
	
	public void setEverything(){
		this.name.setEnabled(true);
		this.name.setText(null);
	}
}
