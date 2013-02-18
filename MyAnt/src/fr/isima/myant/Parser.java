package fr.isima.myant;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Classe permettant de parser un fichier et éxecute le target par defaut.
 */
public class Parser {

	/**
	 * Constantes
	 */
	private static final int PACKAGE=1;
	private static final int CLASSNAME=3;
	private static final int MESSAGE=1;
	private static final int PARAM1=1;
	private static final int PARAM2=3;
	private static final String DEFAULT_PACK="fr.isima.myant";
	
	/**
	 * Buffer utilisé pour la lecture du fichier.
	 */
	private BufferedReader bufred;

	/**
	 * Fonction permettant de parser un fichier et éxecute le target par defaut.
	 * @param name Nom du fichier à parser.
	 * @throws Exception 
	 */
	public void parse(String name) throws Exception
	{
		FileReader reader;
		HashMap<String,Class<?>> classMap = new HashMap<String,Class<?>>();
		//try {
		
		reader = new FileReader(name);
		bufred = new BufferedReader(reader);

		Class<?> projet = Class.forName(DEFAULT_PACK + ".Project");
		Class<?> target = Class.forName(DEFAULT_PACK + ".Target");
		Object proj=projet.getConstructor(String.class).newInstance("MonProjet");
		target.getField("proj").set(target, proj);
		Object targ = null;

		String line=bufred.readLine();
		while(line != null)
		{
			if(!line.startsWith("#"))
			{
				if(line.startsWith("use "))
				{
					String[] list=line.split(" ");
					if(classMap.containsKey(list[CLASSNAME]))
					{
						throw new ClassAlsoLoadedException();
					}
					classMap.put(list[CLASSNAME], Class.forName(list[PACKAGE]));
				}
				else if (line.startsWith(("echo")))
				{
					System.out.println(line.split("\"")[MESSAGE]);
				}
				else if(line.contains(":") && !line.contains("["))
				{
					String nameTarget = line.substring(0,line.indexOf(":"));
					String dependencies = line.substring(line.indexOf(":")+1);

					targ=target.getConstructor(String.class).newInstance(nameTarget);
					projet.getMethod("addTarget", target).invoke(proj, targ);
					if(!dependencies.isEmpty())
					{
						String[] depend = dependencies.split(",");
						for(int i = 0 ; i < depend.length ; ++i)
						{
							target.getMethod("addTarget", String.class).invoke(targ, depend[i].trim());
						}

					}
				}
				else if(!line.isEmpty())
				{
					String taskName= line.substring(0,line.indexOf("["));

					Class<?> tmp = classMap.get(taskName);

					if(tmp == null)
					{
						throw new ClassNotLoadedException();
					}

					String[] list = line.substring(line.indexOf("[")+1).split("\"");
					Method method = target.getMethod("addTask", classMap.get("Task"));

					if(list.length == 3)	
						method.invoke(targ, tmp.getConstructor(String.class).newInstance(list[PARAM1]));
					else if(list.length == 5)	
						method.invoke(targ, tmp.getConstructor(String.class,String.class).newInstance(list[PARAM1],list[PARAM2]));
					else
					{
						System.out.println("Aucun constructeur ne correspond.");
					}
				}
			}

			line=bufred.readLine();
		}

		bufred.close();

		System.out.println("\nExecute :\n");
		projet.getMethod("execute").invoke(proj);


		/*} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		}catch (ClassNotFoundException e) {
			System.out.println("Classe manquante dans le classpath.");
		} catch (InstantiationException e) {
			System.out.println("Methode non défénit dans la classe.");
		} catch (IllegalAccessException e) {
			System.out.println("Attributs ou méthodes inaccessible.");
		} catch (InvocationTargetException e) {
			System.out.println("Impossible d'invoquer la méthode demandé.");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("Méthode non trouvé dans la classe.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Une erreur est survenu lors de la lecture du fichier.");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */

	}

	/**
	 * Fonction lancée au démarrage du programme.
	 * @param args Arguments passés en ligne de commande.
	 */
	public static void main(String[] args) {
		/// Obligé de déporter les exceptions pour que la méthode parse les repousse pendant les tests. 
		Parser par= new Parser();
		try {
			par.parse("run.txt");

		} catch (FileNotFoundException e) {
			System.err.println("Fichier non trouvé.");
		}catch (ClassNotFoundException e) {
			System.err.println("Classe manquante dans le classpath.");
		} catch (InstantiationException e) {
			System.err.println("Methode non défénit dans la classe.");
		} catch (IllegalAccessException e) {
			System.err.println("Attributs ou méthodes inaccessible.");
		} catch (InvocationTargetException e) {
			System.err.println("Impossible d'invoquer la méthode demandé.");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.err.println("Méthode non trouvée dans la classe.");
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			System.err.println("Attribut non trouvé dans la classe.");
		} catch (SecurityException e) {
			System.err.println("Attribut inaxessibledans la classe.");
		} catch (IOException e) {
			System.err.println("Une erreur est survenu lors de la lecture du fichier.");
		} catch (Exception e) {
			System.err.println("Ca ne devrait jamais se produire...");
		}
	}

}
