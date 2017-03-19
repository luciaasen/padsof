package moon.mark;

import moon.course.question.*;

public class OpenAnswer extends MQuestion{
	private String answer;
	
	
	public OpenAnswer(Question question, String answer){
		super(question);
		this.answer = answer;
	}
}
