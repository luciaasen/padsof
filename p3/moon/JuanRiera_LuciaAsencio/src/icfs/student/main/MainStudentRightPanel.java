/**
 * 
 */
package icfs.student.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import icfs.DatePanel;
import icfs.calendar.MonthPanel;
import main.mainMoon;
import moon.Academy;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class MainStudentRightPanel extends JPanel{
	/* This right panel will have two panels inside of it: an upper and a lower one */
	
	JPanel upperPanel = new JPanel();
	JPanel lowerPanel = new JPanel();
	JPanel superUpper = new JPanel();
	JPanel statsButtonPanel = new JPanel();
	JLabel average = new JLabel("      Average mark:  ");
	JLabel maximum = new JLabel("      Maximum mark:  ");
	JLabel minimum = new JLabel("      Minimum mark:  ");
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
		lowerPanel.setBorder(border1);
		lowerPanel.setLayout(new GridLayout(1,1));
		lowerPanel.add(new MonthPanel(LocalDate.now().getMonth().getValue()-1,
				LocalDate.now().getYear()));
		lowerPanel.setBackground(Academy.DARK_GREEN);
		superUpper.setBackground(Academy.DARK_GREEN);
		upperPanel.setBackground(Color.white);
		superUpper.setBorder(BorderFactory.createLineBorder(Academy.DARK_GREEN, 10, false));
		superUpper.setLayout(new BorderLayout(10, 10));
		this.setSize(51, 51);
		this.setBackground(Academy.ORANGE);
		JButton moreStats = new JButton("More statistics");
		moreStats.addActionListener(e -> mainMoon.changeCard(mainMoon.SELECT_COURSE));
		statsButtonPanel.add(moreStats);
		statsButtonPanel.setBackground(Academy.DARK_GREEN);
		
		upperPanel.add(average);
		upperPanel.add(averageN);
		upperPanel.add(maximum);
		upperPanel.add(maximumN);
		upperPanel.add(minimum);
		upperPanel.add(minimumN);
		
		superUpper.add(upperPanel, BorderLayout.CENTER);
		superUpper.add(statsButtonPanel, BorderLayout.SOUTH);
		this.add(superUpper);
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
