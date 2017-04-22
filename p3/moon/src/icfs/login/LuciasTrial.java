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
public class LuciasTrial{
	
	 
	public LuciasTrial(){
		/*JFrame loginWindow = new JFrame("moon");
		Container panel = loginWindow.getContentPane();
		SpringLayout lay = new SpringLayout();
		panel.setLayout(lay);
		panel.setBackground(Color.getHSBColor(60,50, 55));
		panel.setPreferredSize(new Dimension(725,50));
		*/
		/*Add image*/
		//Image i = new ImageIcon("~/pr/padsof/p3/moon/logo1.png").getImage();
	/*	Image i = Toolkit.getDefaultToolkit().createImage("logo1.png");
		System.out.println(i.getHeight(null) + " jello" + i.getWidth(null));
		ImgPanel img = new ImgPanel(i);
		img.setVisible(true);
		img.setPreferredSize(new Dimension(500,500));
		lay.putConstraint(SpringLayout.NORTH, img, 400, SpringLayout.NORTH, panel);
		lay.putConstraint(SpringLayout.WEST, img, 400, SpringLayout.WEST, panel);
		panel.add(img);
		*/
		
		/*Add welcome to the moon*/
		/*JLabel label2 = new JLabel("Welcome to the moonkk:");
		JPanel p2 = new JPanel();
		p2.setBackground(Color.getHSBColor(60, 50, 30));
		p2.add(label2);
		p2.setPreferredSize(new Dimension(320,30));
		lay.putConstraint(SpringLayout.NORTH, p2, 20, SpringLayout.NORTH, panel);
		lay.putConstraint(SpringLayout.WEST, p2,  40, SpringLayout.WEST, panel);
		panel.add(p2);
		*/
		/*Add the whole login thing*/
		/*JPanel login = login();
		lay.putConstraint(SpringLayout.NORTH, login,  20, SpringLayout.SOUTH, p2);
		lay.putConstraint(SpringLayout.WEST, login,  40, SpringLayout.WEST, panel);
		panel.add(login);		
		
		
		
		loginWindow.setVisible(true);
		loginWindow.setBackground(Color.GREEN);
		loginWindow.setSize(new Dimension(800,800));*/
	}
	public static void main(String []args){
		JFrame loginWindow = new JFrame("moon");
		Container cont = loginWindow.getContentPane();
		SpringLayout lay = new SpringLayout();
		cont.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		cont.add(panel, BorderLayout.CENTER);
		panel.setLayout(lay);
		panel.setBackground(Color.getHSBColor(60,50, 55));
		panel.setPreferredSize(new Dimension(725,50));
		
		
		
		JLabel label2 = new JLabel("Welcome to the moon:");
		JPanel p2 = new JPanel();
		p2.setBackground(Color.getHSBColor(60, 50, 30));
		p2.add(label2);
		p2.setPreferredSize(new Dimension(320,30));
		//p2.setVisible(true);
		lay.putConstraint(SpringLayout.NORTH, p2, 20, SpringLayout.NORTH, panel);
		lay.putConstraint(SpringLayout.WEST, p2,  40, SpringLayout.WEST, panel);
		panel.add(p2);
		
		
		JPanel login = login();
		//login.setVisible(true);
		lay.putConstraint(SpringLayout.NORTH, login,  20, SpringLayout.SOUTH, p2);
		lay.putConstraint(SpringLayout.WEST, login,  40, SpringLayout.WEST, panel);
		panel.add(login);		
	    //panel.setVisible(true);
		
		loginWindow.setVisible(true);
		loginWindow.setBackground(Color.GREEN);
		loginWindow.setSize(500,400);
	}
	private static JPanel login(){
		JPanel login = new JPanel();		
		
		SpringLayout lay1 = new SpringLayout();
		login.setLayout(lay1);
		login.setBackground(Color.getHSBColor(60,50, 30));
		login.setPreferredSize(new Dimension(320,100));
		
		JPanel user = user(), pswd = pswd();
		
		lay1.putConstraint(SpringLayout.NORTH, user, 10, SpringLayout.NORTH, login);
		lay1.putConstraint(SpringLayout.WEST, user, 10, SpringLayout.WEST, login);
		lay1.putConstraint(SpringLayout.NORTH, pswd, 0, SpringLayout.SOUTH, user);
		lay1.putConstraint(SpringLayout.WEST, pswd, 10, SpringLayout.WEST, login);
				
		login.add(user);
		login.add(pswd);
		//login.setVisible(true);
		
		return login;
	}
	
	private static JPanel user(){
		JPanel user = new JPanel();
		user.setPreferredSize(new Dimension(300,40));
		user.setBackground(Color.getHSBColor(60,70, 40));
		
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
		pswd.setBackground(Color.getHSBColor(60,70, 40));
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
		g.drawImage(img, 0, 0, null);
	} 
}
