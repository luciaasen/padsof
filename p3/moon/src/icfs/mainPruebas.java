/**
 * 
 */
package icfs;

import javax.swing.JFrame;
import javax.swing.JPanel;

import icfs.login.LoginWindow;
import icfs.student.main.MainStudentPanel;
import moon.course.Course;

/**
 * @author juan
 *
 */
public class mainPruebas {
	public static void main(String args[]){
		
		new Course("Math");
		new Course("Padsof");
		JPanel aux = new MainStudentPanel();
		JFrame window = new JFrame();
		
		window.getContentPane().add(aux);
		aux.setVisible(true);
		window.setVisible(true);
		window.setSize(1000, 600);
	}
}
