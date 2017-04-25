/**
 * 
 */
package icfs;

import javax.swing.JFrame;
import javax.swing.JPanel;

import icfs.login.*;
import icfs.student.main.MainStudentPanel;
import moon.course.Course;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class mainPruebas {
	//public static void main(){
	public static void main(String[] args){
		LoginWindowView prueba = new LoginWindowView();
		
		
		new Course("Math");
		new Course("Padsof");
		/* Do not use */
		/*Student s = new Student(null, null, null, 1, null);
		JPanel aux = new MainStudentPanel(s);
		JFrame window = new JFrame();
		window.getContentPane().add(aux);
		aux.setVisible(true);
		window.setVisible(true);
		window.setSize(1000, 600);*/
	}
}
