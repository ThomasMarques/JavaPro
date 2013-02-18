/**
 * 
 */
package fr.isima.myant;

/**
 * @author Gaetan Eyheramono && Thomas Marques
 * @date created on 09:25:04
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Project project = new Project("Mon projet");
		Target target = new Target("default");
		target.getListTask().add(new EchoTask("Hello World !"));
		target.getListTask().add(new MkdirTask("Mon dossier"));
		target.getListTask().add(new CopyTask("from","to"));
		project.getListTarget().add(target);
		
		project.execute();
	}

}
