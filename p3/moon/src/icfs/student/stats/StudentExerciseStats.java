/**
 * 
 */
package icfs.student.stats;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import icfs.LowerPanel;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.course.Exercise;
import moon.course.question.Question;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentExerciseStats extends LowerPanel {
	JLabel name = new JLabel("Nameañwlrgmásnfhṕnasfhnnaif´n");
	JLabel mark = new JLabel("Mark");
	JLabel nCorrect = new JLabel("Correct");
	JLabel nIncorrect = new JLabel("Incorrect");
	JLabel relevance = new JLabel("Relevance");
	DefaultListModel<Question> questionsModel = new DefaultListModel<>();
	JList<Question> questions = new JList<>(questionsModel);
	StudentExerciseStatsController controller = new StudentExerciseStatsController(this);
	
	public StudentExerciseStats(){
		JPanel northEast = new JPanel();
		JPanel northWest = new JPanel();
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		JButton auxButton;
		
		this.setLayout(new BorderLayout(10,10));
		
		northWest.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		northWest.add(name);
		northWest.setBackground(Color.WHITE);
		
		northEast.setLayout(new GridLayout(4,1,5,5));
		northEast.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		northEast.add(mark);
		northEast.add(nCorrect);
		northEast.add(nIncorrect);
		northEast.add(relevance);
		northEast.setBackground(Color.white);
		
		north.setLayout(new BorderLayout(10,10));
		north.add(northWest, BorderLayout.WEST);
		north.add(northEast, BorderLayout.CENTER);
		north.setBackground(Academy.ORANGE);
		
		center.setLayout(new BorderLayout(10,10));
		center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		center.add(new JLabel("Question's statistics:"), BorderLayout.NORTH);
		JScrollPane listScroll = new JScrollPane(questions);
		questions.addMouseListener(controller);
		center.add(listScroll, BorderLayout.CENTER);
		center.setBackground(Color.white);
		
		auxButton = new JButton("Back to course statistics");
		auxButton.addActionListener(e -> mainMoon.changeCard(mainMoon.COURSE_STATS));
		south.add(auxButton);
		auxButton = new JButton("Back to main window");
		auxButton.addActionListener(e -> mainMoon.changeCard(mainMoon.MAIN));
		south.add(auxButton);
		south.setBackground(Academy.ORANGE);
		
		this.setLayout(new BorderLayout(10,10));
		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		questions.addMouseListener(controller);
	}
	
	public void setEverything(Student s, Exercise e){
		controller.setEverything(s, e);
	}
}
