/**
 * 
 */
package icfs;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author juan
 *
 */
public class mainPruebas {
	public static void main(String args[]){
		
		JPanel aux = new LoginWindow();
		JFrame window = new JFrame();
		
		window.getContentPane().add(aux);
		aux.setVisible(true);
		window.setVisible(true);
		window.setSize(500, 500);
	}
}
