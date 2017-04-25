/**
 * 
 */
package icfs.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moon.Academy;

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
	public void actionPerformed(ActionEvent e) {
		Academy.getMoonApp().login(email, pwd)
	}

	
}
