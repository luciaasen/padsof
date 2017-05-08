/**
 * 
 */
package icfs.student.exercise;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
	ArrayList<JLabel> questionNumbers= new ArrayList<>();
	JButton previous;
	JButton next;
	private final static int NCOLS = 15;
	int actualQuestion = 1;
	
	public StudentQuestionView(){
		this.setLayout(new BorderLayout(10, 10));
		Border border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		this.setBorder(border1);
		north = questionNumbers();
		south = questionButtons();
		center = new JPanel();
		center.setLayout(layout);
		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
	}
	
	private JPanel questionNumbers(){
		JPanel questionNumbers = new JPanel();
		questionNumbers.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		return questionNumbers;
	}
	
	private JPanel questionButtons(){
		JPanel buttons = new JPanel();
		previous = new JButton("Previous");
		next = new JButton("Next");
		JButton save = new JButton("End exercise and send my answers");
		JButton exit = new JButton("Exit without saving");
		
		
		previous.addActionListener(e -> {layout.previous(center);
			actualQuestion--;
			if(actualQuestion==1){
				previous.setEnabled(false);
			} 
			if (actualQuestion == controller.getQuestionsOrder().size()-1){
				next.setEnabled(true);
			}
			questionNumbers.get(actualQuestion).setBorder(BorderFactory
					.createEmptyBorder());

			questionNumbers.get(actualQuestion-1).setBorder(BorderFactory
					.createLineBorder(Color.black, 1, true));
		});
		
		next.addActionListener(e -> {layout.next(center); 
			actualQuestion++;
			if(actualQuestion==controller.getQuestionsOrder().size()){
				next.setEnabled(false);
			} 
			if(actualQuestion == 2){
				previous.setEnabled(true);
			}
			questionNumbers.get(actualQuestion-2).setBorder(BorderFactory
					.createEmptyBorder());

			questionNumbers.get(actualQuestion-1).setBorder(BorderFactory
					.createLineBorder(Color.black, 1, true));
		});
		
		save.addActionListener(e -> { 
			
			controller.save(cards);
			mainMoon.changeCard(mainMoon.COURSE);
		});
		exit.addActionListener(e -> { 
			controller.cancel();
			mainMoon.changeCard(mainMoon.COURSE);});
		
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
		north.removeAll();
		questionNumbers.removeAll(questionNumbers);
		
		JLabel northLabel;
		CenterStudentQuestionPanel aux;
		Integer i = 1;
		north.setLayout(new GridLayout(controller.getQuestionsOrder().size()/NCOLS + 1,NCOLS));
		for(Question quest : controller.getQuestionsOrder()){
			if(quest instanceof TfQuestion){
				aux = new TrueFalseCenterPanel(quest);
			} else if (quest instanceof MultiChoiceQuestion){
				aux = new MultipleChoiceCenterPanel(quest);
			} else if (quest instanceof OneChoiceQuestion){
				aux = new SingleChoiceCenterPanel(quest);
			}  else if (quest instanceof OpenQuestion){
				aux = new OpenTextCenterPanel(quest); 
			} else { return; }
			cards.add(aux);
			center.add(aux, i.toString());
			questionNumber.addItem(i.toString());
			northLabel = new JLabel(i.toString(), JLabel.CENTER);
			northLabel.setPreferredSize(new Dimension(10, 30));;
			north.add(northLabel);
			questionNumbers.add(northLabel);
			i++;
		}
		actualQuestion = 1;
		previous.setEnabled(false);
		if(controller.getQuestionsOrder().size()==1){
			next.setEnabled(false);
		}
		questionNumbers.get(0).setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
	}

}
