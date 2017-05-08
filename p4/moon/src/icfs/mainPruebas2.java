/**
 * 
 */
package icfs;

import javax.swing.JFrame;
import javax.swing.JPanel;

import icfs.student.exercise.StudentQuestionView;
import moon.Academy;

/**
 * @author juan
 *
 */
public class mainPruebas2 {
	public static void main(String[] args){
		JFrame window = new JFrame();
		//TODO discute con juan si esto no deberia de estar despues del if (caso de re log in)
		window.setVisible(true);
		window.setSize(Academy.DIMENSION);
	
		JPanel superPanel = new StudentQuestionView();
		window.getContentPane().add(superPanel);
	}
}
