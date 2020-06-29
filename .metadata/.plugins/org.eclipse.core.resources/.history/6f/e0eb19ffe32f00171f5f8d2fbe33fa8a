package p5;

import java.util.*;

import p5.interf.AdjustableTime;


public class Task {
	
	//private ArrayList<Task> tree = new ArrayList();	
	private ArrayList<Task> subtasks = new ArrayList<Task>();	
	private String name;
	private Task parent;
	private MyAdjustableTime estimated;
	private MyAdjustableTime dedicated;
	
	/**
	 * Creates a new task with the given name, and initializes the times to 0
	 * @param name the name of the task
	 */
	public Task(String name){
		this.name = name.toLowerCase();
		this.parent = null;
		this.estimated = new MyAdjustableTime(0);
		this.dedicated = new MyAdjustableTime(0);
	}
	
	/**
	 * Gets task name
	 * @return this' name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * If possible, adds t to this subtasks (and sets t parent as this)
	 * If already contained in this, returns false
	 * Adds t's times to this times
	 * Adds this to t's observers
	 * @param t task to add
	 * @return true if correctly added, false else
	 * @throws IllegalArgumentException when t has another parent
	 */
	public boolean addTask(Task t) throws IllegalArgumentException{
		if(this.containsTask(t)) return false;
		if(t.parent != null) throw new IllegalArgumentException();
		this.subtasks.add(t);
		t.parent = this;
		t.dedicated.addObserver(this.dedicated);
		t.estimated.addObserver(this.estimated);
		this.estimated.incrementTime(t.estimated.getValue());
		this.dedicated.incrementTime(t.dedicated.getValue());
		return true;
	}
	
	/**
	 * If possible, removes t from this subtasks, removing t from t's parent subtasks
	 * and putting t's parent to null
	 * Removes t's times from its parent (and therefore from all it ancestors) times
	 * Removes this from t's observers
	 * @param t task to remove
	 * @return true if successfuly removed, false else
	 */
	public boolean removeTask(Task t){
		if (this.containsTask(t)){
			Task parent = t.parent;
			parent.subtasks.remove(t);
			t.parent = null;
			t.dedicated.removeObserver(this.dedicated);
			t.estimated.removeObserver(this.estimated);
			parent.estimated.incrementTime(-1 * t.estimated.getValue());
			parent.dedicated.incrementTime(-1 * t.dedicated.getValue());
			
			return true;
		}
		return false;
	}
	
	/**
	 * Gets this subtasks in a set
	 * @return an unmodifiable set containing this subtasks
	 */
	public Set<Task> getTasks(){
		return Collections.unmodifiableSet(new HashSet<Task>(this.subtasks));
	}
	
	/**
	 * Returns whether or not t is directly or indirectly contained in this subtasks
	 * @param t
	 * @return true if t contained, else false
	 */
	public boolean containsTask(Task t){
		if(this.subtasks.isEmpty()) return false;
		for(Task subt: this.subtasks){
			if(subt.containsTask(t)) return true;
		}
		return false;
	}
	
	/**
	 * Gets this parent task
	 * @return parent
	 */
	public Task getParent(){
		return this.parent;
	}
	
	/**
	 * If possible, changes this parent and re-sets old and new parent times and observers
	 * @param parent
	 */
	public void setParent(Task parent){
		if(parent != null){
			if (this.containsTask(parent)) throw new IllegalArgumentException();
			/*Esto corta la relacion con el antiguo padre, reajusta tiempos en antiguo padre y pone parent a null, reajusta observers*/
			this.parent.removeTask(this);
			/*Esto crea relacion con nuevo parent y añade tiempos al nuevo padre, reajusta observers*/
			parent.addTask(this);
		}
	}
	
	/**
	 * Gets this estimated time
	 * @return the estimated time
	 */
	public AdjustableTime getEstimated(){
		return this.estimated;
	}

	/**
	 * Gets this dedicated time
	 * @return the dedicated time
	 */
	public AdjustableTime getDedicated(){
		return this.dedicated;
	}

	@Override
	public boolean equals(Object o){
		if(o == null) return false;
		if(!(o instanceof Task)) return false;
		Task t = (Task)o;
		if(!t.name.equals(this.name)) return false;
		return true;		
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode();
	}
	
	@Override
	public String toString(){
		return this.name + " e: " +this.estimated  + " d: " +this.dedicated;
	}
	
}
