/**
 * 
 */
package fr.isima.myant;

/**
 * @author Gaetan Eyheramono && Thomas Marques
 * @date created on 09:02:53
 */
public class EchoTask extends Task {

	private String message;
	
	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public EchoTask(String message) {
		setMessage(message);
	}



	@Override
	public void execute() {
		System.out.println(message);
	}

}
