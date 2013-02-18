import java.io.FileNotFoundException;

import org.junit.Test;

import fr.isima.myant.ClassAlsoLoadedException;
import fr.isima.myant.ClassNotLoadedException;
import fr.isima.myant.Parser;


public class ParserTest {


	@Test(expected=NullPointerException.class)
	public void parseNullArgument() throws Exception
	{
		Parser parser = new Parser();
		parser.parse(null);
	}

	@Test(expected=FileNotFoundException.class)
	public void parseFileNotFound() throws Exception
	{
		Parser parser = new Parser();
		parser.parse("C:/Ca/nexiste/pas.txt");
	}

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void deprecatedUse() throws Exception
	{
		Parser parser = new Parser();
		parser.parse("./taskTest/deprecatedUse.txt");
	}

	@Test(expected=ClassNotFoundException.class)
	public void classNotFound() throws Exception
	{
		Parser parser = new Parser();
		parser.parse("./taskTest/classNotFound.txt");
	}

	@Test(expected=ClassNotLoadedException.class)
	public void classNotLoadedException() throws Exception
	{
		Parser parser = new Parser();
		parser.parse("./taskTest/classNotLoadedException.txt");
	}
	
	@Test
	public void itWorks() throws Exception
	{
		Parser parser = new Parser();
		parser.parse("./taskTest/work.txt");
	}

	@Test(expected=StringIndexOutOfBoundsException.class)
	public void fileNotFormated() throws Exception
	{
		Parser parser = new Parser();
		parser.parse("./taskTest/fileNotFormated.txt");
	}
	
	@Test(expected=StringIndexOutOfBoundsException.class)
	public void fileNotFormated2() throws Exception
	{
		Parser parser = new Parser();
		parser.parse("./taskTest/fileNotFormated2.txt");
	}
	
	@Test
	public void crossReferences() throws Exception
	{
		Parser parser = new Parser();
		parser.parse("./taskTest/crossReferences.txt");
	}
	
	@Test(expected=NoSuchMethodException.class)
	public void noSuchMethod() throws Exception
	{
		Parser parser = new Parser();
		parser.parse("./taskTest/noSuchMethod.txt");
	}
	
	@Test(expected=ClassAlsoLoadedException.class)
	public void classAlsoLoadedException() throws Exception
	{
		Parser parser = new Parser();
		parser.parse("./taskTest/classAlsoLoadedException.txt");		
	}
	
	
	@Test
	public void fileFormated() throws Exception
	{
		Parser parser = new Parser();
		parser.parse("./taskTest/fileFormated.txt");
	}
}
