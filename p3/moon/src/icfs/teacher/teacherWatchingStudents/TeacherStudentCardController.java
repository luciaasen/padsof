/**
 * 
 */
package icfs.teacher.teacherWatchingStudents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import main.mainMoon;
import moon.course.Course;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class TeacherStudentCardController implements ActionListener{
	TeacherStudentCard view;
	Course c;
	Student s;
	
	public TeacherStudentCardController(TeacherStudentCard view){
		this.view = view;
	}
	
	public void setEverything(Course c, Student s){
		this.c = c;
		this.s = s;
		view.name.setText(s.toString());
		view.average.setText("Mark: " + (new Double(c.getCourseMark(s)).toString()));
		if(c.isExpelled(s)==true){
			view.expelledFrom.setText("Expelled from "+ c.getName());
			view.expellOrReadmit.setText("Readmit student");
		} else {
			view.expelledFrom.setText("Not expelled from "+ c.getName());
			view.expellOrReadmit.setText("Expel student");
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		mainMoon.teacherStudentStatsSelectSetEverything(s);
		mainMoon.changeCard(mainMoon.STUDENT_STATS_MENU);
		
	}

	/**
	 * @return
	 */
	public void expelOrReadmit() {
		try {
			if(c.isExpelled(s)){
				c.readmitStudent(s);
			} else {
				c.expelStudent(s);
			}
		} catch (InvalidEmailAddressException  e) {
			JOptionPane.showOptionDialog(null, "Invalid email error", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			
		} catch (FailedInternetConnectionException e){
			JOptionPane.showOptionDialog(null, "Failed to connect to internet", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
		}
	}
}
