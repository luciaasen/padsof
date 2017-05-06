/**
 * 
 */
package icfs.teacher.create;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import exception.EmptyTextFieldException;
import icfs.DatePanel;
import icfs.LowerPanel;
import moon.Academy;
import moon.course.Course;
import moon.course.CourseElement;
import moon.course.Unit;

/**
 * @author lucia
 *
 */
public class AddUnitView extends LowerPanel{
	private int separation = 70;
	private JTextField name;
	private JLabel message;
	/*private DatePanel dateIni;
	private DatePanel dateEnd;
	*/
	private Unit parentUnit;
	private Course parentCourse;
	JPanel down;
	JCheckBox visibility;
	
	public AddUnitView(){
		super();
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
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
		
		JButton addSub = new JButton ("Save & add subunit");
		JButton addNote = new JButton ("Save & add note");
		JButton addExe = new JButton ("Save & add exe");
		JButton save = new JButton("Save & exit");
		JButton exit = new JButton("Back to main page");
		
		int sepButtons = 10;
		layout.putConstraint(SpringLayout.WEST, addSub, 0, SpringLayout.WEST, down);
		layout.putConstraint(SpringLayout.WEST, addNote, sepButtons, SpringLayout.EAST, addSub);
		layout.putConstraint(SpringLayout.WEST, addExe, sepButtons, SpringLayout.EAST, addNote);
		layout.putConstraint(SpringLayout.EAST, exit, 0, SpringLayout.EAST, down);
		layout.putConstraint(SpringLayout.EAST, save, -sepButtons, SpringLayout.WEST, exit);
		
		layout.putConstraint(SpringLayout.NORTH, addSub, 3*separation/2, SpringLayout.SOUTH, down);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, addNote, 0, SpringLayout.VERTICAL_CENTER, addSub);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, addExe, 0, SpringLayout.VERTICAL_CENTER, addSub);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, save, 0, SpringLayout.VERTICAL_CENTER, addSub);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, exit, 0, SpringLayout.VERTICAL_CENTER, addSub);
	
		this.add(exit);
		this.add(save);
		this.add(addExe);
		this.add(addNote);
		this.add(addSub);
		
		exit.addActionListener(new AddUnitController(this));
		save.addActionListener(new AddUnitController(this));
		addExe.addActionListener(new AddUnitController(this));
		addNote.addActionListener(new AddUnitController(this));
		addSub.addActionListener(new AddUnitController(this));
	}
	
	
	private JPanel up(){
		
		JLabel label;
		if(this.parentCourse != null){
			label = new JLabel("Add Unit to course " + this.parentCourse + this.parentUnit);
		}else{
			label = new JLabel("Add Unit to unit " + this.parentUnit + this.parentCourse);
		}
		
		JPanel panel = new JPanel();
		panel.add(label, BorderLayout.WEST);
		panel.setBackground(Color.WHITE);
		this.message = label;
		
		return panel;
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
		JLabel name = new JLabel("Unit name: ");
		JTextField nameT = new JTextField(10);
		this.name = nameT;
		
		layout.putConstraint(SpringLayout.SOUTH, name, -2*separation, SpringLayout.VERTICAL_CENTER, down);
		layout.putConstraint(SpringLayout.SOUTH, nameT, -2*separation, SpringLayout.VERTICAL_CENTER, down);
		layout.putConstraint(SpringLayout.EAST, name, -separation/2, SpringLayout.HORIZONTAL_CENTER, down);
		layout.putConstraint(SpringLayout.WEST, nameT, separation/2, SpringLayout.HORIZONTAL_CENTER, down);
		
		/*Add visibility*/
		
		JCheckBox visibility = new JCheckBox("Visible");
		visibility.setBackground(Color.white);
		this.visibility = visibility;
		layout.putConstraint(SpringLayout.NORTH, visibility, 2*separation, SpringLayout.VERTICAL_CENTER, down);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, visibility, 0, SpringLayout.HORIZONTAL_CENTER, down);
		
				
		
		/*Add unit dates things*/
/*		DatePanel date = new DatePanel("Visibility starting day");
		this.dateIni = date;	
		
		layout.putConstraint(SpringLayout.NORTH, date, 2*separation, SpringLayout.SOUTH, name);
		layout.putConstraint(SpringLayout.WEST, date, separation, SpringLayout.WEST, down);
		layout.putConstraint(SpringLayout.EAST, date, separation, SpringLayout.EAST, down);
		
		DatePanel date2 = new DatePanel("Visibility ending day");
		this.dateEnd = date2;	
		
		layout.putConstraint(SpringLayout.NORTH, date2, 2*separation, SpringLayout.SOUTH, date);
		layout.putConstraint(SpringLayout.WEST, date2, separation, SpringLayout.WEST, down);
		layout.putConstraint(SpringLayout.EAST, date2, separation, SpringLayout.EAST, down);
	*/	
		/*Add Unit subunits things*/
	/*	JLabel subunits = new JLabel("Current contents, ");
		Dimension dim = new Dimension(WIDTH/2, HEIGHT/2);
		FilteredList sublist = new FilteredList(dim, this.u.getContents());		
		
	*/
	/*	down.add(date);
		down.add(date2);
		*/
		down.add(name);
		down.add(nameT);
		down.add(visibility);
		
		return down;
	}
	
	public void setEverything(Course parentCourse){
		this.parentCourse = parentCourse;
		this.parentUnit = null;
		
		message.setText("Add Unit to course " + this.parentCourse + this.parentUnit);
		name.setText(null);
		
	}
	
	public void setEverything(Unit parentUnit){
		this.parentUnit = parentUnit;
		this.parentCourse = null;
		
		message.setText("Add Unit to unit " + this.parentCourse + this.parentUnit);
		name.setText(null);
		
	}
	
	public String getUnitName() throws EmptyTextFieldException{
		if(this.name.getText().equals("")) throw new EmptyTextFieldException();
		return this.name.getText();
	}
	
	public boolean isUnitVisible(){
		return this.visibility.isSelected();
	}
	
	public Course getParentCourse(){
		return this.parentCourse;
	}
	
	public Unit getParentUnit(){
		return this.parentUnit;
	}
/*	public LocalDate getIni() throws NumberFormatException{
		return this.dateIni.getDate();
	}
	public LocalDate getEnd() throws NumberFormatException{
		return this.dateEnd.getDate();
	}
*/
}
