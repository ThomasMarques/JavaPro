package fr.isima.myant;

import java.util.ArrayList;
/**
 * 
 */

/**
 * @author marquest et gaetan
 *
 */
public class Target {
	
	private String name;
	
	private ArrayList<Task> listTask;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public ArrayList<Task> getListTask() {
		return listTask;
	}
	
	public void addTask(Task task)
	{
		listTask.add(task);
	}

	public Target(String name) {
		setName(name);
		listTask = new ArrayList<Task>();
	}

	public void execute()
	{
		for (Task task : listTask) {
			task.execute();
		}
	}

}
