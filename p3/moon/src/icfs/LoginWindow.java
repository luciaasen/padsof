package icfs;

import java.awt.*;

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
		
		buttons.setBackground(Color.cyan);
		
		return buttons;
	}
	
	public JPanel text(){
		SpringLayout layout = new SpringLayout();
		JPanel text = new JPanel();
		JTextField emilioText = new JTextField(10);
		JPasswordField password = new JPasswordField(10);
		JLabel emailLabel = new JLabel("emailLabel");
		JLabel passwordLabel = new JLabel("passwordLabel");
		text.setLayout(layout);
		emilioText.setSize(100, 100);
		
		/* Email label constraints */
		layout.putConstraint(SpringLayout.WEST, emailLabel, 5, SpringLayout.WEST, text);
		layout.putConstraint(SpringLayout.NORTH, emailLabel, 5, SpringLayout.NORTH, text);
		layout.putConstraint(SpringLayout.EAST, emailLabel, 5, SpringLayout.WEST, emilioText);
		
		/* Email text constraints */
		layout.putConstraint(SpringLayout.NORTH, emailLabel, 0, SpringLayout.NORTH, emilioText);
		layout.putConstraint(SpringLayout.EAST, emilioText, 5, SpringLayout.EAST, text);
		
		/* Password label constraints */
		layout.putConstraint(SpringLayout.WEST, passwordLabel, 0, SpringLayout.WEST, emailLabel);
		layout.putConstraint(SpringLayout.NORTH, passwordLabel, 5, SpringLayout.SOUTH, emailLabel);
		layout.putConstraint(SpringLayout.EAST, passwordLabel, 5, SpringLayout.WEST, password);
		
		
		text.add(emilioText);
		text.add(password);
		text.setVisible(true);
		
		text.setBackground(Color.RED);
		
		return text;
	}
	
}
