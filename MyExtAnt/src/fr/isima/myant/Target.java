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

	private ArrayList<String> dependencies;

	private boolean passed = false;
	
	public static Project proj;

	public boolean isPassed()
	{
		return passed;
	}

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

	public void addTarget(String name)
	{
		dependencies.add(name);
	}

	public Target(String name) {
		setName(name.trim());
		listTask = new ArrayList<Task>();
		dependencies = new ArrayList<String>();
	}

	public void execute()
	{
		if(!passed)
		{
			passed = true;
			for (String name : dependencies) {
				Target target = proj.getTargetByName(name);
				if(target != null)
					target.execute();
			}

			for (Task task : listTask) {
				task.execute();
			}
		}
	}

}
