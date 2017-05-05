/**
 * 
 */
package icfs.student.main;

import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import icfs.DatePanel;
import icfs.calendar.MonthPanel;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class MainStudentRightPanel extends JPanel{
	/* This right panel will have two panels inside of it: an upper and a lower one */
	
	JPanel upperPanel = new JPanel();
	JPanel lowerPanel = new JPanel();
	JLabel average = new JLabel("Average mark:  ");
	JLabel maximum = new JLabel("Maximum mark:  ");
	JLabel minimum = new JLabel("Minimum mark:  ");
	JLabel averageN = new JLabel();
	JLabel maximumN = new JLabel();
	JLabel minimumN = new JLabel();
	
	/**
	 * Constructor of the class with package security.
	 */
	MainStudentRightPanel(){
		
		this.setLayout(new GridLayout(2,1,10,10));
		upperPanel.setLayout(new GridLayout(3,2,10,10));
		
		Border border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		this.setBorder(border1);
		upperPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		lowerPanel.setBorder(border1);
		lowerPanel.setLayout(new GridLayout(1,1));
		lowerPanel.add(new MonthPanel(LocalDate.now().getMonth().getValue()-1,
				LocalDate.now().getYear()));
		upperPanel.setSize(50, 50);
		upperPanel.setBackground(Color.pink);
		this.setSize(51, 51);
		this.setBackground(Color.blue);
		
		upperPanel.add(average);
		upperPanel.add(averageN);
		upperPanel.add(maximum);
		upperPanel.add(maximumN);
		upperPanel.add(minimum);
		upperPanel.add(minimumN);
		
		
		this.add(upperPanel);
		this.add(lowerPanel);
		upperPanel.setVisible(true);
		this.setVisible(true);
	}
	
	public void setEverything(Student s, MainStudentController controller){
		double[] stats = controller.getStats();
		averageN.setText((new Double(stats[0])).toString());
		maximumN.setText((new Double(stats[1])).toString());
		minimumN.setText((new Double(stats[2])).toString());
	}
	
	
}
