import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Game {
	int numberRange;
	int numberToGuess;
	int tries;
	Scanner scan;

	Game() {
		initializeGame();
		selectRandomNumber();
	}

	private void initializeGame() {
        this.scan = new Scanner(System.in);
	}

	private void selectRandomNumber() {
		this.numberRange = getInt("Number range: ");
		resetGame();
	}

	private void resetGame() {
		this.numberToGuess = ThreadLocalRandom.current().nextInt(0, this.numberRange + 1);
		this.tries = 0;
	}

	int getInt(String message) {
		int number = 0;
		while (true) {
			System.out.print(message);
			try {
				number = this.scan.nextInt();
			}
			catch (java.util.InputMismatchException exc) {
				this.scan.nextLine();
				System.out.println("Incorrect input");
				continue;
			}
			break;
		}
		return number;
	}

	private int gameRound() {
		tries++;
		int guess = getInt("Make a guess (0 - " + this.numberRange + "): ");
		
		if(guess < numberToGuess) {
			System.out.println("Not enough");
		} if(guess > numberToGuess) {
			System.out.println("Too much");
		} if(guess == numberToGuess) {
			System.out.println("Nice! Number of tries: " + this.tries);
			System.out.print("Do you want to play again? [y/n] : ");
			
			// This line clears input buffer for scan
			this.scan.nextLine();

			while (true) {

				String answer = this.scan.nextLine();

				if(answer.matches("y|Y")) {
					resetGame();
					break;
				} else if(answer.matches("n|N")) {
					this.scan.close();
					return 1;
				}				
				System.out.print("[y/n] ? : ");
				continue;
			}
		}
		return 0;
	}

	public void play() {
		for(int i = 0; i == 0;) {
			i = gameRound();
		}
	}
}