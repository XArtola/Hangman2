import java.util.Scanner;

import hangman.Game;

public class HangmanAnderJar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		Game game = new Game();

		boolean playAgain = true;

		while (playAgain) {

			System.out.println("Welcome to the famous HANGMAN game.");
			System.out.println(
					"You will have to guess which surname of the people in class is hidden between the voids.");
			System.out.println(
					"For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
			System.out.println("WARNING: Invalid or repeated letter will count as a missed try. The same for the last word");

			game.printVoids();

			System.out.println("\n");

			for (int i = 0; i < 3; i++) {

				System.out.println("Enter the letter:");
				String line = sc.nextLine();
				String[] words = line.split(" ");

				if (game.isLetter(words)) {

					game.checkLetter(words[0].charAt(0));

				}

				else {
					System.out.println("Invalid input enter only a letter");

				}

				game.printGuessed();
				System.out.println("\n");

			}

			System.out.println("Last chance you have to  guess the surname");

			String lastChance = sc.nextLine();
			String[] separatedLastChance = lastChance.split(" ");

			if (game.isWord(separatedLastChance)) {

				if (game.checkWord(separatedLastChance[0]))

					System.out.println("Congratulations you are the winner!!!\n");

				else {

					System.out.println(
							"This was not the word, it was " + game.getRandomSurname() + " better luck next time.\n");

				}

			} else {

				System.out.println("This is not a valid word. You have lost your oportunity. Better luck next time\n");

			}

			System.out.println("Would you like to play again?(y/n)");
			boolean askAgain = true;
			while (askAgain == true) {
				String back = sc.next().toLowerCase();
				sc.nextLine();
				switch (back) {
				case "y":
					// Get out of the loop and play again
					askAgain = false;
					break;
				case "n":
					// Get out of the loop and terminate the program
					playAgain = false;
					askAgain = false;
					break;
				default:
					// Ask for a possible value again
					System.out.println("Please, select a possible value(y/n)");
					break;
				}

			}

		}

	}

}
