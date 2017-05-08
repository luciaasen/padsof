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

import exception.EmptyTextFieldException;
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
	protected DatePanel dateIni;
	protected DatePanel dateEnd;
	protected JCheckBox visibility = new JCheckBox("Visibility");
	protected JCheckBox randomOrder = new JCheckBox("Random order");
	protected JTextField name = new JTextField(20);
	protected SpinnerNumberModel relevanceModel = new SpinnerNumberModel(1.0, 0.0, Double.MAX_VALUE, 0.1);
	protected SpinnerNumberModel penaltyModel = new SpinnerNumberModel(-1.0, 0-Double.MAX_VALUE, 0.0, 0.1);
	private JSpinner relevance = new JSpinner(relevanceModel);
	private JSpinner penalty = new JSpinner(penaltyModel);
	private AddExeController controller = new AddExeController(this);
	protected JLabel message;
	protected JButton save;
	protected JButton exit;
	protected JButton TfQuestion, MCQuestion, SCQuestion, OAQuestion;
	
	public AddExeView(){
		JPanel north = new JPanel();
		JPanel center;
		JPanel south = new JPanel();
		
		north.setBackground(Color.WHITE);
		JLabel message = new JLabel("Add exercise");
		north.add(message);
		this.message = message;
		
		center = generateCenter();
		
		JButton button = new JButton("Back to main page");
		this.exit = button;
		button.addActionListener(e -> {
			mainMoon.mainSetEverything();
			mainMoon.changeCard(mainMoon.MAIN);});
		south.add(button);
		
		JButton button2 = new JButton("Save and back");
		save = button2;
		button2.addActionListener(e -> {
			if(controller.save()==0){
				mainMoon.mainSetEverything();
				mainMoon.changeCard(mainMoon.MAIN);}});
		south.add(button2);
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
		this.penaltyModel.setValue(-1);
		this.relevanceModel.setValue(1);
		this.name.setText("");
		this.dateIni.reset();
		this.dateEnd.reset();
		this.randomOrder.setSelected(false);
		this.visibility.setSelected(false);
		
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
		
		JPanel check = new JPanel();
		randomOrder.setBackground(Color.white);
		visibility.setBackground(Color.white);
		check.add(randomOrder);
		check.add(visibility);
		check.setBorder(BorderFactory.createTitledBorder(""));
		check.setBackground(Color.WHITE);
		questionsOrder.add(check);
		name.setBorder(BorderFactory.createTitledBorder("Exercise name"));
		questionsOrder.add(name);
		
		/* Add question */
		addQuestion.setLayout(new GridLayout(4,1,5,5));
		addQuestion.setBackground(Color.white);
		TfQuestion = new JButton("True/falseQuestion");
		TfQuestion.addActionListener(e -> controller.TfQuestion());
		addQuestion.add(TfQuestion);
		MCQuestion = new JButton("Multiple choice question");
		MCQuestion.addActionListener(e -> controller.multiChoiceQuestion());
		addQuestion.add(MCQuestion);
		SCQuestion = new JButton("Single choice question");
		SCQuestion.addActionListener(e -> controller.singleChoiceQuestion());
		addQuestion.add(SCQuestion);
		OAQuestion = new JButton("Open answer question");
		OAQuestion.addActionListener(e -> controller.openAnswerQuestion());
		addQuestion.add(OAQuestion);
		
		/* Relevance and penalty */
		relevanceAndPenalty.setBackground(Color.WHITE);
		relevanceAndPenalty.setLayout(new GridLayout(2,1,10,10));
		relevance.setBorder(BorderFactory.createTitledBorder("Relevance of the exercise"));
		
		relevanceAndPenalty.add(relevance);
		penalty.setBorder(BorderFactory.createTitledBorder("Penalty of the exercise"));
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
	
	
	/**
	 * Gets message JLabel
	 * @return JLabel
	 */
		public JLabel getMessage(){
			return this.message;
		}
		/**
		 * gets visibility checkbox
		 * @return checkbox
		 */
		public JCheckBox getVisibility(){
			return visibility;
		}
		
		/**
		 * Gets the name textfield
		 * @return
		 */
		public JTextField getNameField(){
			return this.name;
		}
		
		/**
		 * Gets the relevance spinner
		 * @return
		 */
		public SpinnerNumberModel getRelevanceModel(){
			return this.relevanceModel;
		}
		
		/**
		 * Gets de penalty spinner
		 * @return
		 */
		public SpinnerNumberModel getPenaltyModel(){
			return this.penaltyModel;
		}
		
		/**
		 * 
		 * @return
		 * @throws NumberFormatException
		 */
		
		public LocalDate getIni() throws NumberFormatException{
			return this.dateIni.getDate();
		}
		
		public LocalDate getEnd() throws NumberFormatException{
			return this.dateEnd.getDate();
		}
		
		public String getExerciseName() throws EmptyTextFieldException{
			if(name.getText().equals("")) throw new EmptyTextFieldException();
			return name.getText();
		}
		
		public boolean getRandom(){
			return randomOrder.isSelected();
		}
		
		public double getRelevance() {
			
			if(relevanceModel.getValue() instanceof Integer){
				return (double) ((Integer)relevanceModel.getValue()).intValue();
			}
			return (double)(relevanceModel.getValue());
		}
		
		public double getPenalty(){
			if(penaltyModel.getValue() instanceof Integer){
				return (double) ((Integer)penaltyModel.getValue()).intValue();
			}
			return (double)(penaltyModel.getValue());
		}
}
