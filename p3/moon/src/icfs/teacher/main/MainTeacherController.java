/**
 * 
 */
package icfs.teacher.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.mainMoon;

/**
 * @author lucia
 *
 */
public class MainTeacherController implements ActionListener{
	private MainTeacherLower view;

	public MainTeacherController(MainTeacherLower view){
		this.view = view;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	/*@Override
	public void actionPerformed(ActionEvent e) {
		if(view.getAction().equals("Add")){
			if(view.getElement().equals("Course")){
				mainMoon.addCourseSetEverything();
				mainMoon.changeCard(mainMoon.ADD_COURSE);
			}
		}
		
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
			mainMoon.addCourseSetEverything();
			mainMoon.changeCard(mainMoon.ADD_COURSE);
	}
}
