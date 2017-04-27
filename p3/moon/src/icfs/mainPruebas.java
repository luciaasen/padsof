/**
 * 
 */
package icfs;

import java.awt.CardLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import icfs.login.*;
import icfs.student.course.StudentCourseView;
import icfs.student.main.MainStudentPanel;
import moon.course.Course;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class mainPruebas {
	//public static void main(){
	public static void main(String[] args) throws Exception {
		//LoginWindowView prueba = new LoginWindowView();
		
		epilepsiaFotosensible();
		
	}
	
	/**
	 * Class designed to destroy your eyes.
	 * @throws Exception
	 */
	public static void epilepsiaFotosensible() throws Exception {
		Course math = new Course("Math");
		new Course("Padsof");
		
		
		Student s = new Student("pepe", "Rodriguez", "134", 1, "superpep.e@uam.es");
		s.apply(math).accept();
		MainStudentPanel aux1 = new MainStudentPanel();
		StudentCourseView aux2 = new StudentCourseView();
		JPanel superPanel = new JPanel();
		CardLayout layout = new CardLayout();
		
		superPanel.setLayout(layout);
		superPanel.add(aux1, "mainPanel");
		superPanel.add(aux2, "coursePanel");
		aux2.setEverything(s, math);
		JFrame window = new JFrame();
		window.getContentPane().add(superPanel);
		aux2.setVisible(true);
		aux1.setVisible(true);
		window.setVisible(true);
		window.setSize(1000, 600);
		
	
		while(true){
			layout.next(superPanel);
			TimeUnit.MILLISECONDS.sleep(50);
			layout.next(superPanel);
			TimeUnit.MILLISECONDS.sleep(50);
		}
	}
}
