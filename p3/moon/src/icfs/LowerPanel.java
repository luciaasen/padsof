/**
 * 
 */
package icfs;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import moon.Academy;

/**
 * This class creates a light orange panel as the one which is in the lower part of every view,
 * calculating its height from the upperpanel height
 * @author lucia
 *
 */
public class LowerPanel extends JPanel{
	public static final int HEIGHT = (int) (Academy.DIMENSION.getHeight() - UpperPanel.HEIGHT);
	public static final int WIDTH = Academy.DIMENSION.width;
	public LowerPanel(){
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Academy.ORANGE);
		this.setVisible(true);
		//this.add(new JButton("Hola"));
	}
}