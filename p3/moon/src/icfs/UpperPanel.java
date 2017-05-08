/**
 * 
 */
package icfs;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import icfs.login.LoginWindowView;
import main.mainMoon;
import moon.Academy;

/**
 * This class defines the Panel which is in the upper side of each view.
 * it has a given height of 100
 * @author lucia
 *
 */
public class UpperPanel extends JPanel{
	public static final int HEIGHT = 45;
	public static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public UpperPanel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, HEIGHT));
		//this.setSize(new Dimension(Academy.DIMENSION.width, HEIGHT));
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		
		ImgPanel logo = new ImgPanel(new ImageIcon("logo1.png").getImage(), 9);
		this.add(logo, BorderLayout.WEST);
		
		this.add(exitPanel(), BorderLayout.EAST);
		
	}
	
	public JPanel exitPanel(){
		
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel(new BorderLayout());
		panel.setLayout(layout);
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(70, UpperPanel.HEIGHT));

		JButton exit = new JButton("Exit");
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, exit, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, exit, 0, SpringLayout.VERTICAL_CENTER, panel);
		panel.add(exit);
		exit.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									new LoginWindowView();
									try {
										Academy.serialize();
									} catch (IOException e1) {
										JOptionPane.showOptionDialog(null, "Error serialiazing academy", "Error", JOptionPane.YES_OPTION, 
												JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
									}
									//TODO why exceptions?
									mainMoon.window.dispose();									
								}
							});		
		return panel;
	}
	
}