package icfs;

import java.awt.*;

import javax.swing.*;


public class LoginWindow {
	
	/*public static void main(String args[]){
		login();
	}*/
	public static void main(String args[]) {

		JFrame w1n = new JFrame("Gui");
		JButton l0g1nB = new JButton("Login");
		JButton c4nc3lB = new JButton("Cancel");
		JTextField emilioText = new JTextField(10);
		JPasswordField password = new JPasswordField(10);
		Container container = w1n.getContentPane();
		container.setLayout(new FlowLayout());
		emilioText.setSize(500, 500);
		
		
		container.add(emilioText);
		container.add(password);
		container.add(l0g1nB);
		container.add(c4nc3lB);
		container.setVisible(true);
		
		container.setBackground(Color.cyan);
		
		
		password.setSize(100, password.getHeight());
		w1n.setSize(1000, 140);
		w1n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w1n.setVisible(true);
	}
	
}
