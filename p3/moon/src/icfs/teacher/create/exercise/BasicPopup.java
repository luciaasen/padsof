/**
 * 
 */
package icfs.teacher.create.exercise;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
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
	SpinnerNumberModel qNumberModel = new SpinnerNumberModel();
	SpinnerNumberModel relevanceModel = new SpinnerNumberModel();
	protected Exercise exe;
	
	public BasicPopup(AddExeController controller, String text, Exercise exe){
		super(text);
		this.setVisible(true);
		this.setSize(100, 100);
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
		qNumberModel.setValue(1);
		qNumberModel.setMinimum(1);
		qNumberModel.setStepSize(1);
		relevanceModel.setValue(1);
		relevanceModel.setMinimum(0);
		relevanceModel.setStepSize(0.1);
		north.add(qNumber);
		north.add(relevance);
		north.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		south.setBackground(Academy.ORANGE);
		JButton button = new JButton("Save and exit");
		button.addActionListener(e -> {
			save();
			this.dispose();
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
		panel.add(getCentralPanel(), BorderLayout.CENTER);
		panel.add(south, BorderLayout.SOUTH);
		
		return panel;
	}
	
	private void save(){
		controller.addQuestion((int)qNumberModel.getValue(), getQuestion((int)relevanceModel.getValue()));
	}
	protected abstract JPanel getCentralPanel();
	
	protected abstract Question getQuestion(double relevance);
}
