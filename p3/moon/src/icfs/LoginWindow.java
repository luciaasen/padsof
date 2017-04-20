package icfs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LoginWindow extends JPanel {
	
	
	private static final long serialVersionUID = 1L;

	/*public static void main(String args[]){
		login();
	}*/
	public LoginWindow() {
		
		JPanel buttons = buttons();
		JPanel text = text();
		
		
		this.setSize(400, 400);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(buttons, BorderLayout.SOUTH);

		this.add(text, BorderLayout.CENTER);
	}
	
	private JPanel buttons(){
		JPanel buttons = new JPanel();
		JButton l0g1nB = new JButton("Login");
		JButton c4nc3lB = new JButton("Cancel");
		buttons.add(l0g1nB);
		buttons.add(c4nc3lB);
		buttons.setVisible(true);
		
		c4nc3lB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("HOLACARACOLA");
			}
			
		});
		
		buttons.setBackground(Color.cyan);
		
		return buttons;
	}
	
	public JPanel text(){
		SpringLayout layout = new SpringLayout();
		JPanel text = new JPanel();
		JTextField email = new JTextField(10);
		JPasswordField password = new JPasswordField(10);
		JLabel emailLabel = new JLabel("emailLabel");
		JLabel passwordLabel = new JLabel("passwordLabel");
		text.setLayout(layout);
		email.setSize(100, 100);
		
		layout.putConstraint(SpringLayout.WEST, emailLabel, 23, SpringLayout.WEST, text);
		layout.putConstraint(SpringLayout.NORTH, emailLabel, 20, SpringLayout.NORTH, text);
		layout.putConstraint(SpringLayout.WEST, email, 0, SpringLayout.WEST, password);
		layout.putConstraint(SpringLayout.NORTH, email, 20, SpringLayout.NORTH, text);
		
		layout.putConstraint(SpringLayout.WEST, passwordLabel, 20, SpringLayout.WEST, text);
		layout.putConstraint(SpringLayout.NORTH, passwordLabel, 20, SpringLayout.SOUTH, emailLabel);
		
		layout.putConstraint(SpringLayout.WEST, password, 20, SpringLayout.EAST, passwordLabel);
		
		layout.putConstraint(SpringLayout.NORTH, password, 20, SpringLayout.SOUTH, email);
		
		
		text.add(emailLabel);
		text.add(passwordLabel);
		text.add(email);
		text.add(password);
		
		text.setVisible(true);
		
		text.setBackground(Color.RED);
		
		return text;
	}
	
}
