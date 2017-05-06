/**
 * 
 */
package icfs.student.stats;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.tree.DefaultMutableTreeNode;

import main.mainMoon;
import moon.course.Exercise;
import moon.course.question.Question;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class StudentExerciseStatsController implements MouseListener {
	StudentExerciseStats view;
	Student s;
	Exercise e;
	/**
	 * @param studentExerciseStats
	 */
	public StudentExerciseStatsController(StudentExerciseStats view) {
		this.view=view;
	}

	public void setEverything(Student s, Exercise e){
		this.s = s;
		this.e = e;
		view.questionsModel.removeAllElements();
		for(Question q : e.getQuestions()){
			view.questionsModel.addElement(q);
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Question question = view.questions.getSelectedValue();
		if (question == null){
			return;
		} 
		
		mainMoon.studentQuestionStatsSetEverything(s,e,question);
		mainMoon.changeCard(mainMoon.QUESTION_STATS);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	
	@Override
	public void mouseExited(MouseEvent arg0) {}

	
	@Override
	public void mousePressed(MouseEvent arg0) {}

	
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
