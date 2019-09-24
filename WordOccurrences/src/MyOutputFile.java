/*Name: Rhina Acevedo
Student Number: 040937718
Section: 522
Professor: Risvan Coskun
Assignment #2
Due Date: Sunday, June 23, 2019

 References:
 1) Paul J. Deitel, Harvey Deitel. (2017) Java How to Program, Early Objects
  Retrieved from http://texidium.com
 
 2) David Gassner (7/24/2015) Managing files with original File class. 
Retrieved from  https://www.lynda.com/Java-tutorials/Managing-files-original-File-class/377484/421354-4.html?autoplay=true

 3) Paul Richard (4th Jan, 2018) How to count the number of words in a text file using Java? 
 Retrieved from https://www.tutorialspoint.com/How-to-count-the-number-of-words-in-a-text-file-using-Java
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
public class MyOutputFile {

	public static void main(String[] args) throws Exception {

		int count = 0;
		
		String sourceFile = "MyInputFile.txt";
		String targetFile = "MyOutputFile.txt";
		File file = new File("MyOutputFile.txt");
	
		// Adds the files from "MyInputFile.txt" to "MyOutputFile.txt"
		try (
				FileReader fReader = new FileReader(sourceFile);
				BufferedReader bReader = new BufferedReader(fReader);
				FileWriter writer = new FileWriter(targetFile);
				
		) {
			System.out.printf("%-10s%n", "File Copied! ");
			//If the file is created it will add a new line until there is no more input.
			while (true) { 
				String line = bReader.readLine();

				if (line == null) {
					break;
				} else {
					writer.write(line + "\n");
				}
			}
			
			
		} catch (IOException | NoSuchElementException | IllegalStateException e) {
			e.printStackTrace();
		}
		
		//It will count how many words are inside the file.
		FileInputStream fis = new FileInputStream(file);
		byte[] bytesArray = new byte[(int)file.length()];
		fis.read(bytesArray);
		
		String s = new String(bytesArray);
		String[] data = s.split(" ");
		for(int i= 0; i<data.length; i++) {count++; }
		
		 
			
		// Outputs the input from "MyOutputFile.txt" like a list.
		try (Scanner input = new Scanner(Paths.get("MyOutputFile.txt"))) {
			System.out.printf("%-10s%n%n", "List of Words: ");
			
				while (input.hasNext()) { 
							System.out.printf(" %-12s%n", input.next() );	
			}
				System.out.println();
			
	       
			
		} catch (IOException | NoSuchElementException | IllegalStateException e) {
			e.printStackTrace();

		}System.out.println("\nNumber of words in the file: " + count);
		
		java.util.List<String> list = Arrays.asList(data);

		    Set<String> uniqueWords = new HashSet<String>(list);
		    for (String word : uniqueWords) {
		        System.out.println( Collections.frequency(list, word) + " :"+ word  );
		        
		    }
		
	} // END OF MAIN
}// END OF CLASS
