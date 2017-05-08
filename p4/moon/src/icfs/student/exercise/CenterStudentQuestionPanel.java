/**
 * 
 */
package icfs.student.exercise;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import moon.course.question.*;
import moon.mark.MExercise;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public abstract class CenterStudentQuestionPanel extends JPanel {
	JPanel north = new JPanel();
	JPanel center = new JPanel();
	private final int maxCharsPerRow = 100;
	private int rowsOfText;
	Question q;
	
	public CenterStudentQuestionPanel(Question quest){
		this.setLayout(new BorderLayout(10, 10));
		north.setBorder(BorderFactory.createDashedBorder(Color.BLACK, 5f, 5f, 2f, true));
		//north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		//north.setPreferredSize(new Dimension(30, 30));
		rowsOfText = quest.getQuestion().length()/maxCharsPerRow +1;
		JLabel question;
		int i=0;
		for(;i<rowsOfText-1;i++){
		
			question= new JLabel();
			question.setText(quest.getQuestion().substring((i)*maxCharsPerRow, (i+1)*maxCharsPerRow));
			north.add(question);
		}
		question= new JLabel();
		question.setText(quest.getQuestion().substring((i)*maxCharsPerRow));
		north.add(question);
		north.setPreferredSize(new Dimension(100, 20*rowsOfText+15));

		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		
		
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		q=quest;
	}
	
	public abstract void generateMQuestion(MExercise me);
	
}
