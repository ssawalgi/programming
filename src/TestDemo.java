import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author snehasavalgi
 *
 */
public class TestDemo {

	private static String data = "";
	
	public static String readTextFile(String fileName) throws Exception
	{
		data = new String(Files.readAllBytes(Paths.get(fileName))); 
		return data;		
	};
	
	public static String search(String query)
	{
		if(!data.isEmpty())
		{
			String rawtext = data.replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(rawtext);
			Pattern p = Pattern.compile(query);   // the pattern to search for
		    Matcher m = p.matcher(data);
		    if (m.find())
		      System.out.println("Found a match");
		}
		return query;
		
	};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Read any text file. Find the pattern in the text file and provide the count of the occurrence		
		try {
			String data = readTextFile("/Users/snehasavalgi/Documents/workspace1/MyProject/resources/text");
			search("General relativity");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
