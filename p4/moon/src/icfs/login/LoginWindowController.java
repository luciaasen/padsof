/**
 * 
 */
package icfs.login;

import java.awt.event.*;

import javax.swing.*;

//import com.sun.prism.paint.Color;

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
			u= Academy.getMoonApp().login(view.getUser(), view.getPassword());
			mainMoon.userMode(u, Academy.getMoonApp());
			view.dispose();
		}catch(InvalidUserException ex){
			UIManager UI=new UIManager();
			UI.put("OptionPane.background", Academy.DARK_GREEN);
			UI.put("OptionPane.messageForeground", Academy.DARK_GREEN);
			//UI.put("Panel.background", Academy.DARK_GREEN);
			//JOptionPane.showMessageDialog(view, ex.toString(), "Invalid User", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showOptionDialog(view, ex.toString(), "Invalid User", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
		}
	}

	
}
