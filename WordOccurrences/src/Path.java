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
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Path {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter file name: "); // MyInputFile.txt

		java.nio.file.Path path = Paths.get(input.nextLine());
		//If the path exists it will print out the System.out statements.
		if (Files.exists(path)) {
			System.out.printf("%n%s exists%n", path.getFileName());
			System.out.printf("%s a directory%n", Files.isDirectory(path) ? "Is" : "Is not");
			System.out.printf("%s a directory%n", Files.isDirectory(path) ? "Is" : "Is not");
			System.out.printf("%s an absolute path%n", path.isAbsolute() ? "Is" : "Is not");
			System.out.printf("Last modified: %s%n", Files.getLastModifiedTime(path));
			System.out.printf("Size: %s%n", Files.size(path));
			System.out.printf("Path: %s%n", path);
			System.out.printf("Absolute path: %s%n", path.toAbsolutePath());

			
		} else {
			System.out.printf("%s does not exist%n", path);
		}

	}// END OF MAIN
}// END OF CLASS
