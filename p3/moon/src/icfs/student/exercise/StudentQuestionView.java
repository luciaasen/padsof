/**
 * 
 */
package icfs.student.exercise;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

import icfs.LowerPanel;
import main.mainMoon;
import moon.course.Course;
import moon.course.Exercise;
import moon.course.question.*;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentQuestionView extends LowerPanel{

	protected JPanel south, north, center;
	StudentQuestionViewController controller = new StudentQuestionViewController();
	CardLayout layout = new CardLayout();
	ArrayList<CenterStudentQuestionPanel> cards = new ArrayList<>();
	JComboBox<String> questionNumber = new JComboBox<>();
	int actualQuestion = 0;
	
	public StudentQuestionView(){
		this.setLayout(new BorderLayout(10, 10));
		Border border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		this.setBorder(border1);
		north = questionNumbers();
		south = questionButtons();
		center = new JPanel();
		center.setLayout(layout);
	}
	
	private JPanel questionNumbers(){
		JPanel questionNumbers = new JPanel();
		
		return questionNumbers;
	}
	
	private JPanel questionButtons(){
		JPanel buttons = new JPanel();
		JButton previous = new JButton("Previous");
		JButton next = new JButton("Next");
		JButton save = new JButton("End exercise and send my answers");
		JButton exit = new JButton("Exit without saving");
		previous.setEnabled(false);
		
		previous.addActionListener(e -> {layout.previous(center);
			actualQuestion--;
			if(actualQuestion==0){
				previous.setEnabled(false);
			}
			
		});
		
		next.addActionListener(e -> {layout.next(center); 
			actualQuestion++;
			if(actualQuestion==controller.getQuestionsOrder().size()){
				next.setEnabled(false);
			}
		});
		
		save.addActionListener(e -> { });
		exit.addActionListener(e -> { 
			//TODO cancel exercise.
			mainMoon.backCard();});
		
		this.questionNumber.addActionListener(e -> {
			layout.show(center, (String)questionNumber.getSelectedItem());
		});
		
		this.questionNumber.addItemListener(e -> {
			actualQuestion = questionNumber.getSelectedIndex()+1;
			layout.show(center, (String)questionNumber.getSelectedItem());
		});
		
		buttons.add(previous);
		buttons.add(next);
		buttons.add(save);
		buttons.add(exit);
		return buttons;
	}
	
	public void setEverything(Student s, Course c, Exercise e){
		center.removeAll();
		controller.setEverything(s, c, e);
		questionNumber.removeAll();
		
		CenterStudentQuestionPanel aux;
		Integer i = 1;
		for(Question quest : controller.getQuestionsOrder()){
			if(quest instanceof TfQuestion){
				aux = new TrueFalseCenterPanel(quest);
			} else if (quest instanceof OpenQuestion){
				aux = new OpenTextCenterPanel(quest);
			} else if (quest instanceof MultiChoiceQuestion){
				aux = new MultipleChoiceCenterPanel(quest);
			} else if (quest instanceof OneChoiceQuestion){
				aux = new SingleChoiceCenterPanel(quest);
			} else { return; }
			cards.add(aux);
			center.add(aux, i.toString());
			questionNumber.addItem(i.toString());
			i++;
		}
	}

}
