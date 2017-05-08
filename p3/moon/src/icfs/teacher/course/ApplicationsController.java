/**
 * 
 */
package icfs.teacher.course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import moon.course.Course;
import moon.user.Application;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class ApplicationsController implements MouseListener{
	Course c;
	ApplicationsView view;
	
	public ApplicationsController(ApplicationsView view){
		this.view=view;
	}
	public void setEverything(Course c){
		this.c=c;
		view.listModel.clear();
		for(Application a : c.getApplications()){
			view.listModel.addElement(a);
		}
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(view.list.getSelectedValue()==null){
			view.accept.setEnabled(false);
			view.reject.setEnabled(false);
		} else {
			view.accept.setEnabled(true);
			view.reject.setEnabled(true);
		}
		
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {}
	

	@Override
	public void mouseExited(MouseEvent e) {}
	

	@Override
	public void mousePressed(MouseEvent e) {}
	

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	Course getCourse(){
		return c;
	}
	
	public void accept() {
		try {
			view.list.getSelectedValue().accept();
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			JOptionPane.showOptionDialog(view, "Error with the email system", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
		}
		view.setEverything(c);
	}
	
	public void reject() {
		try {
			view.list.getSelectedValue().reject();
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			JOptionPane.showOptionDialog(view, "Error with the email system", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
		}
		view.setEverything(c);
	}
}
