/**
 * 
 */
package icfs.teacher.stats;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import icfs.LowerPanel;
import main.mainMoon;
import moon.course.question.*;

/**
 * @author juan
 *
 */
public class TeacherQuestionStats extends LowerPanel {
	JLabel name = new JLabel("Name");
	JPanel correctAnswer = new JPanel();
	JLabel penalty = new JLabel("penalty");
	JLabel correctAnswers = new JLabel("Correct answers");
	JLabel incorrectAnswers = new JLabel("Incorrect answers ");
	JLabel notAnswered = new JLabel("Not answered");
	JLabel answered = new JLabel("Answered");
	
	public TeacherQuestionStats(){
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		north.add(name);
		north.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		center.setLayout(new GridLayout(6,1));
		JScrollPane correctAnswerScroll = new JScrollPane(correctAnswer);
		correctAnswer.setLayout(new BorderLayout());
		center.add(correctAnswerScroll);
		center.add(penalty);
		center.add(correctAnswers);
		center.add(incorrectAnswers);
		center.add(answered);
		center.add(notAnswered);
		
		JButton button = new JButton("Back to exercise");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.EXERCISE_STATS));
		south.add(button);
		
		button = new JButton("Back to course statistics");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.COURSE_STATS));
		south.add(button);
		
		button = new JButton("Back to course");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.COURSE));
		south.add(button);
		
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setLayout(new BorderLayout());
		this.add(north,BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
	}
	
	public void setEverything(Question q){
		name.setText(q.getQuestion());
		penalty.setText("Penalty: " + q.getExercise().getPenalty());
		correctAnswers.setText("Correct answers: " + q.calcNPasses());
		incorrectAnswers.setText("Incorrect answers: " + q.calcNFails());
		notAnswered.setText("Not answered: " + q.calcNUnanswered());
		answered.setText("Answered: " + q.calcNAnswered());
		
		correctAnswer.removeAll();
		correctAnswer.add(new JLabel("Correct answer: "), BorderLayout.WEST);
		JPanel answersPanel = new JPanel();
		if(q instanceof MultiChoiceQuestion){
			answersPanel.setLayout(new GridLayout(((MultiChoiceQuestion)q).getAnswer().size(),1));
			for(Option o : ((MultiChoiceQuestion)q).getAnswer()){
				answersPanel.add(new JCheckBox(o.getOption()));
			}
		} else if(q instanceof OneChoiceQuestion){
			answersPanel.add(new JRadioButton(((OneChoiceQuestion)q).getAnswer().get(0).getOption()));
		} else if(q instanceof OpenQuestion) {
			answersPanel.setLayout(new GridLayout(((OpenQuestion)q).getAnswer().size(),1,5,5));
			for(Option o : ((OpenQuestion)q).getAnswer()){
				answersPanel.add(new JLabel(o.getOption()));
			}
		} else if(q instanceof TfQuestion){
			if(((TfQuestion)q).getAnswer()==true){
				answersPanel.add(new JLabel("True"));
			} else {
				answersPanel.add(new JLabel("False"));
			}
		}
	}
}
