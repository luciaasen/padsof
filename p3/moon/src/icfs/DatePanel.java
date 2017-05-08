/**

 * 
 */
package icfs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * @author lucia
 *
 */
public class DatePanel extends JPanel{
	private JComboBox day, month;
	private JTextField year;
	
	public DatePanel(String s){
		super();		
		this.setBackground(Color.white);
		/*JLabel*/
		JLabel label = new JLabel(s);
		
		/*Month*/
		String[] month =   { "January", "February", "March", "April", "May", "June", "July", "August", "September",
	            			"October", "November", "December"       };
		JComboBox<String> monthC= new JComboBox<String>(month);
		this.month = monthC;
		
		/*Day*/
		JComboBox<Integer> dayC = new JComboBox<Integer>();
		day = dayC;
		DefaultComboBoxModel<Integer> tweight = new DefaultComboBoxModel<>(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28});
		DefaultComboBoxModel<Integer> thirty = new DefaultComboBoxModel<>(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28, 29, 30});
		DefaultComboBoxModel<Integer> thirtyone = new DefaultComboBoxModel<>(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28, 29, 30, 31});
		
		dayC.setModel(thirtyone);
		monthC.addActionListener(new ActionListener(){
									public void actionPerformed(ActionEvent e) {
										int index = monthC.getSelectedIndex();
										int oldIndex = dayC.getSelectedIndex();
								        if (index == 1){
								        	dayC.setModel(tweight);
								        } else if(index == 3 || index == 5 || index == 8 || index == 10){
								        	dayC.setModel(thirty);
								        }else {
								        	dayC.setModel(thirtyone);		             
								        }
								        dayC.setSelectedIndex(oldIndex);
								    }
								});
	
		/*Year*/
		JTextField year = new JTextField(8);
		this.year = year;
		
		/*Add everything*/
		SpringLayout layout = new SpringLayout();
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.NORTH, monthC, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.NORTH, dayC, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.NORTH, year, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, dayC, 10, SpringLayout.WEST, label);
		layout.putConstraint(SpringLayout.WEST, monthC, 10, SpringLayout.WEST, dayC);
		layout.putConstraint(SpringLayout.WEST, year, 10, SpringLayout.WEST, monthC);
		
		this.add(label);
		this.add(dayC);
		this.add(monthC);
		this.add(year);
	}
	
	public LocalDate getDate() throws NumberFormatException{
		int day = this.day.getSelectedIndex();
		int month = this.month.getSelectedIndex();
		int year = Integer.parseInt(this.year.getText());
		
		return LocalDate.of(year, month+1, day+1);
	}	
	
	public void setDate(LocalDate date){
		day.setSelectedItem(date.getDayOfMonth());
		month.setSelectedItem(date.getMonth().getValue()-1);
		year.setText(((Integer)date.getYear()).toString());
	}
}
