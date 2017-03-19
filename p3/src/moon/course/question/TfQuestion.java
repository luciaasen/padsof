package moon.course.question;

public class TfQuestion extends Question{
	
	private boolean answer;
	
	/**
	 * TfQuestion constructor
	 * @param question
	 * @param relevance
	 * @param answer
	 */
	public TfQuestion(String question, double relevance, boolean answer) {
		super(question, relevance);
		this.answer = answer;
	}

	/**
	 * Correct answer getter for the question
	 * @return
	 */
	public boolean getAnswer(){
		return this.answer
	}
	
}
