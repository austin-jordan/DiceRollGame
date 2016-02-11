import java.util.Scanner;

public class Validation {

	// This method checks that the user inputs a valid integer. 
		public static int getValidInteger(Scanner input) {
			while(!input.hasNextInt()) {
				System.out.println("That's not a number! Please enter a number: ");
				input.nextLine();
			}
			int number = input.nextInt();
			return number;
		}
		
		//This method checks that user inputs either yes or no.
		public static String isValidChoice(Scanner input) {
			String inp = input.nextLine();
			while(!inp.matches("^[yY]es|[nN]o|[ynYN]$")) {
				System.out.println("That is not a valid option.");
				System.out.println("Please enter yes or no: ");
				inp= input.nextLine();
			}
			return inp; 
		}
}
