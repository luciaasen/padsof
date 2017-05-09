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
 * Controller of the question view of a student. (What is shown when a 
 * student tries to do an exercise)
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
	
	/**
	 * Sets everything to match the parameters.
	 * @param s the student
	 * @param c the course
	 * @param e the exercise
	 */
	public void setEverything(Student s, Course c, Exercise e){
		questionsOrder = e.getQuestions();
		if(e.getRandord()){
			Collections.shuffle(questionsOrder);
		}
		actual = questionsOrder.get(0);
		me = new MExercise(e);
	}
	
	/**
	 * Cancels the exercise.
	 */
	protected void cancel(){
		me.cancel();
	}
	
	/**
	 * Gets the questions in order.
	 * @return ArrayList<Question> of questions.
	 */
	ArrayList<Question> getQuestionsOrder(){
		return this.questionsOrder;
	}

	/**
	 * Saves the exercise acording to the actual values of the fields.
	 * @param cards
	 */
	public void save(ArrayList<CenterStudentQuestionPanel> cards) {
		for(CenterStudentQuestionPanel card : cards){
			card.generateMQuestion(me);
		}
		me.setStudent(s);
	}

	/**
	 * Gets the student.
	 * @return
	 */
	public Student getStudent() {
		return s;
	}

	/**
	 * Gets the course.
	 * @return
	 */
	public Course getCourse() {
		return c;
	}
}
