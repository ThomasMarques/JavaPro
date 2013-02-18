package fr.isima.myant;

import java.util.ArrayList;

public class Project {
	
	private String name;
	
	private ArrayList<Target> listTarget;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Target> getListTarget() {
		return listTarget;
	}
	
	public void addTarget(Target target)
	{
		listTarget.add(target);
	}

	public static void loadFromFile()
	{
		
	}
	
	public Target getTargetByName(String name)
	{
		for(Target target : listTarget)
			if(target.getName().equals(name))
				return target;
		
		return null;
	}
	
	public Project(String name) {
		setName(name);
		listTarget = new ArrayList<Target>();
	}

	public void execute()
	{
		for (Target target : listTarget) 
		{
			if(target.getName().equals("default"))
				target.execute();
		}
	}

}
