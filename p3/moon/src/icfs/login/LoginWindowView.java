/**
 * 
 */
package icfs.login;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import icfs.ImgPanel;
import moon.Academy;

/**
 * This class constructs de login window
 * @author Lucia Asencio y Juan Riera, este ultimo responsable de todos los males del codigo y del mundo
 */
public class LoginWindowView extends JFrame{
	 
	private JTextField user;
	private JPasswordField password;

	/**
	 * login window constructor
	 * @return a window with de login panel, the image panel and the welcome panel in it
	 */
	public LoginWindowView(){
		super("moon");
		try {
			System.out.println("Deserializo 1");
			Academy.deserialize();
		} catch (ClassNotFoundException | IOException e1) {
			JOptionPane.showOptionDialog(null, "Error deserialiazing academy", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
		}
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				/*try {
					Academy.serialize();
				} catch (IOException e1) {
					JOptionPane.showOptionDialog(null, "Error serialiazing academy", "Error", JOptionPane.YES_OPTION, 
							JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
				}*/
				System.exit(0);
			}
		});
		JFrame loginWindow = this;
		loginWindow.setSize(Academy.DIMENSION);
		Container panel = loginWindow.getContentPane();
		SpringLayout lay = new SpringLayout();
		panel.setLayout(lay);
		panel.setBackground(Academy.ORANGE);
		
		
		/*Image thing*/
		Image i = new ImageIcon("logo1.png").getImage();
		ImgPanel img = new ImgPanel(i, 2);
		img.setVisible(true);
		lay.putConstraint(SpringLayout.NORTH, img, 250, SpringLayout.NORTH, panel);
		lay.putConstraint(SpringLayout.HORIZONTAL_CENTER, img, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		panel.add(img);
		
		/*Welcome thing*/
		JLabel label2 = new JLabel("Welcome to the moon :D");
		label2.setForeground(Color.WHITE);
		JPanel p2 = new JPanel();
		p2.setBackground(Academy.DARK_GREEN);
		p2.add(label2);
		p2.setPreferredSize(new Dimension(320,30));
		lay.putConstraint(SpringLayout.NORTH, p2, 20, SpringLayout.NORTH, panel);
		lay.putConstraint(SpringLayout.HORIZONTAL_CENTER, p2,  0, SpringLayout.HORIZONTAL_CENTER, panel);
		panel.add(p2);
		
		/*Login thing*/
		JPanel login = login();
		lay.putConstraint(SpringLayout.NORTH, login,  10, SpringLayout.SOUTH, p2);
		lay.putConstraint(SpringLayout.HORIZONTAL_CENTER, login,  0, SpringLayout.HORIZONTAL_CENTER, panel);
		panel.add(login);		
		
		loginWindow.setVisible(true);
		loginWindow.setBackground(Color.GREEN);
		loginWindow.setSize(1000,600);
				
	}
	
	/**
	 * login panel maker
	 * @return a panel with the user and pswd panels, as well as the log in button
	 */
	private JPanel login(){
		JPanel login = new JPanel();		
		
		SpringLayout lay1 = new SpringLayout();
		login.setLayout(lay1);
		login.setBackground(Academy.DARK_GREEN);
		login.setPreferredSize(new Dimension(320, 135));
		
		JPanel user = user(), pswd = pswd();
		JButton button = new JButton("Log in");
		button.addActionListener(new LoginWindowController(this));
		button.setBackground(new Color(105, 100, 104));
		button.setForeground(Color.WHITE);
		
		lay1.putConstraint(SpringLayout.NORTH, user, 10, SpringLayout.NORTH, login);
		lay1.putConstraint(SpringLayout.WEST, user, 10, SpringLayout.WEST, login);
		lay1.putConstraint(SpringLayout.NORTH, pswd, 0, SpringLayout.SOUTH, user);
		lay1.putConstraint(SpringLayout.WEST, pswd, 10, SpringLayout.WEST, login);
		lay1.putConstraint(SpringLayout.NORTH, button, 10, SpringLayout.SOUTH, pswd);	
		lay1.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 10, SpringLayout.HORIZONTAL_CENTER, login);	
		
		login.add(user);
		login.add(pswd);
		login.add(button);
		
		return login;
	}
	
	/**
	 * user panel maker
	 * @return a panel with de username label and the Jtextfield for it
	 */
	private JPanel user(){
		JPanel user = new JPanel();
		user.setPreferredSize(new Dimension(300,40));
		user.setBackground(Academy.LIGHT_GREEN);
		
		SpringLayout lay2 = new SpringLayout();
		user.setLayout(lay2);
		JLabel userText = new JLabel("Username:");
		JTextField userName = new JTextField(); 
		this.user = userName;
		userName.setPreferredSize(new Dimension(200, 30));
		
		lay2.putConstraint(SpringLayout.NORTH, userText, 10, SpringLayout.NORTH, user);
		lay2.putConstraint(SpringLayout.WEST, userText, 5, SpringLayout.WEST, user);
		lay2.putConstraint(SpringLayout.NORTH, userName, 5, SpringLayout.NORTH, user);
		lay2.putConstraint(SpringLayout.WEST, userName, 10, SpringLayout.EAST, userText);
		
		user.add(userText);
		user.add(userName);
		//user.setVisible(true);
		return user;
	}
	
	/**
	 * password panel maker
	 * @return a panel with de password label and the jpasswordfield for it
	 */
	private JPanel pswd(){
		JPanel pswd = new JPanel();
		pswd.setBackground(Academy.LIGHT_GREEN);
		pswd.setPreferredSize(new Dimension(300,40));
		
		SpringLayout lay3 = new SpringLayout();
		pswd.setLayout(lay3);
		JLabel pswdText = new JLabel("Password:");
		final JPasswordField pass = new JPasswordField();
		this.password = pass;
		pass.setPreferredSize(new Dimension(200,30));
		lay3.putConstraint(SpringLayout.NORTH, pswdText, 10, SpringLayout.NORTH, pswd);
		lay3.putConstraint(SpringLayout.WEST, pswdText, 5, SpringLayout.WEST, pswd);
		lay3.putConstraint(SpringLayout.NORTH, pass, 5, SpringLayout.NORTH, pswd);
		lay3.putConstraint(SpringLayout.WEST, pass, 10, SpringLayout.EAST, pswdText);
		
		pswd.add(pswdText);
		pswd.add(pass);
		//pswd.setVisible(true);
		
		return pswd;
	}
	
	/**
	 * Gets the JPasswordField of the login window
	 * @return JPasswordField
	 */
	public String getPassword(){
		return this.password.getText();
	}
	
	/**
	 * Gets the JTextField of the login window
	 * @return JTextField
	 */
	public String getUser(){
		return this.user.getText();
	}	
}
