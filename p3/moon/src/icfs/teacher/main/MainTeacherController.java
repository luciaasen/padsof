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

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(view.getAction().equals("Create")){
			if(view.getElement().equals("Course")){
				mainMoon.changeCard("CreateCourse");
			}
		}
		
	}
	
	
	
}
