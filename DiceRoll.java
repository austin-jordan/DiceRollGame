import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DiceRoll {
	static String roll;
	static int min;
	static int dice1;
	static int dice2;
	static int numberOfSides;
	static boolean end = false;
	static boolean quit = false;
	static String answer = null;

	public static void playGame(Scanner input) {
		roll = Validation.isValidChoice(input);
		switch(roll) {
		case "Y": case "y": case "Yes": case "yes":
			end = false;
			break;
		case "N": case "n": case "No": case "no":
			end = true;
			break;
		default:
		}
	}
	public static int askNumber(Scanner input) {
		System.out.println("How many sides do each of the pair of dice have:");
		numberOfSides = Validation.getValidInteger(input);
		return numberOfSides;
	}
	
	public static void rollAgain(Scanner input) {
		System.out.println("Would you like to roll again? (y/n): ");
		answer = Validation.isValidChoice(input);
		switch (answer) {
		case "Y": case "y": case "Yes": case "yes":
			break;
		case "N": case "n": case "No": case "no":
			System.out.println("Hope you had fun!");
			quit = true;
			break;
		}
	}

	public static int rollDice(int min, int numberOfSides) {
		Random rand = null;
		min = 1;
		dice1 = ThreadLocalRandom.current().nextInt(min, numberOfSides + 1);
		dice2 = ThreadLocalRandom.current().nextInt(min, numberOfSides + 1);
		System.out.println("First dice: " + dice1);
		System.out.println("Second dice: " + dice2);
		return dice1 + dice2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean end = false;
		System.out.println("Welcome to the Grand Circus Casino! Roll the dice? (y/n: )");
		Scanner input = new Scanner(System.in);
		DiceRoll player = new DiceRoll();
		player.playGame(input);
		do {
			player.askNumber(input);
			do {
				player.rollDice(min, numberOfSides);
				player.rollAgain(input);
			} while (quit == false);
		} while (end == false);
	}
}
