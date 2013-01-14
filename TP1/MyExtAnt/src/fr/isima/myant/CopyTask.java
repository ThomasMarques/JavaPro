package fr.isima.myant;
/**
 * 
 */

/**
 * @author Gaetan Eyheramono && Thomas Marques
 * @date created on 08:58:14
 */
public class CopyTask extends Task {

	private String from;
	
	private String to;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public CopyTask(String from, String to) {

		setFrom(from);
		setTo(to);
	}

	@Override
	public void execute() {
		System.out.println("Copie d'un fichier de "+from+" a "+to+".");
	}
	
	
}
