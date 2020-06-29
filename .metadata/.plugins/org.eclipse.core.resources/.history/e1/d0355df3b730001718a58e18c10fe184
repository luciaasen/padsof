package p5;

import java.util.HashMap;
import p5.exc.*;
public class Tasks {
	public static HashMap<String,Task> tasks= new HashMap<String,Task>();
	
	/**
	 * If it doesnt exist yet, adds a new task to the Tasks
	 * @param taskName name of the new task
	 * @return t the new task
	 * @throws IllegalArgumentException
	 */
	public static Task newTask(String taskName) throws p5.exc.IllegalArgumentException{
		Task t = new Task(taskName);
		if(Tasks.contains(t)) throw new p5.exc.IllegalArgumentException();
		Tasks.tasks.put(t.getName(), t);
		return t;
	}
	
	/**
	 * Another task adder that receives a task instead of a name, to make easier the tester
	 * @param t the task to add
	 * @return the added task
	 * @throws IllegalArgumentException when the task was already contained
	 */
	public static Task newTask(Task t) throws p5.exc.IllegalArgumentException{
		if(Tasks.contains(t)) throw new p5.exc.IllegalArgumentException();
		Tasks.tasks.put(t.getName(), t);
		return t;
	}
	public static boolean contains(Task t){
		return Tasks.tasks.values().contains(t);
	}
}
