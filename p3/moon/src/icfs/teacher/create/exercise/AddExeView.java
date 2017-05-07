/**
 * 
 */
package icfs.teacher.create.exercise;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import icfs.LowerPanel;
import main.mainMoon;
import moon.Academy;
import moon.course.Exercise;
import moon.course.Unit;

/**
 * @author lucia
 *
 */
public class AddExeView extends LowerPanel{

	public AddExeView(){
		JPanel north = new JPanel();
		JPanel center;
		JPanel south = new JPanel();
		
		north.setBackground(Color.WHITE);
		north.add(new JLabel("Add exercise"));
		
		center = generateCenter();
		
		JButton button = new JButton("Back to main page");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.MAIN));
		south.add(button);
		south.setBackground(Academy.ORANGE);
		
		this.setLayout(new BorderLayout(10,10));
		this.add(north,BorderLayout.NORTH);
		this.add(center,BorderLayout.CENTER);
		this.add(south,BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}
	/**
	 * @param u
	 */
	public void setEverything(Unit u) {
		// TODO Auto-generated method stub
		
	}
	
	private JPanel generateCenter(){
		JPanel center = new JPanel();
		center.setBackground(Color.WHITE);
		
		return center;
	}

}
