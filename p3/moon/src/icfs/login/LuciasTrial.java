/**
 * 
 */
package icfs.login;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author lusilu
 *
 */
public class LuciasTrial extends JFrame{
	
	 
	public LuciasTrial(){
		super("moon");
		JFrame loginWindow = this;
		Container panel = loginWindow.getContentPane();
		SpringLayout lay = new SpringLayout();
		panel.setLayout(lay);
		panel.setBackground(new Color(254, 206, 158));
		//panel.setPreferredSize(new Dimension(1000,600));
		
		/*Image thing*/
		Image i = new ImageIcon("logo1.png").getImage();
		ImgPanel img = new ImgPanel(i);
		img.setVisible(true);
		lay.putConstraint(SpringLayout.NORTH, img, 250, SpringLayout.NORTH, panel);
		lay.putConstraint(SpringLayout.WEST, img, 300, SpringLayout.WEST, panel);
		panel.add(img);
		
		/*Welcome thing*/
		JLabel label2 = new JLabel("Welcome to the moon :D");
		label2.setForeground(Color.WHITE);
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(6, 114, 92));
		p2.add(label2);
		p2.setPreferredSize(new Dimension(320,30));
		lay.putConstraint(SpringLayout.NORTH, p2, 20, SpringLayout.NORTH, panel);
		lay.putConstraint(SpringLayout.WEST, p2,  40, SpringLayout.WEST, panel);
		panel.add(p2);
		
		/*Login thing*/
		JPanel login = login();
		lay.putConstraint(SpringLayout.NORTH, login,  10, SpringLayout.SOUTH, p2);
		lay.putConstraint(SpringLayout.WEST, login,  40, SpringLayout.WEST, panel);
		panel.add(login);		
		
		loginWindow.setVisible(true);
		loginWindow.setBackground(Color.GREEN);
		loginWindow.setSize(1000,600);
				
	}
	public static void main(String []args){
		LuciasTrial prueba = new LuciasTrial();
	}
	
	private static JPanel login(){
		JPanel login = new JPanel();		
		
		SpringLayout lay1 = new SpringLayout();
		login.setLayout(lay1);
		login.setBackground(new Color(6, 114, 92));
		login.setPreferredSize(new Dimension(320, 135));
		
		JPanel user = user(), pswd = pswd();
		JButton button = new JButton("Log in");
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
	
	private static JPanel user(){
		JPanel user = new JPanel();
		user.setPreferredSize(new Dimension(300,40));
		user.setBackground(new Color(205, 227, 224));
		
		SpringLayout lay2 = new SpringLayout();
		user.setLayout(lay2);
		JLabel userText = new JLabel("Username:");
		JTextField userName = new JTextField(); 
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
	
	private static JPanel pswd(){
		JPanel pswd = new JPanel();
		pswd.setBackground(new Color(205, 227, 224));
		pswd.setPreferredSize(new Dimension(300,40));
		
		SpringLayout lay3 = new SpringLayout();
		pswd.setLayout(lay3);
		JLabel pswdText = new JLabel("Password:");
		final JPasswordField pass = new JPasswordField();
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
	
	
	
}

class ImgPanel  extends JPanel{
	private Image img;	
	
	public ImgPanel(Image img){
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	    setPreferredSize(size);
	}
	
	@Override	
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, img.getWidth(null)/2, img.getHeight(null)/2, null);
	} 
}
