/**
 * 
 */
package icfs.student.exercise;

import java.util.ArrayList;
import java.util.Collections;

import moon.course.Course;
import moon.course.Exercise;
import moon.course.question.Question;
import moon.user.Student;

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
	
	public void setEverything(Student s, Course c, Exercise e){
		questionsOrder = e.getQuestions();
		if(e.getRandord()){
			Collections.shuffle(questionsOrder);
		}
		actual = questionsOrder.get(0);
		
	}
	
	ArrayList<Question> getQuestionsOrder(){
		return this.questionsOrder;
	}
}
