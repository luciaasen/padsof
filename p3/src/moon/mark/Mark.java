package moon.mark;

public abstract class Mark {
	private double mark;
	
	/**
	 * Constructor for Mark
	 * @param mark
	 */
	public Mark(){
		this.mark = 0;
	}
	
	/**
	 * Mark setter
	 * @param mark
	 */
	public void setMark(double mark){
		this.mark = mark;
	}
}