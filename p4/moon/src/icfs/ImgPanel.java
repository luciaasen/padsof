/**
 * 
 */
package icfs;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;


/**
 * This class is needed to create a pannel that shows and image each time its drawn
 * It extends JPanel and overrides the painting method
 * @author lucia
 *
 */
public class ImgPanel extends JPanel{
	private Image img;
	private int proportion;
	
	/**
	 * ImgPanel constructor
	 * @param img the imag to be shown
	 * @param proportion between the img given and the panel returned
	 */
	public ImgPanel(Image img, int proportion){
		this.img = img;
		this.proportion = proportion;
		Dimension size = new Dimension(img.getWidth(null)/proportion, img.getHeight(null)/proportion);
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	    setPreferredSize(size);
	    	}
	
	@Override	
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, img.getWidth(null)/proportion, img.getHeight(null)/proportion, null);
	} 
}

