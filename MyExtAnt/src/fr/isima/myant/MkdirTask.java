package fr.isima.myant;

/**
 * 
 * @author Gaetan Eyheramono && Thomas Marques
 * @date created on 09:01:40
 */
public class MkdirTask extends Task {

	private String name;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public MkdirTask(String name) {
		setName(name);
	}



	@Override
	public void execute() {
		System.out.println("Crée un dossier " + name + ".");
	}

}
