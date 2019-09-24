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

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyInputFile {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		//Creates or finds the file "MyInputFile.txt"
		try (Formatter output = new Formatter("MyInputFile.txt")) {

			System.out.printf("%s%n%s%n1 ", "Please enter a word that you would like to save :)",
					"Enter end-of-file indicator to end input.");
			for (int i = 2; i <= 1000; i++) {// loop until end-of-file indicator
				while (input.hasNext()) { 
					try {
						// output new record to file; assumes valid input
						output.format(" %s%n", input.next());
						

					} catch (NoSuchElementException elementException) {
						System.err.println("Invalid input. Please try again.");
						input.nextLine(); // discard input so user can try again
					}
					System.out.print(i++ + " ");
					
				}
			}
		} catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
			e.printStackTrace();
		}

	} // END OF MAIN
} // END OF CLASS
