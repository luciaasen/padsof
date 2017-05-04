/**
 * 
 */
package icfs.teacher.create;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import icfs.LowerPanel;
import moon.Academy;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;;

/**
 * @author lucia
 *
 */
public class AddCourseView extends LowerPanel{
	private int separation = 70;
	
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
		
		this.setVisible(true);
	
	}
	
	private JPanel up(){
		
		/*The following code was taken from http://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size0 */
		/*Used for resizing the labels font when resizing the window*/
		
		JLabel label = new JLabel("Add Course");
		/*********/
		/*Font labelFont = label.getFont();
		
		int stringWidth = label.getFontMetrics(labelFont).stringWidth("Add Course");
		int componentWidth = label.getWidth();

		double widthRatio = (double)componentWidth / (double)stringWidth;

		int newFontSize = (int)(labelFont.getSize() * widthRatio);
		int componentHeight = label.getHeight();

		int fontSizeToUse = Math.min(newFontSize, componentHeight);

		label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		/**********/
		
		JPanel panel = new JPanel();
		panel.add(label, BorderLayout.WEST);
		//panel.setPreferredSize(new Dimension(this.getWidth()/3, this.getHeight()/10));
		panel.setBackground(Color.WHITE);
		return panel;
	}
	
	private JPanel down(){
		JPanel down = new JPanel();
		SpringLayout layout = new SpringLayout();
		down.setPreferredSize(new Dimension(Academy.DIMENSION.width - 2*this.separation, Academy.DIMENSION.height*2/5));
		down.setLayout(layout);
		down.setBackground(Color.WHITE);
		
		return down;
	}
	

}
