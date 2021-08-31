import java.io.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class countUnplugged 
{
	public static void main (String[] args) throws Exception 
	{
		HashMap<String, Integer> something = new HashMap<String,Integer>();
		BufferedReader Reader = null; 
		try {
			Reader = new BufferedReader(new FileReader("C:\\Users\\steph\\Desktop\\Hackerman\\SchoolFiles\\cs\\lab1\\test.txt"));
			String currentLine = Reader.readLine();
			while(currentLine!= null) {
//				String words [] = currentLine.toLowerCase().split(" ");
				String words [] = currentLine.replaceAll("[^0-9a-zA-Z\s]", "").toLowerCase().split(" ");
				
				for (String word:words) {
					if(something.containsKey(word)) {
						something.put(word, something.get(word)+1);
					}
					else {
						something.put(word, 1);
					}
				}
//				System.out.println(words.toString());
				currentLine=Reader.readLine();
			}
			
			String repeated=null; 
			int count = 0; 
			Set<Entry<String,Integer>> entrySet=something.entrySet();
			for(Entry<String, Integer> entry:entrySet){
				if(entry.getValue()>count) {
					repeated=entry.getKey();
					count=entry.getValue();
				}
			}
			System.out.println("most common word is: " +repeated);
			System.out.println("it came up "+count + "times");
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("not Working");
		}
		finally {
			try {
				Reader.close();
			}
			catch (IOException f) {
				f.printStackTrace();
				System.out.println("cant even close the reader u are a pesent");
			}
		}
	}
}