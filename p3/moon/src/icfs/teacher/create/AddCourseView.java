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
	private int separation = 70;
	private JTextField name;
	//private DatePanel date;
	
	public static void main(String[] args){
		JFrame window = new JFrame();
		window.setSize(Academy.DIMENSION);
		window.getContentPane().add(new AddCourseView(), BorderLayout.CENTER);
		window.setVisible(true);
	}
	public AddCourseView(){
		super();
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		JPanel up = up();
		//up.setPreferredSize(new Dimension(this.getWidth()/3, this.getHeight()/10));
		//up.setPreferredSize(new Dimension(40, 50));
		
		layout.putConstraint(SpringLayout.NORTH, up, this.separation, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, up, this.separation, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, up, -this.separation, SpringLayout.EAST, this);
		
		JPanel down = down();
		
		//down.setPreferredSize(new Dimension(this.getWidth() - 2* this.separation, 2*this.getHeight()/5));
		
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
										JOptionPane.showMessageDialog(this, ex2.toString(), "Empty Course name", JOptionPane.ERROR_MESSAGE);
									}
									mainMoon.mainSetEverything();
									mainMoon.changeCard(mainMoon.MAIN);
								});
		add.addActionListener(e -> {
									String nameT;
									try{
										nameT = getCourseName();
										new Course(nameT);
									}catch(EmptyTextFieldException ex2){
										UIManager UI=new UIManager();
										UI.put("OptionPane.background", Academy.DARK_GREEN);
										UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
										JOptionPane.showMessageDialog(this, ex2.toString(), "Empty Course name", JOptionPane.ERROR_MESSAGE);
									}
									mainMoon.mainSetEverything();
									mainMoon.changeCard(mainMoon.ADD_UNIT);
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
		
		this.setVisible(true);
	
	}
	
	private JPanel up(){
		JLabel label = new JLabel("Add Course");
		
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
		JTextField nameT = new JTextField(10);
		this.name = nameT;
		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, name, 0, SpringLayout.VERTICAL_CENTER, down);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, nameT, 0, SpringLayout.VERTICAL_CENTER, down);
		layout.putConstraint(SpringLayout.EAST, name, -separation/2, SpringLayout.HORIZONTAL_CENTER, down);
		layout.putConstraint(SpringLayout.WEST, nameT, separation/2, SpringLayout.HORIZONTAL_CENTER, down);
				
		/*
		DatePanel date = new DatePanel("Visibility starting day");
		this.date = date;	
		
		layout.putConstraint(SpringLayout.NORTH, date, 2*separation, SpringLayout.SOUTH, name);
		layout.putConstraint(SpringLayout.WEST, date, separation, SpringLayout.WEST, down);
		layout.putConstraint(SpringLayout.EAST, date, separation, SpringLayout.EAST, down);
		
		down.add(date);
		*/
		down.add(name);
		down.add(nameT);
		
		return down;
	}
	
	public String getCourseName() throws EmptyTextFieldException{
		if(this.name.getText().equals("")) throw new EmptyTextFieldException();
		return this.name.getText();
	}
	
	/*
	public LocalDate getDate() throws NumberFormatException{
		return this.date.getDate();
	}*/
}
