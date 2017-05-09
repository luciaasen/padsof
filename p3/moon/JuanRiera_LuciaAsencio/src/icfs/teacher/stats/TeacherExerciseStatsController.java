/**
 * 
 */
package icfs.teacher.stats;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import icfs.teacher.stats.TeacherCourseStats;
import main.mainMoon;
import moon.course.Course;
import moon.course.Exercise;
import moon.course.question.Question;
import moon.user.Student;

/**
 * Controls the exercise stats view for a teacher
 * @author juan
 *
 */
public class TeacherExerciseStatsController implements MouseListener{
	 
	Exercise e;
	TeacherExerciseStats view;
	
	/**
	 * Controller constructor
	 * @param view
	 */
	public TeacherExerciseStatsController(TeacherExerciseStats view){
		this.view= view;
	}
	
	/**
	 * Stes the controller so that it matches the exercisse
	 * @param e
	 */
	public void setEverything(Exercise e){
		this.e=e;
		view.listModel.removeAllElements();
		for(Question ce : e.getQuestions()){
			view.listModel.addElement(ce);
		}
		view.exerciseName.setText(e.getName());
		view.average.setText("Average mark: " + e.calcAverage());
		view.nPasses.setText("Number of passes: " + e.calcNPasses());
		view.nFails.setText("Number of fails: " + e.calcNFails());
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Question selected = view.list.getSelectedValue();
		if(selected == null){
			return;
		} else {
			mainMoon.teacherQuestionsStatisticsSetEverything(selected);
			mainMoon.changeCard(mainMoon.TEACHER_QUESTION_STATS);
		}
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
