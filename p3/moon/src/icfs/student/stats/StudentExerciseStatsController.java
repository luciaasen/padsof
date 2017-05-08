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
import moon.mark.MQuestion;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
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
		
		view.mark.setText((new Double(e.getExerciseMark(s))).toString());
		
		int number = 0;
		for(MQuestion mq : e.getExercise(s).getmQuestions()){
			if(mq.getMark()>0){
				number++;
			}
		}
		view.nCorrect.setText((new Integer(number)).toString());
		
		number = 0;
		for(MQuestion mq : e.getExercise(s).getmQuestions()){
			if(mq.getMark()<=0){
				number++;
			}
		}
		view.nIncorrect.setText((new Integer(number)).toString());
		view.relevance.setText((new Double(e.getRelevance())).toString());
		view.name.setText(e.getName());
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

	/**
	 * @return
	 */
	public Student getStudent() {
		return s;
	}
}
