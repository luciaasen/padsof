/**
 * 
 */
package icfs.teacher.create.exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import icfs.DatePanel;
import icfs.LowerPanel;
import main.mainMoon;
import moon.Academy;
import moon.course.Exercise;
import moon.course.Unit;

/**
 * @author lucia
 *
 */
public class AddExeView extends LowerPanel{
	private DatePanel dateIni;
	private DatePanel dateEnd;
	private JCheckBox randomOrder = new JCheckBox();
	private JTextField name = new JTextField();
	private SpinnerNumberModel relevanceModel = new SpinnerNumberModel();
	private SpinnerNumberModel penaltyModel = new SpinnerNumberModel();
	private JSpinner relevance = new JSpinner(relevanceModel);
	private JSpinner penalty = new JSpinner(penaltyModel);
	private AddExeController controller = new AddExeController(this);
	
	public AddExeView(){
		JPanel north = new JPanel();
		JPanel center;
		JPanel south = new JPanel();
		
		north.setBackground(Color.WHITE);
		north.add(new JLabel("Add exercise"));
		
		center = generateCenter();
		
		JButton button = new JButton("Back to main page");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.MAIN));
		south.add(button);
		button = new JButton("Save and back");
		button.addActionListener(e -> {
			controller.save();
			mainMoon.changeCard(mainMoon.MAIN);});
		south.add(button);
		south.setBackground(Academy.ORANGE);
		
		this.setLayout(new BorderLayout(10,10));
		this.add(north,BorderLayout.NORTH);
		this.add(center,BorderLayout.CENTER);
		this.add(south,BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}
	/**
	 * @param u
	 */
	public void setEverything(Unit u) {
		controller.setEverything(u);
		
	}
	
	private JPanel generateCenter(){
		JPanel center = new JPanel();
		JPanel dates = new JPanel();
		JPanel questionsOrder = new JPanel();
		JPanel addQuestion = new JPanel();
		JPanel relevanceAndPenalty = new JPanel();
		
		/* Set the borders */
		dates.setBorder(BorderFactory.createTitledBorder("Visibility dates"));
		addQuestion.setBorder(BorderFactory.createTitledBorder("Add a question"));
		
		/*Add dates */
		DatePanel date = new DatePanel("From: ");
		this.dateIni = date;	
		DatePanel date2 = new DatePanel("To: ");
		this.dateEnd = date2;	
		dates.setLayout(new GridLayout(2,1,5,5));
		dates.setBackground(Color.white);
		dates.add(date);
		dates.add(date2);
		
		/* Question order */
		questionsOrder.setLayout(new GridLayout(2,1,5,5));
		questionsOrder.setBackground(Color.WHITE);
		randomOrder.setBorder(BorderFactory.createTitledBorder("Question displaying"));
		questionsOrder.add(randomOrder);
		name.setBorder(BorderFactory.createTitledBorder("Exercise name"));
		questionsOrder.add(name);
		
		/* Add question */
		addQuestion.setLayout(new GridLayout(4,1,5,5));
		addQuestion.setBackground(Color.white);
		JButton button = new JButton("True/falseQuestion");
		button.addActionListener(e -> controller.TfQuestion());
		addQuestion.add(button);
		button = new JButton("Multiple choice question");
		button.addActionListener(e -> controller.multiChoiceQuestion());
		addQuestion.add(button);
		button = new JButton("Single choice question");
		button.addActionListener(e -> controller.singleChoiceQuestion());
		addQuestion.add(button);
		button = new JButton("Open answer question");
		button.addActionListener(e -> controller.openAnswerQuestion());
		addQuestion.add(button);
		
		/* Relevance and penalty */
		relevanceAndPenalty.setBackground(Color.WHITE);
		relevance.setBorder(BorderFactory.createTitledBorder("Relevance of the exercise"));
		relevance.setValue(1);
		relevanceModel.setMinimum(0);
		relevanceModel.setStepSize(0.1);
		relevanceAndPenalty.add(relevance);
		penalty.setBorder(BorderFactory.createTitledBorder("Penalty of the exercise"));
		penalty.setValue(0);
		penaltyModel.setMaximum(0);
		penaltyModel.setStepSize(0.1);
		relevanceAndPenalty.add(penalty);
		
		/* We finally set up the center */
		center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		center.setBackground(Color.white);
		center.setLayout(new GridLayout(2,2,10,10));
		center.add(dates);
		center.add(questionsOrder);
		center.add(addQuestion);
		center.add(relevanceAndPenalty);
		return center;
	}
		public LocalDate getIni() throws NumberFormatException{
			return this.dateIni.getDate();
		}
		
		public LocalDate getEnd() throws NumberFormatException{
			return this.dateEnd.getDate();
		}
		
		public String getName(){
			return name.getText();
		}
		
		public boolean getRandom(){
			return randomOrder.isSelected();
		}
		
		public Double getRelevance() {
			return (Double)relevanceModel.getValue();
		}
		
		public Double getPenalty(){
			return (Double)relevanceModel.getValue();
		}
}
