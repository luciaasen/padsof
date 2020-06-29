package p5;

import java.util.HashMap;

public class Tasks {
	public static HashMap<String,Task> tasks= new HashMap<String,Task>();
	
	/**
	 * If it doesnt exist yet, adds a new task to the Tasks
	 * @param taskName name of the new task
	 * @return t the new task
	 * @throws IllegalArgumentException
	 */
	public Task newTask(String taskName) throws IllegalArgumentException{
		Task t = new Task(taskName);
		if(Tasks.contains(t)) throw new IllegalArgumentException();
		Tasks.tasks.put(t.getName(), t);
		return t;
	}
	
	public static boolean contains(Task t){
		return Tasks.tasks.values().contains(t);
	}
}
