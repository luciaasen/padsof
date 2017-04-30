/**
 * 
 */
package icfs.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import exception.InvalidUserException;
import moon.Academy;
import moon.user.User;
import main.*;

/**
 * @author Lucia Asencio y Juan Riera
 *
 */
public class LoginWindowController implements ActionListener{
	private LoginWindowView view;
	
	public LoginWindowController(LoginWindowView view){
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e)  {
		User u;
		try{ 
			System.out.println(view.getUser() + " " + view.getPassword());
			u= Academy.getMoonApp().login(view.getUser(), view.getPassword());
			mainMoon.userMode(u, Academy.getMoonApp());
			view.setVisible(false);
		}catch(InvalidUserException ex){
			JOptionPane.showMessageDialog(view, ex.toString(), "Invalid User", JOptionPane.ERROR_MESSAGE);
		}
	}

	
}
