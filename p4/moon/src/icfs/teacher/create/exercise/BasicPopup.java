/**
 * 
 */
package icfs.teacher.create.exercise;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;


import moon.Academy;
import moon.course.Exercise;
import moon.course.question.Question;

/**
 * @author juan
 *
 */
public abstract class BasicPopup extends JFrame{
	AddExeController controller;
	SpinnerNumberModel qNumberModel = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
	SpinnerNumberModel relevanceModel = new SpinnerNumberModel(1.0, 0.0, Double.MAX_VALUE, 0.1);
	protected Exercise exe;
	protected JTextArea contentsT;
	
	public BasicPopup(AddExeController controller, String text, Exercise exe){
		super(text);
		this.setVisible(true);
		this.setSize(700, 700);
		this.controller = controller;
		this.setContentPane(getPanel());
		this.revalidate();
		this.exe = exe;
	}
	
	private JPanel getPanel(){
		JPanel panel = new JPanel();
		JPanel north = new JPanel();
		JPanel south = new JPanel();
		JSpinner qNumber = new JSpinner(qNumberModel);
		JSpinner relevance = new JSpinner(relevanceModel);
		
		north.setLayout(new GridLayout(1,2,20,20));
		qNumber.setBorder(BorderFactory.createTitledBorder("Question number"));
		relevance.setBorder(BorderFactory.createTitledBorder("Relevance in exercise"));
		north.add(qNumber);
		north.add(relevance);
		north.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		south.setBackground(Academy.ORANGE);
		JButton button = new JButton("Save and exit");
		button.addActionListener(e -> {
			if(save()==true){
				this.dispose();
			}
		});
		south.add(button);
		button = new JButton("Close without saving");
		button.addActionListener(e -> {
			this.dispose();
		});
		south.add(button);
		
		panel.setBorder(BorderFactory.createLineBorder(Academy.DARK_GREEN, 5));
		panel.setLayout(new BorderLayout(10,10));
		panel.add(north, BorderLayout.NORTH);
		panel.add(center(), BorderLayout.CENTER);
		panel.add(south, BorderLayout.SOUTH);
		
		return panel;
	}
	
	private JPanel center(){
		JPanel superPanel = new JPanel();
		JPanel upper = new JPanel();
		superPanel.setLayout(new GridLayout(2,1));
		
		upper.setLayout(new BorderLayout(10,10));
		upper.add(new JLabel("Question text: "), BorderLayout.WEST);
		contentsT = new JTextArea();
		contentsT.setBorder(BorderFactory.createLineBorder(Academy.DARK_GREEN));
		contentsT.setLineWrap(true);
		upper.add(contentsT, BorderLayout.CENTER);
		
		superPanel.add(upper);
		superPanel.add(getCentralPanel());
		superPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		return superPanel;
	}
	
	private boolean save(){
		Question q = getQuestion((Double)relevanceModel.getValue());
		if(q == null){
			JOptionPane.showOptionDialog(null, "Invalid question, make sure you entered ALL text fields", "Error", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
			return false;
		}
		if(controller.addQuestion(((Integer)qNumberModel.getValue()), q)==false){
			return false;
		}
		return true;
	}
	protected abstract Component getCentralPanel();
	
	protected abstract Question getQuestion(double relevance);
}
