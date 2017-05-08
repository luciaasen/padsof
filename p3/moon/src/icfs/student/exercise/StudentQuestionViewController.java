/**
 * 
 */
package icfs.student.exercise;

import java.util.ArrayList;
import java.util.Collections;

import moon.course.Course;
import moon.course.Exercise;
import moon.course.question.Question;
import moon.mark.MExercise;
import moon.user.Student;
import moon.user.Teacher;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentQuestionViewController {
	ArrayList<Question> questionsOrder = new ArrayList<>();
	Student s;
	Course c;
	Question actual;
	StudentQuestionView view;
	MExercise me;
	
	public void setEverything(Student s, Course c, Exercise e){
		questionsOrder = e.getQuestions();
		if(e.getRandord()){
			Collections.shuffle(questionsOrder);
		}
		actual = questionsOrder.get(0);
		me = new MExercise(e);
	}
	
	protected void cancel(){
		me.cancel();
	}
	
	ArrayList<Question> getQuestionsOrder(){
		return this.questionsOrder;
	}

	/**
	 * @param cards
	 */
	public void save(ArrayList<CenterStudentQuestionPanel> cards) {
		for(CenterStudentQuestionPanel card : cards){
			card.generateMQuestion(me);
		}
		me.setStudent(s);
	}

	/**
	 * @return
	 */
	public Student getStudent() {
		return s;
	}

	/**
	 * @return
	 */
	public Course getCourse() {
		return c;
	}
}
