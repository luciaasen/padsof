/**
 * 
 */
package icfs.teacher.main;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import icfs.LowerPanel;

/**
 * @author lucia
 *
 */
public class MainTeacherLower extends LowerPanel{
	private static final separation = 20;
	public MainTeacherLower(){
		super();
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		JPanel right = right();
		JPanel left = left();
		layout.putConstraint(SpringLayout.NORTH, right, 0,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, left, 0,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, right, 0,SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.WEST, left, 0,SpringLayout.WEST, this);

	}
	
	/**
	 * Creates the left panel of the main teacher lower vie wwith the scrolled lists
	 * @return Left panel
	 */
	private JPanel left(){
		/*Create left Panel, sey size and layout*/
		JPanel left = new JPanel();
		left.setPreferredSize(new Dimension(this.getWidth()/2, this.getHeight()));
		SpringLayout layout = new SpringLayout();
		left.setLayout(layout);
		
		return left;
	}
	
	/**
	 * This method returns the separation between the panel borders and the lists
	 * @return separation 
	 */
	private int listWidth(){
		return this.getWidth()/2 - 2*separation;
	}
	
	/**
	 * Creates the right panel of the main teacher lower window with the calendar etc
	 * @return right panel
	 */
	private JPanel right(){
		JPanel right = new JPanel();
		
		return right;
	}

}
