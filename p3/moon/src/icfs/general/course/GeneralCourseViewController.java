/**
 * 
 */
package icfs.general.course;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.TreeSelectionListener;

import moon.course.Course;
import moon.user.User;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public abstract class GeneralCourseViewController implements MouseListener {
	protected User u;
	protected Course c;
	
	
	public void setEverything(User u, Course c){
		this.u=u;
		this.c=c;
		System.out.println(c);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
}
