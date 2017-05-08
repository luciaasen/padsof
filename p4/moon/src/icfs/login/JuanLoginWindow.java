package icfs.login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class JuanLoginWindow extends JPanel {
	
	
	private static final long serialVersionUID = 1L;

	/*public static void main(String args[]){
		login();
	}*/
	public JuanLoginWindow() {
		
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
		JPanel superText = new JPanel();
		JPanel aux = new JPanel();
		JTextField email = new JTextField(10);
		JPasswordField password = new JPasswordField(10);
		JLabel emailLabel = new JLabel("Email:  ");
		JLabel passwordLabel = new JLabel("Password:  ");
		text.setLayout(layout);
		superText.setLayout(new GridLayout(3,1));
		
		layout.putConstraint(SpringLayout.WEST, emailLabel, 100, SpringLayout.WEST, text);
		layout.putConstraint(SpringLayout.NORTH, emailLabel, 50, SpringLayout.NORTH, text);
		layout.putConstraint(SpringLayout.WEST, email, 0, SpringLayout.WEST, password);
		layout.putConstraint(SpringLayout.NORTH, email, 50, SpringLayout.NORTH, text);
		layout.putConstraint(SpringLayout.WEST, passwordLabel, 100, SpringLayout.WEST, text);
		layout.putConstraint(SpringLayout.NORTH, passwordLabel, 20, SpringLayout.SOUTH, emailLabel);
		layout.putConstraint(SpringLayout.WEST, password, 20, SpringLayout.EAST, passwordLabel);
		layout.putConstraint(SpringLayout.NORTH, password, 20, SpringLayout.SOUTH, email);
		
		
		
		text.add(emailLabel);
		text.add(passwordLabel);
		text.add(email);
		text.add(password);
		
		superText.add(aux);
		superText.add(text);
		
		text.setSize(50,50);
		
		text.setOpaque(false);
		
		text.setVisible(true);
		superText.setVisible(true);
		
		return superText;
	}
	
}
