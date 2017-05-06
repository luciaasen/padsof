/**
 * 
 */
package icfs.student.stats.question;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import icfs.LowerPanel;
import main.mainMoon;
import moon.Academy;
import moon.course.question.*;
import moon.mark.MQuestion;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentQuestionStats extends LowerPanel{
	JPanel north;
	JPanel south;
	JPanel center = new JPanel();
	JLabel question = new JLabel();
	
	public StudentQuestionStats(){
		this.setLayout(new BorderLayout(10,10));
		
		north = newNorth();
		south = newSouth();
		
		this.add(north, BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);
		this.add(center, BorderLayout.CENTER);
	}
	
	/**
	 * @return
	 */
	private JPanel newSouth() {
		JPanel south = new JPanel();
		south.setBackground(Academy.ORANGE);
		JButton button = new JButton("Back to exercise statistics");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.EXERCISE_STATS));
		south.add(button);
		button = new JButton("Back to course statistics");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.COURSE_STATS));
		south.add(button);
		button = new JButton("Back to main page");
		button.addActionListener(e -> mainMoon.changeCard(mainMoon.MAIN));
		south.add(button);
		return south;
	}

	/**
	 * @return
	 */
	private JPanel newNorth() {
		JPanel north = new JPanel();
		north.add(question);
		return north;
	}

	public void setEverything(Student s, Question q){
		this.remove(center);
		center=newCenter(s, q);
		this.add(center);
	}
	
	private JPanel newCenter(Student s, Question q){
		MQuestion mquestion = null;
		for(MQuestion mq :q.getExercise().getExercise(s).getmQuestions()){
			if(mq.getQuestion()==q){
				mquestion = mq;
				break;
			}
		}
		
		if(q instanceof MultiChoiceQuestion){
			return new MultiChoiceStatsPanel(s, mquestion);
			
		} else if(q instanceof OneChoiceQuestion){
			return new OneChoiceStatsPanel(s, mquestion);
		} else if(q instanceof TfQuestion){
			return new TfQuestionStatsPanel(s,mquestion);
		} else if(q instanceof OpenQuestion){
			return new OpenQuestionStatsPanel(s,mquestion);
		}
	}
}
